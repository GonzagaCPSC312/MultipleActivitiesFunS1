package com.sprint.gina.multipleactivitiesfuns1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivityTag";
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Log.d(TAG, "onActivityResult: ");
                        // this callback executes when MainActivity returns from
                        // starting an activity (e.g. SecondActivity) that was
                        // started for a result
                        // BRB
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            String resultStr = data.getStringExtra("result");
                            TextView tv = findViewById(R.id.textView);
                            tv.setText(resultStr);
                        }
                    }
                });

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                // intent: a message to the Android OS
                // specifying our "intent" to start another activity
                // if the intent looks good, Android will start the activity
                // 2 types
                // explicit intent: you know the name of the activity class
                // you want to start
                // implicit intent: you want to let the user choose an app
                // that can respond to the action you want to perform
                // example actions
                // Intent.ACTION_VIEW
                // Intent.ACTION_SEND
                // Intent.ACTION_DIAL
                // Intent.ACTION_WEB_SEARCH

                // explicit intent example
                // lets start our SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // source, destination
                // lets say, SecondActivity needs some data
                // from the MainActivity
                // we can send this data in as "extra" information in the intent
                // using key-value store
                String username = "spike";
                int pin = 1234;
                intent.putExtra("username", username);
                intent.putExtra("pin", pin);
                // lets say, SecondActivity computes a result that we want
                // in MainActivity (so SecondActivity sends the result back)
                // in the NEW WAY: we need an ActivityResultLauncher
//                startActivity(intent);
                launcher.launch(intent);
            }
        });
        
        Button viewButton = findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implicit intent example #1
                // start an activity that can handle and intent
                // for viewing a webpage
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // URI: uniform resource identifier
                Uri guUri = Uri.parse("https://www.gonzaga.edu");
                intent.setData(guUri);
                startActivity(intent);
            }
        });
        
        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implicit intent example #2
                // start an activity to send a simple string message
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain"); // mime type (media)
                String message = "My message to send :) :) :)";
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
            }
        });
    }
}