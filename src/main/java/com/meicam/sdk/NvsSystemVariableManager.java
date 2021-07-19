/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.preference.PreferenceManager
 */
package com.meicam.sdk;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.HashSet;
import java.util.Set;

public class NvsSystemVariableManager {
    public static int getSystemVariableInt(Context context, String string2) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getInt(string2, 0);
    }

    public static String getSystemVariableString(Context context, String string2) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getString(string2, "");
    }

    public static Set getSystemVariableStringSet(Context context, String string2) {
        context = PreferenceManager.getDefaultSharedPreferences((Context)context);
        HashSet hashSet = new HashSet();
        return context.getStringSet(string2, hashSet);
    }

    public static void setSystemVariableInt(Context context, String string2, int n10) {
        context = PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
        context.putInt(string2, n10);
        context.commit();
    }

    public static void setSystemVariableString(Context context, String string2, String string3) {
        context = PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
        context.putString(string2, string3);
        context.commit();
    }

    public static void setSystemVariableStringSet(Context context, String string2, Set set) {
        context = PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
        context.remove(string2);
        context.putStringSet(string2, set);
        context.commit();
    }
}

