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
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, CountryActivity.class);


        //TODO: Get items from spinners
        //TODO: intent.putExtra
        startActivity(intent);
    }
}