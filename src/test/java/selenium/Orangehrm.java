package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Orangehrm {
	
	WebDriver edgeDriver;
	JavascriptExecutor js = (JavascriptExecutor) edgeDriver;
	
	//1. Login Part
	By username =By.name("username");
	By password =By.name("password");
	By login = By.xpath("//button[@type = 'submit']");
	
	//2. My Information
	// Address
	By myInform = By.linkText("My Info");
	By ContactDet = By.linkText("Contact Details");
	By street1 = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
	By street2 = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");
	By city = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input");
	By state = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/input");
	By zipCode = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input");
	By countryDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]");
	By country = By.xpath("//div[@role='listbox']//*[contains(text(),'Albania')]");
	
	// Telephone
	By home = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input");
	By mobile =By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
	By work = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input");
	
	//Email
	By workEmail = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[1]/div/div[2]/input");
	By otherEmail = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[2]/div/div[2]/input");
	By save = By.xpath("//button[@type='submit']");
	
	// 3.Emergency contacts
	By emerDetails = By.linkText("Emergency Contacts");
	By add = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button");
	By name = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
	By relation = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");
	By homeTelephne = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input");
	By mobileEmer = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
	By workTelephne = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input");
	By saveEmer = By.xpath("//button[@type='submit']");
	
	//4.Dependents
	By depenDetails = By.linkText("Dependents");
	By addDep = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button");
	By nameDepen = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
	By relationDepenDropdown = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div");
	By relationSelection = By.xpath("//div[@role='listbox']//*[contains(text(),'Other')]");
	By relationSpecify = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input");
	By year = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div/div/div[2]/div/div/input");
	By saveDepen = By.xpath("//button[@type='submit']");
	 
	//5.Recruitment
	By recruitment = By.linkText("Recruitment");
	By addCandidate = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By firstName = By.name("firstName");
	By middleName = By.name("middleName");
	By lastName = By.name("lastName");
	By vacancyDropdown = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[1]");
	By vacancySelection = By.xpath("//div[@role='listbox']//*[contains(text(),'Senior QA Lead')]");
	By email = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input");
	By contactNumber = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input");
	By saveRecruit = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]");
	
	//6.ShortList
	By shortList = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]");
	By saveShortlist = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
	By scheduleInterview = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]");
	By interviewTitle = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
	By interviewerName = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div/div[2]/div/div/input");
	By interviewerNameDropdown = By.xpath("//div[@role='listbox']//*[contains(text(),'Odis  Adalwin')]");
	By interviewDate = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div/input");		
	By interviewTime = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div[1]/input");
	By saveInterview = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
	
	//7.OfferJob
	By interviewPass = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]");
	By saveInterviewPass = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
	By offerJobButton = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]");
	By saveOfferJob = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    
    //8.Hiring and candidate history
	By hireButton = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]");
	//By hireButton = By.xpath("//button[@type='button']");
    By saveHire = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    By candidateHistory = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[2]/div");
  
    
//    //10.Navigate to admin and create Ess
//    By addAdmin = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
//    By userRole = By.xpath("//div[@role='listbox']//*[contains(text(),'ESS')]");
//    By employeeName = By.xpath("");
//    By status = By.xpath("//div[@role='listbox']//*[contains(text(),'Enabled')]");
//    By userNameAdmin = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
//    By passwordAdmin = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
//    By passwordConfirmAdmin = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
//    By saveAdmin = By.xpath("//*[@id=\'app\']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
//    
    
	// 1.Launch the application https://opensource-demo.orangehrmlive.com/web/index.php/auth/login 
	@Test(priority = 1)
	public void launchingPart() {
		System.setProperty("WebDriver.edge.Driver","C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\msedgedriver.exe" );
		edgeDriver =new EdgeDriver();
		edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		edgeDriver.manage().window().maximize();
		edgeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
		}
	
	//and login with give credentials
	@Test(priority = 2)
	public void loginPart() {
		//WebElement username = edgeDriver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		edgeDriver.findElement(username).sendKeys("Admin");
		//WebElement password = edgeDriver.findElement(By.name("password"));
		//password.sendKeys("admin123");
		edgeDriver.findElement(password).sendKeys("admin123");
		//js.executeScript("window.scrollby(0,1000)");
		//WebElement login = edgeDriver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		//WebElement login = edgeDriver.findElement(By.xpath("//button[@type = 'submit']"));
		//login.click();
		edgeDriver.findElement(login).click();
	} 
	
	//2.Navigate to My info - > Contact Details, enter contact details and press save button
	@Test(priority = 3)
	public void myInfoPart() throws InterruptedException {
		edgeDriver.findElement(myInform).click();
		edgeDriver.findElement(ContactDet).click();
		
		//Address
		edgeDriver.findElement(street1).sendKeys("Street 1");
		edgeDriver.findElement(street2).sendKeys("Street 2");
		edgeDriver.findElement(city).sendKeys("City");
		edgeDriver.findElement(state).sendKeys("State");
		edgeDriver.findElement(zipCode).sendKeys("100 200");
		edgeDriver.findElement(countryDropdown).click();
		edgeDriver.findElement(country).click();

		
		//Telephone
		edgeDriver.findElement(home).sendKeys("6767676");
		edgeDriver.findElement(mobile).sendKeys("989898");
		edgeDriver.findElement(work).sendKeys(Keys.CONTROL + "A");
	      edgeDriver.findElement(work).sendKeys(Keys.CONTROL + "X");
	      edgeDriver.findElement(work).sendKeys("234234");
	      
	      //Email
	      edgeDriver.findElement(workEmail).sendKeys(Keys.CONTROL+"A");
	      edgeDriver.findElement(workEmail).sendKeys(Keys.CONTROL+"X");
	      edgeDriver.findElement(workEmail).sendKeys("abc@gmail.com");
	      edgeDriver.findElement(otherEmail).sendKeys("efg@gmail.com");
	      edgeDriver.findElement(save).click();
	      Thread.sleep(2000);
	}
	
	//3.Navigate to Emergency contacts and add details
	@Test(priority = 4)
	public void emergencyPart() throws InterruptedException {
		edgeDriver.findElement(emerDetails).click();
		edgeDriver.findElement(add).click();
		Thread.sleep(2000);
		edgeDriver.findElement(name).sendKeys("Priya");
		edgeDriver.findElement(relation).sendKeys("Friend");
		edgeDriver.findElement(homeTelephne).sendKeys("789789");
		edgeDriver.findElement(mobileEmer).sendKeys("478478");
		edgeDriver.findElement(workTelephne).sendKeys("243243");
		edgeDriver.findElement(saveEmer).click();
		
	}
	
	//4.Navigate to Dependents and add dependents
	@Test(priority = 5)
	public void dependentsPart() {
		edgeDriver.findElement(depenDetails).click();
		edgeDriver.findElement(addDep).click();
		edgeDriver.findElement(nameDepen).sendKeys("Praba");
		edgeDriver.findElement(relationDepenDropdown).click();
		edgeDriver.findElement(relationSelection).click();
		edgeDriver.findElement(relationSpecify).sendKeys("Spouse");
		edgeDriver.findElement(year).sendKeys("1982-12-23");
		edgeDriver.findElement(saveDepen).click();
		
	}
	
	//5.Navigate to recruitment menu and add a candidate
	@Test(priority = 6)
	public void recruitPart() {
		edgeDriver.findElement(recruitment).click();
		edgeDriver.findElement(addCandidate).click();
		edgeDriver.findElement(firstName).sendKeys("Revathi");
		edgeDriver.findElement(middleName).sendKeys("");
		edgeDriver.findElement(lastName).sendKeys("Anbazhagan");
		edgeDriver.findElement(vacancyDropdown).click();
		edgeDriver.findElement(vacancySelection).click();
		edgeDriver.findElement(email).sendKeys("123@gmail.com");
		edgeDriver.findElement(contactNumber).sendKeys("23456");
		edgeDriver.findElement(saveRecruit).click();
		
	}
	
	//6.Shortlist the candidate and schedule the interview
	@Test(priority = 7)
	public void shorListPart() {
		edgeDriver.findElement(shortList).click();
		edgeDriver.findElement(saveShortlist).click();
		edgeDriver.findElement(scheduleInterview).click();
		edgeDriver.findElement(interviewTitle).click();
		edgeDriver.findElement(interviewTitle).sendKeys("LeadTester");
		edgeDriver.findElement(interviewerName).click();
		edgeDriver.findElement(interviewerName).sendKeys("Odis"+Keys.DOWN);
		edgeDriver.findElement(interviewerNameDropdown).click();
		edgeDriver.findElement(interviewDate).sendKeys("2022-01-25");
		edgeDriver.findElement(interviewTime).sendKeys("1:00 PM");
		edgeDriver.findElement(saveInterview).click();
	}
	
	//7.Mark the interview passed and offer job
	@Test(priority = 8)
	public void offerJobPart() throws InterruptedException {
	edgeDriver.findElement(interviewPass).click();
	edgeDriver.findElement(saveInterviewPass).click();
	Thread.sleep(2000);
	edgeDriver.findElement(offerJobButton).click();
	edgeDriver.findElement(saveOfferJob).click();
	
	}
	
	//8.Hire the candidate and print the candidate history(table)
	@Test(priority = 9)
	public void candidateHistoryPart() {
		edgeDriver.findElement(hireButton).click();
		edgeDriver.findElement(saveHire).click();
		System.out.println("Candidate History is : ");
		edgeDriver.findElement(candidateHistory).getText();
		
	}
	
	//9.Navigate back to the Recruitment tab and search for the above candidate and verify the status
		@Test(priority = 10)
		public void verifyStatusPart() {
			edgeDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate/38");
		}
		
//	//10.Navigate to the Admin tab and create a user with ESS role for the above employee
//		@Test(priority = 11)
//		public void adminPart() {
//		edgeDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");	
//		edgeDriver.findElement(addAdmin).click();
//		edgeDriver.findElement(userRole).click();
//		edgeDriver.findElement(employeeName).sendKeys("Revathi Anbazhagan");
//		edgeDriver.findElement(status).click();
//		edgeDriver.findElement(userNameAdmin).sendKeys("Revathi Anbazhagan");
//		edgeDriver.findElement(passwordAdmin).sendKeys("Dhakshvidhu123@");
//		edgeDriver.findElement(passwordConfirmAdmin).sendKeys("Dhakshvidhu123@");
//		edgeDriver.findElement(saveAdmin).click();
//		}
//	//11.Logout from the application and login with the above created username & password
//				@Test(priority = 12)
//				public void loginAgainPart() {
//					
//				}	
//	//12.Navigate to leave menu and apply personal leave, Logout from the application	
//				@Test(priority = 13)
//				public void leavePart() {
//					
//				}
//	//13.Login with the Admin user again and navigate to Leave menu	
//				@Test(priority = 14)
//				public void adminAndLeavePart() {
//					
//				}
//	//14.Approve the above applied leave under leave list and logout
//				@Test(priority = 15)
//				public void approvePart() {
//					
//				}
}
