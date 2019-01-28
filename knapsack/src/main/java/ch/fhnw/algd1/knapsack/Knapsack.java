package ch.fhnw.algd1.knapsack;
/*
 * Created on Dec 12, 2013
 */
/**
 * @author Wolfgang Weck
 */
public final class Knapsack {
	private static final int[] weight = Example2.weight, value = Example2.value;
	private static final int capacity = Example2.capacity;
	private static int totWeight, totValue, maxValue;

	public static void main(String[] args) {
		System.out.println("Maximum value of rucksack is: " + maxValue());
	}

	private static int maxValue() {
		maxValue = 0;
		pack(0);
		return maxValue;
	}

	private static void pack(int i) {
		if(totWeight <= capacity) {
			if (i < weight.length) {
				pack(i + 1);
				packItem(i);
				pack(i + 1);
				unpackItem(i);
				// items i+1 and further
			} else if (totWeight <= capacity && totValue > maxValue) {
				maxValue = totValue;
				System.out.println("new max value " + maxValue + " with weight " + totWeight);
			}
		}
	}

	private static void packItem(int i) {
		totWeight = totWeight + weight[i];
		totValue = totValue + value[i];
	}

	private static void unpackItem(int i) {
		totWeight = totWeight - weight[i];
		totValue = totValue - weight[i];
	}
}
