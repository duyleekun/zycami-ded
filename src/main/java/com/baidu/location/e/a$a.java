/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.AsyncTask
 */
package com.baidu.location.e;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import com.baidu.location.e.a;
import com.baidu.location.e.b;

public class a$a
extends AsyncTask {
    public final /* synthetic */ a a;

    private a$a(a a10) {
        this.a = a10;
    }

    public /* synthetic */ a$a(a a10, b b10) {
        this(a10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Boolean a(Boolean ... object) {
        SQLiteDatabase sQLiteDatabase;
        block14: {
            Object object2;
            int n10;
            block13: {
                Boolean bl2 = Boolean.FALSE;
                int n11 = ((Object)object).length;
                n10 = 4;
                if (n11 != n10) {
                    return bl2;
                }
                n11 = 0;
                sQLiteDatabase = null;
                try {
                    object2 = com.baidu.location.e.a.d();
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase((String)object2, null);
                }
                catch (Exception exception) {}
                if (sQLiteDatabase == null) {
                    return bl2;
                }
                long l10 = System.currentTimeMillis() >> 28;
                int n12 = (int)l10;
                try {
                    sQLiteDatabase.beginTransaction();
                    n10 = 0;
                    object2 = null;
                    object2 = object[0];
                    n10 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
                    if (n10 == 0) break block13;
                    object2 = new StringBuilder();
                    String string2 = "delete from wof where ac < ";
                    ((StringBuilder)object2).append(string2);
                    int n13 = n12 + -35;
                    ((StringBuilder)object2).append(n13);
                    object2 = ((StringBuilder)object2).toString();
                }
                catch (Exception exception) {
                    return Boolean.TRUE;
                }
                try {
                    sQLiteDatabase.execSQL((String)object2);
                }
                catch (Exception exception) {}
            }
            n10 = 1;
            object = object[n10];
            boolean bl3 = (Boolean)object;
            if (!bl3) break block14;
            object = new StringBuilder();
            object2 = "delete from bdcltb09 where ac is NULL or ac < ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n12 += -130);
            object = ((StringBuilder)object).toString();
            try {
                sQLiteDatabase.execSQL((String)object);
            }
            catch (Exception exception) {}
        }
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
        sQLiteDatabase.close();
        return Boolean.TRUE;
    }

    public /* synthetic */ Object doInBackground(Object[] objectArray) {
        objectArray = (Boolean[])objectArray;
        return this.a((Boolean[])objectArray);
    }
}

