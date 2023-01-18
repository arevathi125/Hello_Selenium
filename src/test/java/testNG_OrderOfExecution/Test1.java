package testNG_OrderOfExecution;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void test001() {
		System.out.println("I am executing test001");
	}
	@Test
	public void test002() {
		System.out.println("I am executing test002");
	}
	@Test
	public void test003() {
		System.out.println("I am executing test003");
	}
	

}
