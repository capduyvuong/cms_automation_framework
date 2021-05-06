package PageObject.StoreManagement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import freemarker.cache.StrongCacheStorage;

public class CreateStorePage {
	WebDriver driver;
	By dropdown = By.xpath("//span[@class='ant-select-selection-item']");
	By valueOnDropDown = By.xpath("//*[contains(text(),'JUMP ARENA') and @class='ant-select-item-option-content']");
//	By brandStoreCode = By.xpath("//input[@placeholder=\"Brand Store Code\"]");
//	By storeCode = By.xpath("//input[@placeholder=\"Store Code\"]");
//	By storeDomain = By.xpath("//input[@placeholder=\"Store Domain\"]");
//	By storeName = By.xpath("//input[@placeholder=\"Store Name\"]");
//	By storeAddress = By.xpath("//input[@placeholder=\"Address\"]");
//	By storeProvince = By.xpath("//input[@placeholder=\"province\"]");
//	By storeDistrict = By.xpath("//input[@placeholder=\"district\"]");
//	By storeLatitude = By.xpath("//input[@placeholder='Latitude']");
//	By storeLongitude = By.xpath("//input[@placeholder=\"Longitude\"]");
	By buttonCreateForm = By.xpath("//button[@type='button' and @class ='ant-btn ant-btn-primary']");
	@FindBy (xpath= "//input[@placeholder='Store Code']")
	public static  WebElement inputStoreCode;
	
	@FindBy (xpath= "//input[@placeholder='Brand Store Code']")
	public static  WebElement inputBrandStoreCode;
	
	@FindBy (xpath= "//input[@placeholder='Store Domain']")
	public static  WebElement inputStoreDomain;
	
	@FindBy (xpath= "//input[@placeholder='Store Name']")
	public static  WebElement inputStoreName;
	
	@FindBy (xpath= "//input[@placeholder='Address']")
	public static  WebElement inputStoreAddress;
	
	@FindBy (xpath= "//input[@placeholder='province']")
	public static  WebElement inputStoreProvince;
	
	@FindBy (xpath= "//input[@placeholder='district']")
	public static  WebElement inputStoreDistrict;
	
	@FindBy (xpath= "//input[@placeholder='Latitude']")
	public static  WebElement inputStoreLatitude;
	
	@FindBy (xpath= "//input[@placeholder='Longitude']")
	public static  WebElement inputStoreLongitude;
	
	
	public CreateStorePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setBrandStoreCode(String strbrandStoreCode) {

		this.inputBrandStoreCode.sendKeys(strbrandStoreCode);
	}
	public void setStoreCode(String strStoreCode) {

		inputStoreCode.sendKeys(strStoreCode);
	}
	public void setStoreode(String strstoreCode) {

		inputStoreCode.sendKeys(strstoreCode);

	}

	public void setStoreDomain(String strstoreDomain) {

		inputStoreDomain.sendKeys(strstoreDomain);

	}

	public void setStoreName(String strstoreName) {

		inputStoreName.sendKeys(strstoreName);

	}

	public void setStoreProvince(String strstoreProvince) {

		inputStoreProvince.sendKeys(strstoreProvince);

	}

	public void setStoreDistrict(String strstoreDistrict) {

		inputStoreDistrict.sendKeys(strstoreDistrict);

	}

	public void setStoreAddress(String strstoreAddress) {

		inputStoreAddress.sendKeys(strstoreAddress);

	}
	public void setStoreLatitude(String strstoreLatitude) {

		inputStoreLatitude.sendKeys(strstoreLatitude);

	}
	public void setStoreLongitude(String strstoreLongitude) {

		inputStoreLongitude.sendKeys(strstoreLongitude);

	}

	public void clickCreateInForm() {
		driver.findElement(buttonCreateForm).click();
	}
	public void clickDropDown() {
		driver.findElement(dropdown).click();
	}
	public void selectValueInDropDown() {
		
		List<WebElement> itemsInDropdown = driver.findElements(By.xpath("//div[@class='ant-select-item ant-select-item-option']"));
		// Get the size of dropdown list
		int size = itemsInDropdown.size();
		// Generate the random number
		int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
		// Clicking on random value
		itemsInDropdown.get(randomNumber).click();
		
	}


}
