package ch.fhnw.algd1.search.sentinelsearch;

public class SentinelSearch {
    public static boolean exists(int[] data, int value) {
        int lastValue = data[data.length - 1], i = 0;
        data[data.length - 1] = value;

        while (data[i] != value) {
            i++;
        }

        data[data.length - 1] = lastValue;
        return (i != data.length - 1 || lastValue == value);
    }

    public static int firstIndex(int[] data, int value) {
        int lastValue = data[data.length - 1], i = 0;
        data[data.length - 1] = value;

        while (data[i] != value) {
            i++;
        }
        data[data.length - 1] = lastValue;
        if (i == data.length - 1 && value != lastValue) {
            return -1;
        } else {
            return i;
        }
    }
}