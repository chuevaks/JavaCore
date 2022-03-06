package lesson4;

import java.io.*;
import java.util.*;

public class App_lesson4 {
    public static File file = new File(".idea/resources/lesson4_task1.txt");

    public static void main(String[] args) throws Exception {
        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Task 1.");
        System.out.println("*******************************************");

        ArrayList<String> array = createArr();
        System.out.println("Number of unique entries in the array is "+count(array));
        System.out.println("Number of repeats for each word:");
        System.out.println(wordCount(array));

        System.out.println("*******************************************");
        System.out.println("Task 2.");
        System.out.println("*******************************************");

        phoneBook.add("Smith", "0896548");
        phoneBook.add("Jones", "3695489");
        phoneBook.add("Brown", "2165758");
        phoneBook.add("Brown", "2545344");
        phoneBook.add("Watson", "2545878");
        phoneBook.add("Jones", "3546545");
        phoneBook.add("Brown", "3545458");
        try {
            System.out.println(phoneBook.get("Brown"));
            phoneBook.get("Jackson");
        }
        catch (Exception e){
            System.out.println("Name not found.");
        }
    }

    public static ArrayList<String> createArr() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> arrList = new ArrayList<>();
        String string;
            while ((string = br.readLine()) != null) {
                arrList.add(string);
        }
        return arrList;
    }

    public static int count(ArrayList<String> list){
        int result;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        result = set.size();
        return result;
    }
    public static HashMap<String, Integer> wordCount(ArrayList<String> list){
        HashMap<String, Integer> map = new HashMap<>();
        for (String key : list) {
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            }
            else {
                map.put(key,1);
            }
        }
        return map;
    }
}
