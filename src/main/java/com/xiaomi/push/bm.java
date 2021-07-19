/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bm {
    private static volatile bm a;
    private Context a;

    private bm(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static bm a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = bm.class;
        synchronized (object) {
            bm bm2 = a;
            if (bm2 != null) return a;
            a = bm2 = new bm(context);
            return a;
        }
    }

    public long a(String string2, String string3, long l10) {
        synchronized (this) {
            int n10;
            Context context;
            try {
                context = this.a;
                n10 = 4;
            }
            catch (Throwable throwable) {
                return l10;
            }
            string2 = context.getSharedPreferences(string2, n10);
            long l11 = string2.getLong(string3, l10);
            return l11;
        }
    }

    public String a(String string2, String string3, String string4) {
        synchronized (this) {
            int n10;
            Context context;
            try {
                context = this.a;
                n10 = 4;
            }
            catch (Throwable throwable) {
                return string4;
            }
            string2 = context.getSharedPreferences(string2, n10);
            string2 = string2.getString(string3, string4);
            return string2;
        }
    }

    public void a(String string2, String string3, long l10) {
        synchronized (this) {
            Context context = this.a;
            int n10 = 4;
            string2 = context.getSharedPreferences(string2, n10);
            string2 = string2.edit();
            string2.putLong(string3, l10);
            string2.commit();
            return;
        }
    }

    public void a(String string2, String string3, String string4) {
        synchronized (this) {
            Context context = this.a;
            int n10 = 4;
            string2 = context.getSharedPreferences(string2, n10);
            string2 = string2.edit();
            string2.putString(string3, string4);
            string2.commit();
            return;
        }
    }
}

