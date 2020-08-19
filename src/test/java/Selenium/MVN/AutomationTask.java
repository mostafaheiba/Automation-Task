package Selenium.MVN;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTask extends InitTest {


	@Test(priority = 0)
	public void SearchGoogle() {
		// Search with Website (https://parabank.parasoft.com)
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("https://parabank.parasoft.com");
		// Click on Search button
		driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();

		// Click on First Result Search
		driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[1]"))
				.click();
	}

	@Test(priority = 1)
	public void RigsterOnParaBank() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p//a[contains(text(),'Register')]")));
		} catch (Exception e) {
			fail("Failed to Find Register");
		}
		// Click on Register Link
		driver.findElement(By.xpath("//p//a[contains(text(),'Register')]")).click();
		// Wait to appear this message
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Signing up is easy!')]")));
		} catch (Exception e) {
			fail("Failed to Find Message");
		}
		// Make Registertion on Website
		
		driver.findElement(By.id("customer.firstName")).sendKeys("Mostafa"+System.currentTimeMillis());
		driver.findElement(By.id("customer.lastName")).sendKeys("Abdelkader"+System.currentTimeMillis());
		driver.findElement(By.id("customer.address.street")).sendKeys("Cairo - Banha");
		driver.findElement(By.id("customer.address.city")).sendKeys("Banha");
		driver.findElement(By.id("customer.address.state")).sendKeys("Married");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("13511");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("01273224635");
		driver.findElement(By.id("customer.ssn")).sendKeys("1234");
		driver.findElement(By.id("customer.username")).sendKeys("MA"+System.currentTimeMillis());
		driver.findElement(By.id("customer.password")).sendKeys("Asd123!@#");
		driver.findElement(By.id("repeatedPassword")).sendKeys("Asd123!@#");
		driver.findElement(By.xpath("//input[@value='Register']")).click();

		// Wait Register Message appears Successfully
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]")));
		} catch (Exception e) {
			fail("Failed to Find Message");
		}

	}

	@Test(priority = 2)
	public void RequestLoan() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//li//a[contains(text(),'Request Loan')]")));
		} catch (Exception e) {
			fail("Failed to Find Request Loan button");
		}
		
		driver.findElement(By.xpath("//li//a[contains(text(),'Request Loan')]")).click();
		// Wait Message appears for Request Loan
		 wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Apply for a Loan')]")));
		} catch (Exception e) {
			fail("Failed to Find Message");
		}
		// Make Request Loan
		driver.findElement(By.id("amount")).sendKeys("200");
		driver.findElement(By.id("downPayment")).sendKeys("100");
		driver.findElement(By.xpath("//input[@value='Apply Now']")).click();

		// Wait Message appears for Loan Request Processed
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Loan Request Processed')]")));
		} catch (Exception e) {
			fail("Failed to Find Message");
		}
		// Click on Home Page
		driver.findElement(By.xpath("//li[@class='home']//a[contains(text(),'home')]")).click();
		// Wait Services appears on Home Page
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='services']")));
		} catch (Exception e) {
			fail("Failed to Find Services");
		}
	}


}
