package PageObject.LeftMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeftMenuObjects {
    static WebElement element = null;

    public static WebElement layoutSiDer(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@class='ant-layout-sider-children']"));
        return element;
    }

    public static WebElement leftMenu(WebDriver driver){
        element = driver.findElement(By.className("ant-layout-sider-children"));
        return element;
    }

    public static WebElement avatarsFather(WebDriver driver){
        element = driver.findElement(By.xpath("//span[contains(text(),'Avatars')]"));
        return element;
    }

    public static WebElement avatarsSon(WebDriver driver){
        element = driver.findElement(By.xpath("//a[@title='Avatars']"));
        return element;
    }

    public static WebElement referralChallenges(WebDriver driver){
        element = driver.findElement(By.xpath("//a[@href='/referral-challenges']"));
        return element;
    }

    public static WebElement tools(WebDriver driver){
        element = driver.findElement(By.xpath("//span[contains(text(),'Tools')]"));
        return element;
    }

}
