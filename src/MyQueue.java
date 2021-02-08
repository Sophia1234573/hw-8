import java.util.Arrays;

public class MyQueue<E> {
    private int size = 0;
    private MyQueue.Node<E> first;
    private MyQueue.Node<E> last;

    private static class Node<E> {
        E item;
        MyQueue.Node<E> next;
        MyQueue.Node<E> previous;

        Node(MyQueue.Node<E> previous, E element, MyQueue.Node<E> next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
        }
    }

    public void add(E element) {
        MyQueue.Node<E> l = last;
        MyQueue.Node<E> newNode = new MyQueue.Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E peek() {
        MyQueue.Node<E> x = first;
        E element = x.item;
        return element;
    }

    public E poll() {
        MyQueue.Node<E> x = first;
        E element = x.item;
        MyQueue.Node<E> next = x.next;
        x.item = null;
        x.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.previous = null;
        }
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            MyQueue.Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            E element = x.item;
            MyQueue.Node<E> next = x.next;
            MyQueue.Node<E> previous = x.previous;

            if (previous == null) {
                first = next;
            } else {
                previous.next = next;
                x.previous = null;
            }

            if (next == null) {
                last = previous;
            } else {
                next.previous = previous;
                x.next = null;
            }

            x.item = null;
            size--;
        }
    }

    public void clear() {
        for (MyQueue.Node<E> x = first; x != null; ) {
            MyQueue.Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public String toString() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyQueue.Node<E> x = first; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return Arrays.toString(result);
    }
}


