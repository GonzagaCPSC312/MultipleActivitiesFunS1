package com.sprint.gina.multipleactivitiesfuns1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // get the extra information out
        Intent intent = getIntent();
        if (intent != null) { // good practice
            // grab the extra information using the keys (names)
            String username = intent.getStringExtra("username");
            // username will be null if "username" is not a valid key
            int pin = intent.getIntExtra("pin", 0);
            // pin will be 0 if "pin" is not a valid key
            Toast.makeText(this, username + " " + pin, Toast.LENGTH_SHORT).show();
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set a result for MainActivity (or any activity that starts
                // this activity for a result)
                Intent intent = new Intent();
                intent.putExtra("result", "successful");
                SecondActivity.this.setResult(Activity.RESULT_OK, intent);
                SecondActivity.this.finish();
            }
        });
    }
}