/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;

public class s$c {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

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
        int n13 = BleDeviceViewModel$ConnectStatus.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object3 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_FAIL;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = b;
            object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_DISCONNECT;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (BleDeviceViewModel$ConnectStatus)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = b;
            enum_ = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_CONNECTED;
            n10 = enum_.ordinal();
            object2[n10] = (BleDeviceViewModel$ConnectStatus)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = BleDeviceViewModel$OperationStatus.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_ACTIVE;
            n10 = enum_.ordinal();
            object2[n10] = (BleDeviceViewModel$ConnectStatus)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_FORCE_UPDATE;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)BleDeviceViewModel$OperationStatus.OPERATION_STATUS_NORMAL;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_RESTRICTIONS_NET_ERROR;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_RESTRICTIONS_NO_ERROR;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

