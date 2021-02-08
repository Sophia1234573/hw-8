import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    public void  add(E value) {

        if (size == 0) {
            elements[0] = value;
        } else if (size < elements.length) {
            elements[size] = value;
        } else {
            elements = Arrays.copyOf(elements, (elements.length + elements.length / 2));
            elements[size + 1] = value;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {

        if (index >= 0 && index <= size) {
            Object[] elementsAfterRemoving = new Object[elements.length];
            for (int i = 0; i < index; i++) {
                elementsAfterRemoving[i] = elements[i];
            }
            for (int i = index; i < elements.length - 1; i++) {
                elementsAfterRemoving[i] = elements[i + 1];
            }
            elements = elementsAfterRemoving;
            size --;
        } else {
            return;
        }
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public E get(int index) {
        if (index < size && index >= 0) {
            return (E) elements[index];
        } else {
            return null;
        }
    }

    @Override
    public String toString() {

        Object[] elementsToString = new Object[size];
            for (int i = 0; i < size; i++) {
                if (elements[i] != null) {
                    elementsToString[i] = elements[i];
                }
            }
        return Arrays.toString(elementsToString);
    }
}
