package TestSuites.StoreManagement;

import java.util.concurrent.TimeUnit;
import java.text.ParseException;

import org.junit.AfterClass;
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

import PageObject.StoreManagement.CreateStorePage;
import PageObject.StoreManagement.ViewStorePage;
//import jdk.jfr.Timespan;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditStore {
	private static WebDriver driver;
	ViewStorePage objViewStore = new ViewStorePage(driver);
	CreateStorePage objCreateStore = new CreateStorePage(driver);	
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
	@Test()
	public void Test01_Editvalidvalue() throws ParseException, InterruptedException {
		PageFactory.initElements(driver, objCreateStore);
		objViewStore.searchByStoreCode("STORE_CHANG");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objViewStore.clickEdit(); 
	    
		// entering value
		objCreateStore.clickDropDown();
		objCreateStore.selectValueInDropDown();
		String brandActualString = driver.findElement(By.xpath("//span[@class='ant-select-selection-item' and @style='']")).getText();
		System.out.println(brandActualString);
		objCreateStore.inputBrandStoreCode.clear();
		objCreateStore.setBrandStoreCode("CHANG_T11");
		objCreateStore.inputStoreDomain.clear();
		objCreateStore.setStoreDomain("http://changvietnam.vn/1");
		objCreateStore.inputStoreName.clear();
		objCreateStore.setStoreName("CHANG QUAN 11");
		objCreateStore.inputStoreAddress.clear();
		objCreateStore.setStoreAddress("76/2G Nguyen Quoc Tai1");
		objCreateStore.inputStoreDistrict.clear();
		objCreateStore.setStoreDistrict("HCM1");
		objCreateStore.inputStoreProvince.clear();
		objCreateStore.setStoreProvince("Quan 11");
		objCreateStore.inputStoreLatitude.clear();
		objCreateStore.setStoreLatitude("1111");
		objCreateStore.inputStoreLongitude.clear();
		objCreateStore.setStoreLongitude("11121");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// verify by notice create success
		String actualMS = driver.findElement(By.xpath("/html/body/div[2]/div/span/div/div/div/span[2]")).getText();
		// System.out.println(actualMS);
		String expectedMS = "Store is updated successfully.";
		Assert.assertEquals(expectedMS, actualMS);
		
		objViewStore.searchByStoreCode("STORE_CHANG");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		String expectedBrandName = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(expectedBrandName, brandActualString);
		//
		String actualStoreName = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
		String expectedStoreName = "CHANG QUAN 11";
		Assert.assertEquals(expectedStoreName, actualStoreName);
		//
		String actualStoreAddress = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		String expectedStoreAddress = "76/2G Nguyen Quoc Tai1";
		Assert.assertEquals(expectedStoreAddress, actualStoreAddress);
		//
		String actualStoreLocation = driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).getText();
		String expectedStoreLocation = "HCM1 - Quan 11";
		Assert.assertEquals(expectedStoreLocation, actualStoreLocation);
		//
		String actualStoreDomain = driver.findElement(By.xpath("//tbody/tr[1]/td[7]")).getText();
		String expectedStoreDomain = "http://changvietnam.vn/1";
		Assert.assertEquals(expectedStoreDomain, actualStoreDomain);
	}
	@Test
	public void Test02_NothingChange() throws ParseException, InterruptedException {
		
		PageFactory.initElements(driver, objViewStore);
		objViewStore.inputStoreCode.clear();
		objViewStore.searchByStoreCode("STORE_CHANG");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objViewStore.clickEdit(); 
	    driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary' and @type='button']")).click();
	    try
		{
		    WebDriverWait wait = new WebDriverWait(driver,20);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Store is updated successfully.')]")));
		}catch(Throwable e){
		    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
		}
	    String actualMSStoreCode = driver.findElement(By.xpath("//span[contains(text(),'Store is updated successfully.')]")).getText();
		String expectedMSStoreCode = "Store is updated successfully.";
    	Assert.assertEquals(expectedMSStoreCode, actualMSStoreCode);
	}
	@Test
	public void Test03_DeleteFieldRequired() throws ParseException, InterruptedException {
		PageFactory.initElements(driver, objCreateStore);
		objViewStore.searchByStoreCode("STORE_CHANG");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    objViewStore.clickEdit(); 
	    
		// entering value
		objCreateStore.clickDropDown();
		objCreateStore.selectValueInDropDown();
		objCreateStore.inputBrandStoreCode.clear();
		objCreateStore.inputStoreDomain.clear();
		objCreateStore.inputStoreName.clear();
		String expectedBrandStoreCodeMS = "Brand Store Code is required.";
		String actualBrandStoreCodeMS = driver.findElement(By.xpath("//div[contains(text(),'Brand Store Code is required.')]")).getText();
		Assert.assertEquals(expectedBrandStoreCodeMS, actualBrandStoreCodeMS);

		String expectedStoreDomainMS = "Store Domain is required.";
		String actualStoreDomainMS = driver.findElement(By.xpath("//div[contains(text(),'Store Domain is required.')]")).getText();
		Assert.assertEquals(expectedStoreDomainMS, actualStoreDomainMS);

		String expectedStoreNameMS = "Store Name is required.";
		String actualStoreNameMS = driver.findElement(By.xpath("//div[contains(text(),'Store Name is required.')]")).getText();
		Assert.assertEquals(expectedStoreNameMS, actualStoreNameMS);
	}	
		
		 @AfterClass
		 public static void closeBrowser(){
		 driver.quit();
		 }
	}