/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

public final class BleDeviceViewModel$ShowStatus
extends Enum {
    public static final /* enum */ BleDeviceViewModel$ShowStatus SHOW_STATE_DEVICE_LIST;
    public static final /* enum */ BleDeviceViewModel$ShowStatus SHOW_STATE_FAIL;
    public static final /* enum */ BleDeviceViewModel$ShowStatus SHOW_STATE_NO_DEVICE;
    public static final /* enum */ BleDeviceViewModel$ShowStatus SHOW_STATE_NO_SCAN;
    public static final /* enum */ BleDeviceViewModel$ShowStatus SHOW_STATE_SCANNING;
    private static final /* synthetic */ BleDeviceViewModel$ShowStatus[] a;

    static {
        BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus;
        BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus2;
        BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus3;
        BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus4;
        BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus5;
        SHOW_STATE_NO_SCAN = bleDeviceViewModel$ShowStatus5 = new BleDeviceViewModel$ShowStatus("SHOW_STATE_NO_SCAN", 0);
        int n10 = 1;
        SHOW_STATE_SCANNING = bleDeviceViewModel$ShowStatus4 = new BleDeviceViewModel$ShowStatus("SHOW_STATE_SCANNING", n10);
        int n11 = 2;
        SHOW_STATE_DEVICE_LIST = bleDeviceViewModel$ShowStatus3 = new BleDeviceViewModel$ShowStatus("SHOW_STATE_DEVICE_LIST", n11);
        int n12 = 3;
        SHOW_STATE_NO_DEVICE = bleDeviceViewModel$ShowStatus2 = new BleDeviceViewModel$ShowStatus("SHOW_STATE_NO_DEVICE", n12);
        int n13 = 4;
        SHOW_STATE_FAIL = bleDeviceViewModel$ShowStatus = new BleDeviceViewModel$ShowStatus("SHOW_STATE_FAIL", n13);
        BleDeviceViewModel$ShowStatus[] bleDeviceViewModel$ShowStatusArray = new BleDeviceViewModel$ShowStatus[5];
        bleDeviceViewModel$ShowStatusArray[0] = bleDeviceViewModel$ShowStatus5;
        bleDeviceViewModel$ShowStatusArray[n10] = bleDeviceViewModel$ShowStatus4;
        bleDeviceViewModel$ShowStatusArray[n11] = bleDeviceViewModel$ShowStatus3;
        bleDeviceViewModel$ShowStatusArray[n12] = bleDeviceViewModel$ShowStatus2;
        bleDeviceViewModel$ShowStatusArray[n13] = bleDeviceViewModel$ShowStatus;
        a = bleDeviceViewModel$ShowStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleDeviceViewModel$ShowStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static BleDeviceViewModel$ShowStatus valueOf(String string2) {
        return Enum.valueOf(BleDeviceViewModel$ShowStatus.class, string2);
    }

    public static BleDeviceViewModel$ShowStatus[] values() {
        return (BleDeviceViewModel$ShowStatus[])a.clone();
    }
}

