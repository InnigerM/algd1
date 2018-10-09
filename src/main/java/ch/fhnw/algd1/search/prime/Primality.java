package ch.fhnw.algd1.search.prime;

public class Primality {
    public static boolean isPrime(int x) {
        int divider = x - 1;
        boolean isPrime = true;

        while(divider > 1 && isPrime){
            if(x % divider == 0){
                isPrime = false;
            }
            divider--;
        }
        return isPrime;
    }
}