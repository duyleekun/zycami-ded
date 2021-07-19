/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 */
package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mob.commons.logcollector.a;
import com.mob.tools.MobLog;
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
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(String string2) {
        int n10;
        block9: {
            Object object;
            block8: {
                block7: {
                    block6: {
                        SQLiteDatabase sQLiteDatabase = this.a.getWritableDatabase();
                        n10 = 0;
                        Object var4_7 = null;
                        object = string2;
                        try {
                            string2 = sQLiteDatabase.query(string2, null, null, null, null, null, null);
                            if (string2 != null) break block6;
                            break block7;
                        }
                        catch (Throwable throwable) {
                            string2 = null;
                            break block8;
                        }
                    }
                    try {
                        n10 = string2.getCount();
                    }
                    catch (Throwable throwable) {
                        break block8;
                    }
                }
                if (string2 == null) return n10;
                break block9;
            }
            try {
                void var2_5;
                object = MobLog.getInstance();
                ((NLog)object).w((Throwable)var2_5);
                if (string2 == null) return n10;
            }
            catch (Throwable throwable) {
                if (string2 == null) throw throwable;
                string2.close();
                throw throwable;
            }
        }
        string2.close();
        return n10;
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
                object = MobLog.getInstance();
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
        object2 = MobLog.getInstance();
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
            object = MobLog.getInstance();
            n10 = 1;
            objectArray = new Object[n10];
            objectArray[0] = string2;
            string2 = "when insert database occur error table:%s,";
            ((NLog)object).w(exception, (Object)string2, objectArray);
            l10 = -1;
        }
        return l10;
    }

    public Cursor a(String string2, String[] object) {
        SQLiteDatabase sQLiteDatabase = this.a.getWritableDatabase();
        try {
            string2 = sQLiteDatabase.rawQuery(string2, (String[])object);
        }
        catch (Exception exception) {
            object = MobLog.getInstance();
            ((NLog)object).w(exception);
            string2 = null;
        }
        return string2;
    }
}

