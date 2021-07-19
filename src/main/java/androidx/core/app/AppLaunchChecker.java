/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class AppLaunchChecker {
    private static final String KEY_STARTED_FROM_LAUNCHER = "startedFromLauncher";
    private static final String SHARED_PREFS_NAME = "android.support.AppLaunchChecker";

    public static boolean hasStartedFromLauncher(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_NAME, 0).getBoolean(KEY_STARTED_FROM_LAUNCHER, false);
    }

    public static void onActivityCreate(Activity activity) {
        boolean bl2;
        String string2;
        String string3 = null;
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SHARED_PREFS_NAME, 0);
        boolean bl3 = sharedPreferences.getBoolean(string2 = KEY_STARTED_FROM_LAUNCHER, false);
        if (bl3) {
            return;
        }
        if ((activity = activity.getIntent()) == null) {
            return;
        }
        String string4 = "android.intent.action.MAIN";
        string3 = activity.getAction();
        bl3 = string4.equals(string3);
        if (bl3 && ((bl3 = activity.hasCategory(string3 = "android.intent.category.LAUNCHER")) || (bl2 = activity.hasCategory(string3 = "android.intent.category.LEANBACK_LAUNCHER")))) {
            activity = sharedPreferences.edit();
            boolean bl4 = true;
            activity = activity.putBoolean(string2, bl4);
            activity.apply();
        }
    }
}

