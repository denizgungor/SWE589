package com.welyre.welyre;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.welyre.welyre.sync.ReminderIntentService;
import com.welyre.welyre.sync.ReminderTasks;
import com.welyre.welyre.utilities.NotificationUtils;


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
        dataAdapter = new MainDataAdapter(); /* = new MainDataAdapter(RESULT_LIST_ITEMS, RESULTS );;*/
        incrementDays(Context);
        numberOfItems.setAdapter(dataAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                NotificationUtils.remindUserBecauseCharging(this);

            }
        });
       /* searchFunction(dataAdapter,"rihanna");*/

        SearchView searchView=(SearchView) findViewById(R.id.searchText);
        searchView.setQueryHint("Search View");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                searchFunction(dataAdapter,query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /*searchFunction(dataAdapter,newText);*/
                return false;
            }
        });


    }
    public void incrementDays(View view) {

        Intent incrementDayCountIntent = new Intent(this, ReminderIntentService.class);
        incrementDayCountIntent.setAction(ReminderTasks.ACTION_INCREMENT_DAYSAWAY_COUNT);
        startService(incrementDayCountIntent);
    }


    private void searchFunction(MainDataAdapter dataAdapter, String query){
        String queryTerm=query;
        String musicAPIKey = "29f9c6101570daf924bdf81055f9ba64";
        String musicURL = "https://api.musixmatch.com/ws/1.1/" +
                "track.search?" +
                "q_artist=" +queryTerm+
                "&page_size=20" +
                "&page=1" +
                "&s_track_rating=desc" +
                "&apikey=" + musicAPIKey;

        FetchMusicTask musicTask = new FetchMusicTask(dataAdapter, getApplicationContext(), queryTerm);
        musicTask.execute(musicURL);
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
        Context context = getApplicationContext();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
