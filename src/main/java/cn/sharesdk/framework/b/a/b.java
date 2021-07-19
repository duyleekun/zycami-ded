/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 */
package cn.sharesdk.framework.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.b.a.a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public class b {
    private static b b;
    private a a;

    private b() {
        a a10;
        this.a = a10 = new a();
    }

    public static b a() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            b b10 = b;
            if (b10 == null) {
                b = b10 = new b();
            }
            b10 = b;
            return b10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(String string2) {
        Throwable throwable2;
        Cursor cursor;
        block6: {
            Object object = this.a.getWritableDatabase();
            cursor = null;
            int n10 = 0;
            try {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "select count(*) from ";
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                    cursor = object.rawQuery(string2, null);
                    boolean bl2 = cursor.moveToNext();
                    if (bl2) {
                        n10 = cursor.getInt(0);
                    }
                }
                catch (Exception exception) {
                    object = SSDKLog.b();
                    ((NLog)object).w(exception);
                }
            }
            catch (Throwable throwable2) {
                break block6;
            }
            cursor.close();
            return n10;
        }
        cursor.close();
        throw throwable2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(String string2, String string3, String[] object) {
        void var3_6;
        int n10;
        int n11;
        Object object2;
        block4: {
            object2 = this.a.getWritableDatabase();
            n11 = 1;
            try {
                n10 = object2.delete(string2, string3, (String[])object);
            }
            catch (Exception exception) {
                n10 = 0;
                string3 = null;
                break block4;
            }
            try {
                object = SSDKLog.b();
                object2 = "Deleted %d rows from table: %s";
                int n12 = 2;
                Object[] objectArray = new Object[n12];
                Integer n13 = n10;
                objectArray[0] = n13;
                objectArray[n11] = string2;
                ((NLog)object).d(object2, objectArray);
                return n10;
            }
            catch (Exception exception) {}
        }
        object2 = SSDKLog.b();
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        string2 = "when delete database occur error table:%s,";
        ((NLog)object2).w((Throwable)var3_6, (Object)string2, objectArray);
        return n10;
    }

    public long a(String string2, ContentValues contentValues) {
        long l10;
        Object object = this.a.getWritableDatabase();
        int n10 = 0;
        Object[] objectArray = null;
        try {
            l10 = object.replace(string2, null, contentValues);
        }
        catch (Exception exception) {
            object = SSDKLog.b();
            n10 = 1;
            objectArray = new Object[n10];
            objectArray[0] = string2;
            string2 = "when insert database occur error table:%s,";
            ((NLog)object).w(exception, (Object)string2, objectArray);
            l10 = -1;
        }
        return l10;
    }

    public Cursor a(String string2, String[] stringArray, String string3, String[] stringArray2, String string4) {
        SQLiteDatabase sQLiteDatabase = this.a.getWritableDatabase();
        NLog nLog = SSDKLog.b();
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        nLog.d("Query table: %s", objectArray);
        objectArray = string2;
        Object object = stringArray;
        try {
            nLog = sQLiteDatabase.query(string2, stringArray, string3, stringArray2, null, null, string4);
        }
        catch (Exception exception) {
            nLog = SSDKLog.b();
            objectArray = new Object[n10];
            objectArray[0] = string2;
            object = "when query database occur error table:%s,";
            nLog.w(exception, object, objectArray);
            nLog = null;
        }
        return nLog;
    }
}

