package TestSuites.StoreManagement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ViewListStore {
	private static WebDriver driver;

	@BeforeClass
	public static void openBrowser() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		String urlweb = "https://cmsuat.taptap.com.vn/stores/";
		driver.get(urlweb);
		driver.manage().window().maximize();
		// enter field User name
		driver.findElement(By.id("username")).sendKeys("cms-admin");
		// enter password
		driver.findElement(By.id("password")).sendKeys("123456");
		// click on login button
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
		Thread.sleep(1000);

	} 
	@Test()
	public void Test01_AssignPopUpIsDisplayed() throws Exception {
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr[1]/td[9]/div/button[1]")).click();
		String popupAsign = "/html/body/div[2]/div/div[2]/div/div[2]";
		if (isElementDisplayed(driver, popupAsign)) {
			System.out.println("Popup Assign is displayed");
		} else {
			System.out.println("Popup Assign isn't displayed");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]")).click();
	}
  
	@Test
	public void Test02_TextboxIsDisplayed()  throws Exception {
	
		//search with brand name
		String brandName = "//input[@id='brandName']";
		if (isElementDisplayed(driver, brandName)) {
			System.out.println("TextboxbrandName is displayed");
		} else {
			System.out.println("TextboxbrandName isn't displayed");
		}
		
		//search with store code
				String storeCode = "//input[@id='storeCode']";
				if (isElementDisplayed(driver, storeCode)) {
					System.out.println("TextboxstoreCode is displayed");
				} else {
					System.out.println("TextboxstoreCode isn't displayed");
				}
				
				//search with store till
				String storeTill = "//input[@id='storeTill']";
				if (isElementDisplayed(driver, storeTill)) {
					System.out.println("TextboxstoreTill is displayed");
				} else {
					System.out.println("TextboxstoreTill isn't displayed");
				}
		
	}

	@Test
	public void Test03_ButtonIsDisplayed()  throws Exception  {
		
		//button search
		String buttonSearch = "//button[@type=\"submit\"]";
		if (isElementDisplayed(driver, buttonSearch)) {
			System.out.println("Button search is displayed");
		} else {
			System.out.println("Button search isn't displayed");
		}
		
		//button create
				String buttonCreate = "//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[4]/button[2]";
				if (isElementDisplayed(driver, buttonCreate)) {
					System.out.println("Button create is displayed");
				} else {
					System.out.println("Button create isn't displayed");
				}
	}
			
	@Test
	public void Test04_TableIsDisplayed()  throws Exception {
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

	@Test
	public void Test05_PaginationIsDisplayed()  throws Exception {
		String Pagination = "/html/body/div/section/section/main/div/div/div/div/div/ul";
		if (isElementDisplayed(driver, Pagination)) {
			System.out.println("Pagination is displayed");
		} else {
			System.out.println("Pagination isn't displayed");
		}

		List<WebElement> pagination = driver
				.findElements(By.xpath("/html/body/div/section/section/main/div/div/div/div/div/ul"));
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
	public void Test06_editPopUpIsDisplayed()  throws Exception {
		
		driver.findElement(By.xpath("//button[@title=\"Edit\"]")).click();
		String popupEdit = "/html/body/div[2]/div/div[2]/div/div[2]";
		if (isElementDisplayed(driver, popupEdit)) {
			System.out.println("Popup Edit is displayed");
		} else {
			System.out.println("Popup Edit isn't displayed");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]")).click();
	}
	
	@Test
	public void Test07_deletePopUpIsDisplayed()  throws Exception {
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[9]/div[1]/button[3]")).click();
		String popupDelete = "//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]";
		if (isElementDisplayed(driver, popupDelete)) {
			System.out.println("Popup Delete is displayed");
		} else {
			System.out.println("Popup Delete isn't displayed");
		}
		
		
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
	 @AfterClass
	 public static void closeBrowser(){
	 driver.quit();
	 }
}