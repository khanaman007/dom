

import java.io.InputStream;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;

@RunWith(DataProviderRunner.class)
public class JSXTest {

    @Test
    @DataProvider(value = {
           
            "EmptyJSX1.java",
            "EmptyJSX2.java",
            "EmptyJSX3.java",
            "NameSpaceEmptyJSX1.java",
            "NameSpaceEmptyJSX2.java",
            "NameSpaceEmptyJSX1.java",
            "NameSpaceEmptyJSX2.java",
            "AttributesJSX1.java",
            "AttributesJSX2.java",
            "AttributesJSX3.java",
            "AttributesJSX4.java",
            "ChildrenJSX1.java",
            "ChildrenJSX2.java",
            "ChildrenJSX3.java",
            "ChildrenJSX4.java",
            "TextNodeJSX1.java",
            "JSX1.java",
            "Test.java",
            "CommentJSX1.java",
            "CommentJSX2.java",
            "CommentJSX3.java",
            "CommentJSX4.java",
            "CommentJSX5.java",
            "CommentJSX6.java"
    })
    public void testSuccess(String resource) throws Exception {
    	try{
        		ASTParser parser = ASTParser.newParser(AST.JLS3);
        		parser.setSource(" public class A {  java.lang.Integer str = 1234 ; boolean bool= (str==234) ;int i = 9;  \n int j; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; public void mm(){ <text/> return ;} }".toCharArray());
        		//parser.setSource("/*abc*/".toCharArray());
        		parser.setKind(ASTParser.K_COMPILATION_UNIT);
        		//ASTNode node = parser.createAST(null);
        		
        		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        		InputStream in = JSXTest.class.getClassLoader().getSystemResourceAsStream("jsx/"+resource);
        
          
            System.out.println(cu.toString());
        	}catch(Exception exp){
        		 System.out.println(exp.getMessage());
        	}
           
        }
    

 
}
