import java.util.Arrays;

public class MyLinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> previous;

        Node(MyLinkedList.Node<E> previous, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
        }
    }

    public void add(E element) {
        MyLinkedList.Node<E> l = last;
        MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        return node(index).item;
    }

    public void remove(int index) {
        Node<E> x = node(index);
        E element = x.item;
        MyLinkedList.Node<E> next = x.next;
        MyLinkedList.Node<E> previous = x.previous;

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

    public int size() {
        return size;
    }

    public void clear() {
        for (MyLinkedList.Node<E> x = first; x != null; ) {
            MyLinkedList.Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private MyLinkedList.Node<E> node(int index) {
        if (index >= 0 && index < size) {
            MyLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyLinkedList.Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;

        return Arrays.toString(result);
    }
}

