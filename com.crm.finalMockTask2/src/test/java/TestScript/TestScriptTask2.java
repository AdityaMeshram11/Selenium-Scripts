package TestScript;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;
import com.crm.FileUtilities.ReadFromProperties;
import com.crm.pom.DWSElements;

@Listeners(com.crm.Listeners.Listeners.class)

public class TestScriptTask2 extends DwsBase {

	@Test
	public void fbAccount() throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1300);");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		DWSElements dws = new DWSElements(driver);
		dws.fb_button.click();
		String main_dws = driver.getWindowHandle();
		Set<String> fb = driver.getWindowHandles();
		fb.remove(main_dws);
		for (String str : fb) {
			System.out.println(str);

			driver.switchTo().window(str);
			System.out.println("FB login Page");
			dws.fb_createAccount.click();

			String fblogin = driver.getWindowHandle();
			Set<String> acc = driver.getWindowHandles();
			acc.remove(fblogin);
			for (String ca : acc) {
				driver.switchTo().window(ca);
			}
		}

		dws.first_name.sendKeys(ReadFromProperties.getData("fname"));
		dws.last_name.sendKeys(ReadFromProperties.getData("lname"));

		Select day = new Select(dws.day);
		day.selectByValue("29");

		Select month = new Select(dws.month);
//		month.selectByValue("08"); // try to fail the script to take ScreenShot
		month.selectByValue("8"); 

		Select year = new Select(dws.year);
		year.selectByValue("2002");

		dws.male_Gender.click();

		dws.email.sendKeys(ReadFromProperties.getData("email"));
		dws.pswd.sendKeys(ReadFromProperties.getData("pswd"));

		dws.signInButton.click();

		driver.switchTo().window(main_dws);
		

	}

}
