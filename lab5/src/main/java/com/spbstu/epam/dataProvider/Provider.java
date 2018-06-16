package com.spbstu.epam.dataProvider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Provider {
    @DataProvider(name = "provider")
    public static Object[] getData() throws IOException {
        FileReader dataFile =
                new FileReader(Provider.class.getClassLoader().getResource("ex8_jdi_metalsColorsDataSet.json").getFile());

        JsonReader jsonReader = new JsonReader(dataFile);

        Map<String, DataSet> testValues =
                new Gson().fromJson(jsonReader, new TypeToken<Map<String, DataSet>>() {
                }.getType());

        return testValues.values().toArray();
    }
}
