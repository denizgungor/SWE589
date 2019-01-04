package com.welyre.welyre.sync;

import android.content.Context;

public class ReminderTasks {
    public static final String ACTION_INCREMENT_DAYSAWAY_COUNT = "increment-days-count";
    public static void executeTask(Context context, String action){
        if (ACTION_INCREMENT_DAYSAWAY_COUNT.equals(action)){
            incrementDaysCount(context);
        }
    }
    private static void incrementDaysCount(Context context){
       // PreferenceUtilities.incrementDaysCount(context);
    }
}
