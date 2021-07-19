/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.telephony.TelephonyManager
 */
package com.quvideo.mobile.external.platform.httpcore.country;

import android.content.Context;
import android.telephony.TelephonyManager;

public class OooOO0 {
    private static String OooO00o;

    public static String OooO00o(Context object) {
        String string2 = OooO00o;
        if (string2 != null) {
            return string2;
        }
        if (object != null && (object = (TelephonyManager)object.getSystemService(string2 = "phone")) != null && (string2 = object.getSimCountryIso()) != null) {
            object = object.getSimCountryIso().toUpperCase();
            OooO00o = object;
        }
        if ((object = OooO00o) == null) {
            object = "";
            OooO00o = object;
        }
        return OooO00o;
    }
}

