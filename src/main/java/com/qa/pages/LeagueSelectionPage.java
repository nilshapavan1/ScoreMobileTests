package com.qa.pages;

import com.qa.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * League selection screen on theScore mobile app
 **/
public class LeagueSelectionPage extends BaseClass {

    private static final Logger logger = LogManager.getLogger(LeagueSelectionPage.class);

    public AndroidDriver androidDriver;

    public LeagueSelectionPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(id = "titleTextView")
    public static WebElement pageTitle;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'NCAA Football')]")
    public static WebElement leagueSelect;

    /**
     * click on a league
     **/
    public void selectLeague() {
        explicitWait(leagueSelect);
        leagueSelect.click();
        logger.info("clicked on the league");
    }

    /**
     * Method to get title of the league
     **/
    public String getTitle() {
        logger.info("get title of the league");
        return pageTitle.getText();
    }
}
