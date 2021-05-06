package AppFunctions.ReferralChallenge;

import PageObject.ReferralChallenge.RefChallengesPageObjects;
import org.openqa.selenium.WebDriver;

import static PageObject.ReferralChallenge.RefChallengesPageObjects.*;

public class ViewListReferralChallenge {
    public static void testDisplayingOfTextBoxes(WebDriver driver) throws Exception{
        //textBox search with challenge name
        if (searchChallengeName(driver).isDisplayed()) {
            System.out.println("textBox search is displayed");
        } else {
            System.out.println("textBox search isn't displayed");
        }

        //textBox state
        if (searchStateChallenge(driver).isDisplayed()) {
            System.out.println("textBox state is displayed");
        } else {
            System.out.println("textBox state isn't displayed");
        }

        //textBox start date
        if (searchStartDate(driver).isDisplayed()) {
            System.out.println("textBox startDate is displayed");
        } else {
            System.out.println("textBox startDate isn't displayed");
        }

        //textBox end date
        if (searchEndDate(driver).isDisplayed()) {
            System.out.println("textBox endDate is displayed");
        } else {
            System.out.println("textBox endDate isn't displayed");
        }
    }
}
