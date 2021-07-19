/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.NetworkInfo$State
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class p {
    public static boolean a(Context networkInfoArray) {
        boolean bl2;
        block9: {
            bl2 = true;
            String string2 = "connectivity";
            networkInfoArray = networkInfoArray.getSystemService(string2);
            networkInfoArray = (ConnectivityManager)networkInfoArray;
            if (networkInfoArray == null) break block9;
            networkInfoArray = networkInfoArray.getAllNetworkInfo();
            if (networkInfoArray == null) break block9;
            int n10 = networkInfoArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                NetworkInfo networkInfo;
                try {
                    networkInfo = networkInfoArray[i10];
                }
                catch (Exception exception) {}
                networkInfo = networkInfo.getState();
                NetworkInfo.State state = NetworkInfo.State.CONNECTED;
                if (networkInfo != state) continue;
                return bl2;
                break;
            }
        }
        return bl2;
    }

    public static String b(Context object) {
        String string2;
        block20: {
            String string3;
            block21: {
                string2 = "NULL";
                object = object.getApplicationContext();
                string3 = "connectivity";
                object = object.getSystemService(string3);
                object = (ConnectivityManager)object;
                if (object == null) break block20;
                int n10 = 1;
                string3 = object.getNetworkInfo(n10);
                if (string3 == null) break block21;
                try {
                    boolean bl2 = string3.isConnectedOrConnecting();
                    if (!bl2) break block21;
                    return "WIFI";
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (string3 != null) {
                Object object2;
                block22: {
                    object2 = string3.getState();
                    string3 = string3.getSubtypeName();
                    object = object.getActiveNetworkInfo();
                    if (object2 == null || object == null) break block20;
                    int n11 = object.getSubtype();
                    object2 = "3G";
                    switch (n11) {
                        default: {
                            object = "TD-SCDMA";
                            break;
                        }
                        case 20: {
                            return "5G";
                        }
                        case 13: 
                        case 18: 
                        case 19: {
                            return "4G";
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
                            return object2;
                        }
                        case 1: 
                        case 2: 
                        case 4: 
                        case 7: 
                        case 11: 
                        case 16: {
                            return "2G";
                        }
                    }
                    n11 = (int)(string3.equalsIgnoreCase((String)object) ? 1 : 0);
                    if (n11 != 0) break block22;
                    object = "WCDMA";
                    n11 = (int)(string3.equalsIgnoreCase((String)object) ? 1 : 0);
                    if (n11 != 0) break block22;
                    object = "CDMA2000";
                    n11 = (int)(string3.equalsIgnoreCase((String)object) ? 1 : 0);
                    if (n11 != 0) break block22;
                    return string2;
                }
                return object2;
            }
        }
        return string2;
    }
}

