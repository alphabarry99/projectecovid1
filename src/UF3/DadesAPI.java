package src.UF3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DadesAPI {

    public void dadesCatalunya() throws IOException, ParseException {
        String URL1 = "https://api.covid19tracking.narrativa.com/api/2020-04-19/country/spain/region/cataluna";

        URL url = new URL(URL1);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
        JSONObject data = (JSONObject) jsonObject.get("dates");
        JSONObject fecha = (JSONObject) data.get("2020-04-19");
        JSONObject countries = (JSONObject) fecha.get("countries");
        JSONObject Spain = (JSONObject) countries.get("Spain");
        JSONArray regions = (JSONArray) Spain.get("regions");
        JSONObject region = (JSONObject) regions.get(0);
        System.out.println("A Catalunya hi han hagut : " + region.get("today_new_confirmed") + " casos de CoronaVirus avui, ahir " + region.get("date"));
    }
}

