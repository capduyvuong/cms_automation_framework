package TestSuites.ReferralChallenge;

import AppFunctions.Login.Login;
import AppFunctions.Navigations.LeftMenu;
import AppFunctions.ReferralChallenge.CreateReferralChallenge;
import AppFunctions.ReferralChallenge.CreateReferralChallengeWithDataDriven;
import Utils.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utils.BrowserFactory.startBrowser;

public class TestCreateRefChallenge {
	public static WebDriver driver;

	public List<LogEntry> getBrowserConsoleLogs()
	{
		LogEntries log= driver.manage().logs().get("browser");
		List<LogEntry> logs=log.getAll();
		return logs;
	}

	@BeforeMethod (description = "Open Chrome browser and navigate to Referral Challenge Listing Page",
		groups = "Referral Challenge")
	public void beforeTest() throws Exception {
//		startBrowser("firefox");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constant.cms_Url_Staging);
		Login.Execute(driver);
		LeftMenu.navigateToReferralChallenges(driver);
	}

	@Test (description = "Test Create New Referral Challenge",
		groups = "Referral Challenge")
	public void testCreateNewRefChallenge() throws Exception {
		CreateReferralChallenge.testCreateNewRefChallenge(driver);
//		CreateReferralChallengeWithDataDriven.testCreateNewRefChallengeWithDataDriven(driver);
	}

	@AfterMethod
	public static void closeBrowser(){
	//	 	driver.quit();
	}
}
