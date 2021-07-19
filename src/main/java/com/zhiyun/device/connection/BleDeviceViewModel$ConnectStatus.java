/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

public final class BleDeviceViewModel$ConnectStatus
extends Enum {
    public static final /* enum */ BleDeviceViewModel$ConnectStatus CONNECT_STATUS_CONNECTED;
    public static final /* enum */ BleDeviceViewModel$ConnectStatus CONNECT_STATUS_DISCONNECT;
    public static final /* enum */ BleDeviceViewModel$ConnectStatus CONNECT_STATUS_FAIL;
    public static final /* enum */ BleDeviceViewModel$ConnectStatus CONNECT_STATUS_ING;
    public static final /* enum */ BleDeviceViewModel$ConnectStatus CONNECT_STATUS_INITIATIVE_CONNECTED;
    public static final /* enum */ BleDeviceViewModel$ConnectStatus CONNECT_STATUS_NONE;
    private static final /* synthetic */ BleDeviceViewModel$ConnectStatus[] a;

    static {
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus;
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus2;
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus3;
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus4;
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus5;
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus6;
        CONNECT_STATUS_NONE = bleDeviceViewModel$ConnectStatus6 = new BleDeviceViewModel$ConnectStatus("CONNECT_STATUS_NONE", 0);
        int n10 = 1;
        CONNECT_STATUS_ING = bleDeviceViewModel$ConnectStatus5 = new BleDeviceViewModel$ConnectStatus("CONNECT_STATUS_ING", n10);
        int n11 = 2;
        CONNECT_STATUS_CONNECTED = bleDeviceViewModel$ConnectStatus4 = new BleDeviceViewModel$ConnectStatus("CONNECT_STATUS_CONNECTED", n11);
        int n12 = 3;
        CONNECT_STATUS_INITIATIVE_CONNECTED = bleDeviceViewModel$ConnectStatus3 = new BleDeviceViewModel$ConnectStatus("CONNECT_STATUS_INITIATIVE_CONNECTED", n12);
        int n13 = 4;
        CONNECT_STATUS_FAIL = bleDeviceViewModel$ConnectStatus2 = new BleDeviceViewModel$ConnectStatus("CONNECT_STATUS_FAIL", n13);
        int n14 = 5;
        CONNECT_STATUS_DISCONNECT = bleDeviceViewModel$ConnectStatus = new BleDeviceViewModel$ConnectStatus("CONNECT_STATUS_DISCONNECT", n14);
        BleDeviceViewModel$ConnectStatus[] bleDeviceViewModel$ConnectStatusArray = new BleDeviceViewModel$ConnectStatus[6];
        bleDeviceViewModel$ConnectStatusArray[0] = bleDeviceViewModel$ConnectStatus6;
        bleDeviceViewModel$ConnectStatusArray[n10] = bleDeviceViewModel$ConnectStatus5;
        bleDeviceViewModel$ConnectStatusArray[n11] = bleDeviceViewModel$ConnectStatus4;
        bleDeviceViewModel$ConnectStatusArray[n12] = bleDeviceViewModel$ConnectStatus3;
        bleDeviceViewModel$ConnectStatusArray[n13] = bleDeviceViewModel$ConnectStatus2;
        bleDeviceViewModel$ConnectStatusArray[n14] = bleDeviceViewModel$ConnectStatus;
        a = bleDeviceViewModel$ConnectStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleDeviceViewModel$ConnectStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static BleDeviceViewModel$ConnectStatus valueOf(String string2) {
        return Enum.valueOf(BleDeviceViewModel$ConnectStatus.class, string2);
    }

    public static BleDeviceViewModel$ConnectStatus[] values() {
        return (BleDeviceViewModel$ConnectStatus[])a.clone();
    }
}

