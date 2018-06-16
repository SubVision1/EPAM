package com.spbstu.epam.Data;

public enum IndexData {
    URL("https://jdi-framework.github.io/tests/index.htm"),
    TITLE("Index Page"),

    LOGIN("epam"),
    PASSWORD("1234"),
    USERNAME("PITER CHAILOVSKII"),

    PICTURE_NUMBER(4),
    PICTURE_TEXTS(new String[]{
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM projec",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"
    }),

    MAIN_HEADER("EPAM FRAMEWORK WISHES…"),
    MAIN_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
            " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI" +
            " UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
            " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),

    DROPDOWN_TEXTS(new String[]{
            "Support",
            "Dates",
            "Complex Table",
            "Simple Table",
            "Table With Pages",
            "Different Elements"
    });

    public String[] strArrayValue;
    public String strValue;
    public Integer intValue;

    IndexData(String str) {
        strValue = str;
    }

    IndexData(Integer i) {
        intValue = i;
    }

    IndexData(String[] i) {
        strArrayValue = i;
    }
}