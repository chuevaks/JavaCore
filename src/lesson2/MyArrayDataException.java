package lesson2;

public class MyArrayDataException extends Exception {
    public final int i;
    public final int j;

    public MyArrayDataException(int i, int j) {
        super("Wrong data in cell [" + i + ", " + j + "].");
        this.i = i;
        this.j = j;
    }
}
