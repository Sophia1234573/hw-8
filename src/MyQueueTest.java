public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> lessons = new MyQueue<>();
        lessons.add("Math");
        lessons.add("English");
        lessons.add(null);
        lessons.add("Music");
        lessons.add("Nature");

        System.out.println("Lessons queue is: " +  lessons + ", size is: " + lessons.size());

        System.out.println("First element in queue is: " +  lessons.peek());

        System.out.println("Removed element is: " + lessons.poll() + ", size is: " + lessons.size());

        System.out.println("Lessons before removing element by index 2: " + lessons);
        lessons.remove(2);
        System.out.println("Lessons after removing element by index 2: " + lessons);

        lessons.remove(1);
        System.out.println("Lessons after removing element by index 1: " + lessons);

        lessons.remove(0);
        System.out.println("Lessons after removing element by index 0: " + lessons);

        lessons.clear();
        System.out.println("Lessons after clearing: " + lessons + ", size is: " + lessons.size());
    }
}
