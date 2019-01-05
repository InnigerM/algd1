package ch.fhnw.algd1.stringmatch;

import ch.fhnw.algd1.stringmatch.framework.IStringMatch;

public class NaiveStringMatch1 implements IStringMatch {
    @Override
    public int firstMatch(String text, String pattern) {
        // TODO sequential search for first i such that matches(text, i, pattern)
        boolean found = false;
        int i = -1;
        while(i < text.length() - 1 && !found) {
            i++;
            if (pattern.charAt(0) == (text.charAt(i)) && text.length() - i >= pattern.length()){
                int j = 0;
                while (j < pattern.length() && !found) {
                    if (pattern.charAt(j) == text.charAt(i + j)) {
                        if(j == pattern.length() - 1) found = true;
                        j++;
                    } else {
                        j = pattern.length();
                    }
                }
            }
        }
        if(found) return i;
        else return -1;
    }

    private boolean matches(String text, int start, String pattern) {
        // TODO return if pattern matches text from position start
        if(firstMatch(text, pattern) == -1){
            return false;
        } else{
            return true;
        }
    }
}