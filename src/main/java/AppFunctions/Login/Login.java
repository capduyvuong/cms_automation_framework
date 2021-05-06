package AppFunctions.Login;

import PageObject.LoginPage.LoginPageObjects;
import Utils.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObject.LoginPage.LoginPageObjects.*;

public class Login {
    public static void Execute(WebDriver driver) throws Exception {
        if (userName(driver).isDisplayed()) {
            // enter field User name
            userName(driver).sendKeys(Constant.userName);
            // enter password
            password(driver).sendKeys(Constant.password_Staging);
            // click on login button
            loginButton(driver).click();
        }
        else {
            System.out.println("Can not locate element(s), please check again.");
        }

    }
}
