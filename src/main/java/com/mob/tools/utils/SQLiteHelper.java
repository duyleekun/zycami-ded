/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 */
package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mob.tools.utils.SQLiteHelper$SingleTableDB;

public class SQLiteHelper {
    public static void close(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB) {
        SQLiteHelper$SingleTableDB.access$400(sQLiteHelper$SingleTableDB);
    }

    public static int delete(SQLiteHelper$SingleTableDB object, String string2, String[] stringArray) {
        SQLiteHelper$SingleTableDB.access$100((SQLiteHelper$SingleTableDB)object);
        SQLiteDatabase sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300((SQLiteHelper$SingleTableDB)object);
        object = SQLiteHelper$SingleTableDB.access$200((SQLiteHelper$SingleTableDB)object);
        return sQLiteDatabase.delete((String)object, string2, stringArray);
    }

    public static void execSQL(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB, String string2) {
        SQLiteHelper$SingleTableDB.access$100(sQLiteHelper$SingleTableDB);
        SQLiteDatabase sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB);
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB).endTransaction();
                throw throwable2;
            }
        }
        sQLiteDatabase.execSQL(string2);
        string2 = SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB);
        string2.setTransactionSuccessful();
        SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB).endTransaction();
    }

    public static SQLiteHelper$SingleTableDB getDatabase(Context context, String string2) {
        return SQLiteHelper.getDatabase(context.getDatabasePath(string2).getPath(), string2);
    }

    public static SQLiteHelper$SingleTableDB getDatabase(String string2, String string3) {
        SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB = new SQLiteHelper$SingleTableDB(string2, string3, null);
        return sQLiteHelper$SingleTableDB;
    }

    public static int getSize(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB) {
        int n10;
        Cursor cursor;
        block10: {
            block9: {
                SQLiteDatabase sQLiteDatabase;
                SQLiteHelper$SingleTableDB.access$100(sQLiteHelper$SingleTableDB);
                cursor = null;
                try {
                    sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB);
                }
                catch (Throwable throwable) {
                    try {
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw throwable2;
                    }
                }
                String string2 = SQLiteHelper$SingleTableDB.access$200(sQLiteHelper$SingleTableDB);
                cursor = sQLiteDatabase.query(string2, null, null, null, null, null, null);
                if (cursor != null) break block9;
                n10 = 0;
                sQLiteHelper$SingleTableDB = null;
                break block10;
            }
            n10 = cursor.getCount();
        }
        if (cursor != null) {
            cursor.close();
        }
        return n10;
    }

    public static long insert(SQLiteHelper$SingleTableDB object, ContentValues contentValues) {
        SQLiteHelper$SingleTableDB.access$100((SQLiteHelper$SingleTableDB)object);
        SQLiteDatabase sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300((SQLiteHelper$SingleTableDB)object);
        object = SQLiteHelper$SingleTableDB.access$200((SQLiteHelper$SingleTableDB)object);
        return sQLiteDatabase.replace((String)object, null, contentValues);
    }

    public static Cursor query(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB, String[] stringArray, String string2, String[] stringArray2, String string3) {
        SQLiteHelper$SingleTableDB.access$100(sQLiteHelper$SingleTableDB);
        SQLiteDatabase sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB);
        String string4 = SQLiteHelper$SingleTableDB.access$200(sQLiteHelper$SingleTableDB);
        return sQLiteDatabase.query(string4, stringArray, string2, stringArray2, null, null, string3);
    }

    public static Cursor rawQuery(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB, String string2, String[] stringArray) {
        SQLiteHelper$SingleTableDB.access$100(sQLiteHelper$SingleTableDB);
        return SQLiteHelper$SingleTableDB.access$300(sQLiteHelper$SingleTableDB).rawQuery(string2, stringArray);
    }

    public static int update(SQLiteHelper$SingleTableDB object, ContentValues contentValues, String string2, String[] stringArray) {
        SQLiteHelper$SingleTableDB.access$100((SQLiteHelper$SingleTableDB)object);
        SQLiteDatabase sQLiteDatabase = SQLiteHelper$SingleTableDB.access$300((SQLiteHelper$SingleTableDB)object);
        object = SQLiteHelper$SingleTableDB.access$200((SQLiteHelper$SingleTableDB)object);
        return sQLiteDatabase.update((String)object, contentValues, string2, stringArray);
    }
}

