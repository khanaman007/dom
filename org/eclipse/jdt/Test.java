package org.eclipse.jdt;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
//import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.JSXElement;
import org.eclipse.jdt.core.dom.JSXIdentifier;
import org.eclipse.jdt.core.dom.JSXText;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;



public class Test {
	
	public static void main(String args[]){
		                
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(" public class A {  java.lang.Integer str = 1234 ; boolean bool= (str==234) ;int i = 9;  \n int j; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; public void mm(){ <text/> return ;} }".toCharArray());
		//parser.setSource("/*abc*/".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		//ASTNode node = parser.createAST(null);
		
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		
      
		cu.accept(new org.eclipse.jdt.core.dom.ASTVisitor() {
 
			Set names = new HashSet();
 
			public boolean visit(VariableDeclarationFragment node) {
				SimpleName name = node.getName();
				this.names.add(name.getIdentifier());
				JSXText charcater = new JSXText(node.getAST());
				
				
				
				JSXElement element = new JSXElement(node.getAST());
				element.accept(this);
				
				TypeDeclaration typeDecl = (TypeDeclaration) cu.types().get(0);
				MethodDeclaration methodDecl= typeDecl.getMethods()[0];
				Block block= methodDecl.getBody();
				ASTRewrite rewrite= ASTRewrite.create(node.getAST());
				ASTNode newInv1= node.getAST().createInstance(ASTNode.JSX_IDENTIFIER_NAME);
				((JSXIdentifier) newInv1).setJsxIdentifierStart(node.getAST().newJSXIdentifierStart());
				ListRewrite listRewrite= rewrite.getListRewrite(block, Block.STATEMENTS_PROPERTY);
				listRewrite.insertFirst(newInv1, null);
				listRewrite.insertLast(newInv1, null);
				System.out.println("Declaration of '"+name+"' at line"+cu.getLineNumber(name.getStartPosition()));
				return false; // do not continue to avoid usage info
			}
 
			public boolean visit(SimpleName node) {
				if (this.names.contains(node.getIdentifier())) {
				System.out.println("Usage of '" + node + "' at line " +	cu.getLineNumber(node.getStartPosition()));
				}
				return true;
			}
			
			public boolean visit(QualifiedName  node) {
				if (this.names.contains(node.getQualifier())) {
				System.out.println("Usage of '" + node + "' at line " +	node.getQualifier()+" "+node.getLocalName());
				}
				return true;
			}
 
		});
	}
}


