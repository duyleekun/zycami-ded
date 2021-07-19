/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.d.h;

import com.huawei.updatesdk.a.a.d.h.c;

public class d {
    private static int a = 255;

    public static int a() {
        int n10 = a;
        int n11 = -1;
        if (n10 == n11) {
            String string2 = "zh";
            String string3 = "";
            String string4 = c.a("ro.product.locale.language", string3);
            n10 = (int)(string2.equals(string4) ? 1 : 0);
            if (n10 != 0 && (n10 = (int)((string3 = "CN").equals(string4 = c.a("ro.product.locale.region", string3)) ? 1 : 0)) != 0) {
                n10 = 0;
                string4 = null;
            } else {
                n10 = 1;
            }
            a = n10;
        }
        return a;
    }
}

