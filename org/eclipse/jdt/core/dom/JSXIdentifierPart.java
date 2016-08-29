package org.eclipse.jdt.core.dom;

public class JSXIdentifierPart extends JSXIdentifierStart {

	 JSXIdentifierPart(AST ast) {
		super(ast);
		// TODO Auto-generated constructor stub
		
	}

	@Override 
	   public void setIdentifier(SimpleName identifier){
		String jsxId=identifier.getIdentifier();
		if(jsxId.indexOf("-")!=-1){
			 throw new IllegalArgumentException("Invalid identifier : >" + identifier + "<"); 
			
		}
		
		super.setIdentifier(identifier);
	}
	
	final  int getNodeType0() {
			return JSX_IDENTIFIER_PART;
		}
	
}
