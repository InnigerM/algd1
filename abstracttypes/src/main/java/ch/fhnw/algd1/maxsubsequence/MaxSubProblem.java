package ch.fhnw.algd1.maxsubsequence;

public class MaxSubProblem {

    public int maxSub(int[] data) {
        //TODO (A1) Implement your max sub-sequence algorithm here
        int lowest = 0, highest = 0, index = 0, indexOld = 0;
        int pointer = 0, result = 0;
        while (pointer < data.length) {
            indexOld = index;
            if (index + data[pointer] <= lowest) {
                lowest = index + data[pointer];
            }
            if (index + data[pointer] >= highest) {
                highest = index + data[pointer];
            }
            index += data[pointer];
            pointer++;
            if(index >= indexOld && result < index - lowest) {
                result = index - lowest;
            }
        }
        return result;
    }

}
