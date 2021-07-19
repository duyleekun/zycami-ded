/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 */
package com.huawei.updatesdk.a.a.d.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class a {
    private static ConnectivityManager a;

    public static int a(NetworkInfo networkInfo) {
        int n10;
        block6: {
            block5: {
                int n11;
                int n12;
                n10 = 1;
                if (networkInfo == null || (n12 = networkInfo.isConnected()) == 0) break block5;
                n12 = networkInfo.getType();
                if (n10 == n12 || (n11 = 13) == n12) break block6;
                if (n12 != 0) break block5;
                int n13 = networkInfo.getSubtype();
                switch (n13) {
                    default: {
                        break;
                    }
                    case 13: {
                        n10 = 4;
                        break block6;
                    }
                    case 3: 
                    case 5: 
                    case 6: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 12: 
                    case 14: 
                    case 15: {
                        n10 = 3;
                        break block6;
                    }
                    case 1: 
                    case 2: 
                    case 4: 
                    case 7: 
                    case 11: {
                        n10 = 2;
                        break block6;
                    }
                }
            }
            n10 = 0;
        }
        return n10;
    }

    public static NetworkInfo a(Context object) {
        object = (object = com.huawei.updatesdk.a.a.d.i.a.b(object)) != null ? object.getActiveNetworkInfo() : null;
        return object;
    }

    private static ConnectivityManager b(Context context) {
        Object object = a;
        if (object == null) {
            context = context.getApplicationContext();
            object = "connectivity";
            context = (ConnectivityManager)context.getSystemService((String)object);
            a = context;
        }
        return a;
    }

    public static int c(Context context) {
        return com.huawei.updatesdk.a.a.d.i.a.a(com.huawei.updatesdk.a.a.d.i.a.a(context));
    }

    public static boolean d(Context context) {
        boolean bl2;
        return context != null && (context = com.huawei.updatesdk.a.a.d.i.a.b(context)) != null && (context = context.getActiveNetworkInfo()) != null && (bl2 = context.isConnected());
    }
}

