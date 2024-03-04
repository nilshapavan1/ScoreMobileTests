package com.qa.pages;

import com.qa.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Welcome page for theScore MobileApp
 **/
public class WelcomePage extends BaseClass {

    public AndroidDriver androidDriver;

    public WelcomePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(id = "txt_sign_in")
    public static WebElement signInLink;


    /**
     * click on the sign-in link on the mobile app landing page.
     * signInLink is clickable only on the right side. Added logic to click on the right end of the link/text.
     **/
    public void clickSigninLink() {
        int width = signInLink.getSize().getWidth();
        Actions actions = new Actions(androidDriver);
        actions.moveToElement(signInLink).moveByOffset((width / 2) - 2, 0).click().perform();
    }
}
