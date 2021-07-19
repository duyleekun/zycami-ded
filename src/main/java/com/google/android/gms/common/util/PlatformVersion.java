/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;

public final class PlatformVersion {
    private static Boolean zza;

    private PlatformVersion() {
    }

    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwichMR1() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        return n10 >= n11;
    }

    public static boolean isAtLeastJellyBean() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        return n10 >= n11;
    }

    public static boolean isAtLeastJellyBeanMR1() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        return n10 >= n11;
    }

    public static boolean isAtLeastJellyBeanMR2() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        return n10 >= n11;
    }

    public static boolean isAtLeastKitKat() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        return n10 >= n11;
    }

    public static boolean isAtLeastKitKatWatch() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 20;
        return n10 >= n11;
    }

    public static boolean isAtLeastLollipop() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        return n10 >= n11;
    }

    public static boolean isAtLeastLollipopMR1() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        return n10 >= n11;
    }

    public static boolean isAtLeastM() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        return n10 >= n11;
    }

    public static boolean isAtLeastN() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        return n10 >= n11;
    }

    public static boolean isAtLeastO() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        return n10 >= n11;
    }

    public static boolean isAtLeastP() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        return n10 >= n11;
    }

    public static boolean isAtLeastQ() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        return n10 >= n11;
    }

    public static boolean isAtLeastR() {
        Object object;
        String string2;
        int n10;
        int n11;
        block18: {
            int n12;
            String string3;
            n11 = PlatformVersion.isAtLeastQ();
            n10 = 0;
            string2 = null;
            if (n11 == 0) {
                return false;
            }
            n11 = Build.VERSION.SDK_INT;
            int n13 = 30;
            int n14 = 1;
            if (n11 >= n13 && (n11 = (int)(((String)(object = Build.VERSION.CODENAME)).equals(string3 = "REL") ? 1 : 0)) != 0) {
                return n14 != 0;
            }
            object = Build.VERSION.CODENAME;
            n13 = ((String)object).length();
            if (n13 == n14 && (n13 = ((String)object).charAt(0)) >= (n12 = 82) && (n11 = ((String)object).charAt(0)) <= (n13 = 90)) {
                n11 = n14;
            } else {
                n11 = 0;
                object = null;
            }
            if (n11 == 0) {
                return false;
            }
            object = zza;
            if (object != null) {
                return (Boolean)object;
            }
            object = "google";
            string3 = Build.BRAND;
            n11 = (int)(((String)object).equals(string3) ? 1 : 0);
            if (n11 == 0) break block18;
            object = Build.ID;
            string3 = "RPP1";
            n11 = (int)(((String)object).startsWith(string3) ? 1 : 0);
            if (n11 != 0) break block18;
            object = Build.ID;
            string3 = "RPP2";
            n11 = (int)(((String)object).startsWith(string3) ? 1 : 0);
            if (n11 != 0) break block18;
            object = Build.VERSION.INCREMENTAL;
            n11 = Integer.parseInt((String)object);
            n13 = 6301457;
            if (n11 < n13) break block18;
            n10 = n14;
        }
        object = n10 != 0;
        try {
            zza = object;
        }
        catch (NumberFormatException numberFormatException) {
            zza = object = Boolean.TRUE;
        }
        object = zza;
        n11 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
        if (n11 == 0) {
            object = "PlatformVersion";
            string2 = "Build version must be at least 6301457 to support R in gmscore";
            Log.w((String)object, (String)string2);
        }
        return zza;
    }
}

