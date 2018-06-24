package testcases;

import java.util.regex.Pattern;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VidsPage {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	/*
	 * @BeforeClass(alwaysRun = true) public void setUp() throws Exception {
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Users\\sarika.dhall\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 * 
	 * WebDriver driver = new ChromeDriver(); baseUrl = "https://www.katalon.com/";
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); }
	 */

	// public String baseUrl = "https://www.mars.protmv.com/";
	// String driverPath = "C:\\geckodriver.exe";
	// public WebDriver driver ;
	@AfterTest // Jumbled
	public void terminateBrowser() {
		//driver.close();
	}

	@BeforeTest // Jumbled
	public void launchBrowser() {
		baseUrl = "https://www.mars.protmv.com/";
	//	baseUrl = "https://www.neptune.protmv.com/";
		//https://www.neptune.protmv.com/
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sarika.dhall\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() throws Exception {

		try {
			assertEquals(driver.getTitle(), "Search for your favorite vids - ManyVids");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}
	

	@Test(priority = 2)
	public void verifyVidsPageTitleUrl() throws Exception {

		driver.findElement(By.xpath("//button[contains(text(),'I am over 18!')]")).click();
		//driver.findElement(By.linkText("Vids")).click();
		String URL = driver.getCurrentUrl();
		try {
			assertEquals(driver.getTitle(), "Search for your favorite vids - ManyVids");
			assertEquals(URL, "https://www.mars.protmv.com/Vids/");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}
	
	@Test(priority = 3)
	public void verifyHomePageAnnouncements() throws Exception {

		String URL = driver.getCurrentUrl();
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Got it, thanks')]")).click();
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Vids")).click();
	}
	
	
	@Test(priority = 4)
	public void advanceVidsSortCount() {
		List<WebElement> vidsSortingList = driver.findElements(By.xpath("(//ul[@class='list'])[1]/li"));
		System.out.println("List size is: " + vidsSortingList.size());
		for (WebElement e : vidsSortingList) {
			// System.out.print("Text within the Anchor tab"+e.getText()+"\t");
			// System.out.println("Anchor: "+e.getAttribute("href"));
		}
		try {
			assertEquals(vidsSortingList.size(), 10);

		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Test(priority = 4)
	public void verifyVidsSortingWays() throws Exception {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));

		try {
			assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Being Viewed')]")).getText(),
					"Being Viewed");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(driver.findElement(By.xpath("//*[@id=\"sortPageTitleId\"]")).getText(), "Being Viewed");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Reporter.log("Being Viewed text verified");
		driver.findElement(By.xpath("//span[contains(text(),'Being Viewed')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Newest Vids')]")).click();
		
		try {
			assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Newest Vids')]")).getText(),
					"Newest Vids");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if ("Newest Vids".equals(driver.findElement(By.xpath("//*[@id=\"sortPageTitleId\"]")).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		try {
			assertEquals(driver.findElement(By.xpath("//*[@id=\"sortPageTitleId\"]")).getText(), "Newest Vids");
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// ERROR: Caught exception [unknown command []]

		Reporter.log("Newest Viewed text verified");
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Newest Vids')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Most Loved')]")).click();
		String highestLikes= driver.findElement(By.xpath("(//a[contains(@title,'total likes')])[1]")).getText();
		String secondHighestLikes= driver.findElement(By.xpath("(//a[contains(@title,'total likes')])[2]")).getText();
		System.out.println(highestLikes);
		System.out.println(secondHighestLikes);
		
		
		
		try {
			assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Most Loved')]")).getText(),
					"Most Loved");
			
			assertEquals(driver.findElement(By.xpath("//*[@id=\"sortPageTitleId\"]")).getText(), "Most Loved");
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Reporter.log("Most Loved text verified");
		
		
		
		//WebElement element = (new WebDriverWait(driver, 10))
				//   .until(ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id=\"sortPageTitleId\"]"), baseUrl), "Most Loved");
		
		
		

	}
	
	
	@Test(priority = 5)
	public void verifyVidsMostViews() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Most Loved')]")));
	
		driver.findElement(By.xpath("//span[contains(text(),'Most Loved')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Most Views')]")).click();
		//String highestLikes= driver.findElement(By.xpath("(//a[contains(@title,'total likes')])[1]")).getText();
		//String secondHighestLikes= driver.findElement(By.xpath("(//a[contains(@title,'total likes')])[2]")).getText();
		//System.out.println(highestLikes);
		//System.out.println(secondHighestLikes);
	
		try {
			assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Most Views')]")).getText(),
					"Most Views");
			assertEquals(driver.findElement(By.xpath("//*[@id=\"sortPageTitleId\"]")).getText(), "Most Views");
			
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		Reporter.log("Most Views text verified");
		
	}
	


	
	
	/*
	 * @AfterClass(alwaysRun = true) public void tearDown() throws Exception {
	 * driver.quit(); String verificationErrorString =
	 * verificationErrors.toString(); if (!"".equals(verificationErrorString)) {
	 * fail(verificationErrorString); } }
	 */

	
	
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
