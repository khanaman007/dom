package org.eclipse.jdt.core.dom;

public class JSXVisitor {
	
	private ASTVisitor _astVistor=null;
	private static JSXVisitor _instance = new JSXVisitor();
	private boolean isReadyToUse=false;
	public static JSXVisitor getInstance(){
		return _instance;
	}
	
	public void setASTVisitor(ASTVisitor _astMatcher){
		if(_astMatcher!=null){
			isReadyToUse= true;
		this._astVistor =_astMatcher;
		}
	}

	public boolean visit(JSXIdentifierStart node) {
		 if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Visitor is  : >" + null + "<");
		return _astVistor.visit(node.getIdentifier());
	}
	
	public boolean visit(JSXIdentifierPart node) {
		 if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Visitor is  : >" + null + "<");
		return _astVistor.visit(node.getIdentifier());
	}
	
	public boolean visit(JSXIdentifier node) {
		boolean isVistied=true;
		
		return isVistied;
	}

	public void endVisit(JSXIdentifier jsxIdentifier) {
		// TODO Auto-generated method stub
		
	}

	public void endVisit(JSXIdentifierStart jsxIdentifierStart) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXText jsxText) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXText jsxText) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXMemberExpression jsxMemberExpression) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXMemberExpression jsxMemberExpression) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXNamespacedName jsxNamespacedName) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXNamespacedName jsxNamespacedName) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXElementName jsxElementName) {
		boolean isVisisted = false;
		// TODO Auto-generated method stub
		 if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Visitor is  : >" + null + "<");
		   if(jsxElementName.getIdentifier() instanceof JSXIdentifier){
			   JSXIdentifier jxsObject= (JSXIdentifier)jsxElementName.getIdentifier();
			    jxsObject.accept0(_astVistor);
			    isVisisted= true;
		   }
			    
		   if(jsxElementName.getIdentifier() instanceof JSXNamespacedName){
			   JSXNamespacedName jxsObject= (JSXNamespacedName)jsxElementName.getIdentifier();
			   jxsObject.accept0(_astVistor);
			   isVisisted= true;
		   }
		   
		   if(jsxElementName.getIdentifier() instanceof JSXMemberExpression){
			   JSXMemberExpression jxsObject= (JSXMemberExpression)jsxElementName.getIdentifier();
			   jxsObject.accept0(_astVistor);
			   isVisisted= true;
		   }
		return isVisisted;
	}

	public boolean visit(JSXNameValuePair jsxNameValuePair) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXNameValuePair jsxNameValuePair) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXAttribute jsxAttribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXAttribute jsxAttribute) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXSpreadAttribute jsxSpreadAttribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXSpreadAttribute jsxSpreadAttribute) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXAttributeDeclarationExpression jsxAttributeDeclarationStatement) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXAttributeDeclarationExpression jsxAttributeDeclarationStatement) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXSelfClosingElement jsxClosingElement) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXSelfClosingElement jsxClosingElement) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXOpeningElement jsxOpeningElement) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXOpeningElement jsxOpeningElement) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXClosingElement jsxClosingElement) {
		// TODO Auto-generated method stub
		return false;
	}

	public void endVisit(JSXClosingElement jsxClosingElement) {
		// TODO Auto-generated method stub
		
	}

	public boolean visit(JSXElement jsxElement) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXElement jsxElement) {
		// TODO Auto-generated method stub
		
	}

	

	public void  visit(JSXChild jsxChild) {
		// TODO Auto-generated method stub
		jsxChild.getIdentifier().accept0(_astVistor);
	}

	public boolean visit(JSXChildExpression jsxChildExpression) {
		// TODO Auto-generated method stub
		return true;
	}

	public void endVisit(JSXChildExpression jsxChildExpression) {
		// TODO Auto-generated method stub
		
	}

	
}
