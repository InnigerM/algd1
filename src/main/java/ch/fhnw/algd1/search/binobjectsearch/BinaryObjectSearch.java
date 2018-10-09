package ch.fhnw.algd1.search.binobjectsearch;

public class BinaryObjectSearch {
    public static final int NOT_FOUND = -1;

    public static <T extends Comparable<? super T>> int binSearch(T[] data, T value) {
        // TODO (A5) Implement binary search here
        int upperRange = data.length, lowerRange = -1;

        while (lowerRange + 1 != upperRange) {
            int pointer = (upperRange + lowerRange) / 2;
            if (data[pointer].compareTo(value) < 0) {
                lowerRange = pointer;
            } else if (data[pointer].compareTo(value) > 0) {
                upperRange = pointer;
            } else {
                return pointer;
            }
        }
        return NOT_FOUND;
    }
}
