package PageObject.StoreManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewStorePage {
	WebDriver driver; 
	By searchByBrandName = By.xpath("//input[@id='brandName']");
	By searchByStoreCode = By.xpath("//input[@id='storeCode']") ;
	By searchByStoreTill = By.xpath("//input[@id='storeTill']");
	By buttonCreate = By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[4]/button[2]");
	By buttonSearch = By.xpath("//button[@type=\"submit\"]");
	By buttonDisable = By.xpath("//button[@title='Disable']");
	By buttonEdit = By.xpath("//button[@title='Edit']");
	
	@FindBy (xpath= "//input[@placeholder='Store Code']")
	public static  WebElement inputStoreCode;
	public ViewStorePage(WebDriver driver) {
		this.driver = driver ;
	}
	
	//set searchbrandname input
	public void setBrandName (String trbrandName) {
		
	driver.findElement(searchByBrandName).sendKeys(trbrandName);
	}
	//set searchstorecode input
		public void setStoreCode (String trstoreCode) {
		
		driver.findElement(searchByStoreCode).sendKeys(trstoreCode);
	
	}
		//set searchstorecode input
				public void setStoreTill (String trstoreTill) {
				
				driver.findElement(searchByStoreTill).sendKeys(trstoreTill);
			
			}
	public void clickCreate () {
		driver.findElement(buttonCreate).click();
	}
	public void clickSearch () {
		driver.findElement(buttonSearch).click();
	}
	public void clickEdit () {
		driver.findElement(buttonEdit).click();
	}
	public void clickDisable() {
		driver.findElement(buttonDisable).click();
	}
	public void searchByBrandName (String strBrandName)
	{
		this.setBrandName(strBrandName);
		this.clickSearch();
	}
	public void searchByStoreCode (String strStoreCode)
	{
		this.setStoreCode(strStoreCode);
		this.clickSearch();
	}
}
