/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 */
package androidx.core.content;

import android.content.SharedPreferences;
import androidx.core.content.SharedPreferencesCompat$EditorCompat$Helper;

public final class SharedPreferencesCompat$EditorCompat {
    private static SharedPreferencesCompat$EditorCompat sInstance;
    private final SharedPreferencesCompat$EditorCompat$Helper mHelper;

    private SharedPreferencesCompat$EditorCompat() {
        SharedPreferencesCompat$EditorCompat$Helper sharedPreferencesCompat$EditorCompat$Helper;
        this.mHelper = sharedPreferencesCompat$EditorCompat$Helper = new SharedPreferencesCompat$EditorCompat$Helper();
    }

    public static SharedPreferencesCompat$EditorCompat getInstance() {
        SharedPreferencesCompat$EditorCompat sharedPreferencesCompat$EditorCompat = sInstance;
        if (sharedPreferencesCompat$EditorCompat == null) {
            sInstance = sharedPreferencesCompat$EditorCompat = new SharedPreferencesCompat$EditorCompat();
        }
        return sInstance;
    }

    public void apply(SharedPreferences.Editor editor) {
        this.mHelper.apply(editor);
    }
}

