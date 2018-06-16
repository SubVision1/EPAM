package com.spbstu.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SitePage {
    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;

    @FindBy(css = "#Login")
    WebElement loginField;

    @FindBy(css = "#Password")
    WebElement passwordField;

    @FindBy(css = "form .btn-login")
    WebElement submit;

    @FindBy(css = ".logout")
    WebElement logoutBtn;

    @FindBy(css = ".icons-benefit")
    List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    List<WebElement> texts;

    @FindBy(css = ".main-title")
    WebElement mainTitle;

    @FindBy(css = ".main-txt")
    WebElement mainText;

    private WebDriver driver;

    public SitePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate(String URL) {
        driver.navigate().to(URL);
    }

    public String currentURL(){
        return driver.getCurrentUrl();
    }

    public String currentBrowserTitle(){
        return driver.getTitle();
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    public boolean isLoggedIn(){
        return logoutBtn.isDisplayed();
    }


    public String userName(){
        return profilePhoto.getAttribute("innerText");
    }

    public int imagesCount(){
        return images.size();
    }

    public boolean isImagesDisplayed(){
        for (WebElement e : images){
            if(!e.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public int textsCount(){
        return texts.size();
    }

    public boolean isMainTitleDisplayed(){
        return mainTitle.isDisplayed();
    }

    public boolean isMainTextsDisplayed(){
        return mainText.isDisplayed();
    }

    public String mainTitleText(){
        return mainTitle.getText();
    }

    public String mainTextText(){
        return mainText.getText();
    }
}
