package com.spbstu.epam.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DatesPage {
    private SelenideElement leftSlider;

    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[2]")
    private SelenideElement rightSlider;

    public DatesPage() {
        Selenide.page(this);
    }

    private void dragAndDropSlider(SelenideElement slider, int value) {
        Selenide.actions().clickAndHold(slider).build().perform();
        int d=Integer.signum(value-Integer.parseInt(slider.getText()));
        while (value != Integer.parseInt(slider.getText()))
            Selenide.actions().moveByOffset(1, 0).build().perform();

        while (value < Integer.parseInt(slider.getText()))
            Selenide.actions().moveByOffset(-1, 0).build().perform();

        Selenide.actions().release().build().perform();
    }

    public void dragAndDropSliders(int leftValue, int rightValue) {
        if (leftValue > Integer.parseInt(rightSlider.getText())) {
            dragAndDropSlider(rightSlider, rightValue);
            dragAndDropSlider(leftSlider, leftValue);
        } else {
            dragAndDropSlider(leftSlider, leftValue);
            dragAndDropSlider(rightSlider, rightValue);
        }

        leftSlider.shouldHave(text(String.valueOf(leftValue)));
        rightSlider.shouldHave(text(String.valueOf(rightValue)));
    }
}
