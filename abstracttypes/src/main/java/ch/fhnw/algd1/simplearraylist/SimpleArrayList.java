package ch.fhnw.algd1.simplearraylist;

import java.util.AbstractList;
import java.util.List;

public class SimpleArrayList<E> extends AbstractList<E> implements List<E> {
    private int minArrLen = 16;
    private Object[] arr = new Object[minArrLen];
    private int lengthCount = 2;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO (A2) check preconditions
        if (index >= 0 && index < arr.length) {
            return (E) arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E set(int index, E element) {
        E old = get(index); // includes index checking
        arr[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        // TODO (A2) implement adding an element in correct position
        if (arr.length < index) {
            arr = new Object[minArrLen * lengthCount];
            lengthCount++;
        }
        arr[index] = element;
    }

    @Override
    public E remove(int index) {
        E old = get(index); // includes index checking
        while (index + 1 < size) {
            arr[index] = arr[index + 1];
            index++;
        }
        arr[size] = null;
        size--;
        // TODO (A2) optional: reduce list size, if possible / appropriate
        return old;
    }
}
