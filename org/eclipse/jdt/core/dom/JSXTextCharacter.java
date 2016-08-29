package org.eclipse.jdt.core.dom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSXTextCharacter extends CharacterLiteral {
	

	 JSXTextCharacter(AST ast) {
	
		super(ast);
		// TODO Auto-generated constructor stub
	}
	
	public void checkValidJSXCharacter(char charValue){
		
		 if(charValue=='{'||charValue==','|| charValue=='<' ||charValue=='>' ||charValue== '}')
			  throw new IllegalArgumentException("illegal JSX character literal");//$NON-NLS-1$
		
		 
		 
	}
	@Override
	public void setEscapedValue(String value) {
	
	      String pattern = "{|,|<|>|}";//$NON-NLS-1$

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(value);
	      if (m.find( )) {
	    	  throw new IllegalArgumentException("illegal JSX character literal");//$NON-NLS-1$
	      }
		
		 super.setEscapedValue(value);
	}
	
	public void setCharValue(char value) {
		checkValidJSXCharacter(value);
		super.setCharValue(value);
	}
	
	
	ASTNode clone0(AST target) {
		
		CharacterLiteral result = new JSXTextCharacter(target);
		result.setSourceRange(getStartPosition(), getLength());
		result.setEscapedValue(getEscapedValue());
		return result;
	}
}
