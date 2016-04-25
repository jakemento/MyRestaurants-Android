package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.myrestaurants.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mfindRestaurants;
    private EditText mLocationEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfindRestaurants = (Button) findViewById(R.id.findRestaurants);
        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mfindRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String location = mLocationEditText.getText().toString();
                Log.d(TAG, location);
               Intent myIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                myIntent.putExtra("location", location);
                startActivity(myIntent);

            }
        });
    }
}
