package PageObject.StoreManagement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignTilPage {
	WebDriver driver; 
	By inputAvailableTill = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/input");
	By inputAssignedTill = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/input");
	//By buttonChooseAssign = By.xpath("//*[@data-icon='caret-right']");
//	By buttonChooseUnAssign = By.xpath("//*[@data-icon='caret-left']");
//	By buttonChooseAssignAll = By.xpath("//*[@data-icon='double-right']");
//	By buttonChooseUnAssignAll = By.xpath("//*[@data-icon='double-left']");
	
	@FindBy (xpath= "//*[@data-icon='caret-right']")
	public static  WebElement buttonChooseAssign;
	@FindBy (xpath= "//*[@data-icon='caret-left']")
	public static  WebElement buttonChooseUnAssign;
	@FindBy (xpath= "//*[@data-icon='double-right']")
	public static  WebElement buttonChooseAssignAll;
	@FindBy (xpath= "//*[@data-icon='double-right']")
	public static  WebElement buttonChooseUnAssignAll;
	@FindBy (xpath= "//button[@class='ant-btn ant-btn-primary']")
	public static  WebElement buttonOK;
	
	public AssignTilPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	public void setAvaiTill (String strAvaiTill) {
		
	driver.findElement(inputAvailableTill).sendKeys(strAvaiTill);
	}
	public void setAssignTill (String strAssignTill) {
		
		driver.findElement(inputAssignedTill).sendKeys(strAssignTill);
		}

	public void clickChooseAssignTill () {
		buttonChooseAssign.click();
	}
	public void clickOK () {
		buttonOK.click();
	}
	public void clickChooseUnAssignTill () {
		buttonChooseUnAssign.click();
	}
	public void clickChooseAssignAll () {
		buttonChooseAssignAll.click();
	}
	public void clickChooseUnAssignAll () {
		buttonChooseUnAssignAll.click();
	}
	public void searchAvaiTillByEnter () {
		driver.findElement(inputAvailableTill).sendKeys(Keys.ENTER);
	}
	public void searchAssignTillByEnter () {
		driver.findElement(inputAssignedTill).sendKeys(Keys.ENTER);
	}
	public void searchByAvailableTill (String strAvaiTill)
	{
		this.setAvaiTill(strAvaiTill);
		this.searchAvaiTillByEnter();
	}
	public void searchByAssignedTill (String strAssignedTill)
	{
		this.setAvaiTill(strAssignedTill);
		this.searchAssignTillByEnter();
	}
	public void selectTillInListAvai() {
		
		List<WebElement> itemsInListAvai = driver.findElements(By.xpath("//li[@class='py-3 pl-3 cursor-pointer']"));
		// Get the size of dropdown list
		int size = itemsInListAvai.size();
		// Generate the random number
		int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
		// Clicking on random value
		 itemsInListAvai.get(randomNumber).click();
		 itemsInListAvai.toString();
	}
	
	
}
