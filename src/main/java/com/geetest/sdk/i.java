/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.m;

public class i {
    public static long a(Context context, String string2) {
        long l10 = 0L;
        String string3 = "gt_fp";
        try {
            context = context.getSharedPreferences(string3, 0);
        }
        catch (Exception exception) {
            return l10;
        }
        return context.getLong(string2, l10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Context context, String string2, long l10) {
        String string3 = "gt_fp";
        try {
            context = context.getSharedPreferences(string3, 0);
        }
        catch (Exception exception) {
            return;
        }
        context = context.edit();
        context = context.putLong(string2, l10);
        context.apply();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Context context, String string2, String string3) {
        String string4 = "gt_fp";
        try {
            context = context.getSharedPreferences(string4, 0);
        }
        catch (Exception exception) {
            return;
        }
        context = context.edit();
        context = context.putString(string2, string3);
        context.apply();
    }

    public static boolean a(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && !(bl2 = (string3 = "$unknown").equals(string2))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static String b(Context context, String string2) {
        String string3 = "gt_fp";
        try {
            context = context.getSharedPreferences(string3, 0);
            string3 = null;
        }
        catch (Exception exception) {
            return "$unknown";
        }
        return context.getString(string2, null);
    }

    public static String c(Context context, String string2) {
        boolean bl2 = i.a(string2 = m.a(string2.getBytes()));
        if (!bl2) {
            i.a(context, "gt_fp", string2);
            return string2;
        }
        return null;
    }
}

