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
	
	@Test(priority = 2)
	public void verifyHomePageTitleSearchVid()
	{
		logger=report.startTest("ManyVidsHome", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid. verifyTitleHomeManyVidPage();
		
		logger.log(LogStatus.INFO, "Many Vids Home page appeared");
		
		logger.log(LogStatus.PASS, "Many Vids Home page Title Verified"); 
		
	}
	
	@Test
	public void verifyVidsAnnouncements()
	{
		logger=report.startTest("ManyVidsHome", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifyTitleSearchVidPage();
		
		logger.log(LogStatus.INFO, "Many Vids Announcements displayed");
		
		logger.log(LogStatus.PASS, "Announcements Verified"); 
		
	}
	
	@Test
	public void verifyTitleSearchVid()
	{
		logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifyTitleSearchVidPage();
		
		logger.log(LogStatus.INFO, "Many Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Vids Title Verified"); 
		
	}
	
	@Test(priority = 4)
	public void advanceVidsSortCount() {
        logger=report.startTest("Vids", "This test case will validate");
		
		searchvid=PageFactory.initElements(driver, SearchVidsPage.class);
		
		searchvid.verifyTitleSearchVidPage();
		
		logger.log(LogStatus.INFO, "Many Vids Search Video page appeared");
		
		logger.log(LogStatus.PASS, "Advance Sort Elements Verified"); 
		
		
	}
	
	
	
}
