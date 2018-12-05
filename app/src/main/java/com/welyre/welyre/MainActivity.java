package com.welyre.welyre;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String DEGREE = "\u00b0";
    private static final int FORECAST_LIST_ITEMS = 12;
    private static final String[] FORECASTS = {
            "Mon, Oct 9: 15"+DEGREE, "Tue, Oct 10: 17"+DEGREE, "Wed, Oct 11: 17"+DEGREE,
            "Thu, Oct 12: 19"+DEGREE, "Fri, Oct 13: 19"+DEGREE, "Sat, Oct 14: 18"+DEGREE,
            "Sun, Oct 15: 19"+DEGREE, "Mon, Oct 16: 22"+DEGREE, "Tue, Oct 17: 18"+DEGREE,
            "Wed, Oct 18: 21"+DEGREE, "Thu, Oct 19: 12"+DEGREE, "Fri, Oct 20: 22"+DEGREE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}
