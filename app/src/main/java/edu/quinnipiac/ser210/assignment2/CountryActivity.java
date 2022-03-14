package edu.quinnipiac.ser210.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        String country1 = (String) getIntent().getExtras().get("country_1");
        String country2 = (String) getIntent().getExtras().get("country_2");
        String stat = (String) getIntent().getExtras().get("sStat");



    }

    public void goBack(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}