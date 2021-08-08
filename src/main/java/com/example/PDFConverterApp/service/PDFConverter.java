package com.example.PDFConverterApp.service;

import org.apache.fop.apps.*;
import org.springframework.stereotype.Component;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Component
public class PDFConverter {
    private final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

    public void convertFOToPDF(String FOFilePath) {
        try(OutputStream out = new BufferedOutputStream(new FileOutputStream("src/result/result2.pdf"))) {
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Source src = new StreamSource(FOFilePath);
            Result result = new SAXResult(fop.getDefaultHandler());
            transformer.transform(src, result);
        } catch (FOPException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}

