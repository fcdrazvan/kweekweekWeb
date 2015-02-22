package utils;

public class Properties {
	
	public static String pathToProject = System.getProperty("user.dir");
	public static String chromeProperty = "webdriver.chrome.driver";
	public static String pathToChromedriver = "\\src\\main\\resources\\drivers\\chromedriver.exe";
	
	public static String setProperty(){
		return System.setProperty(chromeProperty, pathToProject + pathToChromedriver);
		
		
	}

}
