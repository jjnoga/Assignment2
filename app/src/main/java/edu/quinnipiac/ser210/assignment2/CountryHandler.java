package edu.quinnipiac.ser210.assignment2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryHandler {

    private Country countryClass = new Country();
    private String[] countriesList = countryClass.getCountries();
    private final int NUMBER_OF_COUNTRIES = countriesList.length;
    public String[] countries = new String[NUMBER_OF_COUNTRIES];
    public String[] stats = new String[]{"Capital", "Region", "GDP", "Population", "Population Density",
            "Currency", "Country Surface Area", "Male Lifespan", "Female Lifespan"};


    public CountryHandler() {

        for (int i = 0; i < NUMBER_OF_COUNTRIES; i++ ) {
            countries[i] = countriesList[i];
        }
    }

    public String getCountryCapital(String countryCapitalJsonStr) throws JSONException {
        //JSONObject countryCapitalJSONObj = new JSONObject(countryCapitalJsonStr);
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("capital");
    }

}
