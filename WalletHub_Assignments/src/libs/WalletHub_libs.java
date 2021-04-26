package libs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonLibs.BaseLibs;



public class WalletHub_libs {
	private WebDriver driver;
	
	public WalletHub_libs(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[ng-model='fields.email']")
	private WebElement emailField;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginTab;
	
	@FindBy(css="input[ng-model='fields.password1']")
	private WebElement passwordField;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginBtn;
	
	
	
	@FindBy(css="h1.profile-name+div>review-star+a")
	private WebElement reviewsLinksInHeader;
	
	@FindBy(css="div[class*='rv review-action ng-enter-element']>:nth-child(2)>div>svg:nth-child(4)>g>path")
	private WebElement fourthStar;
	
	@FindBy(css="div[class*='rv review-action ng-enter-element']>:nth-child(2)>div>svg:nth-child(4)>g>path:nth-child(2)")
	private WebElement fourthStarHiglighted;
	
	@FindBy(css="div[class*='dropdown second']")
	private WebElement reviewDropDown;
	
	@FindBy(css="div[class*='dropdown second opened']>ul")
	private WebElement reviewDropDownPanel;
	
	@FindBy(css="div[class*='dropdown second opened']>ul>li")
	private List<WebElement> allReviewDropDownValues;
	
	@FindBy(css="textarea[placeholder*='Write your review...']")
	private WebElement reviewTextArea;
	
	@FindBy(css="div.wrev-user-input-count>span")
	private WebElement reviewCount;

	@FindBy(xpath="//div[text()='Submit']")
	private WebElement reviewSubmitBtn;
	
	@FindBy(css="section.rvtab-content>article[itemprop='review']:nth-child(1)>div[itemprop='description']")
	private WebElement postedReview;
	
	@FindBy(xpath="//h1[contains(text(),'Login or sign up')]")
	private WebElement loginHeader;
	
	public WebElement getLoginHeader() {
		return loginHeader;
	}
	
	public String getPostedReview() {
		return postedReview.getText();
	}
	
	
	public void clickReviewSubmitBtn() {
		reviewSubmitBtn.click();
	}
	
	public int getCountFromUI() {
		return Integer.parseInt(reviewCount.getText());
	}
	
	public void clickReviewsLink() {
		reviewsLinksInHeader.click();
	}
	
	public WebElement getFourthStar() {
		return fourthStar;
	}
	
	public WebElement getHiglightedFourthStar() {
		return fourthStarHiglighted;
	}
	
	public void clickFourthStar() {
		fourthStar.click();
	}
	
	public void selectReviewDropDown(String option) {
		reviewDropDown.click();
		BaseLibs.waitForElementVisible(reviewDropDownPanel);
		for(WebElement item: allReviewDropDownValues) {
			if(item.getText().equals(option)) {
				System.out.println(item.getText());
				item.click();
				break;
			}
		}
	}
	
	public void enterReview(String comments) {
		reviewTextArea.click();
		reviewTextArea.clear();
		reviewTextArea.sendKeys(comments);
	}
	
	public void submitReviewComment(String category,String commments) {
		this.selectReviewDropDown(category);
		this.enterReview(commments);
		this.clickReviewSubmitBtn();
		try {
			BaseLibs.waitForElementVisible(this.getLoginHeader());
			System.out.println("Review is posted");
		}catch (Exception e) {
			System.out.println("Issue in posting review : "+e);
		} 
		
		
	}
	
	public void loginWalletHub(String userName,String password) {
		loginTab.click();
		BaseLibs.waitForElementVisible(emailField);
		emailField.clear();
		emailField.sendKeys(userName);
		BaseLibs.waitForElementVisible(passwordField);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	
	

}
