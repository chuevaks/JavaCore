package lesson8;

import lesson6.dto.DailyForecast;
import lesson6.dto.FiveDayForecastResult;
import lesson6.dto.WeatherProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {

    public void executeApp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the name of the city in English");
            String city = scanner.nextLine();


            System.out.println("Enter answer: 1 - Get the weather for the next 5 days, " +
                    "2 - Get weather from a database" +
                    " 3 - Exit");
            String result = scanner.nextLine();

            if (result.equals("3")){
                return;
            }

                if(result.equals("1")){
                    fetchFromWeb(city);
                }

            if(result.equals("2")){
                fetchFromDB(city);
            }
        }
    }

    private void fetchFromDB(String city) throws IOException {
        Repo repo = new Repo();
        ArrayList<WeatherDto> list= repo.select(city);
        printResult(list);
    }

    private ArrayList<WeatherDto> convertToDto(FiveDayForecastResult result, String city) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<WeatherDto> list = new ArrayList<>();
        for (DailyForecast dailyForecast: result.dailyForecasts) {
            WeatherDto weatherDto = new WeatherDto();
            weatherDto.city = city;
            weatherDto.weatherText = dailyForecast.day.iconPhrase.toLowerCase(Locale.ROOT);
            weatherDto.temperature = dailyForecast.temperature.maximum.value;
            weatherDto.localDate = format.format(dailyForecast.date);
            list.add(weatherDto);
        }
        return list;
    }

    private static void printResult(ArrayList<WeatherDto> list) {
        for (WeatherDto weatherDto:list) {
            System.out.println("The weather in " + weatherDto.city + " on " + weatherDto.localDate + " is " + weatherDto.weatherText + " and maximum temperature is " + weatherDto.temperature + " .");
        }
    }

    private void fetchFromWeb(String city) throws IOException {
        WeatherProvider weatherProvider = new WeatherProvider();
        FiveDayForecastResult result= weatherProvider.getWeather(city);
        ArrayList<WeatherDto> list = convertToDto(result, city);
        Repo repo = new Repo();
        repo.insert(list);
        printResult(list);

    }
}

