package ch.fhnw.algd1.stringmatch;

import ch.fhnw.algd1.stringmatch.framework.IStringMatch;

public class NaiveStringMatch2 implements IStringMatch {
	@Override
	public int firstMatch(String text, String pattern) {
		// TODO search for first start position i where pattern matches text
		NaiveStringMatch1 StringSearch = new NaiveStringMatch1();
		return StringSearch.firstMatch(text, pattern);
	}
}