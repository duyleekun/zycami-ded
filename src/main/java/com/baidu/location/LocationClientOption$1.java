/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

import com.baidu.location.LocationClientOption$LocationMode;

public class LocationClientOption$1 {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        LocationClientOption$LocationMode locationClientOption$LocationMode;
        int n12 = LocationClientOption$LocationMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            locationClientOption$LocationMode = LocationClientOption$LocationMode.Hight_Accuracy;
            n11 = locationClientOption$LocationMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            locationClientOption$LocationMode = LocationClientOption$LocationMode.Battery_Saving;
            n11 = locationClientOption$LocationMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            locationClientOption$LocationMode = LocationClientOption$LocationMode.Device_Sensors;
            n11 = locationClientOption$LocationMode.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

