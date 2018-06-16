package com.spbstu.epam.Data;

public enum DatesData {
    FIRST_TEST(new Integer[]{0, 100}),
    SECOND_TEST(new Integer[]{0, 0}),
    THIRD_TEST(new Integer[]{100, 100}),
    FOURTH_TEST(new Integer[]{30, 70});

    public Integer[] values;

    DatesData(Integer[] i) {
        values = i;
    }
}