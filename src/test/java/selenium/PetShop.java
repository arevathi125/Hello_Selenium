package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class PetShop {
WebDriver driver ;
	
	@Test(priority = 1)
	public void launchingPart()
	{
		System.setProperty("WebDriver.edge.driver", "C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
}

	@Test(priority = 2)
	public void executionPart() throws InterruptedException
	{
		 driver.findElement(By.name("keyword")).sendKeys("Dogs");
		 Thread.sleep(30);
		WebElement part = driver.findElement(By.name("searchProducts"));
		part.click();
	}
}
