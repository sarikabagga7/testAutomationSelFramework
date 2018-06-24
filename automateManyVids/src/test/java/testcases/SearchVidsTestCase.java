package testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import lib.Utility;
import pages.BaseClass;
import pages.SearchVidsPage;


public class SearchVidsTestCase extends BaseClass
{

	SearchVidsPage searchvid;
	
	@Test(priority = 1)
	public void verifyHomePageTitleSearchVid()
	{
		logger=report.startTest("ManyVidsHome", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid. verifyTitleHomeManyVidPage();
		
		logger.log(LogStatus.INFO, "Many Vids Home page appeared");
		
		logger.log(LogStatus.PASS, "Many Vids Home page Title Verified"); 
		
	}
	
	@Test(priority = 2)
	public void verifyVidsAnnouncements()
	{
		logger=report.startTest("ManyVidsHome", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifyTitleSearchVidPage();
		
		logger.log(LogStatus.INFO, "Many Vids Announcements displayed");
		
		logger.log(LogStatus.PASS, "Announcements Verified"); 
		
	}
	
	@Test(priority = 3)
	public void verifyTitleSearchVid()
	{
		logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifyTitleSearchVidPage();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Vids Title Verified"); 
		
	}
	
	@Test(priority = 4)
	public void verifyAdvanceSortListCount() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.advanceVidsSortCount();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Being Viewed Vids verified"); 
		
		
	}
	
	@Test(priority = 4)
	public void verifySortByBeingViewedtVids() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByBeingViewedtVids();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Being Viewed Vids verified"); 
		
		
	}
	
	@Test(priority = 5)
	public void verifySortByNewestVids() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByNewestVids();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Newest Vids Vids verified"); 
		
		
	}
	
	@Test(priority = 6)
	public void verifySortByMostLoved() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByMostLoved();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Most Loved Vids verified"); 
		
		
	}
	

	@Test(priority = 7)
	public void verifySortByMostViewd() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByMostViewed();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, " Most Views verified"); 
		
		
	}
	
	@Test(priority = 8)
	public void verifySortByBestRating() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByBestRating();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Vids BestRating verified"); 
		
		
	}
	
	
	@Test(priority = 9)
	public void verifySortByDuration() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByDuration();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Vids Duration verified"); 
		
		
	}
	
	@Test(priority = 10)
	public void verifyCurrentMonthvids() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByTopMonth();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Top Month vids  verified"); 
		
		
	}
	
	
	@Test(priority = 11)
	public void verifyTop100SoldVids() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByTop100SoldVids();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Top100SoldVids verified"); 
		
		
	}
	
	
	@Test(priority = 12)
	public void verifySortByCrownedVids() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByCrownedVids();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "verifySortByCrownedVids verified"); 
		
		
	}
	
	
	@Test(priority = 13)
	public void verifySortByTop100FetishVids() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifySortByTop100FetishVids();
		
		logger.log(LogStatus.INFO, "Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "verifySortByTop100FetishVids verified"); 
		
		
	}
	
	
	
	
	
	
	
	
}
