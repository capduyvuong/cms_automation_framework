package AppFunctions.ReferralChallenge;

import PageObject.ReferralChallenge.RefChallengesPageObjects;
import Utils.Constant;
import Utils.excelUtil_01;
import org.openqa.selenium.WebDriver;

import static PageObject.ReferralChallenge.RefChallengesPageObjects.*;

public class SearchReferralChallenge {
    public static void searchOpeningReferralChallenge(WebDriver driver) throws Exception{
//        searchChallengeName(driver).sendKeys(excelUtil_01.getCellData(1, 1));
        searchChallengeName(driver).sendKeys(Constant.refChallengeName);
        searchStateChallenge(driver).click();
        searchOpenChallenge(driver).click();
        refChallengeSearchButton(driver).click();
    }
}
