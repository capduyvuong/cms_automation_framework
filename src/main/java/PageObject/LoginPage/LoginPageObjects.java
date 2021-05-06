package PageObject.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

    static WebElement element = null;

    public static WebElement userName(WebDriver driver){
        element = driver.findElement(By.id("username"));
        return element;
    }

    public static WebElement password(WebDriver driver){
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement loginButton(WebDriver driver){
        element = driver.findElement(By.id("kc-login"));
        return element;
    }
}
