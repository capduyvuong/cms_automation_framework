package PageObject.Image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImagePageObjects {
    static WebElement element = null;

    public static WebElement searchImageTextBox (WebDriver driver){
        element = driver.findElement(By.id("search"));
        return element;
    }

    public static WebElement searchImageButton (WebDriver driver){
        element = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(), 'Search')]"));
        return element;
    }

    public static WebElement addImageButton (WebDriver driver){
        element = driver.findElement(By.xpath("//button[@type='button'][@class='ant-btn ant-btn-sm']"));
        return element;
    }
}
