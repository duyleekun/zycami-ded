/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 */
package com.meicam.sdk;

import android.content.Context;
import android.net.ConnectivityManager;

public class NvsNetworkUtil {
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_NONE = 255;
    public static final int TYPE_WIFI = 1;

    public static final int getNetWorkStates(Context context) {
        int n10;
        String string2 = "connectivity";
        context = ((ConnectivityManager)context.getSystemService(string2)).getActiveNetworkInfo();
        int n11 = -1;
        if (context != null && (n10 = context.isConnected()) != 0) {
            int n12 = context.getType();
            if (n12 != 0) {
                n10 = 1;
                if (n12 != n10) {
                    return n11;
                }
                return n10;
            }
            return 0;
        }
        return n11;
    }
}

