package Laba6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public final class Utils {

    public static WebDriver driver;

    private Utils() {
    }

    public static WebDriver instantiate() {
        System.setProperty("webdriver.chrome.driver", "C:\\users\\Dasha_zirochka\\matt\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pn.com.ua/ct/1003/");
        return driver;
    }
}