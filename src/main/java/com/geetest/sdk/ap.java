/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ap {
    private static final SimpleDateFormat a;

    static {
        SimpleDateFormat simpleDateFormat;
        a = simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static int a(byte[] byArray) {
        int n10;
        int n11 = 3;
        try {
            n11 = byArray[n11] & 0xFF;
            n10 = 2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0;
        }
        n10 = (byArray[n10] & 0xFF) << 8;
        n11 |= n10;
        n10 = 1;
        n10 = (byArray[n10] & 0xFF) << 16;
        n11 |= n10;
        return (byArray[0] & 0xFF) << 24 | n11;
    }

    public static long a() {
        long l10 = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = a;
        Date date = new Date(l10);
        Object object = simpleDateFormat.format(date);
        object = simpleDateFormat.parse((String)object);
        try {
            l10 = ((Date)object).getTime();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            l10 = 0L;
        }
        return l10;
    }

    public static byte[] a(int n10) {
        byte[] byArray;
        int n11 = 4;
        try {
            byArray = new byte[n11];
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        int n12 = n10 >> 24 & 0xFF;
        int n13 = 0;
        byArray[0] = n12;
        n12 = (byte)(n10 >> 16 & 0xFF);
        n13 = 1;
        byArray[n13] = n12;
        n12 = (byte)(n10 >> 8 & 0xFF);
        n13 = 2;
        byArray[n13] = n12;
        n10 = (byte)(n10 & 0xFF);
        n12 = 3;
        byArray[n12] = n10;
        return byArray;
    }
}

