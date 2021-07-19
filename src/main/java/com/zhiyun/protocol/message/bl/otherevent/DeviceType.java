/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.otherevent;

public final class DeviceType
extends Enum {
    public static final /* enum */ DeviceType CAMERA;
    public static final /* enum */ DeviceType PHONE;
    private static final /* synthetic */ DeviceType[] a;
    public final int value;

    static {
        DeviceType deviceType;
        DeviceType deviceType2;
        CAMERA = deviceType2 = new DeviceType("CAMERA", 0, 0);
        int n10 = 1;
        PHONE = deviceType = new DeviceType("PHONE", n10, n10);
        DeviceType[] deviceTypeArray = new DeviceType[2];
        deviceTypeArray[0] = deviceType2;
        deviceTypeArray[n10] = deviceType;
        a = deviceTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DeviceType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DeviceType toDeviceType(int n10) {
        DeviceType deviceType = PHONE;
        int n11 = deviceType.value;
        if (n11 == n10) {
            return deviceType;
        }
        return CAMERA;
    }

    public static DeviceType valueOf(String string2) {
        return Enum.valueOf(DeviceType.class, string2);
    }

    public static DeviceType[] values() {
        return (DeviceType[])a.clone();
    }
}

