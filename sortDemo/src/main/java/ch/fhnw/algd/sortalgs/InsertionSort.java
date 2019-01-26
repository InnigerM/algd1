/*
 * Created on 21.03.2014
 */
package ch.fhnw.algd.sortalgs;

import ch.fhnw.algd.sortdemo.framework.SortAlg;
import ch.fhnw.algd.sortdemo.framework.SortData;

public class InsertionSort implements SortAlg {
    @Override
    public void run(SortData data) {
        for (int i = 1; i < data.size(); i++) {
            for (int j = i; j > 0 && data.less(j, j - 1); j--) {
                data.swap(j - 1, j);
            }
        }
    }

}
