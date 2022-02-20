package lesson3;

import java.util.Arrays;

public class App_lesson3 {
    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        String[] arr = {"123", "qqq", "!@#"};
        String arrToStr1 = Arrays.toString(arr);
        swapElements(arr, 0,2);
        String arrToStr2 = Arrays.toString(arr);
        System.out.println(arrToStr1);
        System.out.println(arrToStr2);
        System.out.println("**********************************************");

        //2. Задача
        Box<Apple> appleBox = new Box<Apple>();
        Box<Apple> anotherAppleBox = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();
        Box<Orange> anotherOrangeBox = new Box<Orange>();

        for (int i = 0; i < 5; i++) {
            appleBox.addFruit(new Apple());
        }

        for (int j = 0; j < 8; j++) {
            orangeBox.addFruit(new Orange());
        }

        //compare Apples and Oranges
        System.out.println("Apple box is heavier than orange box");
        System.out.println(appleBox.compare(orangeBox));
        System.out.println("**********************************************");

        //move Apples
        float weight1 = appleBox.getBoxWeight();
        System.out.println("Weight of apple box is " + weight1);
        appleBox.moveFruits(anotherAppleBox);
        float weight2 = appleBox.getBoxWeight();
        float weight3 = anotherAppleBox.getBoxWeight();
        System.out.println("Apples were moved to another box. Weight of apple box now is " + weight2);
        System.out.println("Weight of another apple box now is " + weight3);
        System.out.println("**********************************************");

        //move Oranges
        float weight01 = orangeBox.getBoxWeight();
        System.out.println("Weight of orange box is " + weight01);
        orangeBox.moveFruits(anotherOrangeBox);
        float weight02 = orangeBox.getBoxWeight();
        float weight03 = anotherOrangeBox.getBoxWeight();
        System.out.println("Oranges were moved to another box. Weight of orange box now is " + weight02);
        System.out.println("Weight of another orange box now is " + weight03);
        System.out.println("**********************************************");
        //compare Apples and Oranges
        for (int i = 0; i < 3; i++) {
            appleBox.addFruit(new Apple());
        }

        for (int j = 0; j < 2; j++) {
            orangeBox.addFruit(new Orange());
        }

        System.out.println(appleBox.compare(orangeBox));
    }

    public static <T> void swapElements(T[] arr, int index1, int index2){
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
