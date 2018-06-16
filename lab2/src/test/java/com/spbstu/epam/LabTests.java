package com.spbstu.epam;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LabTests {

    private SitePage page;
    private ChromeDriver driver;

    //Initialise driver
    @BeforeSuite
    public void BeforeSuite(){
        ChromeOptions options = new ChromeOptions();
        //Window - maximized
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        page=new SitePage(driver);
    }

    //Close driver
    @AfterSuite
    public void afterSuite(){
        driver.close();
    }

    //Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void websiteTest(){
        //1. Open test site by URL
        page.navigate(SiteData.url);

        //Test site is opened
        Assert.assertEquals(page.currentURL(), SiteData.url);


        //2. Assert Browser title
        Assert.assertEquals(page.currentBrowserTitle(), SiteData.title);

        //3. Perform login
        page.login(SiteData.login, SiteData.password);

        //User is loggined
        Assert.assertTrue(page.isLoggedIn());

        //4. Assert User name in the left-top side of screen that user is loggined
        Assert.assertEquals(page.userName(), SiteData.userName);

        //5. Assert Browser title
        Assert.assertEquals(page.currentBrowserTitle(), SiteData.title);

        //6. Assert that there are 4 images on the Home Page and they are displayed
        Assert.assertTrue(page.isImagesDisplayed());
        Assert.assertEquals(page.imagesCount(), SiteData.imagesCount);


        //7. Assert that there are 4 texts on the Home Page and check them by getting texts
        Assert.assertEquals(page.textsCount(), SiteData.textsCount);

        //8. Assert that there are the main header and the text below it on the Home Page
        Assert.assertTrue(page.isMainTextsDisplayed());
        Assert.assertTrue(page.isMainTitleDisplayed());
        Assert.assertTrue(page.mainTextText().contains(SiteData.textTitle));
        Assert.assertTrue(page.mainTitleText().contains(SiteData.textMain));
    }
}
