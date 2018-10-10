package ch.fhnw.algd1.search.binsearchfirst;

public class BinSearchFirstElement {
    public static int binSearch(int[] data, int value) {
        int lowerRange = -1, upperRange = data.length;
        while (lowerRange + 1 != upperRange) {
			int pointer = (lowerRange + upperRange) / 2;
			if(data[pointer] < value){
			    lowerRange = pointer;
            } else{
			    upperRange = pointer;
            }
        }
        return upperRange;
    }
}