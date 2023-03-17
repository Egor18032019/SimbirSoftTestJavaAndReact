package com.simbir.words.request;

import com.simbir.words.cons.Cons;
import com.simbir.words.cons.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AbstractWebBaseCase {
    public static WebDriver driver;
//    public static WebDriverWait wait;

    @BeforeSuite
    public void openURL() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = Utils.getWebDriver(Utils.Browser.CHROME);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver.manage().window().maximize();
        //Задержка выполнения теста
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(22));
        driver.manage().timeouts().pageLoadTimeout(22, TimeUnit.SECONDS);
        driver.navigate().to(Cons.urlMain);
    }

    @AfterSuite()
    public void closeBrowser() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + ".jpg"));
//                    "-"+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }
}
