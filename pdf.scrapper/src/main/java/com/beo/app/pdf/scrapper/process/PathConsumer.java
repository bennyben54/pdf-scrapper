package com.beo.app.pdf.scrapper.process;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PathConsumer implements Consumer<Path> {

	private static final Logger log = Logger.getLogger(PathConsumer.class.getName());

	private final StringBuilder stringBuilder = new StringBuilder();
	private final List<String> results = new ArrayList<>();
	private int counter = 0;

	public PathConsumer() {
		super();
	}

	public void accept(Path arg0) {
		if (arg0.toString().endsWith(".pdf") || arg0.toString().endsWith(".PDF")) {
			try (PDDocument doc = PDDocument.load(arg0.toFile());) {
				PDFTextStripper strip = new PDFTextStripper();
				String text = strip.getText(doc);
				
				Arrays.stream(text.split("\n")).forEachOrdered(new StringConsumer(this));
			} catch (IOException e) {
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		}
	}

	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}

	public List<String> getResults() {
		return results;
	}

	public void setCounter(int i) {
		counter = i;
	}

	public int getCounter() {
		return counter;
	}

	public void incrementCounter(int i) {
		counter += i;
	}
}
