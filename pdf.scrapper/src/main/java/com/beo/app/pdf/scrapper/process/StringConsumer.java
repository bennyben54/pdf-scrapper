package com.beo.app.pdf.scrapper.process;

import java.util.function.Consumer;

public class StringConsumer implements Consumer<String> {

	private PathConsumer pathConsumer;

	public StringConsumer(PathConsumer pathConsumer) {
		super();
		this.pathConsumer = pathConsumer;
	}

	public void accept(String t) {
		pathConsumer.incrementCounter(1);
		pathConsumer.getStringBuilder().append(t);
		if (t.trim().endsWith(".")) {
			if (pathConsumer.getStringBuilder().toString().contains("YYY")) {
				pathConsumer.getResults().add(pathConsumer.getStringBuilder().toString());
			}
			pathConsumer.getStringBuilder().delete(0, pathConsumer.getStringBuilder().length() - 1);
			pathConsumer.setCounter(0);
		} else if (pathConsumer.getCounter() >= 2) {
			pathConsumer.setCounter(0);
			pathConsumer.getStringBuilder().delete(0, pathConsumer.getStringBuilder().length() - 1);
		}

	}

	public PathConsumer getPathConsumer() {
		return pathConsumer;
	}

	public void setPathConsumer(PathConsumer pathConsumer) {
		this.pathConsumer = pathConsumer;
	}

}
