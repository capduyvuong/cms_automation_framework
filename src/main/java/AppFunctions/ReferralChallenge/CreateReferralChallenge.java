package AppFunctions.ReferralChallenge;

import PageObject.ReferralChallenge.RefChallengesPageObjects;
import Utils.Constant;
import Utils.Utilities;
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

public class CreateReferralChallenge {

    public static void testCreateNewRefChallenge(WebDriver driver) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // Click create new REF Challenge button
        RefChallengesPageObjects.createRefButton(driver).click();

        //Enter REF Challenge name
        wait.until(ExpectedConditions.visibilityOf(refChallengeName(driver)));
        refChallengeName(driver).sendKeys(Constant.refChallengeName);

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
        refGiftForRefereeTotalPackage(driver).sendKeys(Constant.refGiftForRefereeTotalPackage);
        refGiftAtPointForRefereeCheckbox(driver).click();
        refGiftAtPointForRefereeTextBox(driver).sendKeys(Constant.refGiftAtPointForReferee);
        refGiftAtVoucherForRefereeCheckbox(driver).click();
        refQuantityGiftAtVoucherForReferee(driver).sendKeys(Constant.refQuantityGiftAtVoucherForReferee);
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
        refOfferIdOfGiftAtVoucherForReferee(driver).sendKeys(Constant.refOfferIdOfGiftAtVoucherForRefereeFirstNumber);
        Thread.sleep(3000);
        refOfferIdOfGiftAtVoucherForRefereeSecondNumber(driver).sendKeys(Constant.refOfferIdOfGiftAtVoucherForRefereeSecondNumber);
        Thread.sleep(3000);
        refOfferIdOfGiftAtVoucherForRefereeThirdNumber(driver).sendKeys(Constant.refOfferIdOfGiftAtVoucherForRefereeThirdNumber);
        Thread.sleep(3000);
        refOfferIdOfGiftAtVoucherForRefereeFourNumber(driver).sendKeys(Constant.refOfferIdOfGiftAtVoucherForRefereeFourthNumber);
        Thread.sleep(3000);
        layoutSiDer(driver).click();

        //Set up Milestone for ref Challenge
        actions.moveToElement(refExpandMilestoneDetail(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", refExpandMilestoneDetail(driver));

        //Enter Milestone Name
        refMilestone1Name(driver).sendKeys(Constant.refMilestone1Name);

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
        refMileStone1NoOfInvitedFriend(driver).sendKeys(Constant.refMileStone1NoOfInvitedFriend);
        refMileStone1ContentOfInvitation(driver).sendKeys(Constant.refMileStone1ContentOfInvitation);
        refMileStone1RefereeTransactionsCheckbox(driver).click();
        refMileStone1NoOfRefereeTransactions(driver).sendKeys(Constant.refMileStone1NoOfRefereeTransactions);
        refMileStone1ContentOfInvitation(driver).click();
        refMileStone1ContentOfRefereeTransactions(driver).sendKeys(Constant.refMileStone1ContentOfRefereeTransactions);

        //Set Referrer's Gift
        refMileStone1GiftForReferrerCheckbox(driver).click();
        refMileStone1TotalGiftPackageForReferrer(driver).sendKeys(Constant.refMileStone1TotalGiftPackageForReferrer);
        refMileStone1GiftAtPointForReferrerCheckbox(driver).click();
        refMileStone1QuantityOfGiftAtPointForReferrer(driver).sendKeys(Constant.refMileStone1QuantityOfGiftAtPointForReferrer);
        refMileStone1GiftAtVoucherForReferrerCheckbox(driver).click();
        refMileStone1QuantityGiftAtVoucherForReferrer(driver).sendKeys(Constant.refMileStone1QuantityGiftAtVoucherForReferrer);
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
        refMileStone1OfferIdOfGiftAtVoucherForReferrer(driver).sendKeys(Constant.refMileStone1OfferIdOfGiftAtVoucherForReferrerFirstNumber);
        Thread.sleep(3000);
        refMileStone1OfferIdOfGiftAtVoucherForReferrerSecondNumber(driver).sendKeys(Constant.refMileStone1OfferIdOfGiftAtVoucherForReferrerSecondNumber);
        Thread.sleep(3000);
        refMileStone1OfferIdOfGiftAtVoucherForReferrerThirdNumber(driver).sendKeys(Constant.refMileStone1OfferIdOfGiftAtVoucherForReferrerThirdNumber);
        Thread.sleep(3000);
        refMileStone1OfferIdOfGiftAtVoucherForReferrerFourNumber(driver).sendKeys(Constant.refMileStone1OfferIdOfGiftAtVoucherForReferrerFourthNumber);
        Thread.sleep(3000);
        layoutSiDer(driver).click();

        //Duplicate Milestone 

        //Enter start date and end date of REF challenge
        actions.moveToElement(RefChallengesPageObjects.refChallengeStartDate(driver));
        actions.perform();
        js.executeScript("arguments[0].click();", RefChallengesPageObjects.refChallengeStartDate(driver));
        refChallengeStartDate(driver).sendKeys(Utilities.startDateOfRefChallenge());
        refChallengeEndDate(driver).sendKeys(Utilities.endDateOfRefChallenge());
        refChallengeDatetimePickerNextMonth(driver).click();
        refChallengeSelectedDayOfEndDate(driver).click();
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
        Assert.assertTrue(OpeningREFName.contains(Constant.refChallengeName));
    }
}
