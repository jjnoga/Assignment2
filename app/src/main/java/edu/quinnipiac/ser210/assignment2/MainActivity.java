package edu.quinnipiac.ser210.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    CountryHandler countryHandler = new CountryHandler();
    Spinner country1, country2, stat;
    String c1, c2, sStat;
    private String url1 = "https://api.api-ninjas.com/v1/country?name=";
    private String key = null; //TODO:  Add key properly.  Github yelled at me for it before.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country1 = (Spinner) findViewById(R.id.spinner1);
        country2 = (Spinner) findViewById(R.id.spinner2);
        stat = (Spinner) findViewById(R.id.spinnerStat);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryHandler.countries);
        //TODO: Add countries and stats from API to spinner
        country1.setAdapter(countryAdapter);
        country2.setAdapter(countryAdapter);

        ArrayAdapter<String> statAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryHandler.stats);
        stat.setAdapter(statAdapter);
    }

    public void onClick(View view)
    {
        c1 = (String) country1.getSelectedItem();
        c2 = (String) country2.getSelectedItem();
        sStat = (String) stat.getSelectedItem();
        new FetchCountryStat().execute(c1, c2, sStat);

    }

    class FetchCountryStat extends AsyncTask<String, Void, String>
    {

        @SuppressLint("RestrictedApi")
        @Override
        protected String doInBackground(String... strings)
        {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String stat1 = "";
            String stat2 = "";
            try
            {
                //String str = strings[0].replaceAll(" ", "_");
                URL url = new URL("https://country-by-api-ninjas.p.rapidapi.com/v1/country?name=" + strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key", "d35f5d26e1mshafc3e3ad636a793p1f9ef0jsnb85767fe0bf6");
                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();
                if(in == null) return null;

                reader = new BufferedReader(new InputStreamReader(in));
                stat1 = getStringFromBuffer(reader);
            }
            catch(Exception e)
            {
               e.printStackTrace();
                return null;
            }
            finally
            {
                if(urlConnection != null) urlConnection.disconnect();
                if(reader != null)
                {
                    try
                    {
                        reader.close();
                    }
                    catch(Exception e)
                    {
                        return null;
                    }
                }
            }

            return stat1;

            //TODO: FIX
        }

        @Override
        protected void onPostExecute(String s)
        {
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);


                intent.putExtra("country_1", c1);
                intent.putExtra("country_2", c2);
                intent.putExtra("chosenStat", sStat);
                intent.putExtra("stat_1", s);
                startActivity(intent);

        }

        private String getStringFromBuffer(BufferedReader reader) throws Exception
        {
            StringBuffer buffer = new StringBuffer();
            String line;

            while((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }

            if(reader != null)
            {
                try
                {
                    reader.close();

                }
                catch(Exception e)
                {
                    return null;
                }
            }

            String result = "";
            if (sStat.equals("Capital"))
            {
                result = countryHandler.getCountryCapital(buffer.toString());
            }
            else if (sStat.equals("Region"))
            {
                result = countryHandler.getCountryRegion(buffer.toString());
            }
            else if (sStat.equals("GDP"))
            {
                result = countryHandler.getCountryGDP(buffer.toString());
            }
            else if (sStat.equals("Population"))
            {
                result = countryHandler.getCountryPopulation(buffer.toString());
            }
            else if (sStat.equals("Population Density"))
            {
                result = countryHandler.getCountryPopulationDensity(buffer.toString());
            }
            else if (sStat.equals("Currency"))
            {
                result = countryHandler.getCountryCurrency(buffer.toString());
            }
            else if (sStat.equals("Surface Area"))
            {
                result = countryHandler.getCountrySurfaceArea(buffer.toString());
            }
            else if (sStat.equals("Male Lifespan"))
            {
                result = countryHandler.getCountryMaleLifespan(buffer.toString());
            }
            else if (sStat.equals("Female Lifespan"))
            {
                result = countryHandler.getCountryFemaleLifespan(buffer.toString());
            }
            return result;
        }

    }
}