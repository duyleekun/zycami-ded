/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.quvideo.mobile.external.platform.httpcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;

public class OooO0O0 {
    private OooO0O0 OooO00o;
    private SharedPreferences OooO0O0;
    private SharedPreferences.Editor OooO0OO;
    private Context OooO0Oo;

    public OooO0O0(Context context, String string2) {
        new HashSet(0);
        this.OooO0Oo = context = context.getApplicationContext();
        context = context.getSharedPreferences(string2, 0);
        this.OooO0O0 = context;
        context = context.edit();
        this.OooO0OO = context;
    }

    public OooO0O0 OooO00o(String string2) {
        this.OooO0OO.remove(string2);
        this.OooO0OO.apply();
        return this.OooO00o;
    }

    public String OooO00o(String string2, String string3) {
        return this.OooO0O0.getString(string2, string3);
    }

    public OooO0O0 OooO0O0(String string2, String string3) {
        this.OooO0OO.putString(string2, string3);
        this.OooO0OO.apply();
        return this.OooO00o;
    }
}

