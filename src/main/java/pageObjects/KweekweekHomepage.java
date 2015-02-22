package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Waits;

public class KweekweekHomepage {
	
	WebDriver driver ;
	
	public KweekweekHomepage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy (name="commit")
	private WebElement loginButton;
	@FindBy (id="user_password")
	public WebElement loginPasswordField;
	@FindBy (id="user_login")
	public WebElement loginUsernameField;
    @FindBy(xpath="//a[@class='login-facebook']")
	private WebElement loginWithFacebookButton;
    @FindBy(id="alert-container")
    public WebElement alertContainer;
    @FindBy (xpath="//div[@class='alert alert-error col-lg-12 col-md-12 col-sm-12 col-xs-12']")
    public WebElement errorAlert;
    @FindBy (xpath="//a[@href='/users/password/new']")
	private WebElement forgotPasswordLink;
    @FindBy (id="user_email")
	private WebElement resetPasswordEmailField;
    @FindBy (name="commit")
	private WebElement resetPasswordSubmitButton;
    @FindBy (name="user[password]")
	private WebElement newPasswordField;
    @FindBy (name="user[password_confirmation]")
    private WebElement confirmNewPasswordField;
    @FindBy(name="commit")
	private WebElement changePasswordButton;
	
	
	
	public void clickLoginButtonOnLoginPopup () {
		Waits.waitForVisibilityOfElement(driver, loginButton);
		loginButton.click();
		
	}
	
	public void clickUsernameField(){
		Waits.waitForVisibilityOfElement(driver, loginUsernameField);
		loginUsernameField.click();
	}
	
	public void setLoginUsername(String username){
		Waits.waitForVisibilityOfElement(driver, loginUsernameField);
		loginUsernameField.clear();
		loginUsernameField.sendKeys(username);
	}
	
	public void clickPasswordField(){
		Waits.waitForVisibilityOfElement(driver, loginPasswordField );
		loginPasswordField.click();
	}
	
	public void setLoginPassword(String password){
		Waits.waitForVisibilityOfElement(driver, loginPasswordField);
		loginPasswordField.clear();
		loginPasswordField.sendKeys(password);
	}

	public void clickLoginWithFacebook() {
		Waits.waitForVisibilityOfElement(driver, loginWithFacebookButton);
		loginWithFacebookButton.click();
    }
	
	public String getCssValueForField(WebElement element){
		Waits.waitForVisibilityOfElement(driver, element);
		return element.getCssValue("border-color");
		
	}
	
	public void clickOnEachElement(WebElement element){
		Waits.waitForVisibilityOfElement(driver, element);
		element.click();
	}
	
	public List getFieldsToBeClickedOnLoginPopup(){
		List<WebElement> fieldsToBeClicked = new ArrayList<WebElement>();
		fieldsToBeClicked.add(loginUsernameField);
		fieldsToBeClicked.add(loginPasswordField);
		return fieldsToBeClicked;
		
	}

	public void clickForgotPasswordLink() {
		Waits.waitForVisibilityOfElement(driver, forgotPasswordLink);
		forgotPasswordLink.click();
	}

	public void enterEmailResetPassword(String emailToReset) {
		Waits.waitForVisibilityOfElement(driver, resetPasswordEmailField);
		resetPasswordEmailField.clear();
		resetPasswordEmailField.sendKeys(emailToReset);
		
	}

	public void clickResetPasswordSumitButton() {
		Waits.waitForVisibilityOfElement(driver,resetPasswordSubmitButton );
		resetPasswordSubmitButton.click();
		
	}

	public void setNewPassword(String password) {
		Waits.waitForVisibilityOfElement(driver, newPasswordField);
		newPasswordField.clear();
		newPasswordField.sendKeys(password);
		
	}
	
	public void setNewPasswordConfirmation (String password){
		Waits.waitForVisibilityOfElement(driver,confirmNewPasswordField );
		confirmNewPasswordField.clear();
		confirmNewPasswordField.sendKeys(password);
	}

	public void clickChangePassword() {
		Waits.waitForVisibilityOfElement(driver, changePasswordButton);
		changePasswordButton.click();
		
	}
	
	
	

}