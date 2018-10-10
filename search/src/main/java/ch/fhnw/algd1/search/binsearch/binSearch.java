package ch.fhnw.algd1.search.binsearch;

public class binSearch {
    public static final int NOT_FOUND = -1;

    public static int binSearch(int[] data, int value){
        int lowerRange = -1, upperRange = data.length;
        while(lowerRange + 1 != upperRange){
            int pointer = (lowerRange + upperRange) / 2;
            if(data[pointer] < value){
                lowerRange = pointer;
            } else if(data[pointer] > value){
                upperRange = pointer;
            } else{
                return pointer;
            }
        }
        return NOT_FOUND;
    }
}
