package com.spbstu.epam.pageObjects.IndexPage;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/index.htm", title = "Index Page")
public class IndexPage extends WebPage {
    private LoginForm loginForm;

    @FindBy(css = ".uui-profile-menu")
    private Label profileMenu;

    @FindBy(css = ".uui-navigation a[href='page2.htm']")
    private Button metalsAndColorsPageReference;

    public void login(User user) {
        profileMenu.click();
        loginForm.loginAs(user);
    }

    public void openMetalsAndColorsPage() {
        metalsAndColorsPageReference.click();
    }
}
