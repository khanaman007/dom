/**
 * 
 */
package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amakha1
 *
 */
public class JSXChildExpression extends Expression {


	 private JSXChild child =null;
	
	
	
	
	public static final ChildListPropertyDescriptor FRAGMENTS_PROPERTY =
			new ChildListPropertyDescriptor(JSXChildExpression.class, "fragments", Expression.class, CYCLE_RISK); //$NON-NLS-1$
	
	public static final ChildPropertyDescriptor JSX_CHILD_PROPERTY =
			new ChildPropertyDescriptor(JSXChildExpression.class, "child", JSXChild.class, MANDATORY, NO_CYCLE_RISK); //$NON-NLS-1$

	public List fragments() {
		return this.variableDeclarationFragments;
	}
	
	private ASTNode.NodeList variableDeclarationFragments =
			new ASTNode.NodeList(FRAGMENTS_PROPERTY);
	
	
	
	private static final List PROPERTY_DESCRIPTORS;

	static {
		List propertyList = new ArrayList(3);
		createPropertyList(JSXChildExpression.class, propertyList);
		
		addProperty(FRAGMENTS_PROPERTY, propertyList);
		addProperty(JSX_CHILD_PROPERTY, propertyList);
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
		
		if (property == JSX_CHILD_PROPERTY) {
			if (get) {
				return getChild();
			} else {
				setChild((JSXChild) child);
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
		return this.variableDeclarationFragments.listSize()+this.child.memSize() + 4 * 4;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int treeSize() {
		return
			memSize();
	}
	
	public JSXChild getChild() {
		if (this.child == null) {
			// lazy init must be thread-safe for readers
			synchronized (this) {
				if (this.child == null) {
					preLazyInit();
					
						  this.child = new JSXChild(this.ast);
					  
					postLazyInit(this,JSX_CHILD_PROPERTY);
				}
			}
		}
		return this.child;
	}
	
	
	public void setChild(JSXChild child) {
		if (child == null) {
			throw new IllegalArgumentException();
		}
		ASTNode oldChild = this.child;
		preReplaceChild(oldChild, child, JSX_CHILD_PROPERTY);
		this.child = child;
		postReplaceChild(oldChild, child, JSX_CHILD_PROPERTY);
	}


	/**
	 * @param ast
	 */
	 JSXChildExpression(AST ast) {
		super(ast);
		// TODO Auto-generated constructor stub
	}

	
}
