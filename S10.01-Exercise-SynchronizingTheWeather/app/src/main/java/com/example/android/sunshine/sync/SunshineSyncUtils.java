package com.example.android.sunshine.sync;// COMPLETE (9) Create a class called SunshineSyncUtils
//  COMPLETE (10) Create a public static void method called startImmediateSync
//  COMPLETE (11) Within that method, start the SunshineSyncIntentService

import android.content.Context;
import android.content.Intent;

public class SunshineSyncUtils {
    public static void startImmediateSync(Context context) {
        Intent intentSyncImmediately = new Intent(context, SunshineSyncIntentService.class);
        context.startService(intentSyncImmediately);
    }
}