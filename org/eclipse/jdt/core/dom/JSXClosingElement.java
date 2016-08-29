package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXClosingElement extends Name {



	
	   



		/**
		 * The "name" structural property of this node type (child type: {@link SimpleName}).
		 * @since 3.0
		 */
		public static final ChildPropertyDescriptor NAME_PROPERTY =
			new ChildPropertyDescriptor(JSXClosingElement.class, "name", JSXElementName.class, MANDATORY, NO_CYCLE_RISK); //$NON-NLS-1$
		
		

		/**
		 * A list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor}),
		 * or null if uninitialized.
		 */
		private static final List PROPERTY_DESCRIPTORS;

		static {
			List propertyList = new ArrayList(2);
			createPropertyList(JSXClosingElement.class, propertyList);
			
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
		JSXClosingElement(AST ast) {
			super(ast);
		}

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
			return JSX_SELFCLOSING_ELEMENT_NAME;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		ASTNode clone0(AST target) {
			JSXSelfClosingElement result = new JSXSelfClosingElement(target);
			result.setSourceRange(getStartPosition(), getLength());
			
			result.setName((JSXElementName)getName().clone0(target));
			
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
				
				acceptChild(visitor, getName());
			
			
				
			}
			jstVisitor.endVisit(this);
			
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
			buffer.append("<");
			getName().appendName(buffer);
			
			
		
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
				+ (this.name == null ? 0 : getName().treeSize())
			;
				
		}
		
		
		
		
		


}
