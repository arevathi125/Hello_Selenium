package testNG_OrderOfExecution;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void test004() {
		System.out.println("I am executing test004");
	}
	@Test
	public void test005() {
		System.out.println("I am executing test005");
	}
	@Test
	public void test006() {
		System.out.println("I am executing test006");
	}
	
	@DataProvider
	public Object[][] test007() {
		Object[][] data = {{1,"name1"},{2,"name2"}};
		return data;
			}
	@Test(dataProvider = "test007")
	public void test008(int rollnum,String name) {
		System.out.println("Roll no : " + rollnum + "\nName : " +name );
	}
}
