package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXElement extends Name {

	public JSXElement(AST ast) {
		super(ast);
		// TODO Auto-generated constructor stub
	}
	 

private JSXChildExpression children=null;
public JSXChildExpression getChildren() {
	if (this.children == null) {
		// lazy init must be thread-safe for readers
		synchronized (this) {
			if (this.children == null) {
				preLazyInit();
				this.children = new JSXChildExpression(this.ast);
				postLazyInit(this.children, CHILDREN_PROPERTY);
			}
		}
	}
	

	return this.children;
}

public void setChildren(JSXChildExpression children) {
	if (children == null) {
		throw new IllegalArgumentException();
	}
	ASTNode oldChild = this.children;
	preReplaceChild(oldChild, children, SELFCLOSING_OPEN_PROPERTY);
	this.children = children;
	postReplaceChild(oldChild, children, SELFCLOSING_OPEN_PROPERTY);
}

public JSXClosingElement getClsoingElement() {
	
	if (this.clsoingElement== null) {
		// lazy init must be thread-safe for readers
		synchronized (this) {
			if (this.clsoingElement == null) {
				preLazyInit();
				this.clsoingElement = new JSXClosingElement(this.ast);
				postLazyInit(this.clsoingElement, CLOSING_PROPERTY);
			}
		}
	}
	return this.clsoingElement;
}

public void setClsoingElement(JSXClosingElement clsoingElement) {
	if (this.clsoingElement == null) {
		// lazy init must be thread-safe for readers
		synchronized (this) {
			if (this.clsoingElement == null) {
				preLazyInit();
				this.clsoingElement = new JSXClosingElement(this.ast);
				postLazyInit(this.clsoingElement, CLOSING_PROPERTY);
			}
		}
	}
}

public void setOpeningElement(Expression name) {
	if (this.openingElement == null) {
		// lazy init must be thread-safe for readers
		synchronized (this) {
			if (this.openingElement == null) {
				preLazyInit();
				this.openingElement = new JSXChildExpression(this.ast);
				postLazyInit(this.openingElement, CLOSING_PROPERTY);
			}
		}
	}
	
}


private JSXClosingElement clsoingElement=null;  


		/**
		 * The "name" structural property of this node type (child type: {@link SimpleName}).
		 * @since 3.0
		 */
		public static final ChildPropertyDescriptor SELFCLOSING_OPEN_PROPERTY =
			new ChildPropertyDescriptor(JSXElement.class, "openingElement", Expression.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$
		
		public static final ChildPropertyDescriptor CHILDREN_PROPERTY =
				new ChildPropertyDescriptor(JSXElement.class, "children", JSXChildExpression.class, OPTIONAL, NO_CYCLE_RISK); //$NON-NLS-1$
		public static final ChildPropertyDescriptor CLOSING_PROPERTY =
				new ChildPropertyDescriptor(JSXElement.class, "clsoingElement", JSXClosingElement.class, MANDATORY, NO_CYCLE_RISK); //$NON-NLS-1$

		/**
		 * A list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor}),
		 * or null if uninitialized.
		 */
		private static final List PROPERTY_DESCRIPTORS;

		static {
			List propertyList = new ArrayList(2);
			createPropertyList(JSXElement.class, propertyList);
			
			addProperty(SELFCLOSING_OPEN_PROPERTY, propertyList);

			addProperty(CHILDREN_PROPERTY, propertyList);
			addProperty(CLOSING_PROPERTY, propertyList);
			PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
		}

		/**
		 * Returns a list of structural property descriptors for this node type.
		 * Clients must not modify the result.
		 *
		 * @param apiLevel the API level; one of the
		 * <code>AST.JLS*</code> constants
		 * @return a list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor})
		 * @since 3.0
		 */
		public static List propertyDescriptors(int apiLevel) {
			return PROPERTY_DESCRIPTORS;
		}

		

		/**
		 * The name being qualified; lazily initialized; defaults to a unspecified,
		 * legal Java identifier.
		 */
		private Expression openingElement = null;

		/**
		 * Creates a new AST node for a qualified name owned by the given AST.
		 * <p>
		 * N.B. This constructor is package-private; all subclasses must be
		 * declared in the same package; clients are unable to declare
		 * additional subclasses.
		 * </p>
		 *
		 * @param ast the AST that is to own this node
		 */
		

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final List internalStructuralPropertiesForType(int apiLevel) {
			return propertyDescriptors(apiLevel);
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
		
			if (property == SELFCLOSING_OPEN_PROPERTY) {
				if (get) {
					return getOpeningElement();
				} else {
					setOpeningElement((Expression) child);
					return null;
				}
			}
			if (property == CHILDREN_PROPERTY) {
				if (get) {
					return getChildren();
				} else {
					setChildren((JSXChildExpression) child);
					return null;
				}
			}
			
			if (property == CLOSING_PROPERTY) {
				if (get) {
					return getClsoingElement();
				} else {
					setClsoingElement((JSXClosingElement) child);
					return null;
				}
			}
			// allow default implementation to flag the error
			return super.internalGetSetChildProperty(property, get, child);
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final int getNodeType0() {
			return JSX_SELFCLOSING_ELEMENT_NAME;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		ASTNode clone0(AST target) {
			JSXElement result = new JSXElement(target);
			result.setSourceRange(getStartPosition(), getLength());
			
			result.setOpeningElement(((Expression)getOpeningElement().clone0(target)));
			result.setChildren((JSXChildExpression)getChildren().clone0(target));
			result.setClsoingElement((JSXClosingElement)getClsoingElement().clone0(target));
			return result;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		
		@Override
		final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
			// TODO Auto-generated method stub
			JSXASTMatcher jstMatcher= JSXASTMatcher.getInstance();
			jstMatcher.setASTMatcher(matcher);
			
			
			return jstMatcher.match(this, other);
		}

		

		@Override
		void accept0(ASTVisitor visitor) {
			JSXVisitor jstVisitor= JSXVisitor.getInstance();
			jstVisitor.setASTVisitor(visitor);
			
			
		
			boolean visitChildren = jstVisitor.visit(this);
			if (visitChildren) {
				// visit children in normal left to right reading order
				
				acceptChild(visitor, getOpeningElement());
				acceptChild(visitor, getChildren());
				acceptChild(visitor, getClsoingElement());
			
				
			}
			jstVisitor.endVisit(this);
			
		}

		
		
		
		public Expression getOpeningElement() {
			if (this.openingElement != null) {
				// lazy init must be thread-safe for readers
				synchronized (this) {
					if (this.openingElement == null) {
						preLazyInit();
						 if(openingElement instanceof JSXSelfClosingElement)
						this.openingElement = new JSXSelfClosingElement(this.ast);
						 else if (openingElement instanceof JSXOpeningElement)
							 this.openingElement = new JSXOpeningElement(this.ast);
						postLazyInit(this.openingElement, SELFCLOSING_OPEN_PROPERTY);
					}
				}
			}
			return this.openingElement;
		}

		
		public void seOpeningElement(Expression name) {
			if (openingElement == null) {
				throw new IllegalArgumentException();
			}
			ASTNode oldChild = this.openingElement;
			preReplaceChild(oldChild, openingElement, SELFCLOSING_OPEN_PROPERTY);
			this.openingElement = openingElement;
			postReplaceChild(oldChild, openingElement, SELFCLOSING_OPEN_PROPERTY);
		}

		/* (omit javadoc for this method)
		 * Method declared on Name.
		 */
		void appendName(StringBuffer buffer) {
			buffer.append("<");
			buffer.append(getOpeningElement());
			buffer.append(" ");
			buffer.append(getChildren());
			buffer.append(" ");
			buffer.append(getClsoingElement());
		
			buffer.append("/>");
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		int memSize() {
			return BASE_NAME_NODE_SIZE + 3 * 4;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		int treeSize() {
			return
				memSize()
				+ (this.openingElement == null ? 0 : getOpeningElement().treeSize())
			+ (this.children == null ? 0 : getChildren().treeSize())
			+ (this.clsoingElement == null ? 0 : getClsoingElement().treeSize());
				
		}
		
		
		
		



}
