package src.UF3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DadesAPI {

    public void getDadesCatalunya() throws IOException, ParseException {
        System.out.println("¿Quin día vols veure? (Format: AAAA-MM-DD)");
        Scanner in = new Scanner(System.in);
        String dataPrint = in.nextLine();

        String URL1 = "https://api.covid19tracking.narrativa.com/api/"+dataPrint+"/country/spain/region/cataluna";

        URL url = new URL(URL1);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
        JSONObject data = (JSONObject) jsonObject.get("dates");
        JSONObject fecha = (JSONObject) data.get(dataPrint);
        JSONObject countries = (JSONObject) fecha.get("countries");
        JSONObject Spain = (JSONObject) countries.get("Spain");
        JSONArray regions = (JSONArray) Spain.get("regions");
        JSONObject region = (JSONObject) regions.get(0);
        System.out.println("A Catalunya hi han hagut : " + region.get("today_new_confirmed") + " casos de CoronaVirus ahir : " + region.get("date"));
    }
    public void getDadesGirona() throws IOException, ParseException{
        System.out.println("¿Quin día vols veure? (Format: AAAA-MM-DD)");
        Scanner in = new Scanner(System.in);
        String dataPrint = in.nextLine();

        String URL1 = "https://api.covid19tracking.narrativa.com/api/"+dataPrint+"/country/spain/region/cataluna";

        URL url = new URL(URL1);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
        JSONObject data = (JSONObject) jsonObject.get("dates");
        JSONObject fecha = (JSONObject) data.get(dataPrint);
        JSONObject countries = (JSONObject) fecha.get("countries");
        JSONObject Spain = (JSONObject) countries.get("Spain");
        JSONArray regions = (JSONArray) Spain.get("regions");
        JSONObject region = (JSONObject) regions.get(0);
        JSONArray subregions = (JSONArray) region.get("sub_regions");
        JSONObject girona = (JSONObject) subregions.get(1);
        System.out.println("A Girona hi han hagut: "+ girona.get("yesterday_confirmed") + " casos de CoronaVirus el día : " + dataPrint);


    }
    public void getDadesMundials() throws IOException, ParseException{
        System.out.println("Quin día vols veure (Format: AAAA-MM-DD)");
        Scanner in = new Scanner(System.in);
        String dataPrintMundial = in.nextLine();
        System.out.println("¿Quin país vols veure? (Format: En Anglés i la primera en majúscula )");
        String paisPrintat = in.nextLine();
        String URL1 = "https://api.covid19tracking.narrativa.com/api/"+dataPrintMundial+"/country/"+paisPrintat;

        URL url = new URL(URL1);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
        JSONObject data = (JSONObject) jsonObject.get("dates");
        JSONObject fecha = (JSONObject) data.get(dataPrintMundial);
        JSONObject countries = (JSONObject) fecha.get("countries");
        JSONObject Pais = (JSONObject) countries.get(paisPrintat);
        System.out.println("A "+ Pais.get("name_es")+ " hi han hagut: "+ Pais.get("yesterday_confirmed") + " casos de CoronaVirus el día : " + dataPrintMundial);
    }
    public void getDadesMundialsInterval() throws IOException, ParseException{
        System.out.println("¿Quin interval vols veure ?(Format: AAAA-MM-DD)");
        Scanner in = new Scanner(System.in);
        String dataPrintMundialStart = in.nextLine();
        String dataPrintMundialFinish = in.nextLine();
        System.out.println("Quin país vols veure (Format: En Anglés i la primera en majúscula )");
        String paisPrintat = in.nextLine();
        String URL1 = "https://api.covid19tracking.narrativa.com/api/country/"+paisPrintat+"?date_from="+dataPrintMundialStart+"&date_to="+dataPrintMundialFinish;

        URL url = new URL(URL1);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
        JSONObject data = (JSONObject) jsonObject.get("dates");
        JSONObject fechaStart = (JSONObject) data.get(dataPrintMundialStart);
        JSONObject countriesStart = (JSONObject) fechaStart.get("countries");
        JSONObject PaisStart = (JSONObject) countriesStart.get(paisPrintat);
        JSONObject fechaFinish = (JSONObject) data.get(dataPrintMundialFinish);
        JSONObject countriesFinish = (JSONObject) fechaFinish.get("countries");
        JSONObject PaisFinish= (JSONObject) countriesFinish.get(paisPrintat);
        Long casosStart= (Long) PaisStart.get("today_confirmed");
        Long casosFin = (Long) PaisFinish.get("today_confirmed");
        Long casosTotal = casosFin-casosStart;
        System.out.println("A "+PaisStart.get("name_es")+ " hi han hagut un total de: "+casosTotal+" casos de CoronaVirus en el interval de : "+dataPrintMundialStart+" a "+dataPrintMundialFinish);
    }

}

