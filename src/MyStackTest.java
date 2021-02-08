public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> stackList = new MyStack<>();
        stackList.push("ArrayList");
        stackList.push("LinkedList");
        stackList.push("Queue");
        stackList.push("Stack");
        stackList.push("HashMap");
        stackList.push("TreeMap");

        System.out.println("StackList: " + stackList + ", size is: " + stackList.size());

        stackList.remove(4);
        System.out.println("StackList after removing element: " + stackList + ", size is: " + stackList.size());


        System.out.println("First element is: " + stackList.peek());
        System.out.println("pop element: [" + stackList.pop() + "], StackList: " + stackList);
        System.out.println("pop element: [" + stackList.pop() + "], StackList: " + stackList);

        stackList.clear();
        System.out.println("StackList after clearing : " + stackList + ", size is: " + stackList.size());


    }

}
