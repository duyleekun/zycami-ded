/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 */
package com.google.android.gms.stats;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.stats.WakeLockTracker;

public abstract class GCoreWakefulBroadcastReceiver
extends WakefulBroadcastReceiver {
    private static String TAG = "GCoreWakefulBroadcastReceiver";

    public static boolean completeWakefulIntent(Context object, Intent intent) {
        Object object2 = null;
        if (intent == null) {
            return false;
        }
        if (object != null) {
            object2 = WakeLockTracker.getInstance();
            ((WakeLockTracker)object2).registerReleaseEvent((Context)object, intent);
        } else {
            object = TAG;
            String string2 = "context shouldn't be null. intent: ";
            object2 = String.valueOf(intent.toUri(0));
            int n10 = ((String)object2).length();
            object2 = n10 != 0 ? string2.concat((String)object2) : new String(string2);
            Log.w((String)object, (String)object2);
        }
        return WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}

