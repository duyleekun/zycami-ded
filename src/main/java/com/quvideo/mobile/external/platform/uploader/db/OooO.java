/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.quvideo.mobile.external.platform.uploader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.quvideo.mobile.external.platform.uploader.db.OooO0OO;
import com.quvideo.mobile.external.platform.uploader.db.OooO0o;

public class OooO
extends SQLiteOpenHelper {
    private static OooO OooO00o;
    public static Context OooO0O0;

    private OooO(Context context) {
        super(context, "qv_oss_upload.db", null, 2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OooO OooO00o() {
        Object object = OooO00o;
        if (object != null) return OooO00o;
        object = OooO.class;
        synchronized (object) {
            OooO oooO;
            OooO oooO2 = OooO00o;
            if (oooO2 != null) return OooO00o;
            oooO2 = OooO0O0;
            if (oooO2 == null) return OooO00o;
            OooO00o = oooO = new OooO((Context)oooO2);
            return OooO00o;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void OooO00o(Context context) {
        Object object = OooO0O0;
        if (object != null) return;
        object = OooO.class;
        synchronized (object) {
            Context context2 = OooO0O0;
            if (context2 != null) return;
            if (context == null) return;
            OooO0O0 = context = context.getApplicationContext();
            return;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        String string2 = OooO0OO.OooO0o();
        sQLiteDatabase.execSQL(string2);
        string2 = OooO0o.OooO0o();
        sQLiteDatabase.execSQL(string2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n10, int n11) {
        n11 = 2;
        if (n10 < n11) {
            String string2 = OooO0o.OooO0o();
            sQLiteDatabase.execSQL(string2);
        }
    }
}

