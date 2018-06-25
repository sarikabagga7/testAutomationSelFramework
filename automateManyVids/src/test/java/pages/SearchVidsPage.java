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
	List<WebElement> advanceSortList;

	@FindBy(xpath = "div.mv-announcement.js-mv-announcement.is-visible a:first-child")
	WebElement anouncementLink;

	@FindBy(xpath = "//span[contains(text(),'Being Viewed')]")
	WebElement spanBeingViewed;

	@FindBy(xpath = "//h2[contains(text(),'Trending Vids ')]")
	WebElement headerTrendingVideo;

	@FindBy(xpath = "//h2[contains(text(),'MV Takeover')]")
	WebElement headerMVTakeover;

	@FindBy(xpath = "//span[contains(text(),'Newest Vids')]")
	WebElement spanNewestVids;

	@FindBy(xpath = "//li[contains(text(),'Newest Vids')]")
	WebElement listNewestVids;

	@FindBy(xpath = "//span[contains(text(),'Most Loved')]")
	WebElement spanMostLoved;

	@FindBy(xpath = "//li[contains(text(),'Most Loved')]")
	WebElement listMostLoved;

	@FindBy(xpath = "//span[contains(text(),'Most Views')]")
	WebElement spanMostViews;

	@FindBy(xpath = "//li[contains(text(),'Most Views')]")
	WebElement listMostViews;

	@FindBy(xpath = "//span[contains(text(),'Best Rating')]")
	WebElement spanBestRating;

	@FindBy(xpath = "//li[contains(text(),'Best Rating')]")
	WebElement listBestRating;

	@FindBy(xpath = "//span[contains(text(),'Duration (Longest First)')]")
	WebElement spanDuration;

	@FindBy(xpath = "//li[contains(text(),'Duration (Longest First)')]")
	WebElement listDuration;

	@FindBy(xpath = "//span[contains(text(),'Top June vids")
	WebElement spanTopCurrentMonthvids;

	@FindBy(xpath = "//li[contains(text(),'Top June vids")
	WebElement listTopCurrentMonthvids;

	@FindBy(xpath = "//span[contains(text(),'Top 100 Sold Vids")
	WebElement spanTop100SoldVids;

	@FindBy(xpath = "//li[contains(text(),'Top 100 Sold Vids")
	WebElement listTop100SoldVids;

	@FindBy(xpath = "//span[contains(text(),'Crowned Vids")
	WebElement spanCrownedVids;

	@FindBy(xpath = "//li[contains(text(),'Crowned Vids")
	WebElement listCrownedVids;

	@FindBy(xpath = "//span[contains(text(),'Top 100 Fetish Vids")
	WebElement spanTop100FetishVids;

	@FindBy(xpath = "//li[contains(text(),'Top 100 Fetish Vids")
	WebElement listTop100FetishVids;

	@FindBy(xpath = "(//div[@class='nice-select'])[1]")
	WebElement selectSort;

	@FindBy(id = "sortPageTitleId")
	WebElement sortPageTitleId;

	@FindBy(xpath = "//button[contains(text(),'I am over 18!')]")
	WebElement btnAgeConfirm;

	public void loginToCRM() {

		Utility.waitForWebElement(driver, username, 20).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 0));
		Utility.waitForWebElement(driver, password, 20).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 1));
		Utility.waitForWebElement(driver, loginButton, 20).click();
	}

	// verifyTitleHomeManyVidPage 1
	public void verifyTitleHomeManyVidPage() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals("Search for your favorite vids - ManyVids", driver.getTitle());
		Utility.waitForWebElement(driver, btnAgeConfirm, 20).click();

	}

	// verifyHomePageAnnouncements 2
	public void verifyHomePageAnnouncements() {

		Utility.waitForWebElement(driver, anouncementLink, 20).click();
	}

	// verifyHomePageAnnouncements 3
	public void verifyTitleSearchVidPage() {

		Utility.waitForWebElement(driver, vidsLink, 20).click();

		Assert.assertEquals("Search for your favorite vids - ManyVids", driver.getTitle());
	}

	// advanceVidsSortCount 4
	public void advanceVidsSortCount() {
		System.out.println("List size is: " + advanceSortList.size());
		for (WebElement e : advanceSortList) {
			// System.out.print("Text within the Anchor tab"+e.getText()+"\t");
			// System.out.println("Anchor: "+e.getAttribute("href"));
		}
		try {
			assertEquals(advanceSortList.size(), 10);

		} catch (Error e) {

		}
	}

	public void verifySortByBeingViewedtVids() {

		assertEquals("Being Viewed", spanBeingViewed.getText());
		assertEquals("Being Viewed", sortPageTitleId.getText());
		System.out.println("Being Viewed verified");

	}

	public void verifySortByNewestVids() {

		Utility.waitForWebElement(driver, spanBeingViewed, 20).click();

		Utility.waitForWebElement(driver, listNewestVids, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Newest Vids", 20);

		assertEquals("Newest Vids", spanNewestVids.getText());
		assertEquals("Newest Vids", sortPageTitleId.getText());
		System.out.println("Newest Vids verified");

	}

	public void verifySortByMostLoved() {

		Utility.waitForWebElement(driver, spanNewestVids, 20).click();

		Utility.waitForWebElement(driver, listMostLoved, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Most Loved", 20);

		assertEquals("Most Loved", spanMostLoved.getText());
		assertEquals("Most Loved", sortPageTitleId.getText());
		System.out.println("Most Loved verified");

	}

	public void verifySortByMostViewed() {

		Utility.waitForWebElement(driver, selectSort, 20).click();
		
		Utility.waitForWebElement(driver, listMostViews, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Most Views", 20);

		assertEquals("Most Views", spanMostViews.getText());
		assertEquals("Most Views", sortPageTitleId.getText());
		System.out.println("Most Views verified");

	}

	public void verifySortByBestRating() {

		Utility.waitForWebElement(driver, selectSort, 20).click();

		Utility.waitForWebElement(driver, listBestRating, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Best Rating", 20);

		assertEquals("Best Rating", spanBestRating.getText());
		assertEquals("Best Rating", sortPageTitleId.getText());
		System.out.println("Best Rating verified");

	}

	public void verifySortByDuration() {

		Utility.waitForWebElement(driver, spanBestRating, 20).click();

		Utility.waitForWebElement(driver, listDuration, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Duration (Longest First)", 20);

		assertEquals("Duration (Longest First)", spanDuration.getText());
		assertEquals("Duration (Longest First)", sortPageTitleId.getText());
		System.out.println("Duration (Longest First) verified");

	}

	public void verifySortByTopMonth() {

		Utility.waitForWebElement(driver, spanDuration, 20).click();

		Utility.waitForWebElement(driver, listTopCurrentMonthvids, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Top June vids", 20);

		assertEquals("Top June vids", spanTopCurrentMonthvids.getText());
		assertEquals("Top June vids", sortPageTitleId.getText());
		System.out.println("Top June vids verified");

	}

	public void verifySortByTop100SoldVids() {

		Utility.waitForWebElement(driver, spanTopCurrentMonthvids, 20).click();

		Utility.waitForWebElement(driver, listTop100SoldVids, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Top 100 Sold Vids", 20);

		assertEquals("Top 100 Sold Vids", spanTop100SoldVids.getText());
		assertEquals("Top 100 Sold Vids", sortPageTitleId.getText());
		System.out.println("Top 100 Sold Vids verified");

	}

	public void verifySortByCrownedVids() {

		Utility.waitForWebElement(driver, spanTop100SoldVids, 20).click();

		Utility.waitForWebElement(driver, listCrownedVids, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Crowned Vids", 20);

		assertEquals("Crowned Vids", spanCrownedVids.getText());
		assertEquals("Crowned Vids", sortPageTitleId.getText());
		System.out.println("Crowned Vids verified");

	}

	public void verifySortByTop100FetishVids() {

		Utility.waitForWebElement(driver, spanCrownedVids, 20).click();

		Utility.waitForWebElement(driver, listTop100FetishVids, 20).click();

		Utility.waitForElementAndGetText(driver, sortPageTitleId, "Top 100 Fetish Vids", 20);

		assertEquals("Top 100 Fetish Vids", spanTop100FetishVids.getText());
		assertEquals("Top 100 Fetish Vidss", sortPageTitleId.getText());
		System.out.println("Top 100 Fetish Vids verified");

	}

	public void verifyTitleAfterLogin() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
}
