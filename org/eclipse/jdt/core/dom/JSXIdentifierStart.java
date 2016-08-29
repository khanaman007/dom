package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXIdentifierStart extends Name {
	private SimpleName identifier = null;;
	
	public static final SimplePropertyDescriptor IDENTIFIER_PROPERTY =
		new SimplePropertyDescriptor(JSXIdentifierStart.class, "identifier", String.class, MANDATORY); //$NON-NLS-1$

	/**
	 * A list of property descriptors (element type:
	 * {@link StructuralPropertyDescriptor}),
	 * or null if uninitialized.
	 * @since 3.0
	 */
	private static final List PROPERTY_DESCRIPTORS;

	static {
		List propertyList = new ArrayList(2);
		createPropertyList(JSXIdentifierStart.class, propertyList);
		addProperty(IDENTIFIER_PROPERTY, propertyList);
		PROPERTY_DESCRIPTORS = reapPropertyList(propertyList);
	}

	/**
	 * Returns a list of structural property descriptors for this node type.
	 * Clients must not modify the result.
	 *
	 * @param apiLevel the API level; one of the AST.JLS* constants
	 * @return a list of property descriptors (element type:
	 * {@link StructuralPropertyDescriptor})
	 * @since 3.0
	 */
	public static List propertyDescriptors(int apiLevel) {
		return PROPERTY_DESCRIPTORS;
	}

	JSXIdentifierStart(AST ast) {
		super(ast);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 * @since 3.0
	 */
	final List internalStructuralPropertiesForType(int apiLevel) {
		return propertyDescriptors(apiLevel);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	final Object internalGetSetObjectProperty(SimplePropertyDescriptor property, boolean get, Object value) {
		if (property == IDENTIFIER_PROPERTY) {
			if (get) {
				return getIdentifier();
			} else {
				setIdentifier((SimpleName) value);
				return null;
			}
		}
		// allow default implementation to flag the error
		return super.internalGetSetObjectProperty(property, get, value);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	 int getNodeType0() {
		return JSXIDENTIFIER_START_NAME;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	ASTNode clone0(AST target) {
		JSXIdentifierStart result = new JSXIdentifierStart(target);
		
		result.setIdentifier(getIdentifier());
		return result;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
		if (!(other instanceof JSXIdentifierStart)) {
			return false;
		}
		JSXASTMatcher jstMatcher= JSXASTMatcher.getInstance();
		jstMatcher.setASTMatcher(matcher);
		return jstMatcher.match(this, other);
		
		
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	void accept0(ASTVisitor visitor) {
		JSXVisitor jsxVisitor=JSXVisitor.getInstance();
		jsxVisitor.setASTVisitor(visitor);
		jsxVisitor.visit(this);
		jsxVisitor.endVisit(this);
		
	}

	/**
	 * Returns this node's identifier.
	 *
	 * @return the identifier of this node
	 */
	public SimpleName getIdentifier() {
		return this.identifier;
	}

	/**
	 * Sets the identifier of this node to the given value.
	 * The identifier should be legal according to the rules
	 * of the Java language. Note that keywords are not legal
	 * identifiers.
	 * <p>
	 * Note that the list of keywords may depend on the version of the
	 * language (determined when the AST object was created).
	 * </p>
	 *
	 * @param identifier the identifier of this node
	 * @exception IllegalArgumentException if the identifier is invalid
	 */
	public void setIdentifier(SimpleName identifier) {
		// update internalSetIdentifier if this is changed
		if (identifier == null) {
			throw new IllegalArgumentException();
		}
		String jsxIdentifier =identifier.getIdentifier();
		 if(jsxIdentifier.indexOf("'\'")!=-1)
				 throw new IllegalArgumentException("Invalid identifier : >" + identifier + "<"); 
		preValueChange(IDENTIFIER_PROPERTY);
		this.identifier = identifier;
		postValueChange(IDENTIFIER_PROPERTY);
	}

	/* (omit javadoc for this method)
	 * This method is a copy of setIdentifier(String) that doesn't do any validation.
	 */
	void internalSetIdentifier(SimpleName identifier) {
		preValueChange(IDENTIFIER_PROPERTY);
		this.identifier = identifier;
		postValueChange(IDENTIFIER_PROPERTY);
	}

	
	public boolean isDeclaration() {
		
		return getIdentifier().isDeclaration();
	}

	/* (omit javadoc for this method)
	 * Method declared on Name.
	 */
	void appendName(StringBuffer buffer) {
		buffer.append(getIdentifier());
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int memSize() {
		int size = BASE_NAME_NODE_SIZE + 2 * 4+ identifier.memSize();
		
		return size;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int treeSize() {
		return memSize();
	}
}
