/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.hotspot;

import com.zhiyun.protocol.message.bl.wifi.hotspot.ChannelMode;

public class ChannelMode$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ChannelMode channelMode;
        int n12 = ChannelMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            channelMode = ChannelMode.MANUAL;
            n11 = channelMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            channelMode = ChannelMode.AUTO;
            n11 = channelMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            channelMode = ChannelMode.UNKNOWN;
            n11 = channelMode.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

