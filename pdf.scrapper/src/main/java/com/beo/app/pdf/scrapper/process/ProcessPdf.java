package com.beo.app.pdf.scrapper.process;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessPdf {

	public void println(String folder) throws IOException {
		PathConsumer action = new PathConsumer();
		Files.list(Paths.get(folder)).forEach(action);

		SysoutTest sysoutTest = new SysoutTest();
		action.getResults().stream().sorted().forEachOrdered(sysoutTest::sysout);
	}

	public void printToFile(String folder, String outputFile) throws IOException {
		PathConsumer action = new PathConsumer();
		Files.list(Paths.get(folder)).forEach(action);

		Files.deleteIfExists(Paths.get(outputFile));
		try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(outputFile)))) {
			action.getResults().stream().sorted().forEachOrdered(pw::println);
		}
	}

	private class SysoutTest {
		public void sysout(String s) {
			System.out.println(s);
		}
	}
}
