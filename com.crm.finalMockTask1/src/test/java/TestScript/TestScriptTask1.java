package TestScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;
import com.crm.FileUtilities.ReadFromProperties;
import com.crm.pom.DWSElementsForGiftCard;

@Listeners(com.crm.Listeners.Listeners.class)

public class TestScriptTask1 extends DwsBase {

	@Test
	public void giftCardProduct() throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500);");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		DWSElementsForGiftCard dws = new DWSElementsForGiftCard(driver);
		String productName = dws.prod.getText();
		dws.prod.click();

		dws.recipient_Name.sendKeys(ReadFromProperties.getData("r_name"));
		dws.recipient_Name.sendKeys(ReadFromProperties.getData("r_email"));

		dws.prod_quantity.clear();
		dws.prod_quantity.sendKeys("5");

		dws.addToCart.click();

		dws.cartButton.click();
		String actual_prodNameInCart = dws.prodNameInCart.getText();

		assertEquals(productName, actual_prodNameInCart, "Product is Mismatch");

		Reporter.log("Product is Added Succesfully in Cart ", true);

	}

}
