package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXIdentifier extends Name {
   
	private JSXIdentifierStart jsxIdentifierStart =null;
	
	
	public JSXIdentifierStart getJsxIdentifierStart() {
		return this.jsxIdentifierStart;
	}

	public void setJsxIdentifierStart(JSXIdentifierStart jsxIdentifierStart) {
		this.jsxIdentifierStart = jsxIdentifierStart;
	}

	
	JSXIdentifier(AST ast) {
		super(ast);
	}
	
	public static final ChildPropertyDescriptor JSXIDENTIFIERSTART_PROPERTY =
			new ChildPropertyDescriptor(JSXIdentifier.class, "jsxIdentifierStart", JSXIdentifierStart.class, OPTIONAL, CYCLE_RISK); //$NON-NLS-1$

	
	
	/**
	 * A list of property descriptors (element type:
	 * {@link StructuralPropertyDescriptor}),
	 * or null if uninitialized.
	 */
	private static final List PROPERTY_DESCRIPTORS;

	static {
		List propertyList = new ArrayList(4);
		createPropertyList(JSXIdentifier.class, propertyList);
		addProperty(JSXIDENTIFIERSTART_PROPERTY, propertyList);
		
		
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

	void appendName(StringBuffer buffer) {
		
		getJsxIdentifierStart().appendName(buffer);
		
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
			+ (this.jsxIdentifierStart == null ? 0 : getJsxIdentifierStart().treeSize());
	}

	@Override
	final List internalStructuralPropertiesForType(int apiLevel) {
		return propertyDescriptors(apiLevel);
	}

	@Override
	int getNodeType0() {
		// TODO Auto-generated method stub
		return JSX_IDENTIFIER_NAME;
	}

	@Override
	boolean subtreeMatch0(ASTMatcher matcher, Object other) {
		JSXASTMatcher jstMatcher= JSXASTMatcher.getInstance();
		jstMatcher.setASTMatcher(matcher);
		return jstMatcher.match(this, other);
	}

	@Override
	ASTNode clone0(AST target) {
		JSXIdentifier result = new JSXIdentifier(target);
		result.setJsxIdentifierStart(getJsxIdentifierStart());
		
		 
		return result;
		
	}

	@Override
	void accept0(ASTVisitor visitor) {
		JSXVisitor jstVisitor= JSXVisitor.getInstance();
		jstVisitor.setASTVisitor(visitor);
		
		
		boolean visitChildren = jstVisitor.visit(this);
		if (visitChildren) {
			// visit children in normal left to right reading order
			acceptChild(visitor, getJsxIdentifierStart());
			
		}
		jstVisitor.endVisit(this);
		
	}
}
