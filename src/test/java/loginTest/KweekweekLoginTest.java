package loginTest;


import java.util.Iterator;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.FacebookPage;
import pageObjects.GmailPage;
import pageObjects.KweekweekHeader;
import pageObjects.KweekweekHomepage;
import utils.Iterations;
import utils.Waits;

import base.BaseTest;

public class KweekweekLoginTest extends BaseTest {
	 	
	@Test(enabled=true)
	public void openLoginPopupFromHeader(){
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = new PageFactory().initElements(driver, KweekweekHomepage.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.loginPasswordField);
		Assert.assertTrue(kweekweekHomepage.loginPasswordField.isDisplayed());
	}
	
	@Test 
	public void successfulLoginWithEmail() throws InterruptedException{
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = new PageFactory().initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("all4winning");
		kweekweekHomepage.clickPasswordField();
		kweekweekHomepage.setLoginPassword("12341234");
	    kweekweekHomepage.clickLoginButtonOnLoginPopup();
	    Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
	    Thread.sleep(3000);
	    Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
	}
	@Test
	public void correctMessageWrongPassword() throws InterruptedException{
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("all4winning");
		kweekweekHomepage.setLoginPassword("incorrectPassword");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
	}
	
	@Test
	public void correctMessageNoPassword() throws InterruptedException{
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("all4winning");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
	}
	@Test
	public void correctMessageNoUsername() throws InterruptedException {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("");
		kweekweekHomepage.setLoginPassword("12341234");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
		
	}
	
	@Test
	public void correctMessageNoCredentials() throws InterruptedException {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
		
	}
	
	@Test
	public void correctMessageWrongCredentials() throws InterruptedException {
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickUsernameField();
		kweekweekHomepage.setLoginUsername("incorrectUsername");
		kweekweekHomepage.setLoginPassword("incorrectPassword");
		kweekweekHomepage.clickLoginButtonOnLoginPopup();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.errorAlert);
		Assert.assertTrue(driver.getPageSource().contains("Invalid email, username or password. Please try again"));
		
	}
	
	@Test 
	public void successfulLoginWithFacebook() throws InterruptedException{
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		FacebookPage facebookPage = PageFactory.initElements(driver, FacebookPage.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickLoginWithFacebook();
	    facebookPage.setFacebookLoginEmail("rpop+dinamo@pitechnologies.ro");
	    facebookPage.setFacebookLoginPassword("Pitech01");
	    facebookPage.clickFacebookLoginButton();
	    Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
	    Assert.assertTrue(driver.getPageSource().contains("Logged in successfully"));
	}
	
	@Test
	public void checkThatInputFieldsAreHighlighted() throws InterruptedException{
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver, KweekweekHeader.class);
		kweekweekHeader.clickLoginButtonFromHeader();
		
		List<WebElement> elements = kweekweekHomepage.getFieldsToBeClickedOnLoginPopup();
		
		for (WebElement element : elements){
		
			kweekweekHomepage.clickOnEachElement(element);
			Thread.sleep(3000);
		    String value = kweekweekHomepage.getCssValueForField(element);
		    Assert.assertEquals(value,"rgb(252, 206, 6)");
	}
	}
	
	@Test
	public void forgotPasswordMail() throws InterruptedException {
		KweekweekHeader kweekweekHeader = PageFactory.initElements(driver,KweekweekHeader.class);
		KweekweekHomepage kweekweekHomepage = PageFactory.initElements(driver, KweekweekHomepage.class);
		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
		Thread.sleep(1000);
		kweekweekHeader.clickLoginButtonFromHeader();
		kweekweekHomepage.clickForgotPasswordLink();
		kweekweekHomepage.enterEmailResetPassword("sanityautotest@gmail.com");
		kweekweekHomepage.clickResetPasswordSumitButton();
		gmailPage.getGmailLoginPage();
		gmailPage.loginToGmail("sanityautotest@gmail.com", "Pitech01");
		gmailPage.clickGmailResetPasswordEmail();
		gmailPage.clickGmailResetPasswordButton();
		Iterations.moveToNextWindow(driver);
		kweekweekHomepage.setNewPassword("123123");
		kweekweekHomepage.setNewPasswordConfirmation("123123");
		kweekweekHomepage.clickChangePassword();
		Waits.waitForVisibilityOfElement(driver, kweekweekHomepage.alertContainer);
		Thread.sleep(1000);
		Assert.assertTrue(driver.getPageSource().contains("Password changed successfully. You are now logged in"));
		
	}
	
}

