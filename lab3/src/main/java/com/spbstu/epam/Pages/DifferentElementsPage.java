package com.spbstu.epam.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {
    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    private SelenideElement rightSection;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = "div.colors select")
    private SelenideElement colors;

    @FindBy(css = "button[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "input[value='Button']")
    private SelenideElement inputButton;

    @FindBy(css = "ul.panel-body-list.logs")
    private SelenideElement logs;

    public DifferentElementsPage() {
        Selenide.page(this);
    }

    public void checkElements(int checkboxNumber, int radioNumber) {
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);

        for (SelenideElement checkbox : checkboxes)
            checkbox.shouldBe(visible);
        checkboxes.shouldHaveSize(checkboxNumber);

        for (SelenideElement radio : radios)
            radio.shouldBe(visible);
        radios.shouldHaveSize(radioNumber);

        colors.shouldBe(visible);

        inputButton.shouldBe(visible);
        defaultButton.shouldBe(visible);
    }

    public void selectCheckbox(String name) {
        checkboxes.find(text(name)).$("[type=checkbox]").setSelected(true);
        checkboxes.find(text(name)).$("[type=checkbox]").shouldBe(checked);
    }

    public void unselectCheckbox(String name) {
        checkboxes.find(text(name)).$("[type=checkbox]").setSelected(false);
        checkboxes.find(text(name)).$("[type=checkbox]").shouldNotBe(checked);
    }

    public void selectRadio(String value) {
        radios.find(text(value)).$("[type=radio]").setSelected(true);
        radios.find(text(value)).$("[type=radio]").shouldBe(selected);
    }

    public void selectDropdown(String value) {
        colors.selectOption(value);
    }

    public void checkCheckboxInLog(String name, String value) {
        logs.shouldHave(text(String.format("%s: condition changed to %s", name, value)));
    }

    public void checkRadioInLog(String value) {
        logs.shouldHave(text(String.format("metal: value changed to %s", value)));
    }

    public void checkDropdownInLog(String value) {
        logs.shouldHave(text(String.format("Colors: value changed to %s", value)));
    }
}
