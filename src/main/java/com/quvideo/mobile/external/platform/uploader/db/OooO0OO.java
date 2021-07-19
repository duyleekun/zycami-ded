/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 */
package com.quvideo.mobile.external.platform.uploader.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.quvideo.mobile.external.platform.uploader.db.entity.OooO00o;
import d.o.a.a.b.c.f.b;

public class OooO0OO
extends b {
    public static int OooO0O0;
    public static int OooO0OO;
    public static int OooO0Oo;
    public static int OooO0o;
    public static int OooO0o0;

    public static String OooO0o() {
        return "create table if not exists upload_task (id integer primary key, task_unique_key varchar not null, upload_id integer , cloud_type integer , create_time long);";
    }

    public ContentValues OooO00o(OooO00o object) {
        ContentValues contentValues = new ContentValues();
        Object object2 = ((OooO00o)object).OooO0OO();
        contentValues.put("task_unique_key", (String)object2);
        object2 = ((OooO00o)object).OooO0Oo();
        contentValues.put("upload_id", (Integer)object2);
        object2 = ((OooO00o)object).OooO0O0();
        contentValues.put("create_time", (Long)object2);
        object = ((OooO00o)object).OooO00o();
        contentValues.put("cloud_type", (Integer)object);
        return contentValues;
    }

    public OooO00o OooO00o(Cursor cursor) {
        String string2;
        OooO00o oooO00o = new OooO00o();
        int n10 = OooO0o0;
        if (n10 == 0) {
            OooO0O0 = cursor.getColumnIndex("id");
            OooO0OO = cursor.getColumnIndex("task_unique_key");
            OooO0Oo = cursor.getColumnIndex("upload_id");
            OooO0o0 = cursor.getColumnIndex("create_time");
            string2 = "cloud_type";
            OooO0o = n10 = cursor.getColumnIndex(string2);
        }
        n10 = OooO0O0;
        n10 = cursor.getInt(n10);
        oooO00o.OooO0O0(n10);
        n10 = OooO0OO;
        string2 = cursor.getString(n10);
        oooO00o.OooO00o(string2);
        n10 = OooO0Oo;
        n10 = cursor.getInt(n10);
        oooO00o.OooO0OO(n10);
        n10 = OooO0o0;
        long l10 = cursor.getLong(n10);
        oooO00o.OooO00o(l10);
        n10 = OooO0o;
        int n11 = cursor.getInt(n10);
        oooO00o.OooO00o(n11);
        return oooO00o;
    }

    public OooO00o OooO00o(String string2, int n10) {
        OooO00o oooO00o;
        block15: {
            oooO00o = null;
            SQLiteDatabase sQLiteDatabase = this.OooO00o;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "select * from upload_task where task_unique_key =\"";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = "\" and ";
            stringBuilder.append(string2);
            string2 = "cloud_type";
            stringBuilder.append(string2);
            string2 = " = ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            string2 = stringBuilder.toString();
            string2 = sQLiteDatabase.rawQuery(string2, null);
            n10 = (int)(string2.moveToFirst() ? 1 : 0);
            if (n10 != 0) break block15;
            string2.close();
            return null;
        }
        oooO00o = this.OooO00o((Cursor)string2);
        try {
            string2.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return oooO00o;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void OooO00o(String string2) {
        Throwable throwable2;
        block4: {
            try {
                try {
                    this.OooO00o();
                    SQLiteDatabase sQLiteDatabase = this.OooO00o;
                    String string3 = "upload_task";
                    StringBuilder stringBuilder = new StringBuilder();
                    String string4 = "task_unique_key =\"";
                    stringBuilder.append(string4);
                    stringBuilder.append(string2);
                    string2 = "\"";
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                    stringBuilder = null;
                    sQLiteDatabase.delete(string3, string2, null);
                    this.OooO0Oo();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            catch (Throwable throwable2) {
                break block4;
            }
            this.OooO0O0();
            return;
        }
        this.OooO0O0();
        throw throwable2;
    }

    public String OooO0OO() {
        return "upload_task";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void OooO0o0() {
        Throwable throwable22;
        block6: {
            try {
                this.OooO00o();
                long l11 = System.currentTimeMillis();
                long l10 = 1209600000L;
                l11 -= l10;
                SQLiteDatabase sQLiteDatabase = this.OooO00o;
                String string2 = "upload_task";
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "create_time < ";
                stringBuilder.append(string3);
                stringBuilder.append(l11);
                String string4 = stringBuilder.toString();
                sQLiteDatabase.delete(string2, string4, null);
                this.OooO0Oo();
            }
            catch (Throwable throwable22) {
                break block6;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.OooO0O0();
            return;
        }
        this.OooO0O0();
        throw throwable22;
    }
}

