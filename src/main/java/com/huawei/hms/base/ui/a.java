/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.huawei.hms.base.ui;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static final Pattern a = Pattern.compile("[0-9]*[a-z|A-Z]*[\u4e00-\u9fa5]*");

    public static String a(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return string2;
        }
        n10 = string2.length();
        char c10 = '*';
        int n11 = 1;
        if (n11 == n10) {
            return String.valueOf(c10);
        }
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11 = string2.charAt(i10);
            Object object = a;
            String string3 = String.valueOf(c11);
            int n12 = ((Matcher)(object = ((Pattern)object).matcher(string3))).matches();
            if (n12 != 0) {
                n12 = n11 % 2;
                if (n12 == 0) {
                    c11 = c10;
                }
                ++n11;
            }
            stringBuilder.append(c11);
        }
        return stringBuilder.toString();
    }

    public static String a(String string2, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(512);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            if (bl2) {
                string2 = com.huawei.hms.base.ui.a.a(string2);
                stringBuilder.append(string2);
            } else {
                stringBuilder.append(string2);
            }
        }
        return stringBuilder.toString();
    }

    public static void a(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return;
        }
        string3 = com.huawei.hms.base.ui.a.a(string3, false);
        Log.e((String)string2, (String)string3);
    }

    public static void a(String string2, String string3, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            return;
        }
        string3 = com.huawei.hms.base.ui.a.a(string3, bl2);
        Log.e((String)string2, (String)string3);
    }
}

