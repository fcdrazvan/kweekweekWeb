package base;

import java.util.ArrayList;
import java.util.List;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.GmailPage;



import utils.Properties;
import env.TestAppEnv;


public class BaseTest {
     protected WebDriver driver;

    @BeforeMethod
    public void setup(){
    	
    	Properties.setProperty();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(TestAppEnv.getUrl());
		driver.navigate().refresh();
    }
    
    
    @AfterMethod
    public void tearDown(ITestResult result) {
    	
    	if (result.getName().contains("Mail")){
    		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
    		driver.get("https://mail.google.com/mail/#inbox");
    		gmailPage.deleteAllEmailsAfterTest(driver);
    	}
      
       driver.quit();
    }
   
    

}
