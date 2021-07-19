/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.quvideo.mobile.external.platform.log;

import android.util.Log;

public class OooO00o {
    private static boolean OooO00o = true;

    public static void OooO00o(String string2, String string3) {
        boolean bl2 = OooO00o;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "[";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append("] - ");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            string3 = "QuVideoEx";
            Log.d((String)string3, (String)string2);
        }
    }

    public static void OooO00o(boolean bl2) {
        OooO00o = bl2;
    }

    public static void OooO0O0(String string2, String string3) {
        boolean bl2 = OooO00o;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "[";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append("] - ");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            string3 = "QuVideoEx";
            Log.e((String)string3, (String)string2);
        }
    }
}

