/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final String DEFAULT_USER_AGENT;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.13.2";
    public static final int VERSION_INT = 2013002;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.13.2";
    private static final HashSet registeredModules;
    private static String registeredModulesString;

    static {
        HashSet hashSet = Build.VERSION.RELEASE;
        int n10 = String.valueOf(hashSet).length() + 57;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("ExoPlayerLib/2.13.2 (Linux; Android ");
        stringBuilder.append((String)((Object)hashSet));
        stringBuilder.append(") ");
        stringBuilder.append(VERSION_SLASHY);
        DEFAULT_USER_AGENT = stringBuilder.toString();
        registeredModules = hashSet = new HashSet();
        registeredModulesString = "goog.exo.core";
    }

    private ExoPlayerLibraryInfo() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void registerModule(String string2) {
        Class<ExoPlayerLibraryInfo> clazz = ExoPlayerLibraryInfo.class;
        synchronized (clazz) {
            Object object = registeredModules;
            boolean bl2 = ((HashSet)object).add(string2);
            if (bl2) {
                object = registeredModulesString;
                String string3 = String.valueOf(object);
                int n10 = string3.length() + 2;
                CharSequence charSequence = String.valueOf(string2);
                int n11 = ((String)charSequence).length();
                charSequence = new StringBuilder(n10 += n11);
                ((StringBuilder)charSequence).append((String)object);
                object = ", ";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(string2);
                registeredModulesString = string2 = ((StringBuilder)charSequence).toString();
            }
            return;
        }
    }

    public static String registeredModules() {
        Class<ExoPlayerLibraryInfo> clazz = ExoPlayerLibraryInfo.class;
        synchronized (clazz) {
            String string2 = registeredModulesString;
            return string2;
        }
    }
}

