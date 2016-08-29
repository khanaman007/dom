package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXAttribute extends Expression {

	public JSXAttribute(AST ast) {
		super(ast);
		// TODO Auto-generated constructor stub
	}



	/**
	 * The "typeName" structural property of this node type (child type: {@link Name}).
	 */

	public static final ChildPropertyDescriptor NAME_PROPERTY =
			new ChildPropertyDescriptor(JSXAttribute.class, "name", JSXElementName.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

		/**
		 * The "name" structural property of this node type (child type: {@link SimpleName}).
		 * @since 3.0
		 */
		public static final ChildPropertyDescriptor NAME_VALUE_PROPERTY =
			new ChildPropertyDescriptor(JSXAttribute.class, "nameValue", JSXNameValuePair.class, MANDATORY, CYCLE_RISK); //$NON-NLS-1$

		/**
		 * A list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor}),
		 * or null if uninitialized.
		 */
		private static final List PROPERTY_DESCRIPTORS;

		static {
			List propertyList = new ArrayList(3);
			createPropertyList(JSXAttribute.class, propertyList);
			addProperty(NAME_VALUE_PROPERTY, propertyList);
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
		private JSXNameValuePair nameValue= null;

		/**
		 * The name being qualified; lazily initialized; defaults to a unspecified,
		 * legal Java identifier.
		 */
		private JSXElementName name = null;

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
			if (property == NAME_VALUE_PROPERTY) {
				if (get) {
					return getNameValue();
				} else {
					setNameValue((JSXNameValuePair) child);
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
			return super.internalGetSetChildProperty(property, get, child);
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final int getNodeType0() {
			return JSX_ATTIBUTE;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		ASTNode clone0(AST target) {
			JSXNamespacedName result = new JSXNamespacedName(target);
			result.setSourceRange(getStartPosition(), getLength());
			result.setQualifier((Name) getNameValue().clone(target));
			result.setName((SimpleName) getName().clone(target));
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
				acceptChild(visitor, getNameValue());
				acceptChild(visitor, getName());
				
			}
			jstVisitor.endVisit(this);
		}

		/**
		 * Returns the qualifier part of this qualified name.
		 *
		 * @return the qualifier part of this qualified name
		 */
		public JSXNameValuePair getNameValue() {
			if (this.nameValue == null) {
				// lazy init must be thread-safe for readers
				synchronized (this) {
					if (this.nameValue == null) {
						preLazyInit();
						this.nameValue = new JSXNameValuePair(this.ast);
						postLazyInit(this.nameValue, NAME_VALUE_PROPERTY);
					}
				}
			}
			return this.nameValue;
		}

		/**
		 * Sets the qualifier of this qualified name to the given name.
		 *
		 * @param qualifier the qualifier of this qualified name
		 * @exception IllegalArgumentException if:
		 * <ul>
		 * <li>the node belongs to a different AST</li>
		 * <li>the node already has a parent</li>
		 * <li>a cycle in would be created</li>
		 * </ul>
		 */
		public void setNameValue(JSXNameValuePair nameValue) {
			if (nameValue == null) {
				throw new IllegalArgumentException();
			}
			ASTNode oldChild = this.nameValue;
			preReplaceChild(oldChild, nameValue, NAME_VALUE_PROPERTY);
			this.nameValue = nameValue;
			postReplaceChild(oldChild, nameValue, NAME_VALUE_PROPERTY);
		}

		/**
		 * Returns the name part of this qualified name.
		 *
		 * @return the name being qualified
		 */
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
				memSize()
				+ (this.name == null ? 0 : getName().treeSize())
				+ (this.nameValue == null ? 0 : getNameValue().treeSize());
		}
}
