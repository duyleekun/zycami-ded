/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.util.Log;

public final class ExoDatabaseProvider
extends SQLiteOpenHelper
implements DatabaseProvider {
    public static final String DATABASE_NAME = "exoplayer_internal.db";
    private static final String TAG = "ExoDatabaseProvider";
    private static final int VERSION = 1;

    public ExoDatabaseProvider(Context context) {
        context = context.getApplicationContext();
        super(context, DATABASE_NAME, null, 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void wipeDatabase(SQLiteDatabase sQLiteDatabase) {
        String string2 = "name";
        Object object = new String[]{"type", string2};
        String string3 = "sqlite_master";
        int n10 = 0;
        Object object2 = sQLiteDatabase;
        Cursor cursor = sQLiteDatabase.query(string3, (String[])object, null, null, null, null, null);
        try {
            boolean bl2;
            while (bl2 = cursor.moveToNext()) {
                bl2 = false;
                string2 = null;
                string2 = cursor.getString(0);
                string3 = "sqlite_sequence";
                int n11 = 1;
                object2 = cursor.getString(n11);
                int n12 = string3.equals(object2);
                if (n12 != 0) continue;
                string3 = String.valueOf(string2);
                n12 = string3.length() + 16;
                object = String.valueOf(object2);
                int n13 = ((String)object).length();
                object = new StringBuilder(n12 += n13);
                string3 = "DROP ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string2);
                string2 = " IF EXISTS ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append((String)object2);
                string2 = ((StringBuilder)object).toString();
                try {
                    sQLiteDatabase.execSQL(string2);
                }
                catch (SQLException sQLException) {
                    string3 = TAG;
                    object = "Error executing ";
                    string2 = String.valueOf(string2);
                    n10 = string2.length();
                    string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
                    Log.e(string3, string2, sQLException);
                }
            }
            return;
        }
        finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        ExoDatabaseProvider.wipeDatabase(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
    }
}

