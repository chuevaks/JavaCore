package lesson6.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class WeatherProvider {

    static Properties prop = new Properties();

    static {
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadProperties() throws IOException {
        try (FileInputStream configFile = new FileInputStream("src/main/resources/lesson6.properties")) {
            prop.load(configFile);
        }
    }

    public FiveDayForecastResult getWeather(String cityName) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_URL"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                .addPathSegment(getCityKey(cityName))
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

        FiveDayForecastResult result = mapper.readValue(reader, FiveDayForecastResult.class);
        return result;
    }

    private String getCityKey(String cityName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient client = new OkHttpClient();
        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_URL"))
                .addPathSegment("locations")
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", prop.getProperty("API_KEY"))
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();


        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String foundCityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }


}
