package com.simbir.words.ui.pages;

import com.simbir.words.ui.pages.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//html/body/div[1]/div/main/div/div/a/h2")
    WebElement link;

    public void clickOnRealizationLink() {
        PageBase.clickButton(link);
    }
}
