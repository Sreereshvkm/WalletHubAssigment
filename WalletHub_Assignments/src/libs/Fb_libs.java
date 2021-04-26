package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.BaseLibs;


public class Fb_libs {
	
	private WebDriver driver;
	
	public Fb_libs(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(css="button[name='login']")
	private WebElement loginBtn;
	
	@FindBy(css="a[aria-label='Home']")
	private WebElement homeIcon;
	
	
	public void clearUserNameField() {
		userName.clear();
	}
	
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void clearPasswordField() {
		password.clear();
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	
	
	public boolean loginFB(String user,String pass) {
		boolean isLoginSuccess = false;
		this.clearUserNameField();
		this.clearPasswordField();
		this.enterUserName(user);
		this.enterPassword(pass);
		this.clickLoginBtn();
		try {
			BaseLibs.waitForElementVisible(homeIcon);
			if(homeIcon.isDisplayed()) {
				isLoginSuccess=true;
			}
		}catch (Exception e) {
			System.out.println("Login is not success "+ e);
		}
		
		return isLoginSuccess;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
