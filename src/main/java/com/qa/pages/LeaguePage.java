package com.qa.pages;

import com.qa.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * League screen on theScore mobile app
 **/
public class LeaguePage extends BaseClass {

    public AndroidDriver androidDriver;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Standings\"]")
    public static WebElement standingsTab;

    @FindBy(id = "titleTextView")
    public static WebElement leaguePageTitle;

    @FindBy(id = "txt_name")
    public static List<WebElement> aacHeader;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public static WebElement backArrow;

    public LeaguePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    /**
     * Method to verify League page header
     **/
    public String getLeaguePageTitle() {
        explicitWait(leaguePageTitle);
        return leaguePageTitle.getText();
    }

    /**
     * Method to click standing tab
     **/
    public void clickStandingsTab() {
        standingsTab.click();
    }

    /**
     * Method to verify standing tab
     **/
    public String verifyStandingsTab() {
        return aacHeader.get(0).getText();
    }

    /**
     * Method to verify back navigation
     **/
    public String verifyBackNavigation() {
        backArrow.click();
        return leaguePageTitle.getText();
    }
}
