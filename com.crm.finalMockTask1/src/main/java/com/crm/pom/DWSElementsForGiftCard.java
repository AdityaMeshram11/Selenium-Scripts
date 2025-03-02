package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWSElementsForGiftCard {

	public DWSElementsForGiftCard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "ico-login")
	public WebElement login_link;

	@FindBy(id = "Email")
	private WebElement username;

	@FindBy(id = "Password")
	public WebElement password;

	@FindBy(css = "#RememberMe")
	public WebElement rememberMe;

	@FindBy(linkText = "Forgot password?")
	public WebElement forgot_password;

	@FindBy(xpath = "//input[@value='Log in']")
	public WebElement login_button;

	@FindBy(partialLinkText = "$25 Virtual Gift Card")
	public WebElement prod ;
	
	@FindBy(id = "giftcard_2_RecipientName")
	public WebElement recipient_Name ;
	
	@FindBy(className = "recipient-email")
	public WebElement recipient_Email;
	
	@FindBy(xpath = "//input[@id='addtocart_2_EnteredQuantity']")
	public WebElement prod_quantity;
	
	
	@FindBy(id = "add-to-cart-button-2")
	public WebElement addToCart ;
	
	
	@FindBy(id = "topcartlink")
	public WebElement cartButton ;
	
	@FindBy(xpath = "//td[@class='product']/a")
	public WebElement prodNameInCart;

}