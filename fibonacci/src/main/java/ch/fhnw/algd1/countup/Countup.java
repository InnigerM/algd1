package ch.fhnw.algd1.countup;

public class Countup {
    public static void main(String[] args) {
        countUp(10);
    }

    private static void countUp(int n) {
        if (n > 0) {
            System.out.println(n);
            countUp(n - 1);
        }
    }
}
