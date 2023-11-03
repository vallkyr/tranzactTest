package countries;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import tests.*;


public class countries {

	public static void main(String[] args) {
		
		
				
		TestListenerAdapter listener = new TestListenerAdapter();
        TestNG testng = new TestNG();
      //*Would use this array to run multiple tests at once but my subscription plan limits me to 1 call to the API.
      //Class[] classes = {test01.class, test02.class, test03.class};
     //testng.setTestClasses(classes); //
        
    //Here we set the test that is going to be run.
        //test01: Validate US country Code
        //test02: Validate DE country code
        //test03: Validate GB country code
        //test04: Validate non existent country code
        testng.setTestClasses(new Class[] {test04.class});
        testng.addListener(listener);
        testng.run();
    }

	}

