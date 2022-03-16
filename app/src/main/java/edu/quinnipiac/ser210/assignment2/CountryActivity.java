package edu.quinnipiac.ser210.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.widget.TextView;

import org.w3c.dom.Text;

public class CountryActivity extends AppCompatActivity {

    private boolean blueMode, helping = false;
    private String country1, country2, stat1, stat2, sStat;
    private ShareActionProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        country1 = (String) getIntent().getExtras().get("country_1");
        country2 = (String) getIntent().getExtras().get("country_2");
        sStat = (String) getIntent().getExtras().get("chosenStat");
        stat1 = (String) getIntent().getExtras().get("stat_1");
        stat2 = (String) getIntent().getExtras().get("stat_2");

        TextView c1 = (TextView) findViewById(R.id.country1);
        TextView c2 = (TextView) findViewById(R.id.country2);
        TextView statName = (TextView) findViewById(R.id.statName);
        TextView s1 = (TextView) findViewById(R.id.stat1);
        TextView s2 = (TextView) findViewById(R.id.stat2);

        c1.setText(country1 + ":");
        c2.setText(country2 + ":");
        statName.setText(sStat);
        s1.setText(stat1);
        s2.setText(stat2);

    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.share);
        provider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        setShareActionIntent();
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Look at this awesome app I used to compare countries' statistics!");
        provider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();
        switch(id)
        {
            case R.id.change_background:
                View thisView = (View) findViewById(R.id.country_activity);
                if(blueMode)
                {
                    thisView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    blueMode = false;
                }
                else
                {
                    thisView.setBackgroundColor(Color.parseColor("#00FFFF"));
                    blueMode = true;
                }
                return true;
            case R.id.help:
                TextView help = (TextView) findViewById(R.id.apiInfo);
                if(helping)
                {
                    help.setText("");
                    helping = false;
                }
                else
                {
                    help.setClickable(true);
                    help.setMovementMethod(LinkMovementMethod.getInstance());
                    String link = "https://rapidapi.com/apininjas/api/country-by-api-ninjas/";
                    help.setText(Html.fromHtml(link, Html.FROM_HTML_MODE_COMPACT));
                    helping = true;
                }
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void goBack(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}