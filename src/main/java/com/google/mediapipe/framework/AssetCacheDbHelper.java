/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.google.mediapipe.framework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.FluentLogger$Api;
import java.io.File;

public class AssetCacheDbHelper
extends SQLiteOpenHelper {
    private static final String COMMA_SEP = ",";
    public static final String DATABASE_NAME = "mediapipe.db";
    public static final int DATABASE_VERSION = 2;
    private static final String INT_TYPE = " INTEGER";
    private static final String SQL_CREATE_TABLE = "CREATE TABLE AssetVersion (_id INTEGER PRIMARY KEY,asset TEXT NOT NULL UNIQUE,cache_path TEXT,version INTEGER )";
    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS AssetVersion";
    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_UNIQUE_TYPE = " TEXT NOT NULL UNIQUE";
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public AssetCacheDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    private Cursor queryAssetCacheTable(SQLiteDatabase sQLiteDatabase, String[] stringArray, String string2, String[] stringArray2) {
        return sQLiteDatabase.query("AssetVersion", stringArray, string2, stringArray2, null, null, null);
    }

    private void removeCachedFiles(SQLiteDatabase sQLiteDatabase, String string2, String[] object) {
        String string3 = "cache_path";
        Object object2 = new String[]{string3};
        int n10 = (sQLiteDatabase = this.queryAssetCacheTable(sQLiteDatabase, (String[])object2, string2, (String[])object)).moveToFirst();
        if (n10 != 0) {
            do {
                boolean bl2;
                boolean bl3;
                if (!(bl3 = ((File)(object = new File(string2 = sQLiteDatabase.getString(n10 = sQLiteDatabase.getColumnIndexOrThrow(string3))))).exists()) || (bl2 = ((File)object).delete())) continue;
                object = (FluentLogger$Api)logger.atWarning();
                object2 = "Stale cached file: %s can't be deleted.";
                object.log((String)object2, string2);
            } while ((n10 = (int)(sQLiteDatabase.moveToNext() ? 1 : 0)) != 0);
        }
        sQLiteDatabase.close();
    }

    public boolean checkVersion(String string2, int n10) {
        SQLiteDatabase sQLiteDatabase = this.getReadableDatabase();
        String string3 = "version";
        String[] stringArray = new String[]{string3};
        boolean bl2 = true;
        String[] stringArray2 = new String[bl2];
        stringArray2[0] = string2;
        string2 = this.queryAssetCacheTable(sQLiteDatabase, stringArray, "asset = ?", stringArray2);
        int n11 = string2.getCount();
        if (n11 == 0) {
            return false;
        }
        string2.moveToFirst();
        n11 = string2.getColumnIndexOrThrow(string3);
        n11 = string2.getInt(n11);
        string2.close();
        if (n11 != n10) {
            bl2 = false;
        }
        return bl2;
    }

    public void insertAsset(String object, String string2, int n10) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        int n11 = 2;
        ContentValues contentValues = new String[n11];
        contentValues[0] = object;
        int n12 = 1;
        contentValues[n12] = string2;
        this.removeCachedFiles(sQLiteDatabase, "asset = ? and cache_path != ?", (String[])contentValues);
        contentValues = new ContentValues();
        String string3 = "asset";
        contentValues.put(string3, (String)object);
        contentValues.put("cache_path", string2);
        object = n10;
        contentValues.put("version", (Integer)object);
        object = "AssetVersion";
        string2 = null;
        n10 = 5;
        long l10 = sQLiteDatabase.insertWithOnConflict((String)object, null, contentValues, n10);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            return;
        }
        object = new RuntimeException("Can't insert entry into the mediapipe db.");
        throw object;
    }

    public void invalidateCache(int n10) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        String string2 = Integer.toString(n10);
        String[] stringArray = new String[]{string2};
        string2 = "version != ?";
        this.removeCachedFiles(sQLiteDatabase, string2, stringArray);
        sQLiteDatabase.delete("AssetVersion", string2, stringArray);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        this.onUpgrade(sQLiteDatabase, n10, n11);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        sQLiteDatabase.execSQL(SQL_DELETE_TABLE);
        this.onCreate(sQLiteDatabase);
    }
}

