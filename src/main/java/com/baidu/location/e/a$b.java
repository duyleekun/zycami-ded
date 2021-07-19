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
import com.baidu.location.BDLocation;
import com.baidu.location.e.a;
import com.baidu.location.e.b;
import com.baidu.location.f.h;

public class a$b
extends AsyncTask {
    public final /* synthetic */ a a;

    private a$b(a a10) {
        this.a = a10;
    }

    public /* synthetic */ a$b(a a10, b b10) {
        this(a10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Boolean a(Object ... object) {
        Object object2;
        SQLiteDatabase sQLiteDatabase;
        int n10;
        Object object3;
        block9: {
            block8: {
                object3 = Boolean.FALSE;
                int n11 = ((Object[])object).length;
                n10 = 4;
                if (n11 != n10) break block8;
                n11 = 0;
                sQLiteDatabase = null;
                try {
                    object2 = com.baidu.location.e.a.d();
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase((String)object2, null);
                }
                catch (Exception exception) {}
                if (sQLiteDatabase != null) break block9;
            }
            com.baidu.location.e.a.a(this.a, false);
            return object3;
        }
        try {
            sQLiteDatabase.beginTransaction();
            object3 = this.a;
            object2 = object[0];
            object2 = (String)object2;
            int n12 = 1;
            Object object4 = object[n12];
            object4 = (com.baidu.location.f.a)object4;
            com.baidu.location.e.a.a((a)object3, (String)object2, (com.baidu.location.f.a)object4, sQLiteDatabase);
            object3 = this.a;
            n10 = 2;
            object2 = object[n10];
            object2 = (h)object2;
            n12 = 3;
            object = object[n12];
            object = (BDLocation)object;
            com.baidu.location.e.a.a((a)object3, (h)object2, (BDLocation)object, sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            sQLiteDatabase.close();
        }
        catch (Exception exception) {}
        com.baidu.location.e.a.a(this.a, false);
        return Boolean.TRUE;
    }

    public /* synthetic */ Object doInBackground(Object[] objectArray) {
        return this.a(objectArray);
    }
}

