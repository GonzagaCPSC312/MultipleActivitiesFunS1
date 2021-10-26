package com.sprint.gina.multipleactivitiesfuns1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        // goal: parse the message out of the Intent that started this activity
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getAction().equals(Intent.ACTION_SEND)) {
                if (intent.getType().equals("text/plain")) {
                    String message = intent.getStringExtra(Intent.EXTRA_TEXT);
                    TextView tv = findViewById(R.id.textView2);
                    tv.setText(message);
                }
            }
        }
    }
}