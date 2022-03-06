package lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson6.dto.DailyForecast;
import lesson6.dto.FiveDayForecastResult;
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
    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {

        loadProperties();
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_URL"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                .addPathSegment(prop.getProperty("SAINT_PETERSBURG_KEY"))
                .addQueryParameter("apikey", prop.getProperty("API_KEY"))
                .addQueryParameter("language", "en-us")
                .addQueryParameter("metric", "true")
                .build();

        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        ObjectMapper mapper = new ObjectMapper();
        StringReader reader = new StringReader(jsonResponse);

        FiveDayForecastResult result = mapper.readValue(reader,FiveDayForecastResult.class);
        printResult(result);


    }

    private static void loadProperties() throws IOException {
        try (FileInputStream configFile = new FileInputStream("src/main/resources/lesson6.properties")) {
            prop.load(configFile);
        }
    }

    private static void printResult(FiveDayForecastResult forecast){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        for (DailyForecast dailyForecast: forecast.dailyForecasts) {

            System.out.println("The weather in " + prop.getProperty("CITY") + " on " + format.format(dailyForecast.date)+ " is " +dailyForecast.day.iconPhrase.toLowerCase(Locale.ROOT)+" and maximum temperature is "+ dailyForecast.temperature.maximum.value+" "+dailyForecast.temperature.maximum.unit+".");

        }

    }
}
