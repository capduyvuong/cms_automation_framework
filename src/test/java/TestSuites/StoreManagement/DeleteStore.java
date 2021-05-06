package TestSuites.StoreManagement;

import java.text.ParseException;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.StoreManagement.ViewStorePage;

public class DeleteStore {
	private static WebDriver driver;
	ViewStorePage objViewStore;
	@BeforeClass
	public static void openBrowser() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		String urlweb = "https://cmsuat.taptap.com.vn/stores/";
		driver.get(urlweb);
		// enter field User name
		driver.findElement(By.id("username")).sendKeys("cms-admin");
		// enter password
		driver.findElement(By.id("password")).sendKeys("123456");
		// click on login button
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
		Thread.sleep(1000);

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
	public void deletestore() throws ParseException, InterruptedException {
		
		objViewStore = new ViewStorePage(driver); 
		String searchTerm = "STORE_CHANG";
		WebElement searchField = driver.findElement(By.id("storeCode"));
		searchField.sendKeys(searchTerm);
		WebElement searchButton = driver.findElement(By.xpath(
				"//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[4]/button[1]"));
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objViewStore.clickDisable();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@type=\"button\" and @class=\"ant-btn ant-btn-primary\"]")).click();

		String storecode = driver
				.findElement(By.xpath(
						"/html/body/div/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr/td[7]"))
				.getText();

		if (isElementDisplayed(driver, storecode)) {
			System.out.println("Storecode is displayed");
		} else {
			System.out.println("Storecode isn't displayed");
		}
		driver.navigate().refresh();
	}

	@Test
	public void Canceldeletestore() throws ParseException, InterruptedException {

		driver.findElement(By.xpath(
				"/html/body/div[1]/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr/td[9]/div/button[3]"))
				.click();
		Thread.sleep(500);
		WebElement output = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div"));
		driver.findElement(By.xpath("//button[@class='ant-btn']")).click();

		if (output.isDisplayed() == true) {
			System.out.println("Pop up not displayed");
		} else
			System.out.println("still display");

	}
	 
	 @AfterClass
	 public static void closeBrowser(){
	 driver.quit();
	 }

}