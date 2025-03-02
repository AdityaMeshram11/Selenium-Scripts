package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWSElements {

	public DWSElements(WebDriver driver) {
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

	@FindBy(linkText = "Facebook")
	public WebElement fb_button;
	
	@FindBy(xpath = "//div[@class='x1rg5ohu']")
	public WebElement fb_createAccount;

	@FindBy(name = "firstname")
	public WebElement first_name;
	
	@FindBy(name = "lastname")
	public WebElement last_name;
	
	@FindBy(name = "birthday_day")
	public WebElement day;
	
	@FindBy(name = "birthday_month")
	public WebElement month;
	
	@FindBy(name = "birthday_year")
	public WebElement year;
	
	
	@FindBy(xpath = "//label[text()='Male']")
	public WebElement male_Gender;
	
	
	@FindBy(name = "reg_email__")
	public WebElement email;
	
	@FindBy(name = "reg_passwd__")
	public WebElement pswd;
	

	@FindBy(name = "websubmit")
	public WebElement signInButton;
	
	

}