package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private final HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void  add(String name, String number){
        if (phoneBook.containsKey(name)){
            phoneBook.get(name).add(number);
        }
        else {
            ArrayList<String> numberList = new ArrayList<>();
            numberList.add(number);
            phoneBook.put(name, numberList);
        }
    }
    public ArrayList<String > get(String name) throws Exception {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        else {
            throw new Exception("Name not found.");
        }
    }
}
