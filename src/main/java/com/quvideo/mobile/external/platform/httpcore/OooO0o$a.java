/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.httpcore;

import com.quvideo.mobile.external.platform.httpcore.country.OooOO0O;

public class OooO0o$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        OooOO0O oooOO0O;
        int n12 = OooOO0O.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            oooOO0O = OooOO0O.ZONE_BIG_CHINA;
            n11 = oooOO0O.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            oooOO0O = OooOO0O.ZONE_AMERICAN;
            n11 = oooOO0O.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            oooOO0O = OooOO0O.ZONE_EAST_ASIA;
            n11 = oooOO0O.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            oooOO0O = OooOO0O.ZONE_MIDDLE_EAST;
            n11 = oooOO0O.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

