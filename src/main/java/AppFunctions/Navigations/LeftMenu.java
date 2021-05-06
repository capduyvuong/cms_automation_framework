package AppFunctions.Navigations;

import PageObject.LeftMenu.LeftMenuObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObject.LeftMenu.LeftMenuObjects.*;

public class LeftMenu {
//    static WebDriver driver;
//    public static WebDriverWait wait = new WebDriverWait(driver, 10);
    public static void navigateToAvatars(WebDriver driver)throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Dashboard']")));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(avatarsFather(driver)));
            avatarsFather(driver).click();
//            avatarsSon(driver).click();
        }
        catch (Exception ex){
            System.out.println("Can not locate Avatars element(s), please check again.");
        }
    }

    public static void navigateToReferralChallenges(WebDriver driver)throws Exception {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Dashboard']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            wait.until(ExpectedConditions.visibilityOf(leftMenu(driver)));
            actions.moveToElement(referralChallenges(driver));
            actions.perform();
            js.executeScript("arguments[0].click();", referralChallenges(driver));
        }
        catch (Exception ex){
            System.out.println("Can not locate referral Challenges element(s), please check again.");
        }
    }

    public static void navigateToTools(WebDriver driver)throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Dashboard']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        try {
            wait.until(ExpectedConditions.elementToBeClickable(LeftMenuObjects.tools(driver)));
            LeftMenuObjects.tools(driver).click();
        }
        catch (Exception ex){
            System.out.println("Can not locate tools element(s), please check again.");
        }
    }
}
