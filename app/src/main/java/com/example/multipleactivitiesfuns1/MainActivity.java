package com.example.multipleactivitiesfuns1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MultipleActivitiesFunTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(TAG, "onClick: ");

                // intent: a message to the Android OS
                // specifying our "intent" to start another activity
                // if our intent looks good, Android will start the activity
                // explicit intent: we know the name of the activity
                // class we want to start
                // implicit intent: we'll let the user choose which activity
                // to start that will perform our specified action
                // example actions
                // Intent.ACTION_VIEW
                // Intent.ACTION_SEND
                // Intent.ACTION_DIAL
                // Intent.ACTION_WEB_SEARCH


                // 1. explicit intent example
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // source, destination
                // lets say SecondActivity needs a username and pin
                // that MainActivity collected from the user

                // 2.
                String username = "spike";
                int pin = 1234;
                // we can put extra data into our intent as key-value pairs
                // like dictionary or hash map
                intent.putExtra("username", username);
                intent.putExtra("pin", pin);
                startActivity(intent);
            }
        });
    }
}
