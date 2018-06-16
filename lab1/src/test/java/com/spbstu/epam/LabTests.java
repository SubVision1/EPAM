package com.spbstu.epam;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class LabTests {

    private ChromeDriver driver;

    //Initialise driver
    @BeforeSuite
    public void BeforeSuite(){
        ChromeOptions options = new ChromeOptions();
        //Window - maximized
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
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
        String url="https://jdi-framework.github.io/tests";
        driver.navigate().to(url);

        //Test site is opened
        Assert.assertTrue(driver.getCurrentUrl().contains(url), url);


        //2. Assert Browser title
        String title="Index Page";
        Assert.assertEquals(driver.getTitle(), title);

        //3. Perform login
        String login="epam";
        String password="1234";
        driver.findElementByCssSelector(".profile-photo").click();
        driver.findElementByCssSelector("#Login").sendKeys(login);
        driver.findElementByCssSelector("#Password").sendKeys(password);
        driver.findElementByCssSelector("form .btn-login").click();

        //User is loggined
        Assert.assertTrue(driver.findElementByCssSelector(".logout").isDisplayed());

        //4. Assert User name in the left-top side of screen that user is loggined
        String userName=" PITER CHAILOVSKII";
        Assert.assertEquals(driver.findElementByCssSelector(".profile-photo").
                findElements(By.cssSelector(".hidden")).size(), 0);
        Assert.assertEquals(driver.findElementByCssSelector(".profile-photo").
                getAttribute("innerText"), userName);

        //5. Assert Browser title
        Assert.assertEquals(driver.getTitle(), title);

        //6. Assert that there are 4 images on the Home Page and they are displayed
        int imagesCount=4;
        List<WebElement> images = driver.findElementsByCssSelector(".icons-benefit");
        Assert.assertEquals(images.size(), imagesCount);
        for (WebElement image: images) {
            Assert.assertTrue(image.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Home Page and check them by getting texts
        int textsCount=4;
        List<WebElement> texts = driver.findElementsByCssSelector(".benefit-txt");
        Assert.assertEquals(texts.size(), textsCount);
        for (WebElement text: texts) {
            Assert.assertNotEquals(text.getText(), null);
        }

        //8. Assert that there are the main header and the text below it on the Home Page
        String text1 = "EPAM FRAMEWORK WISHES";
        String text2 = "LOREM IPSUM";
        WebElement mainHeaderText = driver.findElementByCssSelector(".main-title");
        WebElement headerText = driver.findElementByCssSelector(".main-txt");
        Assert.assertTrue(mainHeaderText.isDisplayed());
        Assert.assertTrue(headerText.isDisplayed());
        Assert.assertTrue(mainHeaderText.getAttribute("innerText").contains(text1));
        Assert.assertTrue(headerText.getAttribute("innerText").contains(text2));
    }
}
