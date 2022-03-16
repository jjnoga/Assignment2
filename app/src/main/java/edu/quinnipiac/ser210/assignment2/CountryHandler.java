/*  CountryHandler.java
    Authors: Aiden Rosen and Joseph Noga
    Class: SER210
    Professor: Rehab ElKharboutly
    Date: 16 March 2022
    Description: The handler that will be used to provide the arrays for the names of the countries and
    the stats available for comparison and the data retrieval of the comparison points from the RestAPI
    to the app.
 */

package edu.quinnipiac.ser210.assignment2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountryHandler {

    //variables
    private Country countryClass = new Country();
    private String[] countriesList = countryClass.getCountries();
    private final int NUMBER_OF_COUNTRIES = countriesList.length;
    public String[] countries = new String[NUMBER_OF_COUNTRIES];
    //stats array contains the choices of the data spinner on the main page
    public String[] stats = new String[]{"Capital", "Region", "GDP", "Population", "Population Density",
            "Currency", "Country Surface Area", "Male Lifespan", "Female Lifespan"};


    //initiates the array of countries which will serve as the list by which the spinners for the countries
    //will adapt to
    public CountryHandler() {

        for (int i = 0; i < NUMBER_OF_COUNTRIES; i++ ) {
            countries[i] = countriesList[i];
        }
    }

    //The following are the methods used to retrieve information from the RestAPI depending on
    //what data the user is looking for. The available stats are listed in the stats array above.

    //retrieves the capital of an inputted country
    public String getCountryCapital(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("capital");
    }

    //retrieves the region of the world the inputted country is in
    public String getCountryRegion(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("region");
    }

    //retrieves the GDP of the country (in millions of USD)
    public String getCountryGDP(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("gdp");
    }

    //retrieves the population of the country (in thousands of people)
    public String getCountryPopulation(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("population");
    }

    //retrieves the population density of the country
    public String getCountryPopulationDensity(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("pop_density");
    }

    //retrieves the name of the country's currency
    public String getCountryCurrency(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getJSONObject("currency").getString("name");
    }

    //retrieves the surface area of the country (in square meters)
    public String getCountrySurfaceArea(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("surface_area");
    }

    //retrieves the lifespan of men in the country in years
    public String getCountryMaleLifespan(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("life_expectancy_male");
    }

    //retrieves the lifespan of women in the country in years
    public String getCountryFemaleLifespan(String countryCapitalJsonStr) throws JSONException {
        JSONArray countryArray = new JSONArray(countryCapitalJsonStr);
        return countryArray.getJSONObject(0).getString("life_expectancy_female");
    }

}
