package edu.quinnipiac.ser210.assignment2;

import org.json.JSONException;
import org.json.JSONObject;

public class CountryHandler {

    private final int NUMBER_OF_COUNTRIES = 196;
    final public String[] countries = new String[NUMBER_OF_COUNTRIES];

    public CountryHandler() {

        int i = 0;
        for (int yr = 0; yr <= NUMBER_OF_COUNTRIES; yr++)
            countries[i++] = Integer.toString(yr);
    }

    public String getCountryCapital(String countryCapitalJsonStr) throws JSONException {
        JSONObject countryCapitalJSONObj = new JSONObject(countryCapitalJsonStr);
        return countryCapitalJSONObj.getString("capital");
    }

}
