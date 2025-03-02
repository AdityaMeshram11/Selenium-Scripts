package com.crm.BaseClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.crm.FileUtilities.ReadFromProperties;
@Listeners(com.crm.Listeners.Listeners.class)
public class DwsBase {

	public static WebDriver driver = null;

	@BeforeClass
	public void preCondition() throws IOException {

		String browser = ReadFromProperties.getData("browser");
		String url = ReadFromProperties.getData("url");

		if (browser.equalsIgnoreCase(browser)) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(browser)) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase(browser)) {
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase(browser)) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);

	}

	@BeforeMethod
	public void logIn() throws IOException {

		String expected_url = ReadFromProperties.getData("url");

		String username = ReadFromProperties.getData("username");
		String password = ReadFromProperties.getData("password");
		String actual_url = driver.getCurrentUrl();

		assertEquals(actual_url, expected_url, "URL is not Proper Plz check");
		Reporter.log("I am in DWS Page After Varification ", true);

		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

	}

	@AfterMethod
	public void logOut() {
		driver.findElement(By.xpath("//li/a[@class='ico-logout']")).click();
		System.out.println("logout Condition");
	}

	@AfterClass
	public static void postCondition() {
		driver.close();
		System.out.println("close the browser");
	}

}
