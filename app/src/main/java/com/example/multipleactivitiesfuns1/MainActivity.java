package com.example.multipleactivitiesfuns1;

import androidx.annotation.Nullable;
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
    static final String TAG = "MultipleActivitiesFunTag";
    static final int LOGIN_REQUEST_CODE = 1; // identifies a requeset for a result
    // unique integer for each request
    // we use the request code to identify the result in a callback
    // onActivityResult()


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // this callback method is called when there is a result from an actiivty
        // that was started with startActivityForResult

        // good practice
        if (requestCode == LOGIN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // can access the data in the Intent data
            String result = data.getStringExtra("result");
            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText(result);
        }

    }

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

                // 2.
                //startActivity(intent);

                // 3.
                startActivityForResult(intent, LOGIN_REQUEST_CODE);
            }
        });

        Button viewButton = (Button) findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 4. implicit intent example #1
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri guUri = Uri.parse("https://www.gonzaga.edu");
                // uri - uniform resource identifier
                intent.setData(guUri);
                startActivity(intent);

            }
        });

        Button sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5. implicit intent example #2
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain"); // mime type (media)
                intent.putExtra(Intent.EXTRA_TEXT, "My message to send :) :) :)");
                startActivity(intent);
            }
        });
    }
}
