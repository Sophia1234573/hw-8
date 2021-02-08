public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Oleg");
        list.add("Alisa");
        list.add("Kolya");
        list.add(null);
        list.add("hohoho");

        list.remove(3);
        System.out.println("List after removing 3-th element: " + list + ", size = " + list.size());

        System.out.println("Getting 2-th element: " + list.get(2));
        System.out.println("Getting 7-th element: " + list.get(7));

        MyArrayList<Integer> listIntegers = new MyArrayList<>(5);
        listIntegers.add(157);
        listIntegers.add(348);
        listIntegers.add(574);
        System.out.println("listIntegers " + listIntegers);
    }
}
