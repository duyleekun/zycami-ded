/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediapipe;

public final class ZYMPController$Finger_status
extends Enum {
    public static final /* enum */ ZYMPController$Finger_status SHENZHI;
    public static final /* enum */ ZYMPController$Finger_status WANQU;
    public static final /* enum */ ZYMPController$Finger_status WEIZHI;
    private static final /* synthetic */ ZYMPController$Finger_status[] a;

    static {
        ZYMPController$Finger_status zYMPController$Finger_status;
        ZYMPController$Finger_status zYMPController$Finger_status2;
        ZYMPController$Finger_status zYMPController$Finger_status3;
        WANQU = zYMPController$Finger_status3 = new ZYMPController$Finger_status("WANQU", 0);
        int n10 = 1;
        SHENZHI = zYMPController$Finger_status2 = new ZYMPController$Finger_status("SHENZHI", n10);
        int n11 = 2;
        WEIZHI = zYMPController$Finger_status = new ZYMPController$Finger_status("WEIZHI", n11);
        ZYMPController$Finger_status[] zYMPController$Finger_statusArray = new ZYMPController$Finger_status[3];
        zYMPController$Finger_statusArray[0] = zYMPController$Finger_status3;
        zYMPController$Finger_statusArray[n10] = zYMPController$Finger_status2;
        zYMPController$Finger_statusArray[n11] = zYMPController$Finger_status;
        a = zYMPController$Finger_statusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ZYMPController$Finger_status() {
        void var2_-1;
        void var1_-1;
    }

    public static ZYMPController$Finger_status valueOf(String string2) {
        return Enum.valueOf(ZYMPController$Finger_status.class, string2);
    }

    public static ZYMPController$Finger_status[] values() {
        return (ZYMPController$Finger_status[])a.clone();
    }
}

