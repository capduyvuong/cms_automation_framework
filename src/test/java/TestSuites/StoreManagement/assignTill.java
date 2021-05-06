package TestSuites.StoreManagement;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.StoreManagement.AssignTilPage;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class assignTill {
	private static WebDriver driver;
	AssignTilPage objAssignTill = new AssignTilPage(driver);
	@BeforeClass
	public static void openBrowser() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");

		String urlweb = "https://cmsuat.taptap.com.vn/stores/";
		driver.get(urlweb);
		// enter field User name
		driver.findElement(By.id("username")).sendKeys("cms-admin");
		// enter password
		driver.findElement(By.id("password")).sendKeys("123456");
		// click on login button
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='assign']")).click();

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
	
	@Test
	public void Test01_AvailableTillIsDisplayed() throws Exception {
		
		String availabletill = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/ul";
		if (isElementDisplayed(driver, availabletill)) {
			System.out.println("available till is displayed");
		} else {
			System.out.println("available till isn't displayed");
		}
		
		
	}
	@Test
	public void Test02_AssignedTillIsDisplayed() throws Exception {
		String AssignedTill = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/ul";
		if (isElementDisplayed(driver, AssignedTill)) {
			System.out.println("AssignedTill is displayed");
		} else {
			System.out.println("AssignedTill isn't displayed");
		}
		
	}
	@Test
	public void Test03_ButtonDisplayed() throws Exception {

		if (AssignTilPage.buttonChooseAssign.isDisplayed()) {
		System.out.println("Button choose to assign is displayed");
		}
		 else {
			System.out.println("Button choose to assign isn't displayed");
		}
		if (AssignTilPage.buttonChooseUnAssign.isDisplayed()) {
			System.out.println("Button choose to un-assign is displayed");
			}
			 else {
				System.out.println("Button choose to un-assign isn't displayed");
			}
		if (AssignTilPage.buttonChooseAssignAll.isDisplayed()) {
			System.out.println("Button choose to assign all is displayed");
			}
			 else {
				System.out.println("Button choose to assign all isn't displayed");
			}
		if (AssignTilPage.buttonChooseUnAssignAll.isDisplayed()) {
			System.out.println("Button choose to un-assign all is displayed");
			}
			 else {
				System.out.println("Button choose to un-assign all isn't displayed");
			}
		
	}
		@Test
		public void Test04_AssignAnyTill() throws ParseException, InterruptedException {
			PageFactory.initElements(driver, objAssignTill);
			objAssignTill.selectTillInListAvai();
			objAssignTill.clickChooseAssignTill();
//			String actualTillchosen =driver.findElement(By.xpath("//li[@class='py-3 pl-3 cursor-pointer']")).getText();
//			String expectedTillChosenString driver.findElement(By.xpath("))
			objAssignTill.clickOK();
			try
			{
			    WebDriverWait wait = new WebDriverWait(driver,20);
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Store is updated successfully.')]")));
			}catch(Throwable e){
			    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
			}
			String actualMSStoreCode = driver.findElement(By.xpath("//span[contains(text(),'Store is updated successfully)]")).getText();
			String expectedMSStoreCode = "Store is updated successfully.";
	    	Assert.assertEquals(expectedMSStoreCode, actualMSStoreCode);
			
	}
	
	
//	@AfterClass
//	public static void closeBrowser() {
//		driver.quit();
//	}
	
}


