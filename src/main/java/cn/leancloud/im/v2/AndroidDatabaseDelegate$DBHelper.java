/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package cn.leancloud.im.v2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.leancloud.AVLogger;
import cn.leancloud.im.v2.AndroidDatabaseDelegate;

public class AndroidDatabaseDelegate$DBHelper
extends SQLiteOpenHelper {
    public static final String CONVERSATION_CREATE_SQL = "CREATE TABLE IF NOT EXISTS conversations (conversation_id VARCHAR(32) NOT NULL,expireAt NUMBERIC,attr BLOB,instanceData BLOB,updatedAt VARCHAR(32),createdAt VARCHAR(32),creator TEXT,members TEXT,isTransient INTEGER,unread_count INTEGER,readAt NUMBERIC,deliveredAt NUMBERIC,lm NUMBERIC,last_message TEXT,mentioned INTEGER default 0,last_msg_iType INTEGER default 0, sys INTEGER default 0, temp INTEGER default 0, temp_ttl NUMBERIC, PRIMARY KEY(conversation_id))";
    public static final String MESSAGE_CREATE_SQL = "CREATE TABLE IF NOT EXISTS messages (conversation_id VARCHAR(32) NOT NULL, message_id VARCHAR(32) NOT NULL, timestamp NUMBERIC, from_peer_id TEXT NOT NULL, receipt_timestamp NUMBERIC, readAt NUMBERIC, updateAt NUMBERIC, payload BLOB, status INTEGER, breakpoint INTEGER, dtoken VARCHAR(32), mentionAll INTEGER default 0, mentionList TEXT NULL, iType INTEGER default 0, PRIMARY KEY(conversation_id,message_id)) ";
    public static final String MESSAGE_UNIQUE_INDEX_SQL = "CREATE UNIQUE INDEX IF NOT EXISTS message_index on messages (conversation_id, timestamp, message_id) ";

    public AndroidDatabaseDelegate$DBHelper(Context context, String string2) {
        string2 = AndroidDatabaseDelegate$DBHelper.getDatabasePath(string2);
        super(context, string2, null, 10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean columnExists(SQLiteDatabase sQLiteDatabase, String string2, String string3) {
        boolean bl2 = false;
        try {
            sQLiteDatabase = sQLiteDatabase.query(string2, null, null, null, null, null, null);
        }
        catch (Exception exception) {
            return bl2;
        }
        int n10 = sQLiteDatabase.getColumnIndex(string3);
        int n11 = -1;
        if (n10 == n11) return bl2;
        return true;
    }

    private static String getAddColumnSql(String string2, String string3, String string4) {
        Object[] objectArray = new Object[]{string2, string3, string4};
        return String.format("ALTER TABLE %s ADD COLUMN %s %s;", objectArray);
    }

    private static String getAddColumnSql(String string2, String string3, String string4, String string5) {
        Object[] objectArray = new Object[]{string2, string3, string4, string5};
        return String.format("ALTER TABLE %s ADD COLUMN %s %s default %s;", objectArray);
    }

    private static String getDatabasePath(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.avos.avoscloud.im.v2.");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private void upgradeToVersion10(SQLiteDatabase sQLiteDatabase) {
        block12: {
            String string2;
            String string3;
            CharSequence charSequence;
            Object object;
            block11: {
                String string4;
                String string5;
                block10: {
                    object = "temp_ttl";
                    charSequence = "temp";
                    string3 = "sys";
                    string2 = "conversations";
                    boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string2, string3);
                    string5 = "0";
                    string4 = "INTEGER";
                    if (bl2) break block10;
                    string3 = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string2, string3, string4, string5);
                    sQLiteDatabase.execSQL(string3);
                }
                boolean bl3 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string2, (String)charSequence);
                if (bl3) break block11;
                charSequence = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string2, (String)charSequence, string4, string5);
                sQLiteDatabase.execSQL((String)charSequence);
            }
            boolean bl4 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string2, (String)object);
            if (bl4) break block12;
            charSequence = "NUMBERIC";
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string2, (String)object, (String)charSequence);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string3 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string3);
                String string6 = exception.getMessage();
                ((StringBuilder)charSequence).append(string6);
                string6 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string6);
            }
        }
    }

    private void upgradeToVersion2(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CONVERSATION_CREATE_SQL);
    }

    private void upgradeToVersion3(SQLiteDatabase sQLiteDatabase) {
        block4: {
            Object object = "dtoken";
            CharSequence charSequence = "messages";
            boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)charSequence, (String)object);
            if (bl2) break block4;
            String string2 = "VARCHAR(32)";
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)charSequence, (String)object, string2);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string2 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string3);
            }
        }
    }

    private void upgradeToVersion4(SQLiteDatabase sQLiteDatabase) {
        block4: {
            Object object = "last_message";
            CharSequence charSequence = "conversations";
            boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)charSequence, (String)object);
            if (bl2) break block4;
            String string2 = "TEXT";
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)charSequence, (String)object, string2);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string2 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string3);
            }
        }
    }

    private void upgradeToVersion5(SQLiteDatabase sQLiteDatabase) {
        block4: {
            Object object = "instanceData";
            CharSequence charSequence = "conversations";
            boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)charSequence, (String)object);
            if (bl2) break block4;
            String string2 = "BLOB";
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)charSequence, (String)object, string2);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string2 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string3);
            }
        }
    }

    private void upgradeToVersion6(SQLiteDatabase sQLiteDatabase) {
        block12: {
            String string2;
            String string3;
            String string4;
            CharSequence charSequence;
            Object object;
            block11: {
                object = "messages";
                charSequence = "unread_count";
                string4 = "conversations";
                boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string4, (String)charSequence);
                string3 = "NUMBERIC";
                string2 = "readAt";
                if (bl2) break block11;
                String string5 = "INTEGER";
                charSequence = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string4, (String)charSequence, string5);
                sQLiteDatabase.execSQL((String)charSequence);
                charSequence = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string4, string2, string3);
                sQLiteDatabase.execSQL((String)charSequence);
                charSequence = "deliveredAt";
                charSequence = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string4, (String)charSequence, string3);
                sQLiteDatabase.execSQL((String)charSequence);
            }
            boolean bl3 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)object, string2);
            if (bl3) break block12;
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)object, string2, string3);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string4 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string4);
                String string6 = exception.getMessage();
                ((StringBuilder)charSequence).append(string6);
                string6 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string6);
            }
        }
    }

    private void upgradeToVersion7(SQLiteDatabase sQLiteDatabase) {
        block4: {
            Object object = "updateAt";
            CharSequence charSequence = "messages";
            boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)charSequence, (String)object);
            if (bl2) break block4;
            String string2 = "NUMBERIC";
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)charSequence, (String)object, string2);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string2 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string3);
            }
        }
    }

    private void upgradeToVersion8(SQLiteDatabase sQLiteDatabase) {
        block12: {
            String string2;
            String string3;
            String string4;
            CharSequence charSequence;
            Object object;
            block11: {
                String string5;
                String string6;
                block10: {
                    object = "mentioned";
                    charSequence = "conversations";
                    string4 = "mentionList";
                    string6 = "mentionAll";
                    string5 = "messages";
                    boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string5, string6);
                    string3 = "0";
                    string2 = "INTEGER";
                    if (bl2) break block10;
                    string6 = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string5, string6, string2, string3);
                    sQLiteDatabase.execSQL(string6);
                }
                boolean bl3 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string5, string4);
                if (bl3) break block11;
                string6 = "TEXT";
                string4 = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string5, string4, string6);
                sQLiteDatabase.execSQL(string4);
            }
            boolean bl4 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)charSequence, (String)object);
            if (bl4) break block12;
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)charSequence, (String)object, string2, string3);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string4 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string4);
                String string7 = exception.getMessage();
                ((StringBuilder)charSequence).append(string7);
                string7 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string7);
            }
        }
    }

    private void upgradeToVersion9(SQLiteDatabase sQLiteDatabase) {
        block8: {
            String string2;
            String string3;
            String string4;
            CharSequence charSequence;
            Object object;
            block7: {
                object = "last_msg_iType";
                charSequence = "conversations";
                string4 = "iType";
                String string5 = "messages";
                boolean bl2 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, string5, string4);
                string3 = "0";
                string2 = "INTEGER";
                if (bl2) break block7;
                string4 = AndroidDatabaseDelegate$DBHelper.getAddColumnSql(string5, string4, string2, string3);
                sQLiteDatabase.execSQL(string4);
            }
            boolean bl3 = AndroidDatabaseDelegate$DBHelper.columnExists(sQLiteDatabase, (String)charSequence, (String)object);
            if (bl3) break block8;
            object = AndroidDatabaseDelegate$DBHelper.getAddColumnSql((String)charSequence, (String)object, string2, string3);
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {
                object = AndroidDatabaseDelegate.access$000();
                charSequence = new StringBuilder();
                string4 = "failed to execute upgrade instrument. cause: ";
                ((StringBuilder)charSequence).append(string4);
                String string6 = exception.getMessage();
                ((StringBuilder)charSequence).append(string6);
                string6 = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w(string6);
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(MESSAGE_CREATE_SQL);
        sQLiteDatabase.execSQL(MESSAGE_UNIQUE_INDEX_SQL);
        sQLiteDatabase.execSQL(CONVERSATION_CREATE_SQL);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        n11 = 1;
        if (n10 == n11) {
            this.upgradeToVersion2(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 2)) {
            this.upgradeToVersion3(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 3)) {
            this.upgradeToVersion4(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 4)) {
            this.upgradeToVersion5(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 5)) {
            this.upgradeToVersion6(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 6)) {
            this.upgradeToVersion7(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 7)) {
            this.upgradeToVersion8(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 8)) {
            this.upgradeToVersion9(sQLiteDatabase);
            ++n10;
        }
        if (n10 == (n11 = 9)) {
            this.upgradeToVersion10(sQLiteDatabase);
        }
    }
}

