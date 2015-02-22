package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveToOffsetAction;
import org.openqa.selenium.support.FindBy;

public class Iterations {

	
	WebDriver driver;
	
	public Iterations(WebDriver driver){
		this.driver=driver;
	}
	
	public static void moveToNextWindow(WebDriver driver){
		Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String baseWindow = getBaseWindow(driver);
        
        while (it.hasNext()){
            String newwin = it.next();
            driver.switchTo().window(newwin);
        }
	}
	public static void returnToBaseWindow(WebDriver driver, String baseWindow){
		 String originalHandle = baseWindow;

		    

		    for(String handle : driver.getWindowHandles()) {
		        if (handle.equals(originalHandle)) {
		            driver.switchTo().window(handle);
		            
		        }else driver.switchTo().window(originalHandle);
		    }

		    
	}
	
	public static String getBaseWindow(WebDriver driver){
		String basewindow = driver.getWindowHandle();
		return basewindow;
	}

}

