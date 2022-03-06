package lesson2;


public class Array {

    public static String[][] createArray(int rows, int columns) {
        String[][] arr = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int random = (int) (Math.random() * 10);
                String s = String.valueOf(random);
                arr[i][j] = s;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr;
    }

    public static void checkSize(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length!= 4){
                throw new MyArraySizeException();
            }
        }
    }

    public static int convertToIntAndSum(String[][] arr) throws MyArrayDataException,MyArraySizeException {
        checkSize(arr);
        int finalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    finalSum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return finalSum;
    }
}
