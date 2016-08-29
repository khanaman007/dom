package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXText extends Name  {
  public JSXTextCharacter getJsxTextCharacter() {
		return jsxTextCharacter;
	}

	public void setJsxTextCharacter(JSXTextCharacter jsxTextCharacter) {
		this.jsxTextCharacter = jsxTextCharacter;
	}

	public JSXText getJsxText() {
		return jsxText;
	}

	public void setJsxText(JSXText jsxText) {
		this.jsxText = jsxText;
	}

private JSXTextCharacter jsxTextCharacter;
  private JSXText jsxText =null;
	public JSXText(AST ast) {
	
		super(ast);
		// TODO Auto-generated constructor stub
	}

	public static final ChildPropertyDescriptor JSXTEXTCHARACTER_PROPERTY =
			new ChildPropertyDescriptor(JSXTextCharacter.class, "jsxTextCharacter", JSXTextCharacter.class, MANDATORY,NO_CYCLE_RISK); //$NON-NLS-1$

		/**
		 * The "name" structural property of this node type (child type: {@link SimpleName}).
		 * @since 3.0
		 */
		public static final ChildListPropertyDescriptor FRAGMENTS_PROPERTY =
			new ChildListPropertyDescriptor(JSXText.class, "jsxText", JSXText.class,CYCLE_RISK); //$NON-NLS-1$
		
		/**
		 * A list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor}),
		 * or null if uninitialized.
		 */
		private static final List PROPERTY_DESCRIPTORS;

		static {
			List properyList = new ArrayList(3);
			createPropertyList(JSXText.class, properyList);
			addProperty(FRAGMENTS_PROPERTY, properyList);
			createPropertyList(JSXText.class, properyList);
			addProperty(FRAGMENTS_PROPERTY, properyList);
			PROPERTY_DESCRIPTORS = reapPropertyList(properyList);
		}
		public static List propertyDescriptors(int apiLevel) {
			return PROPERTY_DESCRIPTORS;
		}
		
		

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
			if (property == JSXTEXTCHARACTER_PROPERTY) {
				if (get) {
					return getJsxTextCharacter();
				} else {
					setJsxTextCharacter((JSXTextCharacter) child);
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
		public ASTNode.NodeList fragments() {
			return this.variableDeclarationFragments;
		}
		
		private ASTNode.NodeList variableDeclarationFragments =
				new ASTNode.NodeList(FRAGMENTS_PROPERTY);
		ASTNode clone0(AST target) {
			JSXText result = new JSXText(target);
			result.fragments().addAll(ASTNode.copySubtrees(target, fragments()));
			result.setJsxTextCharacter(getJsxTextCharacter());
			return result;
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
			
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
				acceptChild(visitor, getJsxTextCharacter());
				
				acceptChildren(visitor, fragments());
			}
			jstVisitor.endVisit(this);
			
		
			
		}

		@Override
		void appendName(StringBuffer buffer) {
			 
			buffer.append(getJsxTextCharacter());
			  
			   
			buffer.append(fragments());
			
		}

		@Override
		List internalStructuralPropertiesForType(int apiLevel) {
			// TODO Auto-generated method stub
			return PROPERTY_DESCRIPTORS;
		}

		@Override
		int getNodeType0() {
			// TODO Auto-generated method stub
			return JSXTEXT_NAME;
		}

		int memSize() {
			
			
				 
			 return BASE_NAME_NODE_SIZE + 2 * 4+this.jsxTextCharacter.memSize()+fragments().size();
			
			
		}

		/* (omit javadoc for this method)
		 * Method declared on ASTNode.
		 */
		int treeSize() {
			return memSize();
		}
		
}
