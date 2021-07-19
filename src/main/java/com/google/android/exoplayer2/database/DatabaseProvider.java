/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseProvider {
    public static final String TABLE_PREFIX = "ExoPlayer";

    public SQLiteDatabase getReadableDatabase();

    public SQLiteDatabase getWritableDatabase();
}

