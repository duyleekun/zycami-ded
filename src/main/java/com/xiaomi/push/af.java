/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

public class af {
    public static final char[] a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] byArray, int n10, int n11) {
        int n12 = n11 * 2;
        StringBuilder stringBuilder = new StringBuilder(n12);
        for (n12 = 0; n12 < n11; ++n12) {
            char c10 = n10 + n12;
            c10 = byArray[c10] & 0xFF;
            char[] cArray = a;
            char c11 = c10 >> 4;
            c11 = cArray[c11];
            stringBuilder.append(c11);
            c10 &= 0xF;
            c10 = cArray[c10];
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static boolean a(Context context) {
        return ae.a;
    }
}

