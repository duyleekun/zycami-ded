/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk.b.h;

import android.content.Context;
import com.huawei.updatesdk.b.h.c;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class d {
    public static int a(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object <= 0) {
            return 0;
        }
        double d10 = l10;
        double d11 = l11;
        return Math.min((int)Math.round(d10 / d11 * 100.0), 100);
    }

    public static String a(int n10) {
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        double d10 = (double)n10 / 100.0;
        numberFormat.setMinimumFractionDigits(0);
        return numberFormat.format(d10);
    }

    public static String a(Context object, long l10) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        String string2 = "upsdk_storage_utils";
        if (l12 == false) {
            int n11 = c.c(object, string2);
            Object[] objectArray = new Object[n10];
            objectArray[0] = "0";
            return object.getString(n11, objectArray);
        }
        l12 = 0;
        Object object2 = null;
        long l13 = 104857L;
        double d10 = 5.1806E-319;
        Object object3 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (object3 > 0) {
            String string3 = "###.#";
            object2 = new DecimalFormat(string3);
        } else {
            l13 = 10485L;
            d10 = 5.1803E-320;
            object3 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            if (object3 > 0) {
                String string4 = "###.##";
                object2 = new DecimalFormat(string4);
            }
        }
        if (object2 != null) {
            double d11 = l10;
            l13 = 4697254411347427328L;
            d10 = 1048576.0;
            int n12 = c.c(object, string2);
            Object[] objectArray = new Object[n10];
            String string5 = ((NumberFormat)object2).format(d11 /= d10);
            objectArray[0] = string5;
            object = object.getString(n12, objectArray);
        } else {
            int n13 = c.c(object, string2);
            Object[] objectArray = new Object[n10];
            objectArray[0] = object2 = "0.01";
            object = object.getString(n13, objectArray);
        }
        return object;
    }

    public static boolean a(List list) {
        int n10;
        if (list != null && (n10 = list.size()) > 0) {
            n10 = 0;
            list = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }
}

