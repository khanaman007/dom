package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;



public class JSXAttributeDeclarationExpression extends Expression {

	 private Expression attributeType =null;
	
	
	public JSXAttributeDeclarationExpression(AST ast) {
		super(ast);
		// TODO Auto-generated constructor stub
	}
	
	public static final ChildListPropertyDescriptor FRAGMENTS_PROPERTY =
			new ChildListPropertyDescriptor(VariableDeclarationStatement.class, "fragments", Expression.class, CYCLE_RISK); //$NON-NLS-1$
	
	public static final ChildPropertyDescriptor JSX_ATTRIBUTE_SPREAD_PROPERTY =
			new ChildPropertyDescriptor(VariableDeclarationStatement.class, "attributeType", Expression.class, MANDATORY, NO_CYCLE_RISK);  //$NON-NLS-1$

	public ASTNode.NodeList fragments() {
		return this.variableDeclarationFragments;
	}
	
	private ASTNode.NodeList variableDeclarationFragments =
			new ASTNode.NodeList(FRAGMENTS_PROPERTY);
	
	
	
	private static final List PROPERTY_DESCRIPTORS;

	static {
		List propertyList = new ArrayList(2);
		createPropertyList(VariableDeclarationStatement.class, propertyList);
		
		addProperty(FRAGMENTS_PROPERTY, propertyList);
		addProperty(JSX_ATTRIBUTE_SPREAD_PROPERTY, propertyList);
		PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
		
	}
	public static List propertyDescriptors(int apiLevel) {
		
		return PROPERTY_DESCRIPTORS;
	
}
	@Override
	List internalStructuralPropertiesForType(int apiLevel) {
		// TODO Auto-generated method stub
		return propertyDescriptors(apiLevel);
	}

	@Override
	int getNodeType0() {
		// TODO Auto-generated method stub
		return JSX_ATTRIBUTE_DECLARATION_STATEMENT;
	}

final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
		
		if (property == JSX_ATTRIBUTE_SPREAD_PROPERTY) {
			if (get) {
				return getAttributeType();
			} else {
				setAttributeType((Expression) child);
				return null;
			}
		}
		
		// allow default implementation to flag the error
		return super.internalGetSetChildProperty(property, get, child);
	}

final List internalGetChildListProperty(ChildListPropertyDescriptor property) {
	
	if (property == FRAGMENTS_PROPERTY) {
		return fragments();
	}
	// allow default implementation to flag the error
	return super.internalGetChildListProperty(property);
}
	
	ASTNode clone0(AST target) {
		JSXAttributeDeclarationExpression result = new JSXAttributeDeclarationExpression(target);
		result.setSourceRange(getStartPosition(), getLength());
		result.fragments().addAll(
				ASTNode.copySubtrees(target, fragments()));
		return result;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
		// dispatch to correct overloaded match method
		JSXASTMatcher jstMatcher= JSXASTMatcher.getInstance();
		jstMatcher.setASTMatcher(matcher);
		
		
		return jstMatcher.match(this, other);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	void accept0(ASTVisitor visitor) {
		JSXVisitor jstVisitor= JSXVisitor.getInstance();
		jstVisitor.setASTVisitor(visitor);
		
		
		boolean visitChildren = jstVisitor.visit(this);
		if (visitChildren) {
			// visit children in normal left to right reading order
			acceptChildren(visitor, variableDeclarationFragments);
			
			
		}
		jstVisitor.endVisit(this);
	}

	
	int memSize() {
		return this.variableDeclarationFragments.listSize()+this.attributeType.memSize() + 4 * 4;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int treeSize() {
		return
			memSize();
	}
	
	public Expression getAttributeType() {
		if (this.attributeType == null) {
			// lazy init must be thread-safe for readers
			synchronized (this) {
				if (this.attributeType == null) {
					preLazyInit();
					  if( attributeType instanceof JSXAttribute)
					this.attributeType = new JSXAttribute(this.ast);
					  else if ( attributeType instanceof JSXSpreadAttribute){
						  this.attributeType = new JSXSpreadAttribute(this.ast);
					  }
					postLazyInit(this.attributeType,JSX_ATTRIBUTE_SPREAD_PROPERTY);
				}
			}
		}
		return this.attributeType;
	}
	
	
	public void setAttributeType(Expression attributeType) {
		if (attributeType == null) {
			throw new IllegalArgumentException();
		}
		ASTNode oldChild = this.attributeType;
		preReplaceChild(oldChild, attributeType, JSX_ATTRIBUTE_SPREAD_PROPERTY);
		this.attributeType = attributeType;
		postReplaceChild(oldChild, attributeType, JSX_ATTRIBUTE_SPREAD_PROPERTY);
	}
}
