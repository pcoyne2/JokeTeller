package com.coyne.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.coyne.JokeClass;
import com.udacity.coyne.androidlibrary.MainJokeActivity;

import static com.udacity.coyne.androidlibrary.MainJokeActivity.JOKE_EXTRA;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

//        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
        EndpointsAsyncTask task = new EndpointsAsyncTask(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(), MainJokeActivity.class);
                intent.putExtra(JOKE_EXTRA, s);
                startActivity(intent);
            }
        };
        task.execute(new Pair<Context, String>(this, "Manfred"));


//        JokeClass jokeClass = new JokeClass();
//        String joke = jokeClass.GetRandomJoke();
//        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(this, MainJokeActivity.class);
//        intent.putExtra(JOKE_EXTRA, joke);
//        startActivity(intent);
    }


}
