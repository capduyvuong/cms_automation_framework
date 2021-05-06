package PageObject.ReferralChallenge;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RefChallengesPageObjects {

//	@FindBy (xpath= "//*[@id=\"keyword\"]")
//	public static  WebElement searchChallengeName;

//	@FindBy (xpath= "//*[@id=\"createdAtAfter\"]")
//	public static  WebElement searchStartDate;
//
//	@FindBy (xpath= "//*[@id=\"createdAtBefore\"]")
//	public static  WebElement searchEndDate;
//
//	@FindBy (xpath= "/html/body/div[4]/div/div/div/div/div[2]/ul/li[2]/button")
//	public static  WebElement oKInDateRange;
//
//	@FindBy (xpath= "//button//span[text()='Search']")
//	public static  WebElement buttonSearch;
//
//	@FindBy (xpath= "//button//span[text()='Create']")
//	public static  WebElement buttonCreate;
//
//	@FindBy (xpath= "//button[@title='View']")
//	public static  WebElement buttonViewChallenge;
//
//	@FindBy (xpath= "//button[@title='Publish']")
//	public static  WebElement buttonPublishChallenge;
//
//
//	@FindBy (xpath= "//button[@title='Unpublish']")
//	public static  WebElement buttonUnpublishChallenge;
//
//	@FindBy (xpath= "//button[@title='Edit']")
//	public static  WebElement buttonEditChallenge;
//
//	@FindBy (xpath= "//button[@title='Delete']")
//	public static  WebElement buttonDeleteChallenge;
//
//	@FindBy (xpath= "/html/body/div/section/section/main/div/div/div/div[3]/div/div[2]/a")
//	public static WebElement buttonColap;

	static WebElement element = null;

	public static WebElement searchChallengeName(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='keyword']"));
		return element;
	}

	public static WebElement searchStateChallenge(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-select-selector']"));
		return element;
	}

	public static WebElement searchOpenChallenge(WebDriver driver){
		element = driver.findElement(By.xpath("//div[contains(text(), 'Open')]"));
		return element;
	}

	public static WebElement searchStartDate(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='createdAtAfter']"));
		return element;
	}

	public static WebElement searchEndDate(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='createdAtBefore']"));
		return element;
	}

	public static WebElement createRefButton(WebDriver driver){
		element = driver.findElement(By.xpath("//button//span[text()='Create']"));
		return element;
	}

	public static WebElement refChallengeName(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@id='name']"));
		return element;
	}

	public static WebElement refChallengeBannerImage(WebDriver driver){
		element = driver.findElement(By.xpath("(//span[@title='Choose image'])[1]"));
		return element;
	}

	public static WebElement refChallengeIntroImage(WebDriver driver){
		element = driver.findElement(By.xpath("(//span[@title='Choose image'])[2]"));
		return element;
	}

	public static WebElement introDescriptionBoldText(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@aria-label='Bold'][1]"));
		return element;
	}

	public static WebElement refChallengeIntroDescription(WebDriver driver){
		element = driver.findElement(By.xpath("TBD"));
		return element;
	}

	public static WebElement termAndConditionUnderlineText(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@aria-label='Underline'][1]"));
		return element;
	}

	public static WebElement refChallengeTermAndCondition(WebDriver driver){
		element = driver.findElement(By.xpath("TBD"));
		return element;
	}

	public static WebElement refChallengeRefCodeGuidance(WebDriver driver){
		element = driver.findElement(By.xpath("TBD"));
		return element;
	}

	public static WebElement refChallengeRefCodeSuggestion(WebDriver driver){
		element = driver.findElement(By.xpath("TBD"));
		return element;
	}

	public static WebElement refChallengeStartDate(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@placeholder='Start Date']"));
		return element;
	}

	public static WebElement refChallengeEndDate(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@placeholder='End Date']"));
		return element;
	}

	public static WebElement refChallengeDatetimePickerNextMonth(WebDriver driver){
		element = driver.findElement(By.xpath("//span[@class='ant-picker-next-icon']"));
		return element;
	}

	public static WebElement refChallengeSelectedDayOfEndDate(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-picker-cell-inner']"));
		return element;
	}

	public static WebElement refChallengeSubmitDate(WebDriver driver){
		element = driver.findElement(By.xpath("//span[contains(text(), 'Ok')]"));
		return element;
	}

	public static WebElement refGiftForRefereeCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-4']//input[@type='checkbox']"));
		return element;
	}

	public static WebElement refGiftForRefereeTotalPackage(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@type='number'][@class='ant-input']"));
		return element;
	}

	public static WebElement refGiftAtPointForRefereeCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-8']//input[@type='checkbox']"));
		return element;
	}

	public static WebElement refGiftAtPointForRefereeTextBox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-16']//input[@value='0']"));
		return element;
	}

	public static WebElement refGiftAtVoucherForRefereeCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-8']//span[@class='ant-checkbox']"));
		return element;
	}

	public static WebElement refQuantityGiftAtVoucherForReferee(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@min='0']"));
		return element;
	}

	public static WebElement refOfferIdOfGiftAtVoucherForReferee(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text']"));
		return element;
	}

	public static WebElement refOfferIdOfGiftAtVoucherForRefereeSecondNumber(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text'][@value='3']"));
		return element;
	}

	public static WebElement refOfferIdOfGiftAtVoucherForRefereeThirdNumber(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text'][@value='32']"));
		return element;
	}

	public static WebElement refOfferIdOfGiftAtVoucherForRefereeFourNumber(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text'][@value='329']"));
		return element;
	}

	public static WebElement refImageOffGiftAtVoucherForReferee(WebDriver driver){
		element = driver.findElement(By.xpath("(//span[@title='Choose image'])[3]"));
		return element;
	}

	public static WebElement refExpandMilestoneDetail(WebDriver driver){
		element = driver.findElement(By.xpath("//span[@class='anticon anticon-caret-down']"));
		return element;
	}

	public static WebElement refMilestone1Name(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-row mb-3']//div[@class='ant-col ant-col-20']//input[@maxlength='20']"));
		return element;
	}

	public static WebElement refMileStone1CoverImageURL(WebDriver driver){
		element = driver.findElement(By.xpath("(//span[@title='Choose image'])[4]"));
		return element;
	}

	public static WebElement refMileStone1CoverImageBackground(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@title='#FF6900']"));
		return element;
	}

	public static WebElement refMileStone1NoOfInvitedFriend(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-20']//input[@min='0']"));
		return element;
	}

	public static WebElement refMileStone1ContentOfInvitation(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-15 ml-4']//input[@class='ant-input']"));
		return element;
	}

	public static WebElement refMileStone1RefereeTransactionsCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-4']//span[@class='ant-checkbox']//input[@class='ant-checkbox-input']"));
		return element;
	}

	public static WebElement refMileStone1NoOfRefereeTransactions(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-row mb-3']//div[@class='ant-col ant-col-4']//input[@value='0']"));
		return element;
	}

	public static WebElement refMileStone1ContentOfRefereeTransactions(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-15 ml-4']//input[@value!='Please invite 1 friend']"));
		return element;
	}

	public static WebElement refMileStone1GiftForReferrerCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-4']//span[@class='ant-checkbox']"));
		return element;
	}

	public static WebElement refMileStone1TotalGiftPackageForReferrer(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-16']//input[@value='0']"));
		return element;
	}

	public static WebElement refMileStone1GiftAtPointForReferrerCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-8']//span[@class='ant-checkbox']"));
		return element;
	}

	public static WebElement refMileStone1QuantityOfGiftAtPointForReferrer(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-16']//input[@value='0']"));
		return element;
	}

	public static WebElement refMileStone1GiftAtVoucherForReferrerCheckbox(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-8']//span[@class='ant-checkbox']"));
		return element;
	}

	public static WebElement refMileStone1QuantityGiftAtVoucherForReferrer(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@value='0']"));
		return element;
	}

	public static WebElement refMileStone1OfferIdOfGiftAtVoucherForReferrer(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@class='ant-input'][@type='text'][@value!='3292']"));
		return element;
	}


	public static WebElement refMileStone1OfferIdOfGiftAtVoucherForReferrerSecondNumber(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text'][@value='3']"));
		return element;
	}

	public static WebElement refMileStone1OfferIdOfGiftAtVoucherForReferrerThirdNumber(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text'][@value='32']"));
		return element;
	}

	public static WebElement refMileStone1OfferIdOfGiftAtVoucherForReferrerFourNumber(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-col ant-col-6 pr-3']//input[@type='text'][@value='329']"));
		return element;
	}


	public static WebElement refImageOffGiftAtVoucherForReferer(WebDriver driver){
		element = driver.findElement(By.xpath("(//span[@title='Choose image'])[5]"));
		return element;
	}

	public static WebElement refChallengeCreateButton(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Create')]"));
		return element;
	}

	public static WebElement refChallengeSearchButton(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(), 'Search')]"));
		return element;
	}

	public static WebElement refChallengeSearchedOpeningREFName(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@class='ant-card-body']//strong[contains(text(), '')]"));
		return element;
	}


	//	public RefListingPageObjects(WebDriver driver) {
//		this.driver = driver ;
//	}
	
	//set searchchallengename
//	public void inputChallengeName (String challengeName) {
//	searchChallengeName.sendKeys(challengeName);
//	}
	//set searchstatechallenge
//	public void selectStoreCode () {
//
//		List<WebElement> itemsInDropdown = driver.findElements(By.xpath("//div[@class='ant-select-selector']"));
//		// Get the size of dropdown list
//		int size = itemsInDropdown.size();
//		// Generate the random number
//		int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
//		// Clicking on random value
//		itemsInDropdown.get(randomNumber).click();
//	}
			
//	public void clickCreate () {
//		buttonCreate.click();
//	}
//	public void clickSearch () {
//		buttonSearch.click();
//	}
//	public void clickEdit () {
//		buttonEditChallenge.click();
//	}
//	public void clickPublish() {
//		buttonPublishChallenge.click();
//	}
//	public void clickUnpublish() {
//		buttonUnpublishChallenge.click();
//	}
//	public void searchByChallengeName (String strchallengeName)
//	{
//		this.inputChallengeName(strchallengeName);
//		this.clickSearch();
//	}
}
