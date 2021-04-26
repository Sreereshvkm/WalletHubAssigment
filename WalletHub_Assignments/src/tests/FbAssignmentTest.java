package tests;

import org.openqa.selenium.WebDriver;

import commonLibs.BaseLibs;
import libs.Fb_libs;

public class FbAssignmentTest {
	static WebDriver driver = BaseLibs.browserSetUp("Chrome");
	
	
	public static void loginTest() {
		BaseLibs.launchApp("https://www.facebook.com/");
		Fb_libs fb=new Fb_libs(driver);
		boolean loginFB = fb.loginFB("9605907568", "$reeOCT1996");
		if(loginFB) {
			System.out.println("Hello world");
		}
		
		BaseLibs.quiteApp();
		
	}

	public static void main(String[] args) {
		loginTest();

	}

}
