package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Waits;

import env.TestAppEnv;

public class GmailPage {

	WebDriver driver;
	@FindBy (id="Email")
	private WebElement gmailLoginEmailField;
	@FindBy(id="Passwd")
	private WebElement gmailLoginPasswordField;
	@FindBy(id="signIn")
	private WebElement gmailSigninButton;
	@FindBy(xpath="//span[contains(.,'Reset your KweekWeek password')]")
	private WebElement resetPasswordEmail;
	@FindBy (xpath="//img[@alt='Reset password']")
	private WebElement resetPasswordButton;
	@FindBy (xpath="//div[@data-tooltip='Delete']")	
	private WebElement gmailDeleteMailButton;
	@FindBy (xpath="//div[@data-tooltip='Select']/div/span[@role='checkbox']")
	private WebElement mailCheckbox;
	
	
	
	public GmailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void getGmailLoginPage(){
		driver.get(TestAppEnv.getGmailLoginPage());
	}
	public void setGmailLoginEmail(String email){
		Waits.waitForVisibilityOfElement(driver, gmailLoginEmailField);
		gmailLoginEmailField.clear();
		gmailLoginEmailField.sendKeys(email);
	}
	public void setGmailLoginPassword(String password){
		Waits.waitForVisibilityOfElement(driver, gmailLoginPasswordField);
		gmailLoginPasswordField.clear();
        gmailLoginPasswordField.sendKeys(password);
	}
	
	public void clickGmailSigninButton(){
		Waits.waitForVisibilityOfElement(driver, gmailSigninButton);
		gmailSigninButton.click();
	}
	
	public void clickGmailResetPasswordEmail(){
		Waits.waitForVisibilityOfElement(driver, resetPasswordEmail);
		resetPasswordEmail.click();
	}
	
	public void clickGmailResetPasswordButton(){
		Waits.waitForVisibilityOfElement(driver, resetPasswordButton);
		resetPasswordButton.click();
	}
	
	public void deleteResetPasswordEmail(){
		Waits.waitForVisibilityOfElement(driver, gmailDeleteMailButton);
		gmailDeleteMailButton.click();
	}
	public void loginToGmail(String email, String password) throws InterruptedException{
		Waits.waitForVisibilityOfElement(driver, gmailLoginEmailField);
		setGmailLoginEmail(email);
		Thread.sleep(1000);
		setGmailLoginPassword(password);
		clickGmailSigninButton();
		
	}
	
	public void clickMailCheckbox(){
		Waits.waitForVisibilityOfElement(driver, mailCheckbox);
		mailCheckbox.click();
	}
	
	public void clickDeleteAllButtonInHeader(){
		Waits.waitForVisibilityOfElement(driver, gmailDeleteMailButton);
		gmailDeleteMailButton.click();
	}
	
	public void clickResetLink(){
		Waits.waitForVisibilityOfElement(driver, resetPasswordEmail);
		clickGmailResetPasswordButton();
		clickGmailResetPasswordButton();
	}
	
	public void deleteAllEmailsAfterTest(WebDriver driver){
		clickMailCheckbox();
	    clickDeleteAllButtonInHeader();
	}
	
	
        
	}


