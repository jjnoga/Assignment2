package edu.quinnipiac.ser210.assignment2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CountryFragmentLand extends Fragment
{
	private boolean blueMode, helping = false;
	private String country1, country2, stat1, stat2, sStat;
	private ShareActionProvider provider;
	private View view;

	public CountryFragmentLand()
	{
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

	}

	//Inflates the toolbar with the menu options
	@SuppressLint("ResourceType")
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater.inflate(R.menu.menu_main, menu);
		MenuItem item = menu.findItem(R.id.share);
		provider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
		setShareActionIntent();
		super.onCreateOptionsMenu(menu, inflater);
	}

	//Activates the share button
	private void setShareActionIntent()
	{
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, "Look at this awesome app I used to compare countries' statistics!");
		provider.setShareIntent(intent);
	}

	//Logic for determining which toolbar icon is pressed, and what to do after its pressed
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item)
	{
		int id = item.getItemId();
		switch(id)
		{
			case R.id.change_background: //Change background code
				View mainFrag = (View) getActivity().findViewById(R.id.fragment_container_land_1);
				View countryFrag = (View) getActivity().findViewById(R.id.fragment_container_land_2);
				if(blueMode)
				{
					mainFrag.setBackgroundColor(Color.parseColor("#FFFFFF"));
					countryFrag.setBackgroundColor(Color.parseColor("#FFFFFF"));
					blueMode = false;
				}
				else
				{
					mainFrag.setBackgroundColor(Color.parseColor("#00FFFF"));
					countryFrag.setBackgroundColor(Color.parseColor("#00FFFF"));
					blueMode = true;
				}
				return true;
			case R.id.help: //Help button code
				TextView help = (TextView) getActivity().findViewById(R.id.apiInfo);
				if(helping)
				{
					help.setText("");
					helping = false;
				}
				else
				{
					//Makes the help link clickable in app
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





	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		view = inflater.inflate(R.layout.fragment_country, container, false);
		//Initialize and set the toolbar
		Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
		((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
		setHasOptionsMenu(true);

		//If in portrait mode, get the data from the intent
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT && getActivity().getIntent().getExtras() != null)
		{
			country1 = (String) getActivity().getIntent().getExtras().get("country_1");
			country2 = (String) getActivity().getIntent().getExtras().get("country_2");
			sStat = (String) getActivity().getIntent().getExtras().get("chosenStat");
			stat1 = (String) getActivity().getIntent().getExtras().get("stat_1");
			stat2 = (String) getActivity().getIntent().getExtras().get("stat_2");

			//Assign the TextViews to java variables
			TextView c1 = (TextView) view.findViewById(R.id.country1);
			TextView c2 = (TextView) view.findViewById(R.id.country2);
			TextView statName = (TextView) view.findViewById(R.id.statName);
			TextView s1 = (TextView) view.findViewById(R.id.stat1);
			TextView s2 = (TextView) view.findViewById(R.id.stat2);

			//Combine everything and set the text
			c1.setText(country1 + ":");
			c2.setText(country2 + ":");
			statName.setText(sStat);
			s1.setText(stat1);
			s2.setText(stat2);
		}
		return view;
	}

	public void setTexts(String c1, String c2, String sStat, String s1, String s2)
	{
		TextView tc1 = (TextView) view.findViewById(R.id.country1);
		TextView tc2 = (TextView) view.findViewById(R.id.country2);
		TextView statName = (TextView) view.findViewById(R.id.statName);
		TextView ts1 = (TextView) view.findViewById(R.id.stat1);
		TextView ts2 = (TextView) view.findViewById(R.id.stat2);

		tc1.setText(c1);
		tc2.setText(c2);
		statName.setText(sStat);
		ts1.setText(s1);
		ts2.setText(s2);
	}
}