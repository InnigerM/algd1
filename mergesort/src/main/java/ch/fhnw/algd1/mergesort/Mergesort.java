package ch.fhnw.algd1.mergesort;

public class Mergesort {
    public <T extends Comparable<? super T>> void mergesort(T[] a) {
        sort(a, 0, a.length);
    }

    private <T extends Comparable<? super T>> void sort(T[] a, int beg, int end) {
        if (end - beg > 1) {
            int m = (beg + end) / 2;
            sort(a, beg, m);
            sort(a, m, end);
            merge(a, beg, m, end);
        }
    }

    // Merges sequence a[beg...m-1] with a[m...end-1] into a[beg...end-1]
    private <T extends Comparable<? super T>> void merge(T[] a, int beg, int m, int end) {
        @SuppressWarnings("unchecked")
        T[] b = (T[]) new Comparable[end - beg];
        int i = 0, j = beg, k = m;
        while (j < m && k < end) {
            if (-(a[j].compareTo(a[k])) <= 0) b[i++] = a[j++];
            else b[i++] = a[k++];
        }
        while (j < m) b[i++] = a[j++];
        while (k < end) b[i++] = a[k++];
        while(i > 0){
            i--;
            a[beg + i] = b[i];
        }
    }
}
