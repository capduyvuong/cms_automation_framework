package AppFunctions.ReferralChallenge;

import PageObject.ReferralChallenge.RefChallengesPageObjects;
import Utils.Constant;
import Utils.Utilities;
import Utils.excelUtil_01;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static AppFunctions.ReferralChallenge.SearchReferralChallenge.searchOpeningReferralChallenge;
import static PageObject.Image.ImagePageObjects.*;
import static PageObject.LeftMenu.LeftMenuObjects.layoutSiDer;
import static PageObject.ReferralChallenge.RefChallengesPageObjects.*;

public class CreateReferralChallengeWithDataDriven {

    public static void testCreateNewRefChallengeWithDataDriven(WebDriver driver) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // Click create new REF Challenge button
        RefChallengesPageObjects.createRefButton(driver).click();

        //Enter REF Challenge name
        String refChallengeName = excelUtil_01.getCellData(1, 1);
        wait.until(ExpectedConditions.visibilityOf(refChallengeName(driver)));
        refChallengeName(driver).sendKeys(refChallengeName);

        //Search and add Banner image
        refChallengeBannerImage(driver).click();
        searchImageTextBox(driver).sendKeys(Constant.bannerImageValue);
        searchImageButton(driver).click();
        actions.moveToElement(addImageButton(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", addImageButton(driver));

        //Search and add Intro image
        refChallengeIntroImage(driver).click();
        searchImageTextBox(driver).sendKeys(Constant.introImageValue);
        searchImageButton(driver).click();
        actions.moveToElement(addImageButton(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", addImageButton(driver));

        //Enter Intro Description (TBD)
//        introDescriptionBoldText(driver).click();
//        wait.until(ExpectedConditions.visibilityOf(refChallengeIntroDescription(driver)));
//        actions.moveToElement(refChallengeIntroDescription(driver));
//        actions.perform();
//        js.executeScript("arguments[0].click();", refChallengeIntroDescription(driver));
//        refChallengeIntroDescription(driver).sendKeys(Constant.refChallengeIntroDescription);

        //Set Referee's gift
        refGiftForRefereeCheckbox(driver).click();
        wait.until(ExpectedConditions.visibilityOf(refGiftForRefereeTotalPackage(driver)));
        String refGiftForRefereeTotalPackage = excelUtil_01.getCellData(1, 1);
        refGiftForRefereeTotalPackage(driver).sendKeys(refGiftForRefereeTotalPackage);
        refGiftAtPointForRefereeCheckbox(driver).click();
        String refGiftAtPointForRefereeTextBox = excelUtil_01.getCellData(3, 1);
        refGiftAtPointForRefereeTextBox(driver).sendKeys(refGiftAtPointForRefereeTextBox);
        refGiftAtVoucherForRefereeCheckbox(driver).click();
        String refQuantityGiftAtVoucherForReferee = excelUtil_01.getCellData(4, 1);
        refQuantityGiftAtVoucherForReferee(driver).sendKeys(refQuantityGiftAtVoucherForReferee);
        layoutSiDer(driver).click();

        //Search and add voucher image
        refImageOffGiftAtVoucherForReferee(driver).click();
        searchImageTextBox(driver).sendKeys(Constant.voucherImageValue);
        searchImageButton(driver).click();
        actions.moveToElement(addImageButton(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", addImageButton(driver));

        //Enter offer voucher id for Referee
        actions.moveToElement(refOfferIdOfGiftAtVoucherForReferee(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", refOfferIdOfGiftAtVoucherForReferee(driver));
        refOfferIdOfGiftAtVoucherForReferee(driver).sendKeys(excelUtil_01.getCellData(5, 1));
        Thread.sleep(3000);
        refOfferIdOfGiftAtVoucherForRefereeSecondNumber(driver).sendKeys(excelUtil_01.getCellData(6, 1));
        Thread.sleep(3000);
        refOfferIdOfGiftAtVoucherForRefereeThirdNumber(driver).sendKeys(excelUtil_01.getCellData(7, 1));
        Thread.sleep(3000);
        refOfferIdOfGiftAtVoucherForRefereeFourNumber(driver).sendKeys(excelUtil_01.getCellData(8, 1));
        Thread.sleep(3000);
        layoutSiDer(driver).click();

        //Set up Milestone for ref Challenge
        actions.moveToElement(refExpandMilestoneDetail(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", refExpandMilestoneDetail(driver));

        //Enter Milestone Name
        refMilestone1Name(driver).sendKeys(excelUtil_01.getCellData(9, 1));

        //Enter cover image URL
        refMileStone1CoverImageURL(driver).click();
        searchImageTextBox(driver).sendKeys(Constant.refMilestone1ImageName);
        searchImageButton(driver).click();
        actions.moveToElement(addImageButton(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", addImageButton(driver));
        //Select Cover image background
        refMileStone1CoverImageBackground(driver).click();

        //Set Milestone 1 Target
        refMileStone1NoOfInvitedFriend(driver).sendKeys(excelUtil_01.getCellData(10, 1));
        refMileStone1ContentOfInvitation(driver).sendKeys(excelUtil_01.getCellData(11, 1));
        refMileStone1RefereeTransactionsCheckbox(driver).click();
        refMileStone1NoOfRefereeTransactions(driver).sendKeys(excelUtil_01.getCellData(12, 1));
        refMileStone1ContentOfInvitation(driver).click();
        refMileStone1ContentOfRefereeTransactions(driver).sendKeys(excelUtil_01.getCellData(13, 1));

        //Set Referrer's Gift
        refMileStone1GiftForReferrerCheckbox(driver).click();
        refMileStone1TotalGiftPackageForReferrer(driver).sendKeys(excelUtil_01.getCellData(14, 1));
        refMileStone1GiftAtPointForReferrerCheckbox(driver).click();
        refMileStone1QuantityOfGiftAtPointForReferrer(driver).sendKeys(excelUtil_01.getCellData(15, 1));
        refMileStone1GiftAtVoucherForReferrerCheckbox(driver).click();
        refMileStone1QuantityGiftAtVoucherForReferrer(driver).sendKeys(excelUtil_01.getCellData(16, 1));
        layoutSiDer(driver).click();

        //Search and add voucher image
        refImageOffGiftAtVoucherForReferer(driver).click();
        searchImageTextBox(driver).sendKeys(Constant.voucherImageValue);
        searchImageButton(driver).click();
        actions.moveToElement(addImageButton(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", addImageButton(driver));

        //Enter offer voucher id for Referrer
        actions.moveToElement(refMileStone1OfferIdOfGiftAtVoucherForReferrer(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", refMileStone1OfferIdOfGiftAtVoucherForReferrer(driver));
        refMileStone1OfferIdOfGiftAtVoucherForReferrer(driver).sendKeys(excelUtil_01.getCellData(17, 1));
        Thread.sleep(3000);
        refMileStone1OfferIdOfGiftAtVoucherForReferrerSecondNumber(driver).sendKeys(excelUtil_01.getCellData(18, 1));
        Thread.sleep(3000);
        refMileStone1OfferIdOfGiftAtVoucherForReferrerThirdNumber(driver).sendKeys(excelUtil_01.getCellData(19, 1));
        Thread.sleep(3000);
        refMileStone1OfferIdOfGiftAtVoucherForReferrerFourNumber(driver).sendKeys(excelUtil_01.getCellData(20, 1));
        Thread.sleep(3000);
        layoutSiDer(driver).click();

        //Enter start date and end date of REF challenge
        actions.moveToElement(RefChallengesPageObjects.refChallengeStartDate(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", RefChallengesPageObjects.refChallengeStartDate(driver));
        refChallengeStartDate(driver).sendKeys(Utilities.startDateOfRefChallenge());
        refChallengeEndDate(driver).sendKeys(Utilities.endDateOfRefChallenge());
        refChallengeDatetimePickerNextMonth(driver).click();
//        refChallengeSelectedDayOfEndDate(driver).click();
        actions.moveToElement(refChallengeSubmitDate(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", refChallengeSubmitDate(driver));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //Submit creating REF Challenge
        actions.moveToElement(refChallengeCreateButton(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", refChallengeCreateButton(driver));

        //Wait for creating process is completed
        wait.until(ExpectedConditions.visibilityOf(searchChallengeName(driver)));

        //Verify created REF Challenge
        searchOpeningReferralChallenge(driver);
        String OpeningREFName = refChallengeSearchedOpeningREFName(driver).getText();
        Assert.assertTrue(OpeningREFName.contains(refChallengeName));
    }
}
