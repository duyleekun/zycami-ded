/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 */
package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetWorkUtil {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(NetworkInfo networkInfo) {
        int n10 = 1;
        if (networkInfo == null) return 0;
        int n11 = networkInfo.isConnected();
        if (n11 == 0) return 0;
        n11 = networkInfo.getType();
        if (n11 == n10) return n10;
        n10 = networkInfo.getType();
        if (n10 != 0) return 0;
        int n12 = networkInfo.getSubtype();
        switch (n12) {
            default: {
                return 6;
            }
            case 13: 
            case 14: {
                return 4;
            }
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 15: {
                return 3;
            }
            case 1: 
            case 2: 
            case 4: {
                return 2;
            }
        }
    }

    public static NetworkInfo a(Context object) {
        String string2 = "connectivity";
        object = (object = (ConnectivityManager)object.getSystemService(string2)) != null ? object.getActiveNetworkInfo() : null;
        return object;
    }

    public static int getNetworkType(Context context) {
        return NetWorkUtil.a(NetWorkUtil.a(context));
    }
}

