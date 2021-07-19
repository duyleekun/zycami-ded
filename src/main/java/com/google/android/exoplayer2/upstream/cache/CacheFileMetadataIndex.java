/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 */
package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.upstream.cache.CacheFileMetadata;
import com.google.android.exoplayer2.util.Assertions;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class CacheFileMetadataIndex {
    private static final String[] COLUMNS = new String[]{"name", "length", "last_touch_timestamp"};
    private static final int COLUMN_INDEX_LAST_TOUCH_TIMESTAMP = 2;
    private static final int COLUMN_INDEX_LENGTH = 1;
    private static final int COLUMN_INDEX_NAME = 0;
    private static final String COLUMN_LAST_TOUCH_TIMESTAMP = "last_touch_timestamp";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_NAME = "name";
    private static final String TABLE_PREFIX = "ExoPlayerCacheFileMetadata";
    private static final String TABLE_SCHEMA = "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)";
    private static final int TABLE_VERSION = 1;
    private static final String WHERE_NAME_EQUALS = "name = ?";
    private final DatabaseProvider databaseProvider;
    private String tableName;

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void delete(DatabaseProvider databaseProvider, long l10) {
        int n10;
        String string2;
        Object object = Long.toHexString(l10);
        try {
            string2 = CacheFileMetadataIndex.getTableName((String)object);
            databaseProvider = databaseProvider.getWritableDatabase();
            databaseProvider.beginTransactionNonExclusive();
            n10 = 2;
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        try {
            VersionTable.removeVersion((SQLiteDatabase)databaseProvider, n10, (String)object);
            CacheFileMetadataIndex.dropTable((SQLiteDatabase)databaseProvider, string2);
            databaseProvider.setTransactionSuccessful();
            return;
        }
        finally {
            databaseProvider.endTransaction();
        }
    }

    private static void dropTable(SQLiteDatabase sQLiteDatabase, String string2) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "DROP TABLE IF EXISTS ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        sQLiteDatabase.execSQL(string2);
    }

    private Cursor getCursor() {
        Assertions.checkNotNull(this.tableName);
        SQLiteDatabase sQLiteDatabase = this.databaseProvider.getReadableDatabase();
        String string2 = this.tableName;
        String[] stringArray = COLUMNS;
        return sQLiteDatabase.query(string2, stringArray, null, null, null, null, null);
    }

    private static String getTableName(String string2) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = TABLE_PREFIX;
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        return string2;
    }

    /*
     * Unable to fully structure code
     */
    public Map getAll() {
        var1_1 = this.getCursor();
        var3_6 = var1_1.getCount();
        try {
            var2_4 = new HashMap(var3_6);
            while ((var3_6 = (int)var1_1.moveToNext()) != 0) {
                var3_6 = 0;
                var4_7 = null;
            }
        }
        catch (Throwable var2_5) {
            if (var1_1 == null) ** GOTO lbl18
            try {
                var1_1.close();
                ** GOTO lbl18
            }
            catch (Throwable var1_2) {
                try {
                    var2_5.addSuppressed(var1_2);
lbl18:
                    // 3 sources

                    throw var2_5;
                }
                catch (SQLException var1_3) {
                    var2_4 = new DatabaseIOException(var1_3);
                    throw var2_4;
                }
            }
        }
        {
            var4_7 = var1_1.getString(0);
            var5_8 = 1;
            var6_9 = var1_1.getLong(var5_8);
            var8_10 = 2;
            var9_11 = var1_1.getLong(var8_10);
            var11_12 = new CacheFileMetadata(var6_9, var9_11);
            var2_4.put(var4_7, var11_12);
            continue;
        }
        if (var1_1 != null) {
            var1_1.close();
        }
        return var2_4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initialize(long l10) {
        int n12;
        int n10;
        Object object;
        String string2;
        try {
            string2 = Long.toHexString(l10);
            this.tableName = object = CacheFileMetadataIndex.getTableName(string2);
            object = this.databaseProvider;
            object = object.getReadableDatabase();
            n10 = 2;
            int n11 = VersionTable.getVersion((SQLiteDatabase)object, n10, string2);
            n12 = 1;
            if (n11 == n12) return;
            object = this.databaseProvider;
            object = object.getWritableDatabase();
            object.beginTransactionNonExclusive();
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        try {
            VersionTable.setVersion((SQLiteDatabase)object, n10, string2, n12);
            string2 = this.tableName;
            CacheFileMetadataIndex.dropTable((SQLiteDatabase)object, string2);
            string2 = this.tableName;
            String string3 = String.valueOf(string2);
            n10 = string3.length() + 108;
            StringBuilder stringBuilder = new StringBuilder(n10);
            string3 = "CREATE TABLE ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = " ";
            stringBuilder.append(string2);
            string2 = TABLE_SCHEMA;
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object.execSQL(string2);
            object.setTransactionSuccessful();
            return;
        }
        finally {
            object.endTransaction();
        }
    }

    public void remove(String string2) {
        Object object = this.tableName;
        Assertions.checkNotNull(object);
        try {
            object = this.databaseProvider;
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        object = object.getWritableDatabase();
        String string3 = this.tableName;
        String string4 = WHERE_NAME_EQUALS;
        int n10 = 1;
        String[] stringArray = new String[n10];
        stringArray[0] = string2;
        object.delete(string3, string4, stringArray);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeAll(Set iterator2) {
        Object object = this.tableName;
        Assertions.checkNotNull(object);
        try {
            object = this.databaseProvider;
            object = object.getWritableDatabase();
            object.beginTransactionNonExclusive();
        }
        catch (SQLException sQLException) {
            object = new DatabaseIOException(sQLException);
            throw object;
        }
        try {
            boolean bl2;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = iterator2.next();
                object2 = (String)object2;
                String string2 = this.tableName;
                String string3 = WHERE_NAME_EQUALS;
                int n10 = 1;
                String[] stringArray = new String[n10];
                stringArray[0] = object2;
                object.delete(string2, string3, stringArray);
            }
            object.setTransactionSuccessful();
            return;
        }
        finally {
            object.endTransaction();
        }
    }

    public void set(String string2, long l10, long l11) {
        Serializable serializable;
        Object object = this.tableName;
        Assertions.checkNotNull(object);
        try {
            object = this.databaseProvider;
        }
        catch (SQLException sQLException) {
            serializable = new DatabaseIOException(sQLException);
            throw serializable;
        }
        object = object.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String string3 = COLUMN_NAME;
        contentValues.put(string3, string2);
        string2 = COLUMN_LENGTH;
        serializable = Long.valueOf(l10);
        contentValues.put(string2, (Long)serializable);
        string2 = COLUMN_LAST_TOUCH_TIMESTAMP;
        serializable = Long.valueOf(l11);
        contentValues.put(string2, (Long)serializable);
        string2 = this.tableName;
        serializable = null;
        object.replaceOrThrow(string2, null, contentValues);
    }
}

