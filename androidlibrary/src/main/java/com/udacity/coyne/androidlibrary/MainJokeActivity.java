package com.udacity.coyne.androidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        Intent intent = getIntent();
        if(intent != null){
            String joke = intent.getStringExtra(JOKE_EXTRA);
            TextView jokeTextView = (TextView)findViewById(R.id.joke_text_view);
            jokeTextView.setText(joke);
        }
    }
}
