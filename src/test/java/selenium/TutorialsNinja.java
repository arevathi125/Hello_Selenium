package selenium;

import java.awt.Desktop.Action;
import java.io.Console;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TutorialsNinja {

	WebDriver driver;
	

	// 1.Launch the application http://tutorialsninja.com/demo/index.php
	@Test(priority = 1)
	public void launchingPart() {
		// System.setProperty("WebDriver.chrome.driver","C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
//		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();
	}

	// 2.Select the currency in the left top corner to Euro
	@Test(priority = 2)
	public void currency() throws InterruptedException {
		WebElement currency = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i"));
		currency.click();
		Thread.sleep(1000);
//		Select left = new Select(currency);
//		left.selectByVisibleText("€ Euro");
		driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
	}

	// 3.Try to order a canon EOS 5 D camera and collect the error message occurred
	// due to a bug in select option
	@Test(priority = 3)
	public void camera() throws InterruptedException {

		WebElement canonCamera = driver.findElement(By.linkText("Canon EOS 5D"));
		canonCamera.click();
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\'button-cart\']"));
		addToCart.click();
		Thread.sleep(3000);
		driver.navigate().back();
	}

	// 4.Move to the home screen, Click on iphone and go to details screen, change
	// the quantity to two then add to cart.
	@Test(priority = 4)
	public void iphone() throws InterruptedException {
		//driver.get("http://tutorialsninja.com/demo/index.php");
		WebElement iphone = driver.findElement(By.linkText("iPhone"));
		iphone.click();
		WebElement quantity = driver.findElement(By.xpath("//*[@id=\'input-quantity\']"));
		quantity.clear();
		quantity.sendKeys("2");
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\'button-cart\']"));
		addToCart.click();
		Thread.sleep(3000);
		// 5.Print the success message in the console
		System.out.println("You Have Successfully Ordered Your IPhones in Your Cart");
	}

	// 6.Click on the cart icon (black color) in the right side top then click view
	// cart
	@Test(priority = 5)
	public void CartButton() {
		WebElement CartButton = driver.findElement(By.xpath("//*[@id=\'cart\']/button"));
		CartButton.click();
	}

	// 7.Change the quantity of iphone to 3 and click update button
	@Test(priority = 6)
	public void viewCart() {
		WebElement viewCart = driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[4]/a/span"));
		viewCart.click();
		WebElement quantity = driver.findElement(By.xpath("//*[@id=\'content\']/form/div/table/tbody/tr/td[4]/div/input"));
		quantity.clear();
		quantity.sendKeys("3");
		WebElement update = driver.findElement(By.xpath("//*[@id=\'content\']/form/div/table/tbody/tr/td[4]/div/span/button[1]"));
		update.click();
	}
	
	//8.Print the Eco tax and VAT Amount in console and click Checkout button
	@Test(priority = 7)
	public void print() throws InterruptedException {
		WebElement ecoTax = driver.findElement(By.xpath("//*[@id=\'content\']/div[2]/div/table/tbody/tr[2]/td[2]"));
		System.out.println("Eco Tax Amount Is : "+ecoTax.getText());
		WebElement vatTax = driver.findElement(By.xpath("//*[@id=\'content\']/div[2]/div/table/tbody/tr[3]/td[2]"));
		System.out.println("VAT  Amount Is : "+vatTax.getText());
		Thread.sleep(3000);
		System.out.println(" ");
		
		//WebElement checkOutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a"));
		try {
			WebElement checkOutButton = driver.findElement(By.linkText("Checkout"));
			Thread.sleep(3000);
			checkOutButton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//9.Print the error message and remove the product from the cart
		
//		WebElement CartButton = driver.findElement(By.xpath("//*[@id=\'cart\']/button"));
//		CartButton.click();
		Thread.sleep(3000);
		WebElement redButton = driver.findElement(By.xpath("//*[@id=\'content\']/form/div/table/tbody/tr/td[4]/div/span/button[2]"));
		redButton.click();
		Thread.sleep(3000);
		driver.navigate().to("http://tutorialsninja.com/demo/index.php");
	}
	
	
	//10.Move to the home screen and click on Mac book, check the default quantity is 1 and click add to cart then verify success message
	@Test(priority = 8)
	public void macBook() throws InterruptedException {
		WebElement macBook = driver.findElement(By.linkText("MacBook"));
		macBook.click();
		WebElement quantity = driver.findElement(By.xpath("//*[@id=\'input-quantity\']"));
		quantity.clear();
		quantity.sendKeys("1");
		Thread.sleep(3000);
		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\'button-cart\']"));
		addToCart.click();
		WebElement succeemsg = driver.findElement(By.xpath("//*[@id=\'product-product\']/div[1]"));
		System.out.println(" Success Message ");
		System.out.println(" =============== ");
		System.out.println(succeemsg.getText());
		System.out.println(" ");
		
	}
	
	//11.Click on the shopping cart link in the top and apply ABCD123 as coupon code to check, print error message
	@Test(priority = 9)
	public void couponCode() throws InterruptedException {
		WebElement shoppingCart = driver.findElement(By.xpath("//*[@id=\'top-links\']/ul/li[4]/a/span"));
		
		shoppingCart.click();
		WebElement couponCodeButton = driver.findElement(By.xpath("//*[@id=\'accordion\']/div[1]/div[1]/h4/a"));
		couponCodeButton.click();
		WebElement couponCodeBox = driver.findElement(By.xpath("//*[@id=\'input-coupon\']"));
		couponCodeBox.sendKeys("ABCD123");
		WebElement applyButton = driver.findElement(By.xpath("//*[@id=\'button-coupon\']"));
		applyButton.click();
		Thread.sleep(2000);
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\'checkout-cart\']/div[1]"));
		System.out.println(" Error Message ");
		System.out.println(" =============== ");
		System.out.println(errorMsg.getText());
		System.out.println(" ");
		couponCodeBox.clear();
}
	
	//12.Enter AXDFGH123 as gift certificate and perform apply to check, print error message
		@Test(priority = 10)
		public void giftCard() throws InterruptedException {
			WebElement giftButton = driver.findElement(By.xpath("//*[@id=\'accordion\']/div[2]/div[1]/h4/a"));
			giftButton.click();
			WebElement giftCodeBox = driver.findElement(By.xpath("//*[@id=\'input-voucher\']"));
			giftCodeBox.sendKeys("AXDFGH123");
			WebElement applyButton = driver.findElement(By.xpath("//*[@id=\'button-voucher\']"));
			applyButton.click();
			Thread.sleep(2000);
			WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\'checkout-cart\']/div[1]"));
			System.out.println(" Error Message ");
			System.out.println(" =============== ");
			System.out.println(errorMsg.getText());
			System.out.println(" ");
			giftCodeBox.clear();
		}
		
		
	//13.Clear both textbox values and proceed to checkout
				@Test(priority = 11)
				public void checkOut() {
					WebElement checkOutButton = driver.findElement(By.xpath("//*[@id=\'content\']/div[3]/div[2]/a"));
					checkOutButton.click();				
				}
	
	//14.Select register account option and enter all account and billing details, click continue
				@Test(priority = 12)
				public void registerAccount() {
//					WebElement registerAccountButton = driver.findElement(By.xpath("//*[@id=\'collapse-checkout-option\']/div/div/div[1]/div[1]/label/input"));
//					registerAccountButton.click();
					WebElement continueButton = driver.findElement(By.id("button-account"));
					continueButton.click();
//					Actions action = new Actions(driver);
//					action.moveToElement(continueButton).click();
					
					//Personal Details
					WebElement firstName = driver.findElement(By.name("firstname"));
					firstName.sendKeys("Revathi");
					WebElement lastName = driver.findElement(By.name("lastname"));
					lastName.sendKeys("Anbazhagan");
					WebElement eMail = driver.findElement(By.id("input-payment-email"));
					eMail.sendKeys("jack236@gmail.com");
					WebElement telePhone = driver.findElement(By.name("telephone"));
					telePhone.sendKeys("67856790");
					
					// Password Details
					WebElement password = driver.findElement(By.id("input-payment-password"));
					password.sendKeys("selenium");
					WebElement confirmPassword = driver.findElement(By.id("input-payment-confirm"));
					confirmPassword.sendKeys("selenium");
					
					
					//Your Address
					WebElement company = driver.findElement(By.xpath("//*[@id=\'input-payment-company\']"));
					company.sendKeys("NumpyNinja");
					WebElement address1 = driver.findElement(By.name("address_1"));
					address1.sendKeys("123,delmar colony");
					WebElement address2 = driver.findElement(By.name("address_2"));
					address2.sendKeys("123,delmar colony");
					WebElement city = driver.findElement(By.xpath("//*[@id=\'input-payment-city\']"));
					city.sendKeys("Saint louis");
					WebElement postCode = driver.findElement(By.id("input-payment-postcode"));
					postCode.sendKeys("63368");
					WebElement countryDropDown = driver.findElement(By.id("input-payment-country"));
					Select country =new Select(countryDropDown);
					country.selectByVisibleText("United States");
					WebElement stateDropDown = driver.findElement(By.id("input-payment-zone"));
					Select state =new Select(stateDropDown);
					state.selectByVisibleText("Rhode Island");
					//WebElement agreeButton = driver.findElement(By.xpath("//*[@id=\'collapse-payment-address\']/div/div[4]/div/input[1]"));
					WebElement agreeButton = driver.findElement(By.name("agree"));
					agreeButton.click();
					WebElement registerButton = driver.findElement(By.id("button-register"));
					registerButton.click();
					
				}
			
   //15.Add comments, click continue and check the error message related to payment method
				@Test(priority = 13)
				public void commentPart() {
					WebElement comment = driver.findElement(By.name("comment"));
					comment.sendKeys("Ready for order");
					WebElement agreeButton = driver.findElement(By.name("agree"));
					agreeButton.click();
					WebElement continueButton = driver.findElement(By.id("button-payment-method"));
					continueButton.click();
				
				}	
	//16.Click on contact us hyperlink and submit a contact request and click continue
				@Test(priority = 14)
				public void contactUs() {
					WebElement cotactUs = driver.findElement(By.linkText("Contact Us"));
					cotactUs.click();
					WebElement enquiry = driver.findElement(By.id("input-enquiry"));
					enquiry.sendKeys("Regarding my order");
					//WebElement submit = driver.findElement(By.linkText("Submit"));
					WebElement submit = driver.findElement(By.xpath("//*[@id=\'content\']/form/div/div/input"));
					submit.click();
				}
				
		}