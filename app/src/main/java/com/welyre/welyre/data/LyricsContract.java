package com.welyre.welyre.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class LyricsContract {

    public static final String CONTENT_AUTHORITY = "com.welyre.welyre";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_WEATHER = "first";
    public static final String PATH_LOCATION = "second";

    public static final class ArtistEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon() .appendPath(PATH_LOCATION)
                .build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;

        public static final String TABLE_NAME = "artist";
        public static final String X = "artist";
        public static final String Y = "artist";
        public static final String Z = "artist";
        public static final String V = "artist";


        public static Uri buildLocationUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildWeatherLocationWithDate(String locationSetting, long date) {
            return CONTENT_URI.buildUpon()
                .appendPath(locationSetting)
                .appendPath(Long.toString(date))
                .build();
        }

        // Method for building a Location and Date URI with Start Date as a Query Param (Type 5)
        public static Uri buildWeatherLocationWithStartDate(String locationSetting, long startDate) {
            return CONTENT_URI.buildUpon()
                .appendPath(locationSetting)
                .appendQueryParameter(Y, Long.toString(startDate))
                .build();

        }

        public static String getLocationSettingFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
        // Based on our URI definitions, the second path of the URI will be the "Date" information. // Therefore, we are getting the second path segment to get the date information
        public static long getDateFromUri(Uri uri) {
            return Long.parseLong(uri.getPathSegments().get(2));
        }

        public static long getStartDateFromUri(Uri uri) {
            String dateString = uri.getQueryParameter(X);
            if (null != dateString && dateString.length() > 0)
                return Long.parseLong(dateString);
            else
                return 0;
        }


    }


    public static final class LyricsEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon() .appendPath(PATH_LOCATION)
                .build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_LOCATION;

        public static final String TABLE_NAME = "artist";
        public static final String X = "artist";
        public static final String Y = "artist";
        public static final String Z = "artist";
        public static final String V = "artist";

        public static Uri buildLocationUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }






}
