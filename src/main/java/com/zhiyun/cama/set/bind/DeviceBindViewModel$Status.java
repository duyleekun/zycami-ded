/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

public final class DeviceBindViewModel$Status
extends Enum {
    public static final /* enum */ DeviceBindViewModel$Status FAILED;
    public static final /* enum */ DeviceBindViewModel$Status NET_ERROR;
    public static final /* enum */ DeviceBindViewModel$Status RUNNING;
    public static final /* enum */ DeviceBindViewModel$Status SUCCESS_EMPTY;
    public static final /* enum */ DeviceBindViewModel$Status SUCCESS_OK;
    private static final /* synthetic */ DeviceBindViewModel$Status[] a;

    static {
        DeviceBindViewModel$Status deviceBindViewModel$Status;
        DeviceBindViewModel$Status deviceBindViewModel$Status2;
        DeviceBindViewModel$Status deviceBindViewModel$Status3;
        DeviceBindViewModel$Status deviceBindViewModel$Status4;
        DeviceBindViewModel$Status deviceBindViewModel$Status5;
        RUNNING = deviceBindViewModel$Status5 = new DeviceBindViewModel$Status("RUNNING", 0);
        int n10 = 1;
        SUCCESS_OK = deviceBindViewModel$Status4 = new DeviceBindViewModel$Status("SUCCESS_OK", n10);
        int n11 = 2;
        SUCCESS_EMPTY = deviceBindViewModel$Status3 = new DeviceBindViewModel$Status("SUCCESS_EMPTY", n11);
        int n12 = 3;
        FAILED = deviceBindViewModel$Status2 = new DeviceBindViewModel$Status("FAILED", n12);
        int n13 = 4;
        NET_ERROR = deviceBindViewModel$Status = new DeviceBindViewModel$Status("NET_ERROR", n13);
        DeviceBindViewModel$Status[] deviceBindViewModel$StatusArray = new DeviceBindViewModel$Status[5];
        deviceBindViewModel$StatusArray[0] = deviceBindViewModel$Status5;
        deviceBindViewModel$StatusArray[n10] = deviceBindViewModel$Status4;
        deviceBindViewModel$StatusArray[n11] = deviceBindViewModel$Status3;
        deviceBindViewModel$StatusArray[n12] = deviceBindViewModel$Status2;
        deviceBindViewModel$StatusArray[n13] = deviceBindViewModel$Status;
        a = deviceBindViewModel$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DeviceBindViewModel$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static DeviceBindViewModel$Status valueOf(String string2) {
        return Enum.valueOf(DeviceBindViewModel$Status.class, string2);
    }

    public static DeviceBindViewModel$Status[] values() {
        return (DeviceBindViewModel$Status[])a.clone();
    }
}

