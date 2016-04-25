package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {
    public static final String TAG = RestaurantActivity.class.getSimpleName();
    private TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent myIntent = getIntent();
        String location = myIntent.getStringExtra("location");
        getRestaurants(location);
        mLocationTextView.setText("Here are the restaurants with the zip code " + location);

    }

    private void getRestaurants(String location) {
        YelpService.findRestaurants(location, new Callback() {
            @Override
            public void onFailure(Call call, IOEXCEPTION e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v(TAG, jsonData);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
