package com.beo.app.pdf.scrapper;

import java.io.IOException;

import com.beo.app.pdf.scrapper.process.ProcessPdf;

/**
 * Hello world!
 *
 */
public class PdfScrapperApp {
	public static void main(String[] args) throws IOException {
		ProcessPdf processPdf = new ProcessPdf();
		processPdf.println("/home/xx");
		processPdf.printToFile("/home/xx", "XX");
	}
}
