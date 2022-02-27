package lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private final String[] header;
    private final ArrayList<Integer[]> data = new ArrayList<>();

    public AppData(String[] header) {
        this.header = header;
    }

    public void addRow(Integer[] inrArray) throws Exception {
        if (inrArray.length != header.length) {
            throw new Exception("Wrong row length");
        }
        data.add(inrArray);
    }

    public void save(String filePath) {
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath))) {
            bWriter.write(String.join(";", header));
            bWriter.newLine();
            for (Integer[] row : data) {
                String[] rowStr = new String[row.length];
                for (int i = 0; i < rowStr.length; i++) {
                    rowStr[i] = row[i].toString();
                }
                bWriter.write(String.join(";", rowStr));
                bWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static AppData loadAppData(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String str = reader.readLine();
        String[] header = str.split(";");
        AppData appdata = new AppData(header);
        while ((str = reader.readLine()) != null) {
            String[] dataString = str.split(";");
            Integer[] appInt = new Integer[dataString.length];
            for (int i = 0; i < dataString.length; i++) {
                appInt[i] = Integer.parseInt(dataString[i]);
            }
            appdata.addRow(appInt);
        }
        return appdata;
    }

    public void  print(){
        System.out.println(Arrays.toString(header));
        for (int i = 0; i < data.size(); i++) {
            System.out.println(Arrays.toString(data.get(i)));
        }
    }
}
