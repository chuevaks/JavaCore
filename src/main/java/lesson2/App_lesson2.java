package lesson2;

public class App_lesson2 {
    public static void main(String[] args) {
        //correct behaviour
        String[][] arr =  Array.createArray(4, 4);
        try {
            int result = Array.convertToIntAndSum(arr);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        //incorrect behaviour - MyArraySizeException
        String[][] arr2 =  Array.createArray(4, 5);
        try {
            int result = Array.convertToIntAndSum(arr2);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }


        //incorrect behaviour - MyArraySizeException
        String[][] arr3 =  Array.createArray(4, 4);
        arr3[1][0] = "a";
        try {
            int result = Array.convertToIntAndSum(arr3);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
