package com.spbstu.epam.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IndexPage {
    @FindBy(css = ".dropdown-toggle[href='#']")
    private SelenideElement loginMenu;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo")
    private SelenideElement userName;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection pictures;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection pictureTexts;

    @FindBy(css = ".main-title")
    private SelenideElement mainHeader;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".dropdown-toggle[href='page1.htm']")
    private SelenideElement serviceHead;

    @FindBy(css = ".sub-menu a[href='page1.htm']")
    private SelenideElement serviceLeft;

    @FindBy(css = "ul.dropdown-menu")
    private SelenideElement menuServiceHead;

    @FindBy(css = "ul.sub")
    private SelenideElement menuServiceLeft;

    @FindBy(css = "li a[href='page4.htm']")
    private SelenideElement datesButton;

    @FindBy(css = "li a[href='page8.htm']")
    private SelenideElement differentElemnetsButton;

    public IndexPage() {
        Selenide.page(this);
    }

    public void open(String Url) {
        Selenide.open(Url);
    }

    public void checkTitle(String title) {
        assert Selenide.title().equals(title);
    }

    public void checkLogin(String login, String password, String username) {
        loginMenu.click();
        loginInput.setValue(login);
        passwordInput.setValue(password);
        submitButton.click();
        userName.shouldBe(visible);
        userName.shouldHave(text(username));
    }

    public void checkMainHeader(String headerText) {
        mainHeader.shouldHave(text(headerText));
    }

    public void checkMainText(String text) {
        mainText.shouldHave(text(text));
    }

    public void checkPictureTexts(String[] texts) {
        pictureTexts.shouldHaveSize(texts.length);

        for (int i = 0; i < texts.length; i++) {
            pictureTexts.get(i).shouldBe(visible);
            pictureTexts.get(i).shouldHave(text(texts[i]));
        }
    }

    public void checkPictures(int size) {
        pictures.shouldHaveSize(size);
        for (SelenideElement picture : pictures)
            picture.shouldBe(visible);
    }

    public void checkHeadDropdown(String[] menuTexts) {
        if (!menuServiceHead.isDisplayed())
            serviceHead.click();
        for (String menuText : menuTexts)
            menuServiceHead.shouldHave(text(menuText));
        serviceHead.click();
    }

    public void checkLeftDropdown(String[] menuTexts) {
        if (!menuServiceLeft.isDisplayed())
            serviceLeft.click();
        for (String menuText : menuTexts)
            menuServiceLeft.shouldHave(text(menuText));
        serviceLeft.click();
    }

    public void relocateToDifferentElements() {
        if (!menuServiceHead.isDisplayed())
            serviceHead.click();

        differentElemnetsButton.click();
    }

    public void relocateToDates() {
        if (!menuServiceHead.isDisplayed())
            serviceHead.click();

        datesButton.click();
    }
}
