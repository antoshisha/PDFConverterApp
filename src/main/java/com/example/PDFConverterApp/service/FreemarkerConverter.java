package com.example.PDFConverterApp.service;


import com.example.PDFConverterApp.entity.Person;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

@Component
public class FreemarkerConverter {
    public String XMLConverter(List<Person> people) throws IOException, TemplateException, URISyntaxException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(FreemarkerConverter.class.getResource("/templates").toURI()));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);
        Map<String, List<Person>> root = new HashMap<>();
        root.put("personList", people);
        Template template = configuration.getTemplate("person.ftl");
        String fileName = "src/result/created.xml";
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName), "ISO-8859-9"));

        template.process(root, out);
        out.flush();
        out.close();
        return fileName;
    }
}
