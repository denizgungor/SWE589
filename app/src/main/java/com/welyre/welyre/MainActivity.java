package com.welyre.welyre;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private MainDataAdapter dataAdapter;
    private RecyclerView numberOfItems;
    private static final int RESULT_LIST_ITEMS = 9;
    private static final String[] RESULTS = {
            "Artist: Eva Cassidy, Song: Bridge Over troubled water",
            "Artist: Lee Lessack, Song: The look of love",
            "Artist: Marianna Leporace, Song: Bizarre love triangle",
            "Artist: Roberto Gambarini, Song: Smoke gets in your eyes",
            "Artist: Marcela, Song: Loving you",
            "Artist: Kimber Manning, Song: What a wonderful world",
            "Artist: Lona knopfler, Song: Alfie",
            "Artist: Emi Fujita , Song: The rose",
            "Artist: Stacey Kent, Song: You've got a friend",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        numberOfItems = (RecyclerView) findViewById(R.id.rv_result);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numberOfItems.setLayoutManager(layoutManager);
        numberOfItems.setHasFixedSize(true);
        dataAdapter = new MainDataAdapter(RESULT_LIST_ITEMS, RESULTS );
        numberOfItems.setAdapter(dataAdapter);

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
