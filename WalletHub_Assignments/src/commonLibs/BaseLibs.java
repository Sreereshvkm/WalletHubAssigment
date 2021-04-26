package commonLibs;

import java.awt.AWTException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseLibs {

	private static WebDriver driver;
	private static String driverPath = System.getProperty("user.dir") + "\\driver";
	private static WebDriverWait wait;
	private static Actions actions;

	public static WebDriver browserSetUp(String browser) {
		if (browser == "Chrome") {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 30);
			actions = new Actions(driver);
		} else if (browser == "Firefox") {
			System.setProperty("webdriver.gecko.driver", driverPath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 30);
			actions = new Actions(driver);
		}

		return driver;
	}

	public static void launchApp(String url) {
		driver.get(url);

	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public static void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void mouseOver(WebElement element) {

		actions.moveToElement(element).build().perform();
		try {
			Thread.sleep(3000);
			System.out.println("mouseOver done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void quiteApp() {
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mousePointerMove() {
		java.awt.Robot robot = null;
		try {
			robot = new java.awt.Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseMove(0, 1080);
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static int getLength(String text) {
		return text.length();
	}

	public static String generateRandomText(int size) {
		String text = "abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		String randomString = "";
		for (int i = 0; i < size; i++) {
			randomString = randomString + text.charAt(rand.nextInt(25));
			if (i % 5 == 0) {
				randomString = randomString + " ";
			}
			if (randomString.length() == 200) {
				break;
			}
		}

		System.out.println(randomString);
		return randomString;

	}

	public static void main(String arg[]) {
		generateRandomText(200);
	}

}
