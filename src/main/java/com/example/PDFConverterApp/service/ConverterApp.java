package com.example.PDFConverterApp.service;

import com.example.PDFConverterApp.entity.Person;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
@Component
public class ConverterApp {
    private final FreemarkerConverter freemarkerConverter;
    private final PDFConverter pdfConverter;

    private final String jsonSource = "src/input/people.json";

    public ConverterApp(FreemarkerConverter freemarkerConverter, PDFConverter pdfConverter) {
        this.freemarkerConverter = freemarkerConverter;
        this.pdfConverter = pdfConverter;
    }

    public void processJSONToPDF() throws IOException, TemplateException, URISyntaxException {
        List<Person> people = JSONConverter.toJavaObject(jsonSource);
        String convertedXML = freemarkerConverter.XMLConverter(people);
        pdfConverter.convertToPDF(convertedXML);
    }

}
