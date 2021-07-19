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
import com.quvideo.mobile.external.platform.uploader.db.entity.OooO0O0;
import d.o.a.a.b.c.f.b;

public class OooO0o
extends b {
    public static int OooO;
    public static int OooO0O0;
    public static int OooO0OO;
    public static int OooO0Oo;
    public static int OooO0o;
    public static int OooO0o0;
    public static int OooO0oO;
    public static int OooO0oo;
    public static int OooOO0;
    public static int OooOO0O;
    public static int OooOO0o;
    public static int OooOOO;
    public static int OooOOO0;
    public static int OooOOOO;
    public static int OooOOOo;
    public static int OooOOo;
    public static int OooOOo0;
    public static int OooOOoo;
    public static int OooOo0;
    public static int OooOo00;
    public static int OooOo0O;

    public static String OooO0o() {
        return "create table if not exists upload_token (id integer primary key, task_unique_key varchar not null, updateTime long, localPath varchar not null, localFileMsg varchar, configId long, withOutExpiry integer, isCustomFileName integer, isPrivacy integer, countryCode varchar, ossType varchar, expirySeconds long, accessKey varchar, accessSecret varchar, securityToken varchar, uploadHost varchar, filePath varchar, region varchar, bucket varchar, accessUrl varchar, isUseHttps integer);";
    }

    public ContentValues OooO00o(OooO0O0 object) {
        ContentValues contentValues = new ContentValues();
        Object object2 = ((OooO0O0)object).OooO0O0;
        contentValues.put("task_unique_key", (String)object2);
        object2 = ((OooO0O0)object).OooO0OO;
        contentValues.put("localPath", (String)object2);
        object2 = ((OooO0O0)object).OooO0Oo;
        contentValues.put("localFileMsg", (String)object2);
        object2 = ((OooO0O0)object).OooO0o0;
        contentValues.put("configId", (Long)object2);
        object2 = (int)(((OooO0O0)object).OooO0o ? 1 : 0);
        contentValues.put("withOutExpiry", (Integer)object2);
        object2 = (int)(((OooO0O0)object).OooO0oO ? 1 : 0);
        contentValues.put("isCustomFileName", (Integer)object2);
        object2 = (int)(((OooO0O0)object).OooO0oo ? 1 : 0);
        contentValues.put("isPrivacy", (Integer)object2);
        object2 = ((OooO0O0)object).OooO;
        contentValues.put("countryCode", (String)object2);
        object2 = ((OooO0O0)object).OooOO0;
        contentValues.put("ossType", (String)object2);
        object2 = ((OooO0O0)object).OooOO0O;
        contentValues.put("expirySeconds", (Long)object2);
        object2 = ((OooO0O0)object).OooOO0o;
        contentValues.put("accessKey", (String)object2);
        object2 = ((OooO0O0)object).OooOOO0;
        contentValues.put("accessSecret", (String)object2);
        object2 = ((OooO0O0)object).OooOOO;
        contentValues.put("securityToken", (String)object2);
        object2 = ((OooO0O0)object).OooOOOO;
        contentValues.put("uploadHost", (String)object2);
        object2 = ((OooO0O0)object).OooOOOo;
        contentValues.put("filePath", (String)object2);
        object2 = ((OooO0O0)object).OooOOo0;
        contentValues.put("region", (String)object2);
        object2 = ((OooO0O0)object).OooOOo;
        contentValues.put("bucket", (String)object2);
        object2 = ((OooO0O0)object).OooOOoo;
        contentValues.put("accessUrl", (String)object2);
        object = (int)(((OooO0O0)object).OooOo00 ? 1 : 0);
        contentValues.put("isUseHttps", (Integer)object);
        return contentValues;
    }

    public OooO0O0 OooO00o(Cursor cursor) {
        long l10;
        String string2;
        long l11;
        Object object;
        int n10 = OooO0o0;
        if (n10 == 0) {
            OooO0O0 = cursor.getColumnIndex("id");
            OooO0OO = cursor.getColumnIndex("task_unique_key");
            OooO0Oo = cursor.getColumnIndex("updateTime");
            OooO0o0 = cursor.getColumnIndex("localPath");
            OooO0o = cursor.getColumnIndex("localFileMsg");
            OooO0oO = cursor.getColumnIndex("configId");
            OooO0oo = cursor.getColumnIndex("withOutExpiry");
            OooO = cursor.getColumnIndex("isCustomFileName");
            OooOO0 = cursor.getColumnIndex("isPrivacy");
            OooOO0O = cursor.getColumnIndex("countryCode");
            OooOO0o = cursor.getColumnIndex("ossType");
            OooOOO0 = cursor.getColumnIndex("expirySeconds");
            OooOOO = cursor.getColumnIndex("accessKey");
            OooOOOO = cursor.getColumnIndex("accessSecret");
            OooOOOo = cursor.getColumnIndex("securityToken");
            OooOOo0 = cursor.getColumnIndex("uploadHost");
            OooOOo = cursor.getColumnIndex("filePath");
            OooOOoo = cursor.getColumnIndex("region");
            OooOo00 = cursor.getColumnIndex("bucket");
            OooOo0 = cursor.getColumnIndex("accessUrl");
            object = "isUseHttps";
            OooOo0O = n10 = cursor.getColumnIndex((String)object);
        }
        object = new OooO0O0();
        int n11 = OooO0O0;
        ((OooO0O0)object).OooO00o = l11 = cursor.getLong(n11);
        n11 = OooO0OO;
        ((OooO0O0)object).OooO0O0 = string2 = cursor.getString(n11);
        n11 = OooO0Oo;
        cursor.getLong(n11);
        n11 = OooO0o0;
        ((OooO0O0)object).OooO0OO = string2 = cursor.getString(n11);
        n11 = OooO0o;
        ((OooO0O0)object).OooO0Oo = string2 = cursor.getString(n11);
        n11 = OooO0oO;
        ((OooO0O0)object).OooO0o0 = l11 = cursor.getLong(n11);
        n11 = OooO0oo;
        n11 = cursor.getInt(n11);
        int n12 = 0;
        int n13 = 1;
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            string2 = null;
        }
        ((OooO0O0)object).OooO0o = n11;
        n11 = OooO;
        n11 = cursor.getInt(n11);
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            string2 = null;
        }
        ((OooO0O0)object).OooO0oO = n11;
        n11 = OooOO0;
        n11 = cursor.getInt(n11);
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            string2 = null;
        }
        ((OooO0O0)object).OooO0oo = n11;
        n11 = OooOO0O;
        ((OooO0O0)object).OooO = string2 = cursor.getString(n11);
        n11 = OooOO0o;
        ((OooO0O0)object).OooOO0 = string2 = cursor.getString(n11);
        n11 = OooOOO0;
        ((OooO0O0)object).OooOO0O = l10 = cursor.getLong(n11);
        n11 = OooOOO;
        ((OooO0O0)object).OooOO0o = string2 = cursor.getString(n11);
        n11 = OooOOOO;
        ((OooO0O0)object).OooOOO0 = string2 = cursor.getString(n11);
        n11 = OooOOOo;
        ((OooO0O0)object).OooOOO = string2 = cursor.getString(n11);
        n11 = OooOOo0;
        ((OooO0O0)object).OooOOOO = string2 = cursor.getString(n11);
        n11 = OooOOo;
        ((OooO0O0)object).OooOOOo = string2 = cursor.getString(n11);
        n11 = OooOOoo;
        ((OooO0O0)object).OooOOo0 = string2 = cursor.getString(n11);
        n11 = OooOo00;
        ((OooO0O0)object).OooOOo = string2 = cursor.getString(n11);
        n11 = OooOo0;
        ((OooO0O0)object).OooOOoo = string2 = cursor.getString(n11);
        n11 = OooOo0O;
        int n14 = cursor.getInt(n11);
        if (n14 == n13) {
            n12 = n13;
        }
        ((OooO0O0)object).OooOo00 = n12;
        return object;
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
                    String string3 = "upload_token";
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

    public OooO0O0 OooO0O0(String string2) {
        OooO0O0 oooO0O0;
        block12: {
            oooO0O0 = null;
            SQLiteDatabase sQLiteDatabase = this.OooO00o;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "select * from upload_token where task_unique_key =\"";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = "\"";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            string2 = sQLiteDatabase.rawQuery(string2, null);
            boolean bl2 = string2.moveToFirst();
            if (bl2) break block12;
            string2.close();
            return null;
        }
        oooO0O0 = this.OooO00o((Cursor)string2);
        try {
            string2.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return oooO0O0;
    }

    public void OooO0O0(OooO0O0 object) {
        ContentValues contentValues = this.OooO00o((OooO0O0)object);
        SQLiteDatabase sQLiteDatabase = this.OooO00o;
        String[] stringArray = new String[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        long l10 = ((OooO0O0)object).OooO00o;
        stringBuilder.append(l10);
        stringArray[0] = object = stringBuilder.toString();
        sQLiteDatabase.update("upload_token", contentValues, "id=?", stringArray);
    }

    public String OooO0OO() {
        return "upload_token";
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
                long l10 = 604800000L;
                l11 -= l10;
                SQLiteDatabase sQLiteDatabase = this.OooO00o;
                String string2 = "upload_token";
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "updateTime < ";
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

