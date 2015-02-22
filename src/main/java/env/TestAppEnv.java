package env;

public class TestAppEnv {

	public static final String DOMAIN = "kweekweek.com" ;
	public static final String SERVER = "staging";
	public static final String GMAIL = "accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/";
	
	public static String getUrl(){
		return "http://kwk:kweekweek@" + SERVER +"." + DOMAIN ;
		
	}
	public static String getGmailLoginPage(){
		return "https://" + GMAIL ;
	}
		
		

	

}
