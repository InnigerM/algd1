package ch.fhnw.algd1.stringmatch;

import ch.fhnw.algd1.stringmatch.framework.IStringMatch;

import java.util.Arrays;

/**
 * Boyer-Moore-Horspool String Match (supporting LATIN-1 character set)
 */
public class BoyerMooreHorspoolStringMatch implements IStringMatch {
    private int[] allShifts(String pattern) {
        int[] shift = new int[256]; // we support the LATIN-1 character set
        for (int i = 0; i < shift.length; i++) {
            shift[i] = pattern.length();
        }
        for (int i = 0; i < pattern.length() - 1; i++) {
            shift[(int) pattern.charAt(i)] = pattern.length() - 1 - i;
        }
        return shift;
    }

    @Override
    public int firstMatch(String text, String pattern) {
        int[] shift = allShifts(pattern);
        int i = 0, j;
        boolean found = false;
        while (i <= text.length() - pattern.length() && !found) {
            j = pattern.length() - 1;
            while (j >= 0 && text.charAt(i + j) == pattern.charAt(j)) {
                j--;
            }
            if (j >= 0) {
                i += shift[text.charAt(i + pattern.length() - 1)];
            } else {
                found = true;
            }
        }
        if (found) return i;
        else return -1;
    }
}

/* OBSOLETE: first draft of boyer-moore-horspool algorithm
        int i = -1, j = 0;
        boolean found = false, shifted = false;
        while (i < text.length() - 1 && !found) {
            i++;
            if (pattern.charAt(0) == text.charAt(i) && text.length() - i >= pattern.length()) {
                j = 1;
                shifted = false;
                while (j <= pattern.length() && !found && !shifted) {
                    if (pattern.charAt(j) == text.charAt(i + j)) {
                        if (j == pattern.length() - 1) found = true;
                        j++;
                    } else {
                        shifted = true;
                        i += shift[(int) text.charAt(i + pattern.length() - j)];
                    }
                }
            }
        }
        if (found) return i;
        else return -1;
 */