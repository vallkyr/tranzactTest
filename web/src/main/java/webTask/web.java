package webTask;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;


import tests.test01;
public class web {

	public static void main(String[] args) {

		       TestListenerAdapter listener = new TestListenerAdapter();
		       TestNG testng = new TestNG();
		       testng.setTestClasses(new Class[] {test01.class});
		       testng.addListener(listener);
		       testng.run();
		    }
		

	}
