package TestSuites.ReferralChallenge;

import java.util.List;
import java.util.concurrent.TimeUnit;
import AppFunctions.Login.Login;
import AppFunctions.Navigations.LeftMenu;
import AppFunctions.ReferralChallenge.ViewListReferralChallenge;
import Utils.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestListRefChallenge {
	public WebDriver driver;

	public List<LogEntry> getBrowserConsoleLogs()
	{
		LogEntries log= driver.manage().logs().get("browser");
		List<LogEntry> logs=log.getAll();
		return logs;
	}

	@BeforeMethod (description = "Open Chrome browser and navigate to Referral Challenge Listing Page",
		groups = "Referral Challenge")
	public void beforeTest() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constant.cms_Url);
		Login.Execute(driver);
		LeftMenu.navigateToReferralChallenges(driver);
	}

	@Test (description = "Test Displaying of TextBoxes Referral Challenge Listing Page",
		groups = "Referral Challenge")
	public void TestCase01_TextBoxIsDisplayed() throws Exception {
		ViewListReferralChallenge.testDisplayingOfTextBoxes(driver);
	}
	/*
	@Test
	public void Test02_PaginationIsDisplayed()  throws Exception {
		String Pagination = "/html/body/div/section/section/main/div/div/div/div[11]/ul";
		if (isElementDisplayed(driver, Pagination)) {
			System.out.println("Pagination is displayed");
		} else {
			System.out.println("Pagination isn't displayed");
		}

		List<WebElement> pagination = driver
				.findElements(By.xpath("/html/body/div/section/section/main/div/div/div/div[11]/ul"));
		// pagination exists
		if (pagination.size() > 0) {
			System.out.println("Pagination exists");

			for (int i = 0; i < pagination.size(); i++) 
			{
				pagination.get(i).click();
			}
		} 
		else 
		{
			System.out.println("Pagination not exists");
		}
		
	}
	
	@Test
	public void Test03_TableIsDisplayed()  throws Exception {
		String table = "/html/body/div/section/section/main/div/div/div/div/div/div/div/div/table";
		if (isElementDisplayed(driver, table)) {
			System.out.println("Table is displayed");
		} else {
			System.out.println("Table isn't displayed");
		}
		List<WebElement> rows = driver.findElements(By.tagName("tr")); 
		int numberRow = rows.size() -1 ;
		System.out.println(numberRow);
	}

	public boolean isElementDisplayed(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	*/
	 @AfterMethod
	 public static void closeBrowser(){
//	 	driver.quit();
	 }
}
