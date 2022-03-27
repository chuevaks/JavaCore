package lesson8;

import java.sql.*;
import java.util.ArrayList;


public class Repo {
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Repo() {
        createTable();
    }

    private Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
        return connection;
    }

    private void createTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "city TEXT NOT NULL,\n" +
                "date_time TEXT NOT NULL,\n" +
                "weather_text TEXT NOT NULL,\n" +
                "temperature REAL NOT NULL\n" +
                ");";
        try (Connection connection = createConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insert(ArrayList<WeatherDto> list) {
        String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
        try (Connection connection = createConnection();
             PreparedStatement prepInsert = connection.prepareStatement(insertWeatherQuery)) {
            for (WeatherDto weatherDto : list) {
                prepInsert.setString(1, weatherDto.city);
                prepInsert.setString(2, weatherDto.localDate);
                prepInsert.setString(3, weatherDto.weatherText);
                prepInsert.setDouble(4, weatherDto.temperature);
                prepInsert.addBatch();
            }
            int[] result = prepInsert.executeBatch();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<WeatherDto> select(String city) {
        String selectWeatherQuery = "SELECT city, date_time, weather_text, temperature FROM weather WHERE city = ?";
        ArrayList<WeatherDto> list = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement prepSelect = connection.prepareStatement(selectWeatherQuery)) {
            prepSelect.setString(1,city);
            ResultSet result = prepSelect.executeQuery();
            while (result.next()){
                WeatherDto weatherDto = new WeatherDto();
                weatherDto.city = result.getString(1);
                weatherDto.localDate = result.getString(2);
                weatherDto.weatherText = result.getString(3);
                weatherDto.temperature = result.getDouble(4);
                list.add(weatherDto);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

