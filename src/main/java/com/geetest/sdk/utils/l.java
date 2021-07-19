/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.geetest.sdk.utils;

import android.util.Log;
import com.geetest.sdk.utils.l$b;

public class l {
    private static l$b a;
    private static boolean b = true;

    private static void a(String string2, String string3) {
        boolean bl2 = b;
        if (bl2) {
            l$b l$b = a;
            if (l$b == null) {
                a = l$b = new l$b();
                l$b.b();
                l$b = a;
                l$b.a();
            }
            l$b = a;
            l$b.a(string2, string3);
        }
    }

    public static void a(boolean bl2) {
        b = bl2;
    }

    public static void b(String string2, String string3) {
        string2 = "Geetest";
        Log.i((String)string2, (String)string3);
        l.a(string2, string3);
    }

    public static void c(String string2, String string3) {
    }

    public static void d(String string2, String string3) {
    }
}

