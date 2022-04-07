/*  MainActivity.java
    Authors: Aiden Rosen and Joseph Noga
    Class: SER210
    Professor: Rehab ElKharboutly
    Date: 16 March 2022
    Description: The main meat of the app. Contains the spinners necessary to choose the stat and two countries
    for comparison and the direct connection between the app and the RestAPI.
 */

package edu.quinnipiac.ser210.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

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

public class MainActivity extends AppCompatActivity implements MainFragment.Listener {

    CountryHandler countryHandler = new CountryHandler();
    Spinner country1, country2, stat;

    //"constructor" of the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country1 = (Spinner) this.findViewById(R.id.spinner1);
        country2 = (Spinner) this.findViewById(R.id.spinner2);
        stat = (Spinner) this.findViewById(R.id.spinnerStat);

        //add country names to country spinners
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryHandler.countries);
        country1.setAdapter(countryAdapter);
        country2.setAdapter(countryAdapter);

        //add stat options to stat spinner
        ArrayAdapter<String> statAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryHandler.stats);
        stat.setAdapter(statAdapter);
    }



    @Override
    public void itemClicked(String c1, String c2, String sStat, String s1, String s2) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null)
        {
            MainFragment mainFragment = new MainFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, mainFragment);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            Intent intent = new Intent(this, CountryActivity.class);
            intent.putExtra("country_1", c1);
            intent.putExtra("country_2", c2);
            intent.putExtra("chosenStat", sStat);
            intent.putExtra("stat_1", s1);
            intent.putExtra("stat_2", s2);
            startActivity(intent);

        }
    }
}