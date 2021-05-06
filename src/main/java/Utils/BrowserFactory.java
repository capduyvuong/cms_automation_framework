package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    static WebDriver driver;

    public static void startBrowser(String browserName) throws Exception
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(Constant.cms_Url);
        }
        if(browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to(Constant.cms_Url);
        }
    }
}
