package com.spbstu.epam;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.spbstu.epam.pageObjects.IndexPage.IndexPage;
import com.spbstu.epam.pageObjects.MetalsAndColorsPage;


@JSite("https://jdi-framework.github.io/tests/")
public class Site extends WebSite {
    static IndexPage indexPage;
    static MetalsAndColorsPage metalsAndColorsPage;
}


