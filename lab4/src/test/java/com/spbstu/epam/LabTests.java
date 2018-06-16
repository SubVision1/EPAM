package com.spbstu.epam;

import com.codeborne.selenide.Configuration;
import com.spbstu.epam.Data.DifferentElementsData;
import com.spbstu.epam.Data.IndexData;
import com.spbstu.epam.Pages.DifferentElementsPage;
import com.spbstu.epam.Pages.IndexPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class LabTests {
    private static IndexPage indexPage;
    private static DifferentElementsPage differentElementsPage;

    @BeforeClass(description = "Set browser and initialize pages")
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.browserSize = "1920x2500";
        indexPage = new IndexPage();
        differentElementsPage = new DifferentElementsPage();
    }

    @Test(description = "Test home page and elements")
    public void Task1() {
        indexPage.open(IndexData.URL.strValue);

        indexPage.checkTitle(IndexData.TITLE.strValue);

        indexPage.checkLogin(IndexData.LOGIN.strValue,IndexData.PASSWORD.strValue,IndexData.USERNAME.strValue);

        indexPage.checkPictures(IndexData.PICTURE_NUMBER.intValue);

        indexPage.checkPictureTexts(IndexData.PICTURE_TEXTS.strArrayValue);

        indexPage.checkMainHeader(IndexData.MAIN_HEADER.strValue);

        indexPage.checkMainText(IndexData.MAIN_TEXT.strValue);

        indexPage.checkHeadDropdown(IndexData.DROPDOWN_TEXTS.strArrayValue);
        indexPage.checkLeftDropdown(IndexData.DROPDOWN_TEXTS.strArrayValue);

        indexPage.relocateToDifferentElements();

        differentElementsPage.checkElements(DifferentElementsData.CHECKBOX_NUMBER.intValue,
                DifferentElementsData.CHECKBOX_NUMBER.intValue);

        differentElementsPage.selectCheckbox(DifferentElementsData.CHECKBOX_1_NAME.strValue);
        differentElementsPage.selectCheckbox(DifferentElementsData.CHECKBOX_3_NAME.strValue);

        differentElementsPage.selectRadio(DifferentElementsData.RADIO_4_VALUE.strValue);

        differentElementsPage.selectDropdown(DifferentElementsData.DROPDOWN_4_VALUE.strValue);

        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_1_NAME.strValue, "true");
        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_3_NAME.strValue, "true");
        differentElementsPage.checkRadioInLog(DifferentElementsData.RADIO_4_VALUE.strValue);
        differentElementsPage.checkDropdownInLog(DifferentElementsData.DROPDOWN_4_VALUE.strValue);

        differentElementsPage.unselectCheckbox(DifferentElementsData.CHECKBOX_1_NAME.strValue);
        differentElementsPage.unselectCheckbox(DifferentElementsData.CHECKBOX_3_NAME.strValue);

        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_1_NAME.strValue, "false");
        differentElementsPage.checkCheckboxInLog(DifferentElementsData.CHECKBOX_3_NAME.strValue, "false");
    }
}
