/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.hotspot;

import com.zhiyun.protocol.message.bl.wifi.hotspot.ChannelMode$a;

public final class ChannelMode
extends Enum {
    public static final /* enum */ ChannelMode AUTO;
    public static final /* enum */ ChannelMode MANUAL;
    public static final /* enum */ ChannelMode UNKNOWN;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final /* synthetic */ ChannelMode[] d;

    static {
        ChannelMode channelMode;
        ChannelMode channelMode2;
        ChannelMode channelMode3;
        UNKNOWN = channelMode3 = new ChannelMode("UNKNOWN", 0);
        int n10 = 1;
        MANUAL = channelMode2 = new ChannelMode("MANUAL", n10);
        int n11 = 2;
        AUTO = channelMode = new ChannelMode("AUTO", n11);
        ChannelMode[] channelModeArray = new ChannelMode[3];
        channelModeArray[0] = channelMode3;
        channelModeArray[n10] = channelMode2;
        channelModeArray[n11] = channelMode;
        d = channelModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ChannelMode() {
        void var2_-1;
        void var1_-1;
    }

    public static int toCode(ChannelMode channelMode) {
        int[] nArray = ChannelMode$a.a;
        int n10 = channelMode.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11 && n10 != (n11 = 2)) {
            return 0;
        }
        return n11;
    }

    public static ChannelMode toStatus(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return UNKNOWN;
            }
            return AUTO;
        }
        return MANUAL;
    }

    public static ChannelMode valueOf(String string2) {
        return Enum.valueOf(ChannelMode.class, string2);
    }

    public static ChannelMode[] values() {
        return (ChannelMode[])d.clone();
    }
}

