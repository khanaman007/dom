package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXNameValuePair extends BodyDeclaration {
	
	private JSXElementName name=null;
	private ASTNode.NodeList values =
			new ASTNode.NodeList(VALUE_PROPERTY);

	


	JSXNameValuePair(AST ast) {
		super(ast);
		  unsupportedIn2();
		// TODO Auto-generated constructor stub
	}

	
	public static final ChildPropertyDescriptor NAME_PROPERTY =
			new ChildPropertyDescriptor(JSXNameValuePair.class, "name", JSXElementName.class, MANDATORY, NO_CYCLE_RISK); //$NON-NLS-1$

		/**
		 * The "value" structural property of this node type (child type: {@link Expression}).
		 */
		public static final ChildListPropertyDescriptor VALUE_PROPERTY =
				new ChildListPropertyDescriptor(JSXNameValuePair.class, "value", Expression.class, CYCLE_RISK);
		
		
		private static final List PROPERTY_DESCRIPTORS;

		static {
			List propertyList = new ArrayList(3);
			createPropertyList(JSXNameValuePair.class, propertyList);
			addProperty(NAME_PROPERTY, propertyList);
			addProperty(VALUE_PROPERTY, propertyList);
			PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
		}

		/**
		 * Returns a list of structural property descriptors for this node type.
		 * Clients must not modify the result.
		 *
		 * @param apiLevel the API level; one of the AST.JLS* constants
		 * @return a list of property descriptors (element type:
		 * {@link StructuralPropertyDescriptor})
		 */
		public static List propertyDescriptors(int apiLevel) {
			return PROPERTY_DESCRIPTORS;
		}
		
	
	@Override
	final SimplePropertyDescriptor internalModifiersProperty() {
		// this property will not be asked for (node type did not exist in JLS2)
		return null;
	}

	@Override
	ChildListPropertyDescriptor internalModifiers2Property() {
		// TODO Auto-generated method stub
		return VALUE_PROPERTY;
	}

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
	final List internalGetChildListProperty(ChildListPropertyDescriptor property) {
		if (property == VALUE_PROPERTY) {
			return modifiers();
		}
		// allow default implementation to flag the error
		return super.internalGetChildListProperty(property);
	}
	
	@Override
	final ChildPropertyDescriptor internalJavadocProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List internalStructuralPropertiesForType(int apiLevel) {
		// TODO Auto-generated method stub
		return propertyDescriptors(apiLevel);
	}

	@Override
	int getNodeType0() {
		// TODO Auto-generated method stub
		return JSX_NAME_VALUE;
	}

	@Override
	boolean subtreeMatch0(ASTMatcher matcher, Object other) {
		// TODO Auto-generated method stub
		JSXASTMatcher jstMatcher= JSXASTMatcher.getInstance();
		jstMatcher.setASTMatcher(matcher);
		
		
		return jstMatcher.match(this, other);
	}

	@Override
	ASTNode clone0(AST target) {
		// TODO Auto-generated method stub
		JSXNameValuePair result = new JSXNameValuePair(target);
		result.setSourceRange(getStartPosition(), getLength());
	
		result.setName((JSXElementName) getName().clone(target));
		result.values().addAll(ASTNode.copySubtrees(target, values()));
		
		return result;
	}

	@Override
	void accept0(ASTVisitor visitor) {
		JSXVisitor jstVisitor= JSXVisitor.getInstance();
		jstVisitor.setASTVisitor(visitor);
		
		
	
		boolean visitChildren = jstVisitor.visit(this);
		if (visitChildren) {
			// visit children in normal left to right reading order
			
			acceptChildren(visitor, this.values);
		
			acceptChild(visitor, getName());
			
		}
		jstVisitor.endVisit(this);
		
	}

	int memSize() {
		return super.memSize() + 3 * 4;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int treeSize() {
		return
			memSize()
			
			+ this.values.listSize()
			+ (this.name == null ? 0 : getName().treeSize());
			
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
	
	public List<Expression> values() {
		// more efficient than just calling unsupportedIn2() to check
		if (this.values == null) {
			unsupportedIn2();
		}
		return this.values;
	}
	
	
}
