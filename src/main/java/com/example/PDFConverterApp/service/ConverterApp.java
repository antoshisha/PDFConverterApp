package com.example.PDFConverterApp.service;

import com.example.PDFConverterApp.entity.Person;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class ConverterApp {
    private final FreemarkerConverter freemarkerConverter;
    private final PDFConverter pdfConverter;

    private final String jsonSource = "src/input/person.json";

    public ConverterApp(FreemarkerConverter freemarkerConverter, PDFConverter pdfConverter) {
        this.freemarkerConverter = freemarkerConverter;
        this.pdfConverter = pdfConverter;
    }

    public void processJSONToPDF() throws IOException, TemplateException, URISyntaxException {
        Person person = JSONConverter.toJavaObject(jsonSource);
        String convertedFO = freemarkerConverter.XMLConverter(person);
        pdfConverter.convertFOToPDF(convertedFO);
    }

}
