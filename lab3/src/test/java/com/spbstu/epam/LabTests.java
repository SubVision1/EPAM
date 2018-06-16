package com.spbstu.epam;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.epam.Data.DatesData;
import com.spbstu.epam.Data.DifferentElementsData;
import com.spbstu.epam.Data.IndexData;
import com.spbstu.epam.Pages.DatesPage;
import com.spbstu.epam.Pages.DifferentElementsPage;
import com.spbstu.epam.Pages.IndexPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LabTests {
    private static IndexPage indexPage;
    private static DifferentElementsPage differentElementsPage;
    private static DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        indexPage = new IndexPage();
        differentElementsPage = new DifferentElementsPage();
        datesPage = new DatesPage();
    }

    @AfterClass
    public void afterClass() {
        Selenide.close();
    }

    @Test
    public void Lab3Task1() {
        //Open test site by URL
        indexPage.open(IndexData.URL.strValue);
        indexPage.checkTitle(IndexData.TITLE.strValue);

        //Perform login
        //Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLogin(
                IndexData.LOGIN.strValue,
                IndexData.PASSWORD.strValue,
                IndexData.USERNAME.strValue);

        //Check interface on Home page, it contains all needed elements.
        indexPage.checkPictures(IndexData.PICTURE_NUMBER.intValue);
        indexPage.checkPictureTexts(IndexData.PICTURE_TEXTS.strArrayValue);
        indexPage.checkMainHeader(IndexData.MAIN_HEADER.strValue);
        indexPage.checkMainText(IndexData.MAIN_TEXT.strValue);

        //Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeadDropdown(IndexData.DROPDOWN_TEXTS.strArrayValue);

        //Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftDropdown(IndexData.DROPDOWN_TEXTS.strArrayValue);

        //Open through the header menu Service -> Different Elements Page
        indexPage.relocateToDifferentElements();

        //Select and assert checkboxes
        differentElementsPage.checkElements(DifferentElementsData.CHECKBOX_NUMBER.intValue,
                DifferentElementsData.CHECKBOX_NUMBER.intValue);
        differentElementsPage.selectCheckbox(DifferentElementsData.CHECKBOX_1_NAME.strValue);
        differentElementsPage.selectCheckbox(DifferentElementsData.CHECKBOX_3_NAME.strValue);

        //Select radio
        differentElementsPage.selectRadio(DifferentElementsData.RADIO_4_VALUE.strValue);

        //Select in dropdown
        differentElementsPage.selectDropdown(DifferentElementsData.DROPDOWN_4_VALUE.strValue);

        //Check in logs section selected values and status (true|false)
        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_1_NAME.strValue, "true");
        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_3_NAME.strValue, "true");
        differentElementsPage.checkRadioInLog(DifferentElementsData.RADIO_4_VALUE.strValue);
        differentElementsPage.checkDropdownInLog(DifferentElementsData.DROPDOWN_4_VALUE.strValue);

        //Unselect and assert checkboxes
        differentElementsPage.unselectCheckbox(DifferentElementsData.CHECKBOX_1_NAME.strValue);
        differentElementsPage.unselectCheckbox(DifferentElementsData.CHECKBOX_3_NAME.strValue);

        //Check in logs section unselected values and status (true|false)
        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_1_NAME.strValue, "false");
        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_3_NAME.strValue, "false");
    }

    @Test
    public void Lab3Task2() {
        //Open test site by URL
        indexPage.open(IndexData.URL.strValue);
        indexPage.checkTitle(IndexData.TITLE.strValue);

        //Open Service -> Dates
        indexPage.relocateToDates();

        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.dragAndDropSliders(DatesData.FIRST_TEST.values[0], DatesData.FIRST_TEST.values[1]);
        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.dragAndDropSliders(DatesData.SECOND_TEST.values[0], DatesData.SECOND_TEST.values[1]);
        //Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.dragAndDropSliders(DatesData.THIRD_TEST.values[0], DatesData.THIRD_TEST.values[1]);
        //Using drag-and-drop set Range sliders.
        datesPage.dragAndDropSliders(DatesData.FOURTH_TEST.values[0], DatesData.FOURTH_TEST.values[1]);
    }
}
