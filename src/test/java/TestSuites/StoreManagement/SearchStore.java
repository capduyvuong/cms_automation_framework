package TestSuites.StoreManagement;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.StoreManagement.ViewStorePage;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchStore {
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
		Thread.sleep(500);

	}

	// search by brandname
	@Test
	public void Test02_SearchByName() throws ParseException, InterruptedException {

		driver.navigate().refresh();
		List<WebElement> Paginglist = driver
				.findElements(By.xpath("/html/body/div/section/section/main/div/div/div/div/div/ul/li"));

		WebElement enabled_next_page_btn = Paginglist.get(Paginglist.size() - 1);

		int count = 0;
		String brandFilterValue = "brand4";

		Boolean isComplete = false;

		/// trường hợp 1 page => ban dau disable => iscomplêt=false vẫn chạy vào để đếm
		/// page đó
		// trường hợp >= 2 page => chay vào đếm, nhấn next page đến khi nextpagedisable
		/// chạy vào lần cuối để
		// kiểm tra page cuối cùng xong isComplete=true kết thúc vòng while

		while (!enabled_next_page_btn.getAttribute("class").contains("disabled") || isComplete == false) {
			if (enabled_next_page_btn.getAttribute("class").contains("disabled")) {
				isComplete = true;
			}
			driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			List<WebElement> listrow = driver.findElements(
					By.xpath("//*[@id=\"root\"]/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr"));

			for (int i = 1; i <= listrow.size(); i++) {

				String brandname = driver.findElement(By
						.xpath("//*[@id=\"root\"]/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr["
								+ i + "]/td[2]"))
						.getText();

				if (brandname.equals(brandFilterValue)) {
					count++;
				}

			}

			try {
				enabled_next_page_btn.click();
				driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

				Paginglist = driver
						.findElements(By.xpath("/html/body/div/section/section/main/div/div/div/div/div/ul/li"));

				enabled_next_page_btn = Paginglist.get(Paginglist.size() - 1);

			} catch (Exception e) {
				System.out.println("No more Pages Available");
				break;
			}

		}

		objViewStore = new ViewStorePage(driver);
		objViewStore.searchByBrandName("brand4");
//		   String searchTerm = "brand4";
//			WebElement searchField = driver.findElement(By.id("brandName"));
//		    searchField.sendKeys(searchTerm);
//		    WebElement searchButton = driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[4]/button[1]"));
//		    searchButton.click();
		List<WebElement> results = driver.findElements(By.cssSelector(".r"));
		for (int i = 0; i < results.size(); i++) {
			Assert.assertTrue("Search result validation failed at instance [ + i + ].",
					results.get(i).getText().contains("brand4"));
		}

		if (results.size() == count) {
			System.out.println("Ket qua tim kiem dung roi");
		}
		// driver.findElement(By.id("brandName")).clear();;

	}

	// search by Storecode
	@Test
	public void Test01_SearchByStoreCode() throws ParseException, InterruptedException {
		// check search co dung hay khong
		String searchTerm = "sylvan_demo";
		WebElement searchField = driver.findElement(By.id("storeCode"));
		searchField.sendKeys(searchTerm);
		WebElement searchButton = driver.findElement(By.xpath(
				"//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[4]/button[1]"));
		searchButton.click();
		String expectResult = "sylvan_demo";
		String actualResult = driver
				.findElement(By.xpath(
						"/html/body/div/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr[1]/td[6]"))
				.getText();
		Assert.assertEquals(expectResult, actualResult);

	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}