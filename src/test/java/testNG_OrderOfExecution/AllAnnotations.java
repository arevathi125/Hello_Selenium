package testNG_OrderOfExecution;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AllAnnotations {
	
	 @BeforeClass
	  public void beforeClass() {
		  System.out.println("i am executing only once before first test method ");
	  }
	 @AfterClass
	  public void afterClass() {
		  System.out.println("i am executing only once after all test methods ");
	  }
	 @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("i am executing only once before all the tests  ");
	  }
	 @AfterSuite
	  public void afterSuite() {
		  System.out.println("i am executing only once before all the tests ");
	  }
	 @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("i am executing before every method ");
	  }
	 @AfterMethod
	  public void afterMethod() {
		  System.out.println("i am executing after every method ");
	  }
	 @Test
	 public void test() {
		  System.out.println("i am testing this Class ");
	  }
	 @Test
	 public void test1() {
		  System.out.println("i am testing this Class ");
	  }
	 
	
	
	  
}
