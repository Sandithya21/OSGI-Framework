package com.mtit.osgi.vehiclesparesservice;

import java.util.Arrays;
import java.util.List;

public class DictionaryImpl implements Dictionary {

	private List<String> fWords = Arrays.asList("osgi", "eclipse", "equinox");
	private String fLanguage = "en_US";

	public String getLanguage() {
		return fLanguage;
	}

	public boolean check(String word) {
		return fWords.contains(word);
	}

	public String toString() {
		return fLanguage;
	}

}
