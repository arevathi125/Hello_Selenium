package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class juiceShopBasic {
WebDriver driver ;
	
	@Test(priority = 1)
	public void launchingPart()
	{
		System.setProperty("WebDriver.edge.driver", "C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://juiceshop.myspreadshop.com/");
}
	@Test(priority = 2)
	public void executionPart()
	{
		WebElement getDrop = driver.findElement(By.xpath("//*[@id=\"sprd-department-filter__department-D2\"]/svg/use"));
//		Select drop = new Select(getDrop);
//		drop.selectByVisibleText("T-Shirts");
		WebElement tShirts = driver.findElement(By.xpath("//*[@id=\"mobileSubFilter-D2-P30\"]/a"));
		tShirts.click();
		
}
}
