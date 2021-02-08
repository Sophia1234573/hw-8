import java.util.Arrays;

public class MyStack<E> {
    private int size = 0;
    private MyStack.Node<E> first = null;

    private static class Node<E> {
        E item;
        MyStack.Node<E> next;
    }

    public void push(E element) {
        MyStack.Node<E> oldFirst = first;
        first = new Node<>();
        first.item = element;
        first.next = oldFirst;
        size++;
    }

    public E peek() {
        E element = first.item;
        return element;
    }

    public E pop() {
        E element = first.item;
        removeTopElement ();
        return element;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index == size - 1) {
            removeTopElement ();
        } else if (index >= 0 && index < size - 1) {
            MyStack.Node<E> oldFirst = first;
            for (int i = size - 1; i > index + 1; i--) {
                oldFirst = oldFirst.next;
            }
            E element = oldFirst.item;
            MyStack.Node<E> next = oldFirst.next;
            if (next == null) {
                return;
            } else {
                oldFirst.next = oldFirst.next.next;
            }
            size--;
        }
    }

    public void clear() {
        for (MyStack.Node<E> oldFirst = first; oldFirst != null; ) {
            MyStack.Node<E> next = oldFirst.next;
            oldFirst.item = null;
            oldFirst.next = null;
            oldFirst = next;
        }
        first = null;
        size = 0;
    }

    private void removeTopElement () {
        if (first != null) {
            E element = first.item;
            first = first.next;
            size--;
        }
    }

    @Override
    public String toString() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyStack.Node<E> oldFirst = first; oldFirst != null && i < size; oldFirst = oldFirst.next) {
            result[i++] = oldFirst.item;
        }
        return Arrays.toString(result);
    }
}

