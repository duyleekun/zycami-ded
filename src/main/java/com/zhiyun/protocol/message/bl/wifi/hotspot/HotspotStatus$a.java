/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.hotspot;

import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus;

public class HotspotStatus$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        HotspotStatus hotspotStatus;
        int n12 = HotspotStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            hotspotStatus = HotspotStatus.ENABLE;
            n11 = hotspotStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            hotspotStatus = HotspotStatus.ERROR;
            n11 = hotspotStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            hotspotStatus = HotspotStatus.NONE;
            n11 = hotspotStatus.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

