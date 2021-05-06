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
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateNewStore {
	private static WebDriver driver;
	ViewStorePage objViewStore = new ViewStorePage(driver);
	CreateStorePage objCreateStore = new CreateStorePage(driver);
	
	@BeforeClass
	public static void openBrowser() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
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
	public void Test01_Createvalidvalue() throws ParseException, InterruptedException {
		// entering value
		PageFactory.initElements(driver, objCreateStore);
		objViewStore.clickCreate();
		objCreateStore.clickDropDown();
		objCreateStore.selectValueInDropDown();
		objCreateStore.setBrandStoreCode("CHANG_T1");
		objCreateStore.setStoreCode("STORE_CHANG");
		objCreateStore.setStoreDomain("http://changvietnam.vn/");
		objCreateStore.setStoreName("CHANG QUAN 1");
		objCreateStore.setStoreAddress("76/2G Nguyen Quoc Tai");
		objCreateStore.setStoreDistrict("HCM");
		objCreateStore.setStoreProvince("Quan 1");
		objCreateStore.setStoreLatitude("111");
		objCreateStore.setStoreLongitude("1112");
		objCreateStore.clickCreateInForm();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actualMS = driver.findElement(By.xpath("/html/body/div[2]/div/span/div/div/div/span[2]")).getText();
		String expectedMS = "Store is created successfully.";
		Assert.assertEquals(expectedMS, actualMS);
		for (int i = 1; i < 9; i++) {
			String storeCodeToFind = "STORE_CHANG";
			String actualStorecode = driver.findElement(
					By.xpath("//*[@id=\"root\"]/section/section/main/div/div/div/div/div/div/div/div/table/tbody/tr["
							+ i + "]/td[6]"))
					.getText();
			if (storeCodeToFind.equals(actualStorecode)) {
				System.out.println(actualStorecode);
			}
		}
	}

	@Test
	public void Test02_Createinvalidvalue() throws ParseException, InterruptedException  {

		objViewStore.clickCreate();
		objCreateStore.clickCreateInForm();
		String expectedBrandStoreCodeMS = "Brand Store Code is required.";
		String actualBrandStoreCodeMS = driver.findElement(By.xpath("//div[contains(text(),'Brand Store Code is required.')]")).getText();
		Assert.assertEquals(expectedBrandStoreCodeMS, actualBrandStoreCodeMS);

		String expectedStoreCodeMS = "Store Code is required.";
		String actualStoreCodeMS = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div")).getText();
		Assert.assertEquals(expectedStoreCodeMS, actualStoreCodeMS);
		String expectedStoreDomainMS = "Store Domain is required.";
		String actualStoreDomainMS = driver.findElement(By.xpath("//div[contains(text(),'Store Domain is required.')]")).getText();
		Assert.assertEquals(expectedStoreDomainMS, actualStoreDomainMS);

		String expectedStoreNameMS = "Store Name is required.";
		String actualStoreNameMS = driver.findElement(By.xpath("//div[contains(text(),'Store Name is required.')]")).getText();
		Assert.assertEquals(expectedStoreNameMS, actualStoreNameMS);

		WebElement numberlatidute;
		 numberlatidute = driver.findElement(By.xpath("//input[@placeholder=\"Latitude\"]"));
		// type alphabets
		numberlatidute.sendKeys("A");
		// Retrieve typed value
		String typedValueLatidute = numberlatidute.getAttribute("value");
		// Get the length of typed value
		int size = typedValueLatidute.length();
		if (size == 0) {
			System.out.println("Alphabets for Lati are not allowed.");
		}
		// Type special Characters
		numberlatidute.clear();
		numberlatidute.sendKeys("#%$%&");

		// Retrieve typed value
		String getValueLatidute = numberlatidute.getAttribute("value");

		// Get the length of typed value
		int size1 = getValueLatidute.length();

		if (size1 == 0) {
			System.out.println("Special characters for lati are not allowed.");
		}
		
		
		// verify number input off longitude
				// located element
				numberlatidute.clear();
				WebElement numberlongtiduteField = driver.findElement(By.xpath("//input[@placeholder=\"Longitude\"]"));
				// type alphabets
				numberlongtiduteField.sendKeys("A");
				// Retrieve typed value
				String typedValue = numberlongtiduteField.getAttribute("value");
				// Get the length of typed value
				int sizeofLongitdute = typedValue.length();
				if (sizeofLongitdute == 0) {
					System.out.println("Alphabets longti are not allowed.");
				}
				// Type special Characters
				numberlongtiduteField.clear();
				numberlongtiduteField.sendKeys("#%$%&");

				// Retrieve typed value
				String typedValue1 = numberlongtiduteField.getAttribute("value");

				// Get the length of typed value
				int getlength = typedValue1.length();

				if (getlength == 0) {
					System.out.println("Special longti characters are not allowed.");
				}
	}

	@Test
	public void Test03_validateMessageError() throws Exception {

		//verify for storecode
		driver.navigate().to("https://cmsuat.taptap.com.vn/stores/create");
		Thread.sleep(1000);
		objCreateStore.clickDropDown();
		objCreateStore.selectValueInDropDown();
		objCreateStore.setBrandStoreCode("CHANG_T1");
		objCreateStore.setStoreCode("STORE_CHANG");
		objCreateStore.setStoreDomain("http://changvietnam.vn/");
		objCreateStore.setStoreName("CHANG QUAN 1");
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[2]")).click();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{
		    WebDriverWait wait = new WebDriverWait(driver,20);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'This Store code is existed in the system. Please check!')]")));
		}catch(Exception e){
		    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
		}
		String actualMSStoreCode = driver.findElement(By.xpath("//span[contains(text(),'This Store code is existed in the system. Please check!')]")).getText();
		String expectedMSStoreCode = "This Store code is existed in the system. Please check!";
    	Assert.assertEquals(expectedMSStoreCode, actualMSStoreCode);
		
	}

	@Test
	public void Test04_CheckCancleButton() throws InterruptedException {
		   
		driver.navigate().to("https://cmsuat.taptap.com.vn/stores/create");
		Thread.sleep(1000);
		 // This step will result in an alert on screen
		 WebElement cancleDriver =  driver.findElement(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]"));
		
		   if(driver.findElements(By.xpath("//body/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]")).size() > 0)
		   {
			   cancleDriver.click();
		   }
		   String element = "/html/body/div/section/section/main/div/div/div/div/div/div/div/div/table";
		   if(isElementDisplayed(driver, element)){
		   System.out.println("Table is displayed");
		   } else{
		   System.out.println("Table isn't displayed");
		   }
}

	

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
