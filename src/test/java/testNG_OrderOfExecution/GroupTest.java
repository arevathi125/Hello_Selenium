package testNG_OrderOfExecution;

import org.testng.annotations.Test;

public class GroupTest {

	@Test(groups={"sanity"})
	public void test001() {
		System.out.println("I am executing test001");
	}
	@Test(groups={"smoke"})
	public void test002() {
		System.out.println("I am executing test002");
	}
	@Test(groups={"smoke","sanity"})
	public void test003() {
		System.out.println("I am executing test003");
	}
	
}
