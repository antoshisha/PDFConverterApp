package com.example.PDFConverterApp;

import com.example.PDFConverterApp.service.ConverterApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfConverterAppApplication implements CommandLineRunner {
	@Autowired
	ConverterApp converterApp;

	public static void main(String[] args) {
		SpringApplication.run(PdfConverterAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		converterApp.processJSONToPDF();
	}
}
