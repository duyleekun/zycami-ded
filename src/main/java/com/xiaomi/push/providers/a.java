/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.SQLException
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
extends SQLiteOpenHelper {
    private static int a = 1;
    public static final Object a;
    private static final String[] a;

    static {
        Object object;
        a = object = new Object();
        a = new String[]{"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};
    }

    public a(Context context) {
        int n10 = a;
        super(context, "traffic.db", null, n10);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        Object object;
        int n10;
        CharSequence charSequence = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i10 = 0; i10 < (n10 = ((String[])(object = a)).length + -1); i10 += 2) {
            String string2;
            if (i10 != 0) {
                string2 = ",";
                ((StringBuilder)charSequence).append(string2);
            }
            string2 = object[i10];
            ((StringBuilder)charSequence).append(string2);
            string2 = " ";
            ((StringBuilder)charSequence).append(string2);
            n10 = i10 + 1;
            object = object[n10];
            ((StringBuilder)charSequence).append((String)object);
        }
        ((StringBuilder)charSequence).append(");");
        charSequence = ((StringBuilder)charSequence).toString();
        sQLiteDatabase.execSQL((String)charSequence);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Object object = a;
        synchronized (object) {
            Throwable throwable2;
            block5: {
                try {
                    try {
                        this.a(sQLiteDatabase);
                    }
                    catch (SQLException sQLException) {
                        b.a(sQLException);
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
    }
}

