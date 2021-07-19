/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import com.huawei.hms.hatool.y;

public class h {
    /*
     * Enabled aggressive block sorting
     */
    public static String a(int n10, String string2) {
        switch (n10) {
            default: {
                String string3 = "TD-SCDMA";
                n10 = (int)(string2.equalsIgnoreCase(string3) ? 1 : 0);
                if (n10 != 0) return "3G";
                string3 = "WCDMA";
                n10 = (int)(string2.equalsIgnoreCase(string3) ? 1 : 0);
                if (n10 != 0) return "3G";
                string3 = "CDMA2000";
                n10 = (int)(string2.equalsIgnoreCase(string3) ? 1 : 0);
                if (n10 == 0) return string2;
                return "3G";
            }
            case 13: {
                return "4G";
            }
            case 1: 
            case 2: 
            case 4: 
            case 7: 
            case 11: {
                return "2G";
            }
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 14: 
            case 15: 
        }
        return "3G";
    }

    public static String a(Context object) {
        String string2;
        String string3;
        Object object2;
        int n10;
        CharSequence charSequence = "";
        String string4 = "hmsSdk";
        if (object != null && (n10 = (object2 = object.getPackageManager()).checkPermission(string3 = "android.permission.ACCESS_NETWORK_STATE", string2 = object.getPackageName())) == 0) {
            object2 = "connectivity";
            if ((object = (ConnectivityManager)object.getSystemService((String)object2)) != null && (object = object.getActiveNetworkInfo()) != null && (n10 = (int)(object.isConnected() ? 1 : 0)) != 0) {
                int n11 = object.getType();
                if (n11 == (n10 = 1)) {
                    charSequence = "WIFI";
                } else {
                    n11 = object.getType();
                    if (n11 == 0) {
                        charSequence = object.getSubtypeName();
                        object2 = new StringBuilder();
                        string2 = "Network getSubtypeName : ";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append((String)charSequence);
                        object2 = ((StringBuilder)object2).toString();
                        y.c(string4, (String)object2);
                        int n12 = object.getSubtype();
                        charSequence = h.a(n12, (String)charSequence);
                    } else {
                        n11 = object.getType();
                        n10 = 16;
                        string2 = "type name = ";
                        if (n11 == n10) {
                            charSequence = "COMPANION_PROXY";
                            object = new StringBuilder();
                            ((StringBuilder)object).append(string2);
                            ((StringBuilder)object).append((String)charSequence);
                            object = ((StringBuilder)object).toString();
                            y.f(string4, (String)object);
                        } else {
                            n11 = object.getType();
                            if (n11 == (n10 = 9)) {
                                charSequence = "ETHERNET";
                                object = new StringBuilder();
                                ((StringBuilder)object).append(string2);
                                ((StringBuilder)object).append((String)charSequence);
                                object = ((StringBuilder)object).toString();
                                y.c(string4, (String)object);
                            } else {
                                charSequence = new StringBuilder();
                                ((StringBuilder)charSequence).append(string2);
                                int n13 = object.getType();
                                ((StringBuilder)charSequence).append(n13);
                                object = ((StringBuilder)charSequence).toString();
                                y.c(string4, (String)object);
                                charSequence = "OTHER_NETWORK_TYPE";
                            }
                        }
                    }
                }
            }
            return charSequence;
        }
        y.f(string4, "not have network state phone permission!");
        return charSequence;
    }
}

