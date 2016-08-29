package org.eclipse.jdt.core.dom;

public class JSXASTMatcher {
	
	private ASTMatcher _astMatcher=null;
	private static JSXASTMatcher _instance = new JSXASTMatcher();
	private boolean isReadyToUse=false;
	public static JSXASTMatcher getInstance(){
		return _instance;
	}
	
	public void setASTMatcher(ASTMatcher _astMatcher){
		if(_astMatcher!=null){
			isReadyToUse= true;
		this._astMatcher =_astMatcher;
		}
	}
	public boolean match(JSXIdentifier node, Object other) {
		  if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXIdentifier)) {
			return false;
		}
		JSXIdentifier o = (JSXIdentifier) other;
		return match(node, o);
	}

	final boolean match(JSXIdentifierStart node, Object other) {
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXIdentifierStart)) {
			return false;
		}
		JSXIdentifierStart comparee= (JSXIdentifierStart)other;
		return this._astMatcher.match(node.getIdentifier(),comparee.getIdentifier());
	}

	public boolean match(JSXText jsxText, Object other) {
		  if(jsxText==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXText)) {
			return false;
		}
		JSXText o = (JSXText) other;
		return jsxText.getJsxTextCharacter().subtreeMatch0(this._astMatcher, o.getJsxTextCharacter())&&_astMatcher.safeSubtreeListMatch(jsxText.fragments(),o.fragments());
		
	}

	public boolean match(JSXMemberExpression jsxMemberExpression, Object other) {
		if(jsxMemberExpression==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXMemberExpression)) {
			return false;
		}
		JSXMemberExpression o = (JSXMemberExpression) other;
		// TODO Auto-generated method stub
		return jsxMemberExpression.getQualifier().subtreeMatch0(this._astMatcher, o)&&jsxMemberExpression.getName().subtreeMatch0(_astMatcher, o);
	}

	public boolean match(JSXNamespacedName jsxNamespacedName, Object other) {
		// TODO Auto-generated method stub
		if(jsxNamespacedName==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXMemberExpression)) {
			return false;
		}
		JSXNamespacedName o = (JSXNamespacedName) other;
		// TODO Auto-generated method stub
		return jsxNamespacedName.getQualifier().subtreeMatch0(this._astMatcher, o.getQualifier())&&o.getName().subtreeMatch0(_astMatcher, o.getName());
	}

	public boolean match(JSXElementName jsxElementName, Object other) {
		// TODO Auto-generated method stub
		if(jsxElementName==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXElementName)) {
			return false;
		}
		JSXElementName o = (JSXElementName) other;
		// TODO Auto-generated method stub
		return jsxElementName.getIdentifier().subtreeMatch0(this._astMatcher, o.getIdentifier());
	}

	public boolean match(JSXSelfClosingElement jsxSelfClosingElement, Object other) {
		// TODO Auto-generated method stub
		if(jsxSelfClosingElement==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXSelfClosingElement)) {
			return false;
		}
		JSXSelfClosingElement o = (JSXSelfClosingElement) other;
		// TODO Auto-generated method stub
		return jsxSelfClosingElement.getName().subtreeMatch0(this._astMatcher, o.getName())&&jsxSelfClosingElement.getAttributeStatement().subtreeMatch(this._astMatcher, o.getAttributeStatement());
	}

	public boolean match(JSXNameValuePair jsxNameValuePair, Object other) {
		if(jsxNameValuePair==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXNameValuePair)) {
			return false;
		}
		JSXNameValuePair o = (JSXNameValuePair) other;
		
		// TODO Auto-generated method stub
		return jsxNameValuePair.getName().subtreeMatch0(this._astMatcher, o.getName())&&_astMatcher.safeSubtreeListMatch(jsxNameValuePair.values(),o.values());
	}

	public boolean match(JSXAttribute jsxAttribute, Object other) {
		// TODO Auto-generated method stub
		if(jsxAttribute==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXAttribute)) {
			return false;
		}
		JSXAttribute o = (JSXAttribute) other;
		
		// TODO Auto-generated method stub
		return jsxAttribute.getName().subtreeMatch0(this._astMatcher, o.getName())&&jsxAttribute.getNameValue().subtreeMatch0(_astMatcher, o.getNameValue());
	}

	public boolean match(JSXSpreadAttribute jsxSpreadAttribute, Object other) {
		// TODO Auto-generated method stub
		if(jsxSpreadAttribute==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXSpreadAttribute)) {
			return false;
		}
		JSXSpreadAttribute o = (JSXSpreadAttribute) other;
		return jsxSpreadAttribute.getName().subtreeMatch0(this._astMatcher, o.getName())&&jsxSpreadAttribute.getAssignment().subtreeMatch0(_astMatcher, o.getAssignment());
	}

	public boolean match(JSXAttributeDeclarationExpression jsxAttributeDeclarationStatement, Object other) {
		if(jsxAttributeDeclarationStatement==null)
		   return false;
	if(isReadyToUse ==false)
		  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
	if (!(other instanceof JSXAttributeDeclarationExpression)) {
		return false;
	}
	JSXAttributeDeclarationExpression o = (JSXAttributeDeclarationExpression) other;
		return _astMatcher.safeSubtreeListMatch(jsxAttributeDeclarationStatement.fragments(),o.fragments());
	}

	public boolean match(JSXOpeningElement jsxOpeningElement, Object other) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(jsxOpeningElement==null)
					   return false;
				if(isReadyToUse ==false)
					  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
				if (!(other instanceof JSXSelfClosingElement)) {
					return false;
				}
				JSXOpeningElement o = (JSXOpeningElement) other;
				// TODO Auto-generated method stub
				return jsxOpeningElement.getName().subtreeMatch0(this._astMatcher, o.getName())&&jsxOpeningElement.getAttributeStatement().subtreeMatch(this._astMatcher, o.getAttributeStatement());
			}

	public boolean match(JSXClosingElement jsxClosingElement, Object other) {
		// TODO Auto-generated method stub
		if(jsxClosingElement==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXClosingElement)) {
			return false;
		}
		JSXClosingElement o = (JSXClosingElement) other;
		// TODO Auto-generated method stub
		return jsxClosingElement.getName().subtreeMatch0(this._astMatcher, o.getName());
	}

	public boolean match(JSXElement jsxElement, Object other) {
		// TODO Auto-generated method stub
		if(jsxElement==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXElement)) {
			return false;
		}
		JSXElement o = (JSXElement) other;
		// TODO Auto-generated method stub
		return jsxElement.getOpeningElement().subtreeMatch0(this._astMatcher, o.getOpeningElement())&&jsxElement.getChildren().subtreeMatch0(this._astMatcher, o.getChildren())&&jsxElement.getClsoingElement().subtreeMatch0(this._astMatcher, o.getClsoingElement());
	}

	public boolean match(JSXChild jsxChild, Object other) {
		
		if(jsxChild==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXChild)) {
			return false;
		}
		JSXChild o = (JSXChild) other;
		// TODO Auto-generated method stub
		return jsxChild.getIdentifier().subtreeMatch0(this._astMatcher, o.getIdentifier());
	}

	public boolean match(JSXChildExpression jsxChildExpression, Object other) {
		// TODO Auto-generated method stub
		if(jsxChildExpression==null)
			   return false;
		if(isReadyToUse ==false)
			  throw new IllegalStateException("AST Matcher is  : >" + null + "<");
		if (!(other instanceof JSXChildExpression)) {
			return false;
		}
		JSXChildExpression o = (JSXChildExpression) other;
		// TODO Auto-generated method stub
		return jsxChildExpression.getChild().subtreeMatch0(this._astMatcher, o.getChild())&&_astMatcher.safeSubtreeListMatch(jsxChildExpression.fragments(),o.fragments());
	}
	
	
	
}
