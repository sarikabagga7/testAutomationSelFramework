package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import dataProviders.DataProviderFactory;
import lib.Utility;

public class SearchVidsPage {

	WebDriver driver;

	public SearchVidsPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement password;

	@FindBy(xpath = "//*[@value='LOGIN']")
	WebElement loginButton;

	@FindBy(linkText = "Vids")
	WebElement vidsLink;

	@FindBy(xpath = "(//ul[@class='list'])[1]/li")
	WebElement advanceSortList;

	@FindBy(xpath = "//a[contains(text(),'Got it, thanks')]")
	WebElement anouncementLink;

	@FindBy(xpath = "//span[contains(text(),'Being Viewed')]")
	WebElement spanBeingViewed;

	@FindBy(id = "sortPageTitleId")
	WebElement sortPageTitleId;
	
	@FindBy(xpath = "//button[contains(text(),'I am over 18!')]")
	WebElement btnAgeConfirm;

	public void loginToCRM() {

		Utility.waitForWebElement(driver, username, 20).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 0));
		Utility.waitForWebElement(driver, password, 20).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 1));
		Utility.waitForWebElement(driver, loginButton, 20).click();
	}

	public void verifyTitleHomeManyVidPage() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("Search for your favorite vids - ManyVids", driver.getTitle());
		btnAgeConfirm.click();
	}

	public void verifyTitleSearchVidPage() {

		vidsLink.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("Search for your favorite vids - ManyVids", driver.getTitle());
	}

	public void verifyHomePageAnnouncements() {

		Utility.waitForWebElement(driver, anouncementLink, 20).click();
	}

	public void verifyTitleAfterLogin() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	public void advanceVidsSortCount() {
		List<WebElement> vidsSortingList = (List<WebElement>) advanceSortList;
		System.out.println("List size is: " + vidsSortingList.size());
		for (WebElement e : vidsSortingList) {
			// System.out.print("Text within the Anchor tab"+e.getText()+"\t");
			// System.out.println("Anchor: "+e.getAttribute("href"));
		}
		try {
			assertEquals(vidsSortingList.size(), 10);

		} catch (Error e) {

		}
	}

	public void verifyVidsSortingWays() {

		assertEquals("Being Viewed", spanBeingViewed.getText());
		assertEquals(driver.findElement(By.xpath("//*[@id=\"sortPageTitleId\"]")).getText(), "Being Viewed");

	}

}
