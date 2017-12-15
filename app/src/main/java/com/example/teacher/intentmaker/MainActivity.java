package com.example.teacher.intentmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView quoteText;
    ProgressBar progressBar;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteText = findViewById(R.id.quote);
        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        progressBar.setProgress(++count);
                    } catch (Exception e) {

                    }
                }
            }
        });
        thread.start();

        Button myButton = new Button(this);
        myButton.setText("Push Me");
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent someIntent = new Intent(getApplicationContext(), SomeActivity.class);
                someIntent.putExtra("greeting", "привет");
                startActivity(someIntent);
            }
        });

        LinearLayout ll = (LinearLayout)findViewById(R.id.layout);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);

    }

    public void makeQuote(View view) {
        String[] quotes = getResources().getStringArray(R.array.quotes);
        progressBar.setProgress(++count);
        switch (view.getId()) {
            case R.id.eatButton: quoteText.setText(quotes[0]); break;
            case R.id.sleepButton: quoteText.setText(quotes[1]); break;
            case R.id.studyButton: quoteText.setText(quotes[2]); break;
        }
    }
}
