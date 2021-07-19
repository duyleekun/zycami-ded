/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.wifi.hotspot;

import com.zhiyun.protocol.message.bl.wifi.hotspot.Channel$a;

public final class Channel$Status
extends Enum {
    public static final /* enum */ Channel$Status BUSY;
    public static final /* enum */ Channel$Status IDLE;
    public static final /* enum */ Channel$Status UNKNOWN;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final /* synthetic */ Channel$Status[] d;

    static {
        Channel$Status channel$Status;
        Channel$Status channel$Status2;
        Channel$Status channel$Status3;
        IDLE = channel$Status3 = new Channel$Status("IDLE", 0);
        int n10 = 1;
        BUSY = channel$Status2 = new Channel$Status("BUSY", n10);
        int n11 = 2;
        UNKNOWN = channel$Status = new Channel$Status("UNKNOWN", n11);
        Channel$Status[] channel$StatusArray = new Channel$Status[3];
        channel$StatusArray[0] = channel$Status3;
        channel$StatusArray[n10] = channel$Status2;
        channel$StatusArray[n11] = channel$Status;
        d = channel$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Channel$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static Channel$Status from(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return UNKNOWN;
            }
            return BUSY;
        }
        return IDLE;
    }

    public static int to(Channel$Status channel$Status) {
        int[] nArray = Channel$a.a;
        int n10 = channel$Status.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                return n12;
            }
            return n11;
        }
        return 0;
    }

    public static Channel$Status valueOf(String string2) {
        return Enum.valueOf(Channel$Status.class, string2);
    }

    public static Channel$Status[] values() {
        return (Channel$Status[])d.clone();
    }
}

