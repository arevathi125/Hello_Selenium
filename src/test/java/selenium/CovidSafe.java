package selenium;

import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CovidSafe {

	WebDriver edgeDriver;
	int i;
	int j;
	String hosNames;
	String colsNames;
	String col1Names;
	String col2Names;
	String col3Names;
	String col4Names;

	@Test(priority = 1)
	public void launchBrowser() {

		System.setProperty("WebDriver.edge.Driver",
				"C:\\Users\\areva\\OneDrive\\Desktop\\AllDrivers\\msedgedriver.exe");
		edgeDriver = new EdgeDriver();
		edgeDriver.get("https://westbengal.covidsafe.in");

	}

	@Test(priority = 2)
	public void hospitalList() {

		// To get number of hospitals(row numbers)
		int noOfhospitals = edgeDriver.findElements(By.xpath("//tbody/tr")).size();

		System.out.println("Number Of Hospital Availabilty is : " + noOfhospitals);
		System.out.println(" ");

		// To get hospital Names(row values)
		for (int i = 1; i <= noOfhospitals; i++) {

			WebElement hospNames = edgeDriver.findElement(By.xpath("//tr[" + i + "]//strong"));

			String hosNames = hospNames.getText();

			System.out.println("List Of All Hospitals  : " + hosNames);
			System.out.println(" ");

		}
//		for(int s=2;s<=5;s++) {
//			WebElement headerNames = edgeDriver.findElement(By.xpath("//tr/th[" + s + "]"));
//			System.out.println("header names  : " + headerNames.getText());
//		}

		// To get column numbers for first row
		int noOfcolumns = edgeDriver.findElements(By.xpath("//tr[1]/td")).size();

		System.out.println("Number Of columns is : " + noOfcolumns);
		System.out.println(" ");

		// To get column values
		for (int j = 2; j <= noOfcolumns; j++) {
			// WebElement colNames = edgeDriver.findElement(By.xpath("//tr[1]/td[" + j +
			// "]//span"));
			WebElement colNames = edgeDriver.findElement(By.xpath("//tr[1]/td[" + j + "]//span"));
			String colsNames = colNames.getText();
			System.out.println("Columns Are : " + colsNames);
		}

		// To get all details for one hospital
		// noOfhospitals=2;
		
		for (int i = 1; i <= noOfhospitals; i++) {
			int totalBedCount = 0;
			String hosp1name = "";
			  
			  
			for (int j1 = 1; j1 <= noOfcolumns; j1++) {

				// To get the hospital name
			    
				if (j1 == 1) {
					WebElement hospname = edgeDriver.findElement(By.xpath("//tr[" + i + "]/td[" + j1 + "]"));
					hosp1name = hospname.getText();
					System.out.println(" Name Of The Hospital Is : " + hosp1name);
					System.out.println(" ");
				}
				WebElement colNames1 = edgeDriver.findElement(By.xpath("//tr[" + i + "]/td[" + j1 + "]//span"));

				if (j1 == 2) {

					// To get Without oxygen Bed Availability

					col1Names = colNames1.getText();
					totalBedCount = totalBedCount + Integer.parseInt(col1Names);
					System.out.println("\tWithout Oxygen Bed Availability Is : " + col1Names);
				}

				if (j1 == 3) {
					// To get With oxygen Bed Availability

					col2Names = colNames1.getText();
					totalBedCount = totalBedCount + Integer.parseInt(col2Names);
					System.out.println(" \tWith Oxygen Bed Availability Is : " + col2Names);
				}

				if (j1 == 4) {

					// To get ICU Availability
					col3Names = colNames1.getText();
					totalBedCount = totalBedCount + Integer.parseInt(col3Names);
					System.out.println(" \tICU Availability Is : " + col3Names);
				}

				if (j1 == 5) {

					// To get ICU With Ventilator Bed Availability
					col4Names = colNames1.getText();
					totalBedCount = totalBedCount + Integer.parseInt(col4Names);
					System.out.println(" \tICU With Ventilator Availability Is : " + col4Names);
				}
 
			}
			System.out.println("\tTotal Number Of Beds Available In  " + hosp1name + " Is : " + totalBedCount);
			System.out.println(" ");
		}
		
		WebElement contact = edgeDriver.findElement(By.xpath(
				"//tbody/tr[1]/td[1]/div[1]/button[1]/*[1]"));
		contact.click();
		WebElement phone = edgeDriver.findElement(By.xpath(
				"//tbody/tr[2]/td/p[2]/span"));
		StringTokenizer st = new StringTokenizer(phone.getText(), "Phone:");
			System.out.println("Contact Number is : " + st.nextToken().trim());
	}

}
