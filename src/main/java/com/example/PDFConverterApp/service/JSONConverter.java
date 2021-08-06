package com.example.PDFConverterApp.service;

import com.example.PDFConverterApp.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONConverter {

    public static void toJSON(String path, List<Person> personList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path), personList);
    }

    public static List<Person> toJavaObject(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(new File(path), Person[].class));
    }

}