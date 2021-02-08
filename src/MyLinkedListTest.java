public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Winter");
        linkedList.add("Spring");
        linkedList.add(null);
        linkedList.add("Autumn");

        System.out.println("linkedList is: " + linkedList + ", size is: " + linkedList.size());

        System.out.println("3-th element is: " + linkedList.get(3));

        linkedList.remove(1);
        System.out.println("linkedList after removing 1-th element: " + linkedList + ", size is: " + linkedList.size());

        linkedList.clear();
        System.out.println("linkedList after clearing: " + linkedList + ", size is: " + linkedList.size());
    }
}
