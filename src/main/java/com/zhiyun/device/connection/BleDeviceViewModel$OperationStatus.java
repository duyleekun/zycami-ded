/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

public final class BleDeviceViewModel$OperationStatus
extends Enum {
    public static final /* enum */ BleDeviceViewModel$OperationStatus OPERATION_STATUS_ACTIVE;
    public static final /* enum */ BleDeviceViewModel$OperationStatus OPERATION_STATUS_FORCE_UPDATE;
    public static final /* enum */ BleDeviceViewModel$OperationStatus OPERATION_STATUS_NONE;
    public static final /* enum */ BleDeviceViewModel$OperationStatus OPERATION_STATUS_NORMAL;
    public static final /* enum */ BleDeviceViewModel$OperationStatus OPERATION_STATUS_RESTRICTIONS_NET_ERROR;
    public static final /* enum */ BleDeviceViewModel$OperationStatus OPERATION_STATUS_RESTRICTIONS_NO_ERROR;
    private static final /* synthetic */ BleDeviceViewModel$OperationStatus[] a;

    static {
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus;
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus2;
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus3;
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus4;
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus5;
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus6;
        OPERATION_STATUS_NONE = bleDeviceViewModel$OperationStatus6 = new BleDeviceViewModel$OperationStatus("OPERATION_STATUS_NONE", 0);
        int n10 = 1;
        OPERATION_STATUS_ACTIVE = bleDeviceViewModel$OperationStatus5 = new BleDeviceViewModel$OperationStatus("OPERATION_STATUS_ACTIVE", n10);
        int n11 = 2;
        OPERATION_STATUS_FORCE_UPDATE = bleDeviceViewModel$OperationStatus4 = new BleDeviceViewModel$OperationStatus("OPERATION_STATUS_FORCE_UPDATE", n11);
        int n12 = 3;
        OPERATION_STATUS_RESTRICTIONS_NET_ERROR = bleDeviceViewModel$OperationStatus3 = new BleDeviceViewModel$OperationStatus("OPERATION_STATUS_RESTRICTIONS_NET_ERROR", n12);
        int n13 = 4;
        OPERATION_STATUS_RESTRICTIONS_NO_ERROR = bleDeviceViewModel$OperationStatus2 = new BleDeviceViewModel$OperationStatus("OPERATION_STATUS_RESTRICTIONS_NO_ERROR", n13);
        int n14 = 5;
        OPERATION_STATUS_NORMAL = bleDeviceViewModel$OperationStatus = new BleDeviceViewModel$OperationStatus("OPERATION_STATUS_NORMAL", n14);
        BleDeviceViewModel$OperationStatus[] bleDeviceViewModel$OperationStatusArray = new BleDeviceViewModel$OperationStatus[6];
        bleDeviceViewModel$OperationStatusArray[0] = bleDeviceViewModel$OperationStatus6;
        bleDeviceViewModel$OperationStatusArray[n10] = bleDeviceViewModel$OperationStatus5;
        bleDeviceViewModel$OperationStatusArray[n11] = bleDeviceViewModel$OperationStatus4;
        bleDeviceViewModel$OperationStatusArray[n12] = bleDeviceViewModel$OperationStatus3;
        bleDeviceViewModel$OperationStatusArray[n13] = bleDeviceViewModel$OperationStatus2;
        bleDeviceViewModel$OperationStatusArray[n14] = bleDeviceViewModel$OperationStatus;
        a = bleDeviceViewModel$OperationStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleDeviceViewModel$OperationStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static BleDeviceViewModel$OperationStatus valueOf(String string2) {
        return Enum.valueOf(BleDeviceViewModel$OperationStatus.class, string2);
    }

    public static BleDeviceViewModel$OperationStatus[] values() {
        return (BleDeviceViewModel$OperationStatus[])a.clone();
    }
}

