package com.simbir.words.ui.base;


import com.simbir.words.cons.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.simbir.words.cons.Cons.urlMain;


public class BaseCase {

    public static WebDriver driver;

    @BeforeSuite
    public void openURL() {

        driver = Utils.getWebDriver(Utils.Browser.CHROME);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver.manage().window().maximize();
        long min = 5;
        driver.manage().timeouts().pageLoadTimeout(min, TimeUnit.MINUTES);
        driver.navigate().to(urlMain);
    }

    @AfterSuite()
    public void closeBrowser() {

        driver.close();
        driver.quit();
    }

}