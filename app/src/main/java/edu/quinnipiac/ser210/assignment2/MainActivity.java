package edu.quinnipiac.ser210.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    CountryHandler countryHandler = new CountryHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryHandler.countries);
        //TODO: Add countries and stats from API to spinner
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, CountryActivity.class);
        Spinner country1 = (Spinner) findViewById(R.id.spinner1);
        Spinner country2 = (Spinner) findViewById(R.id.spinner2);
        Spinner stat = (Spinner) findViewById(R.id.spinnerStat);

        //TODO: Get items from spinners
        //TODO: intent.putExtra
        startActivity(intent);
    }
}