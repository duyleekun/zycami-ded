/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.bf;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class an {
    private static long a = 0L;
    private static String a = "";

    public static String a() {
        CharSequence charSequence = a;
        int n10 = TextUtils.isEmpty((CharSequence)charSequence);
        if (n10 != 0) {
            n10 = 4;
            charSequence = bf.a(n10);
            a = charSequence;
        }
        charSequence = new StringBuilder();
        String string2 = a;
        ((StringBuilder)charSequence).append(string2);
        long l10 = a;
        a = 1L + l10;
        ((StringBuilder)charSequence).append(l10);
        return ((StringBuilder)charSequence).toString();
    }
}

