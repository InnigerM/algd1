/*
 * Created on 21.03.2014
 */
package ch.fhnw.algd.sortalgs;

import ch.fhnw.algd.sortdemo.framework.SortAlg;
import ch.fhnw.algd.sortdemo.framework.SortData;

public class QuickSort implements SortAlg {
	@Override
	public void run(SortData data) {
		this.quickSort(data, 0, data.size() - 1);
	}

	private void quickSort(SortData a, int beg, int end) {
		int i = beg;
		int j = end;
		int x = (beg + end) / 2;
		if (beg < end) {
			while (i <= j) {
				while (a.less(i, x)) i++;
				while (a.less(x, j)) j--;
				if (i <= j) {
					a.swap(i, j);
					if (i == x) x = j;
					if (j == x) x = i;
					i++;
					j--;
				}
			}
			this.quickSort(a, beg, j);
			this.quickSort(a, i, end);
		}
	}
}