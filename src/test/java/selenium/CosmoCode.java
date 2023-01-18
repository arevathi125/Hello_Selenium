package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CosmoCode {

	public static void main(String[] args) {
		WebDriver edgedriver;

		System.setProperty("webdriver.edge.driver", "C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\geckodriver.exe");
		WebDriverManager.edgedriver().setup();
		edgedriver = new EdgeDriver();
		//edgedriver.manage().window().maximize();

		edgedriver.get("https://cosmocode.io/automation-practice/");
		edgedriver.findElement(By.id("firstname")).sendKeys("Revathi");
		edgedriver.findElement(By.className("lastname")).sendKeys("Anbazhagan");
		edgedriver.findElement(By.xpath("//*[@id=\"post-433\"]/div/div/input[4]")).click();
		edgedriver.findElement(By.name("language_java")).click();
		edgedriver.findElement(By.name("language_python")).click();
		WebElement ageSelect = edgedriver.findElement(By.name("age"));
		Select age = new Select(ageSelect);
		age.selectByVisibleText("Not Born"); 
		edgedriver.findElement(By.id("submit_htmlform")).click();
		edgedriver.findElement(By.partialLinkText(""));

	}

}
