package com.example.multipleactivitiesfuns1;

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

        // 2.
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("username");
            // getStringExtra() returns null if it doesn't find username
            int pin = intent.getIntExtra("pin", 0);
            // getIntExtra() will return 0 if it doesn't find pin
            Toast.makeText(this, username + " " + pin, Toast.LENGTH_SHORT).show();
        }

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 3. send a result back to MainActivity
                Intent intent = new Intent();
                intent.putExtra("result", "successful");
                setResult(Activity.RESULT_OK, intent);
                SecondActivity.this.finish();
            }
        });
    }
}
