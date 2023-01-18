package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NumpyNinja {
	
	//public static void main(String[] args) {
		
	
	
	WebDriver edgedriver;
	
	@Test(priority = 1)
	  public void launchNumpyNinja() { 
	
	    System.setProperty("webdriver.gecko.driver","C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\msedgedriver.exe");
			 WebDriverManager.edgedriver().setup();
			 edgedriver = new EdgeDriver();
			 edgedriver.get("https://www.numpyninja.com/contact");
	  } 
			 
	   @DataProvider
	   public Object[][] contactDetails(){
		   String contact[][] = {{"fhjk","lname1","ghjkl@gmail.com","5678290"},
				   {"fname2","lname2","ghjkl@gmail.com","5678290"},
				   {"fname3","lname3","ghjkl@gmail.com","5678290"}};
		  	   
	   return contact;
	   }


      @Test(priority = 2, dataProvider = "contactDetails")
      public void valuesForContactDetails(String fName,String lName,String mail,String phone) {
    	  WebElement fNameVal = edgedriver.findElement(By.name("first-name"));
    	  fNameVal.clear();
    	  fNameVal.sendKeys(fName);
    	  
    	  WebElement lNameVal = edgedriver.findElement(By.name("last-name"));
    	  lNameVal.clear();
    	  lNameVal.sendKeys(lName);
    	  
    	  WebElement mailVal = edgedriver.findElement(By.name("email"));
    	  mailVal.clear();
    	  mailVal.sendKeys(mail);
    	  
    	  WebElement phoneVal = edgedriver.findElement(By.name("phone"));
    	  phoneVal.clear();
    	  phoneVal.sendKeys(phone);
      }
      
      @Test(priority = 3)
      public void submit() {
    	  WebElement submitVal = edgedriver.findElement(By.className("_1Qjd7"));
    	  submitVal.click();
      }
    	  
      
}