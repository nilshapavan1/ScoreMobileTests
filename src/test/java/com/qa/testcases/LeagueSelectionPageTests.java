package com.qa.testcases;

import com.qa.base.BaseClass;
import com.qa.pages.LeaguePage;
import com.qa.pages.LeagueSelectionPage;
import com.qa.pages.SignInPage;
import com.qa.pages.WelcomePage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class LeagueSelectionPageTests extends BaseClass {

    private static final Logger logger = LogManager.getLogger(LeagueSelectionPageTests.class);

    public AndroidDriver androidDriver;
    WelcomePage welcomePage;

    SignInPage signInPage;

    LeagueSelectionPage leagueSelectionPage;

    LeaguePage leaguePage;

    @BeforeMethod
    public void initialize() {
        androidDriver = initializeDriver();
        welcomePage = new WelcomePage(androidDriver);
        signInPage = new SignInPage(androidDriver);
        leagueSelectionPage = new LeagueSelectionPage(androidDriver);
        leaguePage = new LeaguePage(androidDriver);
    }

    @Test(description = "verify league, standing tab and back navigation")
    @Parameters({"LeagueSelectionPageTitle", "LeagueTitle", "StandingHeader"})
    public void verifyLeague(String LeagueSelectionPageTitle, String LeagueTitle, String StandingHeader) throws InterruptedException {
        welcomePage.clickSigninLink();


        signInPage.signIn(prop.getProperty("email"), prop.getProperty("password"));
        logger.debug("SignIn completed");

        signInPage.clickLeagueTab();


        Assert.assertEquals(leagueSelectionPage.getTitle(), LeagueSelectionPageTitle, "Not in League Selection page");
        logger.info("Verified league selection page");

        leagueSelectionPage.selectLeague();


        Assert.assertEquals(leaguePage.getLeaguePageTitle(), LeagueTitle, "League page title not matched");
        logger.info("Verified league page");

        leaguePage.clickStandingsTab();

        Assert.assertEquals(leaguePage.verifyStandingsTab(), StandingHeader, "Not under standing tab");
        logger.info("Verified League page standing tab");

        Assert.assertEquals(leaguePage.verifyBackNavigation(), LeagueSelectionPageTitle, "Back navigation failed!");
        logger.info("Clicked on back arrow");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("tear down method");
        this.androidDriver.quit();
    }
}
