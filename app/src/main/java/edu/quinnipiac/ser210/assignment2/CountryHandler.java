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
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("capital");
    }

    public String getCountryRegion(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("region");
    }

    public String getCountryGDP(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return "$" + countryArray.getJSONObject(0).getString("gdp") + " million";
    }

    public String getCountryPopulation(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("population") + " thousand people";
    }

    public String getCountryPopulationDensity(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("pop_density");
    }

    public String getCountryCurrency(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getJSONObject("currency").getString("name");
    }

    public String getCountrySurfaceArea(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("surface_area") + " m^2";
    }

    public String getCountryMaleLifespan(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("life_expectancy_male") + " years";
    }

    public String getCountryFemaleLifespan(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("life_expectancy_female") + " years";
    }

}
