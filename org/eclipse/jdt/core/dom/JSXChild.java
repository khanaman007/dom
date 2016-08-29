package org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;

public class JSXChild extends Name {



	/**
	 * The "identifier" structural property of this node type (type: {@link String}).
	 *
	 * @since 3.0
	 */
	public static final ChildPropertyDescriptor IDENTIFIER_PROPERTY =
		new ChildPropertyDescriptor(JSXChild.class, "identifier", Name.class, OPTIONAL,CYCLE_RISK); //$NON-NLS-1$

	/**
	 * A list of property descriptors (element type:
	 * {@link StructuralPropertyDescriptor}),
	 * or null if uninitialized.
	 * @since 3.0
	 */
	private static final List PROPERTY_DESCRIPTORS;

	static {
		List propertyList = new ArrayList(2);
		createPropertyList(JSXElementName.class, propertyList);
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


	/**
	 * The identifier; defaults to a unspecified, legal Java identifier.
	 */
	private Name identifier = null;

	/**
	 * Creates a new AST node for a simple name owned by the given AST.
	 * The new node has an unspecified, legal Java identifier.
	 * <p>
	 * N.B. This constructor is package-private; all subclasses must be
	 * declared in the same package; clients are unable to declare
	 * additional subclasses.
	 * </p>
	 *
	 * @param ast the AST that is to own this node
	 */
	JSXChild(AST ast) {
		super(ast);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 * @since 3.0
	 */
	final List internalStructuralPropertiesForType(int apiLevel) {
		return propertyDescriptors(apiLevel);
	}

	
	final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
		
		if (property == IDENTIFIER_PROPERTY) {
			if (get) {
				return getIdentifier();
			} else {
				setIdentifier((Name) child);
				return null;
			}
		}
		
		// allow default implementation to flag the error
		return super.internalGetSetChildProperty(property, get, child);
	}

	
	final int getNodeType0() {
		return JSX_CHILD_NAME;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	ASTNode clone0(AST target) {
		JSXElementName result = new JSXElementName(target);
		result.setSourceRange(getStartPosition(), getLength());
		result.setIdentifier(getIdentifier());
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
		
		
		jstVisitor.visit(this);
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
	public Name getIdentifier() {
		if (this.identifier == null) {
			// lazy init must be thread-safe for readers
			synchronized (this) {
				if (this.identifier == null) {
					preLazyInit();
					this.identifier = (Name)getIdentifier().clone0(this.ast);
					postLazyInit(this.identifier, IDENTIFIER_PROPERTY);
				}
			}
		}
		return this.identifier;
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
	public void setIdentifier(Name identifier) {
		if (identifier == null) {
			throw new IllegalArgumentException();
		}
		ASTNode oldChild = this.identifier;
		preReplaceChild(oldChild, identifier, IDENTIFIER_PROPERTY);
		this.identifier = identifier;
		postReplaceChild(oldChild, identifier, IDENTIFIER_PROPERTY);
	}


	/* (omit javadoc for this method)
	 * This method is a copy of setIdentifier(String) that doesn't do any validation.
	 */
	



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
		int size = BASE_NAME_NODE_SIZE + 2 * 4 + this.getIdentifier().memSize();
		
		return size;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int treeSize() {
		return memSize();
	}


}
