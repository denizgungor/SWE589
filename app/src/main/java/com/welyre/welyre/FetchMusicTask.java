package com.welyre.welyre;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchMusicTask extends AsyncTask<String, Void, String[]> {
    @Override
    protected String[] doInBackground (String... urlStrings) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String musicJsonStr = null;
        String[] resultset = null;
        try {
            URL musicURL = new URL(urlStrings[0]);
            urlConnection = (HttpURLConnection) musicURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream != null) {
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() != 0) {
                    musicJsonStr = buffer.toString();
                    try{
                        resultset = getMusicDataFromJson(musicJsonStr);
                    }
                    catch (JSONException j){
                        Log.e( "JsonError", "Error",j);
                    }
                }

            }

        } catch (IOException e) {
            Log.e("MainActivity", "Error ", e);
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("MainActivity", "Error closing stream", e);
                }
            }
        }
        return resultset ;
    }

    MainDataAdapter dataAdapter;
    public FetchMusicTask(MainDataAdapter musicAdapter){
        dataAdapter = musicAdapter;
    }

    private String[] getMusicDataFromJson(String musicJsonStr) throws JSONException {
        final String message = "message";
        final String body = "body";
        final String track_list = "track_list";
        final String track = "track";

        final String trackID = "track_id";
        final String trackName = "track_name";
        final String trackArtist = "artist_name";
        final String trackAlbum = "album_name";

        JSONObject musicJson = new JSONObject(musicJsonStr);
        JSONObject musicMessage = musicJson.getJSONObject(message);
        JSONObject musicBody = musicMessage.getJSONObject(body);
        JSONArray trackList = musicBody.getJSONArray(track_list);
        String[] resultStrs = new String[trackList.length()];

        for(int i = 0; i < trackList.length(); i++) {

            JSONObject trackData = trackList.getJSONObject(i);
            JSONObject trackObject= trackData.getJSONObject(track);
            String trackidstring = trackObject.getString(trackID);
            String tracknamestring = trackObject.getString(trackName);
            String trackartiststring = trackObject.getString(trackArtist);
            String trackalbumstring = trackObject.getString(trackAlbum);
            resultStrs[i] = tracknamestring +" by " + trackartiststring +" - " + trackalbumstring;

        }
        return resultStrs;
    }

    @Override
    protected void onPostExecute(String[] musicData) {
        super.onPostExecute(musicData);
        for(int i=0; i<musicData.length; i++){
            Log.v("FetchMusicTask", musicData[i]);
        }
        dataAdapter.setMusicData(musicData);
        Log.v("data","1");
    }
}


/*

  URL musicURL = new URL(urlStrings[0]);
            urlConnection = (HttpURLConnection) musicURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream != null) {
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() != 0) {
                    musicJsonStr = buffer.toString();
                }
            }
 */