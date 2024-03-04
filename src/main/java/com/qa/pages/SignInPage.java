package com.qa.pages;

import com.qa.base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sign In page of theScore Mobile app
 **/
public class SignInPage extends BaseClass {

    private static final Logger logger = LogManager.getLogger(SignInPage.class);

    public AndroidDriver androidDriver;
    WelcomePage welcomePage;

    public SignInPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        welcomePage = new WelcomePage(androidDriver);
    }

    @FindBy(id = "email_input_edittext")
    public static WebElement emailId;

    @FindBy(id = "password_input_edittext")
    public static WebElement passWord;

    @FindBy(id = "login_button")
    public static WebElement login;

    @FindBy(id = "dismiss_modal")
    public static WebElement popUp;

    @FindBy(id = "btn_disallow")
    WebElement disablePopUp;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Leagues']/android.widget.FrameLayout/android.widget.ImageView")
    public static WebElement leaguesMenuTab;

    public boolean isPopUpPresent() {
        try {
            popUp.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * enter user credentials and sign-in
     **/
    public void signIn(String username, String password) throws InterruptedException {
        emailId.sendKeys(username);
        passWord.sendKeys(password);

        explicitWait(login);
        login.click();

        explicitWait(popUp);
        if (isPopUpPresent()) {
            popUp.click();
        } else {
            logger.info("Pop up not found");
        }
        explicitWait(disablePopUp);
        disablePopUp.click();
    }

    /**
     * click on League Tab
     **/
    public void clickLeagueTab() {
        leaguesMenuTab.click();
    }
}
