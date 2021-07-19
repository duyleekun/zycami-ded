/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.availableupdate;

import android.content.Context;

public class a {
    public String a;
    public int b;
    public String c;
    public int d;

    public int a() {
        return this.d;
    }

    public void a(Context context, int n10, String string2) {
        this.d = n10;
        this.b(context, string2);
    }

    public void a(Context context, String string2) {
        int n10;
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.huawei.hms.update.DOWNLOAD_RECORD");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        context = context.getSharedPreferences(string2, 0);
        String string3 = "";
        this.a = string2 = context.getString("mUri", string3);
        this.b = n11 = context.getInt("mSize", 0);
        this.c = string2 = context.getString("mHash", string3);
        this.d = n10 = context.getInt("mReceived", 0);
    }

    public void a(String string2, int n10, String string3) {
        this.a = string2;
        this.b = n10;
        this.c = string3;
        this.d = 0;
    }

    public int b() {
        return this.b;
    }

    public final void b(Context context, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.huawei.hms.update.DOWNLOAD_RECORD");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        context = context.getSharedPreferences(string2, 0).edit();
        string2 = this.a;
        context.putString("mUri", string2);
        int n10 = this.b;
        context.putInt("mSize", n10);
        string2 = this.c;
        context.putString("mHash", string2);
        n10 = this.d;
        context.putInt("mReceived", n10);
        context.commit();
    }

    public boolean b(String string2, int n10, String string3) {
        int n11;
        String string4;
        if (string2 != null && string3 != null && (string4 = this.a) != null && (n11 = string4.equals(string2)) != 0 && (n11 = this.b) == n10 && (string2 = this.c) != null && (n11 = (int)(string2.equals(string3) ? 1 : 0)) != 0 && (n11 = this.d) <= (n10 = this.b)) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        return n11 != 0;
    }
}

