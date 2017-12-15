package com.example.teacher.intentmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SomeActivity extends AppCompatActivity {
    TextView quoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);
        Intent intent = getIntent();

        quoteText = findViewById(R.id.textView);
        quoteText.setText(intent.getStringExtra("greeting"));
    }
}
