package lesson5;

public class App_lesson5 {
    public static void main(String[] args) throws Exception {
        AppData appData = new AppData(new String[] {"Value 1", "Value 2", "Value 3", "Value 4"});

        appData.addRow(new Integer[] {10,20,30,40});
        appData.addRow(new Integer[] {110,120,130,140});
        appData.addRow(new Integer[] {210,220,230,240});
        appData.addRow(new Integer[] {310,320,330,340});

        appData.save("lesson5.txt");

        AppData a = AppData.loadAppData("lesson5.txt");
        a.print();
    }
}
