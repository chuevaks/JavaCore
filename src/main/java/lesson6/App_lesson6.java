package lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson6.dto.DailyForecast;
import lesson6.dto.FiveDayForecastResult;
import lesson6.dto.WeatherProvider;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

public class App_lesson6 {


    public static void main(String[] args) throws IOException {

        String cityName = "Saint Petersburg";
        WeatherProvider weatherProvider = new WeatherProvider();
        printResult(weatherProvider.getWeather(cityName), cityName);
    }


    private static void printResult(FiveDayForecastResult forecast, String cityName){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        for (DailyForecast dailyForecast: forecast.dailyForecasts) {

            System.out.println("The weather in " + cityName + " on " + format.format(dailyForecast.date)+ " is " +dailyForecast.day.iconPhrase.toLowerCase(Locale.ROOT)+" and maximum temperature is "+ dailyForecast.temperature.maximum.value+" "+dailyForecast.temperature.maximum.unit+".");

        }

    }
}
