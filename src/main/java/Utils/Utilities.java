package Utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {
    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
    static Calendar date = Calendar.getInstance();
    public static long currentTime = date.getTimeInMillis();

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String startDateOfRefChallenge(){
        Date startDateOfRefChallenge = new Date(currentTime + (2 * ONE_MINUTE_IN_MILLIS));
        return formatter.format(startDateOfRefChallenge);
    }

    public static String endDateOfRefChallenge(){
        Date endDateOfRefChallenge = new Date(currentTime + (1440 * ONE_MINUTE_IN_MILLIS));
        return formatter.format(endDateOfRefChallenge);
    }

    public static void checkAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }

    public static String randomREFChallengeName(){
        int min = 69;
        int max = 96;
        String randomREFChallengeName = "Referral Challenge " + (int)Math.floor(Math.random()*(max-min+1)+min);
        return randomREFChallengeName;
    }
}
