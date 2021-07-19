/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.os;

import android.os.Build;

public class BuildCompat {
    private BuildCompat() {
    }

    public static boolean isAtLeastN() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastNMR1() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastO() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastOMR1() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastP() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastQ() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastR() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean isAtLeastS() {
        return Build.VERSION.CODENAME.equals("S");
    }
}

