/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

public final class BleDeviceViewModel$ScanFailType
extends Enum {
    public static final /* enum */ BleDeviceViewModel$ScanFailType FAIL_TYPE_BLUETOOTH_UNABLE;
    public static final /* enum */ BleDeviceViewModel$ScanFailType FAIL_TYPE_LOCATION_PERMISSION;
    public static final /* enum */ BleDeviceViewModel$ScanFailType FAIL_TYPE_LOCATION_UNABLE;
    public static final /* enum */ BleDeviceViewModel$ScanFailType FAIL_TYPE_OTHER;
    private static final /* synthetic */ BleDeviceViewModel$ScanFailType[] a;

    static {
        BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType;
        BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType2;
        BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType3;
        BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType4;
        FAIL_TYPE_OTHER = bleDeviceViewModel$ScanFailType4 = new BleDeviceViewModel$ScanFailType("FAIL_TYPE_OTHER", 0);
        int n10 = 1;
        FAIL_TYPE_BLUETOOTH_UNABLE = bleDeviceViewModel$ScanFailType3 = new BleDeviceViewModel$ScanFailType("FAIL_TYPE_BLUETOOTH_UNABLE", n10);
        int n11 = 2;
        FAIL_TYPE_LOCATION_PERMISSION = bleDeviceViewModel$ScanFailType2 = new BleDeviceViewModel$ScanFailType("FAIL_TYPE_LOCATION_PERMISSION", n11);
        int n12 = 3;
        FAIL_TYPE_LOCATION_UNABLE = bleDeviceViewModel$ScanFailType = new BleDeviceViewModel$ScanFailType("FAIL_TYPE_LOCATION_UNABLE", n12);
        BleDeviceViewModel$ScanFailType[] bleDeviceViewModel$ScanFailTypeArray = new BleDeviceViewModel$ScanFailType[4];
        bleDeviceViewModel$ScanFailTypeArray[0] = bleDeviceViewModel$ScanFailType4;
        bleDeviceViewModel$ScanFailTypeArray[n10] = bleDeviceViewModel$ScanFailType3;
        bleDeviceViewModel$ScanFailTypeArray[n11] = bleDeviceViewModel$ScanFailType2;
        bleDeviceViewModel$ScanFailTypeArray[n12] = bleDeviceViewModel$ScanFailType;
        a = bleDeviceViewModel$ScanFailTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleDeviceViewModel$ScanFailType() {
        void var2_-1;
        void var1_-1;
    }

    public static BleDeviceViewModel$ScanFailType valueOf(String string2) {
        return Enum.valueOf(BleDeviceViewModel$ScanFailType.class, string2);
    }

    public static BleDeviceViewModel$ScanFailType[] values() {
        return (BleDeviceViewModel$ScanFailType[])a.clone();
    }
}

