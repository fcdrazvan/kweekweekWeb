package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

public class FacebookPage {

	WebDriver driver;
	@FindBy (id="email")
	private WebElement facebookLoginEmailField;
	@FindBy(id="pass")
	private WebElement facebookLoginPasswordField;
	@FindBy (id="loginbutton")
	private WebElement facebookLoginButton;
	
	public FacebookPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickFacebookEmailField(){
		Waits.waitForVisibilityOfElement(driver, facebookLoginEmailField);
	    facebookLoginEmailField.click();
	}
	
	public void setFacebookLoginEmail(String facebookLoginEmail){
		Waits.waitForVisibilityOfElement(driver, facebookLoginEmailField);
		facebookLoginEmailField.clear();
		facebookLoginEmailField.sendKeys(facebookLoginEmail);
	}
	
	public void clickFacebookPasswordField(){
		Waits.waitForVisibilityOfElement(driver, facebookLoginPasswordField);
		facebookLoginPasswordField.click();
	}
	
	public void setFacebookLoginPassword(String facebookLoginPassword){
		Waits.waitForVisibilityOfElement(driver, facebookLoginEmailField);
		facebookLoginPasswordField.clear();
		facebookLoginPasswordField.sendKeys(facebookLoginPassword);
	}
	
	public void clickFacebookLoginButton(){
		Waits.waitForVisibilityOfElement(driver, facebookLoginButton);
		facebookLoginButton.click();
	}

	}


