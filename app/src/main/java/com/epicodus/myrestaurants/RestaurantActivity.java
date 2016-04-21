package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {
    private TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent myIntent = getIntent();
        String location = myIntent.getStringExtra("location");
        mLocationTextView.setText("Here are the restaurants with the zip code " + location);

    }
}
