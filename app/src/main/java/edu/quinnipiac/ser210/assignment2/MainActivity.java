package edu.quinnipiac.ser210.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CountryHandler countryHandler = new CountryHandler();
    Spinner country1, country2, stat;

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
        Intent intent = new Intent(this, CountryActivity.class);


        //TODO: Get items from spinners
        String c1 = (String) country1.getSelectedItem();
        String c2 = (String) country2.getSelectedItem();
        String sStat = (String) stat.getSelectedItem();

        //TODO: intent.putExtra

        intent.putExtra("country_1", c1);
        intent.putExtra("country_2", c2);
        intent.putExtra("chosenStat", sStat);
        startActivity(intent);
    }
}