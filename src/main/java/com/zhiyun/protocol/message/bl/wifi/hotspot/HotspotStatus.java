/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.hotspot;

import com.zhiyun.protocol.message.bl.wifi.hotspot.HotspotStatus$a;

public final class HotspotStatus
extends Enum {
    public static final /* enum */ HotspotStatus ENABLE;
    public static final /* enum */ HotspotStatus ERROR;
    public static final /* enum */ HotspotStatus NONE;
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final /* synthetic */ HotspotStatus[] d;

    static {
        HotspotStatus hotspotStatus;
        HotspotStatus hotspotStatus2;
        HotspotStatus hotspotStatus3;
        NONE = hotspotStatus3 = new HotspotStatus("NONE", 0);
        int n10 = 1;
        ENABLE = hotspotStatus2 = new HotspotStatus("ENABLE", n10);
        int n11 = 2;
        ERROR = hotspotStatus = new HotspotStatus("ERROR", n11);
        HotspotStatus[] hotspotStatusArray = new HotspotStatus[3];
        hotspotStatusArray[0] = hotspotStatus3;
        hotspotStatusArray[n10] = hotspotStatus2;
        hotspotStatusArray[n11] = hotspotStatus;
        d = hotspotStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HotspotStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static int toCode(HotspotStatus hotspotStatus) {
        int[] nArray = HotspotStatus$a.a;
        int n10 = hotspotStatus.ordinal();
        n10 = nArray[n10];
        int n11 = 2;
        int n12 = 1;
        if (n10 != n12) {
            if (n10 != n11) {
                return n12;
            }
            return 3;
        }
        return n11;
    }

    public static HotspotStatus toStatus(int n10) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                return NONE;
            }
            return ERROR;
        }
        return ENABLE;
    }

    public static HotspotStatus valueOf(String string2) {
        return Enum.valueOf(HotspotStatus.class, string2);
    }

    public static HotspotStatus[] values() {
        return (HotspotStatus[])d.clone();
    }
}

