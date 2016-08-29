package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXSpreadAttribute extends Expression {
	private JSXElementName name = null;
	 JSXSpreadAttribute(AST ast) {
		super(ast);
		// TODO Auto-generated constructor stub
	}

	

		/**
		 * The "name" structural property of this node type (child type: {@link SimpleName}).
		 * @since 3.0
		 */
	
	public static final ChildPropertyDescriptor NAME_PROPERTY =
			new ChildPropertyDescriptor(JSXAttribute.class, "name", JSXElementName.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$
		public static final ChildPropertyDescriptor ASSIGNMENT_PROPERTY =
			new ChildPropertyDescriptor(JSXAttribute.class, "nameValue", Assignment.class,MANDATORY, CYCLE_RISK); //$NON-NLS-1$

		/**
		 * A list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor}),
		 * or null if uninitialized.
		 */
		private static final List PROPERTY_DESCRIPTORS;

		static {
			List propertyList = new ArrayList(3);
			createPropertyList(JSXAttribute.class, propertyList);
			addProperty(ASSIGNMENT_PROPERTY, propertyList);
			addProperty(NAME_PROPERTY, propertyList);
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
		 * The identifier; lazily initialized; defaults to a unspecified, legal
		 * Java identifier.
		 */
		private Expression  assignment= null;

				 
		final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
			
			
			
			if (property == ASSIGNMENT_PROPERTY) {
				if (get){
					return getAssignment();
				}else {
					setAssignment((Expression) child);
					return null;
				}
			}
			if (property == NAME_PROPERTY) {
				if (get) {
					return getName();
				} else {
					setName((JSXElementName) child);
					return null;
				}
			}
			
			// allow default implementation to flag the error
			return super.internalGetSetChildProperty(property, get,child );
		}
		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final int getNodeType0() {
			return JSX_SPREAD_ATTIBUTE;
		}

	
	@Override
	boolean subtreeMatch0(ASTMatcher matcher, Object other) {
		// TODO Auto-generated method stub
		JSXASTMatcher jstMatcher= JSXASTMatcher.getInstance();
		jstMatcher.setASTMatcher(matcher);
		
		
		return jstMatcher.match(this, other);
	}

	@SuppressWarnings("unchecked")
	@Override
	ASTNode clone0(AST target) {
		// TODO Auto-generated method stub
		JSXSpreadAttribute result = new JSXSpreadAttribute(target);
		result.setSourceRange(getStartPosition(), getLength());
	
		
		result.setName(getName());
		result.setAssignment(getAssignment());
		
		return result;
	}

	@Override
	void accept0(ASTVisitor visitor) {
		JSXVisitor jstVisitor= JSXVisitor.getInstance();
		jstVisitor.setASTVisitor(visitor);
		
		
	
		boolean visitChildren = jstVisitor.visit(this);
		if (visitChildren) {
			// visit children in normal left to right reading order
			
			acceptChild(visitor, getName());
			acceptChild(visitor, getAssignment());
		
			
		}
		jstVisitor.endVisit(this);
		
	}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		int memSize() {
			return BASE_NODE_SIZE + 1 * 4;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.BASE_NODE_SIZE + 1 * 4;
		 */
		int treeSize() {
			return
				+ (this.assignment == null ? 0 : assignment.memSize());
		}

		@Override
		List internalStructuralPropertiesForType(int apiLevel) {
			// TODO Auto-generated method stub
			return propertyDescriptors(apiLevel);
		}
		
		public Expression  getAssignment() {
			// more efficient than just calling unsupportedIn2() to check
			if (this.assignment == null) {
				unsupportedIn2();
			}
			return this.assignment;
		}
		
		public void setAssignment(Expression assignment) {
			if (assignment == null) {
				throw new IllegalArgumentException();
			}
			ASTNode oldChild = this.assignment;
			preReplaceChild(oldChild, assignment, ASSIGNMENT_PROPERTY);
			this.assignment = assignment;
			postReplaceChild(oldChild, assignment, ASSIGNMENT_PROPERTY);
		}
		
		public JSXElementName getName() {
			if (this.name == null) {
				// lazy init must be thread-safe for readers
				synchronized (this) {
					if (this.name == null) {
						preLazyInit();
						this.name = new JSXElementName(this.ast);
						postLazyInit(this.name, NAME_PROPERTY);
					}
				}
			}
			return this.name;
		}

		/**
		 * Sets the name part of this qualified name to the given simple name.
		 *
		 * @param name the identifier of this qualified name
		 * @exception IllegalArgumentException if:
		 * <ul>
		 * <li>the node belongs to a different AST</li>
		 * <li>the node already has a parent</li>
		 * </ul>
		 */
		public void setName(JSXElementName name) {
			if (name == null) {
				throw new IllegalArgumentException();
			}
			ASTNode oldChild = this.name;
			preReplaceChild(oldChild, name, NAME_PROPERTY);
			this.name = name;
			postReplaceChild(oldChild, name, NAME_PROPERTY);
		}

		/* (omit javadoc for this method)
		 * Method declared on Name.
		 */
		void appendName(StringBuffer buffer) {
			
			
			getName().appendName(buffer);
		}

}
