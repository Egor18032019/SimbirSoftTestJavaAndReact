package com.simbir.words.ui.base;

import com.simbir.words.cons.Cons;
import com.simbir.words.ui.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.simbir.words.ui.base.BaseCase.driver;

public class TestFistCase {
    MainPage mainPage;

    @Test(priority = 1, alwaysRun = true)
    public void userCanMoveOnRealizationLink() {
        mainPage = new MainPage(driver);
        mainPage.clickOnRealizationLink();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, Cons.realization);
    }
}
