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
    private String url1 = "country-by-api-ninjas.p.rapidapi.com/v1/";
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
        String stat1, stat2;

        @SuppressLint("RestrictedApi")
        @Override
        protected String doInBackground(String... strings)
        {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            try
            {
                URL url = new URL(url1 + strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key", key);
                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();
                if(in == null) return null;

                reader = new BufferedReader(new InputStreamReader(in));
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

            return null;

            //TODO: FIX
        }

        @Override
        protected void onPostExecute(String s)
        {
            Intent intent = new Intent(MainActivity.this, CountryActivity.class);


            intent.putExtra("country_1", c1);
            intent.putExtra("country_2", c2);
            intent.putExtra("chosenStat", sStat);
            startActivity(intent);

        }

        private String getStringFromBuffer(BufferedReader reader)
        {
            StringBuffer buffer = new StringBuffer();
            String line;
            if(reader != null)
            {
                try
                {
                    while((line = reader.readLine()) != null)
                    {
                        buffer.append(line + "\n");
                    }
                    reader.close();
                    return countryHandler.getCountryCapital(buffer.toString());
                }
                catch(Exception e)
                {
                    return null;
                }
            }
            else return null;
        }

    }
}