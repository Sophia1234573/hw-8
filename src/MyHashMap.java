public class MyHashMap<K, V> {
    private int size = 0;
    private int M = 16;
    private Node[] st;
    private Node first;

    private static class Node<K, V> {

        private K key;
        private V value;
        private Node next;

        Node(K key, V value, Node<K, V> next) {

            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap () {
        this.st = new Node[M];
    }

    public void put(K key, V value) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        st[i] = new Node(key, value, st[i]);
        size++;
    }

    public K get(K key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (K) x.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int i = hash(key);
        int count = 0;
        int countNodes = 0;

        for (Node x = st[i]; x != null; x = x.next) {
            ++count;
            if (key.equals(x.key) && x.next == null && count == 1) {
                st[i] = null;
                size--;
                return;
            }
            if (key.equals(x.key) && x.next != null && count == 1) {
                x = x.next;
                st[i] = x;
                size--;
                return;
            }
            if (key.equals(x.next.key) && x.next.next != null) {
                x.next = x.next.next;
                x = x.next;
                size--;
                return;
            }

            if (key.equals(x.next.key) && x.next.next == null) {
                x.next = null;
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        if (st != null && size > 0) {
            size = 0;
            for (int i = 0; i < st.length; ++i) {
                st[i] = null;
            }
        }
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (Node element : st) {
            if (element != null) {
                for (MyHashMap.Node x = element; x != null; x = x.next) {
                    builder.append("{");
                    builder.append("key=");
                    builder.append(x.key);
                    builder.append("; ");
                    builder.append("value=");
                    builder.append(x.value);
                    builder.append("} ");
                }
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
