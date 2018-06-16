package com.spbstu.epam;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.spbstu.epam.constants.IndexConstants;
import com.spbstu.epam.dataProvider.DataSet;
import com.spbstu.epam.dataProvider.Provider;
import com.spbstu.epam.pageObjects.IndexPage.User;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.spbstu.epam.Site.indexPage;
import static com.spbstu.epam.Site.metalsAndColorsPage;


public class LabTests extends TestNGBase {

    static final String driverPath="C:\\java\\chromeDriver";

    @BeforeSuite
    public void beforeSuite() {

        driverFactory.setDriverPath(driverPath);
        WebSite.init(Site.class);
        driverFactory.getDriver();
        WebSite.open();

        //Login on JDI site as User
        indexPage.login(new User(IndexConstants.LOGIN.strValue, IndexConstants.PASSWORD.strValue));
        //Open Metals & Colors page by Header menu
        indexPage.openMetalsAndColorsPage();
        metalsAndColorsPage.components.select("Salad");
    }
    @Test(dataProvider = "provider", dataProviderClass = Provider.class)
    public void Task(DataSet testValues) {
        //Fill form Metals & Colors by data below:
        //Submit form Metals & Colors
        //Result sections should contains data
        metalsAndColorsPage.setValues(testValues);
        metalsAndColorsPage.checkValues(testValues);
        metalsAndColorsPage.unsetValues(testValues);
    }
}