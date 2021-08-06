package com.example.PDFConverterApp.service;

import org.apache.fop.apps.*;
import org.springframework.stereotype.Component;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
@Component
public class PDFConverter {
    public void convertToPDF(String createdXML) throws IOException {
        File xsltFile = new File("src/main/resources/templates/xslTemplate.xsl");
        StreamSource xmlSource = new StreamSource(new File("src/result/created.xml"));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        OutputStream out = new FileOutputStream("src/result/result.pdf");
        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
        } catch (FOPException | TransformerException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}

