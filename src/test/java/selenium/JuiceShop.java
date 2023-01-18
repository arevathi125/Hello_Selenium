package selenium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Scanner;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JuiceShop {

	WebDriver driver;
	UUID uuid;
	
	//* Please create a user in https://juice-shop.herokuapp.com/#/register
	@Test(priority=1)
	public void registerPart() {
		 driver = new EdgeDriver(); 
		System.setProperty("WebDriver.edge.Driver","C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\msedgedriver.exe" );
		//String URL ="https://juice-shop.herokuapp.com/#/register";
		driver.get("https://juice-shop.herokuapp.com/#/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement dismissButton = driver.findElement(By.xpath("//*[@id=\'mat-dialog-0\']/app-welcome-banner/div/div[2]/button[2]"));
		dismissButton.click();
		WebElement email = driver.findElement(By.id("emailControl"));
		//random mail id "UUID uuid =UUID.randomUUID();
		uuid=UUID.randomUUID();   
		email.sendKeys(uuid+"ACa2132114abcd@gmail.com");
		WebElement password = driver.findElement(By.xpath("//*[@id=\'passwordControl\']"));
		password.sendKeys("Dhakshanvidhuna123@");
		WebElement repeatPassword = driver.findElement(By.xpath("//*[@id=\'repeatPasswordControl\']"));
		repeatPassword.sendKeys("Dhakshanvidhuna123@");
		WebElement securityQuest =driver.findElement(By.xpath("//*[@id=\'mat-select-0\']/div/div[2]/div"));
		securityQuest.click();
		//Select option = new Select(securityQuest);
		//WebElement securityQuestDropdown =driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'Father's birth date?(MM/DD/YY)')]"));
		//option.selectByVisibleText("Father's birth date?(MM/DD/YY)");
		WebElement securityQuestDropdown =driver.findElement(By.xpath("//span[text()=' Your eldest siblings middle name? ']"));
		securityQuestDropdown.click();
		WebElement securityAns = driver.findElement(By.xpath("//*[@id=\'securityAnswerControl\']"));
		securityAns.sendKeys("Santhi");
		//WebElement register = driver.findElement(By.xpath("//*[@id=\'registerButton\']/span[1]"));
		WebElement register = driver.findElement(By.xpath("//button[@type='submit']"));
		register.click();
		WebElement wantItButton = driver.findElement(By.xpath("/html/body/div[1]/div/a"));
		wantItButton.click();
		
	}
	
	//• Please login to the website and Add one or two items to basket (from each
	//page) – scroll, navigate and select product
	@Test(priority=2)
	public void logInPart() {
		//login
		WebElement emailLogin = driver.findElement(By.xpath("//*[@id=\'email\']"));
		//UUID uuid=UUID.randomUUID();   
		emailLogin.sendKeys(uuid+"ACa2132114abcd@gmail.com");
		//emailLogin.sendKeys("ACa2132114abcd@gmail.com");
		WebElement passwordLogin = driver.findElement(By.xpath("//*[@id=\'password\']"));
		passwordLogin.sendKeys("Dhakshanvidhuna123@");
		WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		logInButton.click();
	}
	
		@Test(priority=3)
		public void addToBasketPart() {
		//add apple juice to Basket
		WebElement addAppleJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button"));
		addAppleJuice.click();
		//add lemon juice to basket
		WebElement addLemonJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[10]/div/mat-card/div[2]/button"));
		
		//scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,3000)");
		js.executeScript("arguments[0].scrollIntoView();",addLemonJuice);
		// js.executeScript("scroll(0,800);");
		addLemonJuice.click();
		WebElement nextButton1 =driver.findElement(By.cssSelector("[aria-label='Next page']"));
		nextButton1.click();
		WebElement owaspJuiceHoodie = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[5]/div/mat-card/div[2]/button"));
		owaspJuiceHoodie.click();
		WebElement NextButton2 = driver.findElement(By.cssSelector("[arial-label='Next page']"));
		js.executeScript("arguments[0].scrollIntoView();",NextButton2);
		//	Actions action = new Actions(driver);
		//	 action.scrollToElement(NextButton2);
		NextButton2.click();
		WebElement strawberryJuice= driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[10]/div/mat-card/div[2]/button"));
		strawberryJuice.click();
		WebElement previousPageButton = driver.findElement(By.cssSelector("[arial-label='Previous page']"));
		js.executeScript("arguments[0].scrollIntoView();",previousPageButton);
		//Actions action1 = new Actions(driver);
		//action.scrollToElement(previousPageButton);
		previousPageButton.click();
	}
	
		//• Go to your basket and increase the quantity of all items by 2
		@Test(priority=4)
		public void basketQuantityPart() {
			//view basket
			WebElement viewBasket = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]"));
			viewBasket.click();
			//quantity increasing
			WebElement quantity1Button = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row[1]/mat-cell[3]/button[2]"));
			quantity1Button.click();
			WebElement quantity2Button = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row[2]/mat-cell[3]/button[2]"));
			quantity2Button.click();
			WebElement quantity3Button = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row[3]/mat-cell[3]/button[2]"));
			quantity3Button.click();
			WebElement checkOutButton = driver.findElement(By.xpath("//*[@id='checkoutButton']"));
			checkOutButton.click();
		}
	   
		//• Press checkout and add a new address (for all inputs generate random values using code and don’t hard code)
		@Test(priority=5)
		public void addingaddressPart() throws IOException {
			WebElement addingaddressButton = driver.findElement(By.xpath("//*[@id=\'card\']/app-address/mat-card/div/button"));
			addingaddressButton.click();
			// getting inputs
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//country - India
			  System.out.println("Please Enter the Country Name :: ");
			  String country = input.readLine();
			  WebElement countryInput = driver.findElement(By.xpath("//*[@id=\'mat-input-7\']"));
			  countryInput.sendKeys(country);
			  //name -Revathi
			  System.out.println("Please Enter the  Name :: ");
			  String name = input.readLine();
			  WebElement nameInput = driver.findElement(By.xpath("//*[@id=\'mat-input-8\']"));
			  nameInput.sendKeys(name);
			  //mobile number - 9629052669
			  System.out.println("Please Enter the  Mobile Number :: ");
			  String mobNum = input.readLine();
			  WebElement mobNumInput = driver.findElement(By.xpath("//*[@id=\'mat-input-9\']"));
			  mobNumInput.sendKeys(mobNum);
			  //zip code - 639113
			  System.out.println("Please Enter the  ZipCode :: ");
			  String zipCode = input.readLine();
			  WebElement zipCodeInput = driver.findElement(By.xpath("//*[@id=\'mat-input-10\']"));
			  zipCodeInput.sendKeys(zipCode);
			  //Address - 1233,mallardswaymamallardswaymallardswaymallardswaymallardswaymallardswaymallardswaymallardswaymallardsway
			
			  System.out.println("Please Enter the  Address :: ");
			  String address = input.readLine();
			  WebElement addressInput = driver.findElement(By.xpath("//*[@id=\'address\']"));
			  addressInput.sendKeys(address);
			  //city - Karur
			  System.out.println("Please Enter the  City :: ");
			  String city = input.readLine();
			  WebElement cityInput = driver.findElement(By.xpath("//*[@id=\'mat-input-12\']"));
			  cityInput.sendKeys(city);
			  //state -TamilNadu 
			  
			  System.out.println("Please Enter the  State :: ");
			  String state = input.readLine();
			  WebElement stateInput = driver.findElement(By.xpath("//*[@id=\'mat-input-13\']"));
			  stateInput.sendKeys(state);
			  //Submit
			  WebElement submitButton = driver.findElement(By.xpath("//button[@type ='submit']"));
			  submitButton.click();
		}
		 
		//• Select the address and any delivery speed
		@Test(priority=6)
		public void deliveryspeedPart() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//selectaddress 
			WebElement selectaddressButton = driver.findElement(By.xpath("//*[@id=\'mat-radio-40\']/label/span[1]/span[1]"));
			selectaddressButton.click();
			//continue
			WebElement continueButton = driver.findElement(By.xpath("//*[@id=\'card\']/app-address/mat-card/button"));
			continueButton.click();
			//delivery speed  
			WebElement deliverySpeedButton = driver.findElement(By.xpath("//*[@id=\'mat-radio-41\']/label/span[1]/span[1]"));
			deliverySpeedButton.click();
			//continue
			WebElement continueButton1 = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]"));
			continueButton1.click();
		}
		
		//• Add a new card, try to add a fake coupon (10 digits) and verify error
		//message. Select card, review and place the order.
		@Test(priority=7)
		public void newCardPart() {
			//Adding New card
			WebElement newCard = driver.findElement(By.xpath("//*[@id=\'mat-expansion-panel-header-0\']/span[1]/mat-panel-title"));
			newCard.click();
			//name
			WebElement name = driver.findElement(By.xpath("//*[@id=\'mat-input-14\']"));
			name.sendKeys("PRDV");
			// card number 
			WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\'mat-input-15\']"));
			cardNumber.sendKeys("1234567234123456");
			//card expiry Month
			WebElement cardExpiryMonth = driver.findElement(By.xpath("//*[@id=\'mat-input-16\']"));
			cardExpiryMonth.click();
			WebElement cardExpiryMonthDropDown = driver.findElement(By.xpath("//div[@role='listbox']*[contains(text(),'4')]"));
			cardExpiryMonthDropDown.click();
			//card expiry Year
			WebElement cardExpiryYear = driver.findElement(By.xpath("//*[@id=\'mat-input-17\']"));
			cardExpiryYear.click();
			WebElement cardExpiryYearDropDown = driver.findElement(By.xpath("//div[@role='listbox']*[contains(text(),'2090')]"));
			cardExpiryYearDropDown.click();
			//addcoupon
			WebElement addCoupon = driver.findElement(By.xpath("//*[@id=\'mat-expansion-panel-header-1\']/span[1]/mat-panel-title"));
			addCoupon.click();
			WebElement addCouponDropDown = driver.findElement(By.xpath("//*[@id=\'coupon\']"));
			addCouponDropDown.sendKeys("dfghjkwerw");
			//redeem
			WebElement redeemButton = driver.findElement(By.xpath("//*[@id=\'applyCouponButton\']/span[1]"));
			redeemButton.click();
			WebElement invalidCoupon = driver.findElement(By.xpath("//*[@id=\'cdk-accordion-child-1\']/div/div"));
			String couponResult = invalidCoupon.getText();
			System.out.println(couponResult);
			//Submit
			  WebElement submitButton = driver.findElement(By.xpath("//button[@type ='submit']"));
			  submitButton.click();
				//Radio Button
				WebElement radioButton = driver.findElement(By.xpath("//*[@id=\'mat-radio-44\']/label/span[1]/span[1]"));
				radioButton.click();
				//continue
				WebElement continueButton2 = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[2]/button[2]"));
				continueButton2.click();
			  // Place the order
			  WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id=\'checkoutButton\']/span[1]/span"));
			  placeOrderButton.click();
			
		}
			  
			 //• Verify in Account, order history -> print order, track order
		@Test(priority=8)
		public void orderHistoryPart() {
			// print order
			WebElement printOrderButton = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-completion/mat-card/div[2]/div/button/span[1]/mat-icon"));
			printOrderButton.click();
			printOrderButton.getText();
			//Track order
			WebElement trackOrderButton = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-order-completion/mat-card/div[1]/div/mat-card[1]/div/div/a"));
			trackOrderButton.click();
			trackOrderButton.getText();
		}
			
			//• Then logout from the application
		@Test(priority=9)
		public void logOutPart() {
			 // log out
			  WebElement accountButton = driver.findElement(By.xpath("//*[@id=\'navbarAccount\']/span[1]/span"));
			  accountButton.click();
			  WebElement logoutButton = driver.findElement(By.xpath("//button[@id='navbarLogoutButton']"));
			  logoutButton.click();
			  
		}
		
}
