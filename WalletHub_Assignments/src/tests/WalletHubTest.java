package tests;

import org.openqa.selenium.WebDriver;

import commonLibs.BaseLibs;
import libs.WalletHub_libs;

public class WalletHubTest {
	static WebDriver driver = BaseLibs.browserSetUp("Firefox");
	private static String reviewComment=BaseLibs.generateRandomText(200);
	
	public static void postReview() {
		BaseLibs.launchApp("http://wallethub.com/profile/test_insurance_company/");
		WalletHub_libs wh=new WalletHub_libs(driver);
		wh.clickReviewsLink();
		BaseLibs.waitForElementVisible(wh.getFourthStar());
		BaseLibs.mouseOver(wh.getFourthStar());
		try {
			BaseLibs.waitForElementVisible(wh.getHiglightedFourthStar());
			if(wh.getHiglightedFourthStar().isDisplayed()) {
				wh.clickFourthStar();
				wh.submitReviewComment("Health Insurance", reviewComment);
			}

		}catch (Exception e) {
			System.out.println("Highlighted four star is not displayed"+ e);
		}
				
		BaseLibs.quiteApp();
	}
	
	
	public static void validatePostedReview() {
		driver = BaseLibs.browserSetUp("Firefox");
		BaseLibs.launchApp("http://wallethub.com/profile/test_insurance_company/");
		WalletHub_libs wh=new WalletHub_libs(driver);
		wh.clickReviewsLink();
		String postedReview = wh.getPostedReview();
		System.out.println(postedReview);
		if(postedReview.equals(reviewComment)) {
			System.out.println("Review is posted correctly");
		}else {
			System.out.println("Issue in Review posted. Unable to find the same posted review");
		}
		
		BaseLibs.quiteApp();
	}
	public static void main(String args[]) {
		postReview();
		validatePostedReview();
	}

}
