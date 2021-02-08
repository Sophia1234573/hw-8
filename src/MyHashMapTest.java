public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> hashMapList = new MyHashMap<>();

        hashMapList.put("Kolya", "03.02.11, pupil");
        hashMapList.put("Alisa", "30.06.16, child");
        hashMapList.put("Riva", "Cat");
        hashMapList.put("Riva", "My white cat");
        hashMapList.put("Oleg", "19.10.18, child");

        System.out.println("hashMapList: " + hashMapList + ", size is: " + hashMapList.size());
        System.out.println("getting value by key Alisa: " + hashMapList.get("Alisa"));

        hashMapList.remove("Riva");
        System.out.println("hashMapList after removing element by key Riva: " + hashMapList + ", size is: " + hashMapList.size());

        hashMapList.clear();
        System.out.println("hashMapList after clearing: " +  hashMapList + ", size is: " + hashMapList.size());
    }
}
