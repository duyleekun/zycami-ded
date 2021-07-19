/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.connect;

import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$ScanFailType;

public class DeviceConnectFragment$b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14;
        Object object5;
        int n15 = BleDeviceViewModel$ScanFailType.values().length;
        int[] nArray = new int[n15];
        c = nArray;
        int n16 = 1;
        try {
            object5 = BleDeviceViewModel$ScanFailType.FAIL_TYPE_OTHER;
            n14 = object5.ordinal();
            nArray[n14] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 2;
        try {
            object5 = c;
            object4 = BleDeviceViewModel$ScanFailType.FAIL_TYPE_BLUETOOTH_UNABLE;
            n13 = object4.ordinal();
            object5[n13] = (BleDeviceViewModel$ScanFailType)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 3;
        try {
            object4 = c;
            object3 = BleDeviceViewModel$ScanFailType.FAIL_TYPE_LOCATION_UNABLE;
            n12 = object3.ordinal();
            object4[n12] = (BleDeviceViewModel$ScanFailType)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 4;
        try {
            object3 = c;
            object2 = BleDeviceViewModel$ScanFailType.FAIL_TYPE_LOCATION_PERMISSION;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (BleDeviceViewModel$ScanFailType)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = BleDeviceViewModel$ConnectStatus.values().length;
        object3 = new int[n12];
        b = (int[])object3;
        try {
            object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_FAIL;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (BleDeviceViewModel$ScanFailType)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object3 = b;
            object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_CONNECTED;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (BleDeviceViewModel$ScanFailType)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object3 = b;
            object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_INITIATIVE_CONNECTED;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (BleDeviceViewModel$ScanFailType)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object3 = b;
            object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_ING;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (BleDeviceViewModel$ScanFailType)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 5;
        try {
            object2 = b;
            enum_ = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_DISCONNECT;
            n10 = enum_.ordinal();
            object2[n10] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = BleDeviceViewModel$OperationStatus.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_ACTIVE;
            n10 = enum_.ordinal();
            object2[n10] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_FORCE_UPDATE;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)BleDeviceViewModel$OperationStatus.OPERATION_STATUS_NORMAL;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_RESTRICTIONS_NO_ERROR;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_RESTRICTIONS_NET_ERROR;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

