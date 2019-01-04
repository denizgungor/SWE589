package com.welyre.welyre.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LyricsDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "lyrics.db";

    public LyricsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_SEARCH_TABLE = "CREATE TABLE " + LyricsContract.SearchEntry.TABLE_NAME + " (" +
                LyricsContract.SearchEntry.SEARCH_ID + " INTEGER PRIMARY KEY," +
                LyricsContract.SearchEntry.KEYWORD+ " TEXT NOT NULL " + " );";

      /*  final String SQL_CREATE_SECOND_TABLE = "CREATE TABLE " + LyricsContract.ArtistEntry.TABLE_NAME + " (" +
                LyricsContract.ArtistEntry._ID + " INTEGER PRIMARY KEY," +
                LyricsContract.ArtistEntry.X + " TEXT UNIQUE NOT NULL, " +
                LyricsContract.ArtistEntry.Y + " TEXT NOT NULL, " +
                LyricsContract.ArtistEntry.Z + " REAL NOT NULL, " +
                LyricsContract.ArtistEntry.V + " REAL NOT NULL " + " );";

*/
        sqLiteDatabase.execSQL(SQL_CREATE_SEARCH_TABLE);
        Log.v("DB","Created the database");
       // sqLiteDatabase.execSQL(SQL_CREATE_SECOND_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LyricsContract.SearchEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
