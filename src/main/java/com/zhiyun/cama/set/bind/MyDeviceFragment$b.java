/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$Status;

public class MyDeviceFragment$b {
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
        int n13;
        Object object4;
        int n14;
        Object object5;
        int n15 = DeviceBindViewModel$Status.values().length;
        int[] nArray = new int[n15];
        b = nArray;
        int n16 = 1;
        try {
            object5 = DeviceBindViewModel$Status.RUNNING;
            n14 = object5.ordinal();
            nArray[n14] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 2;
        try {
            object5 = b;
            object4 = DeviceBindViewModel$Status.SUCCESS_OK;
            n13 = object4.ordinal();
            object5[n13] = (DeviceBindViewModel$Status)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 3;
        try {
            object4 = b;
            object3 = DeviceBindViewModel$Status.SUCCESS_EMPTY;
            n12 = object3.ordinal();
            object4[n12] = (DeviceBindViewModel$Status)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 4;
        try {
            object3 = b;
            object2 = DeviceBindViewModel$Status.FAILED;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (DeviceBindViewModel$Status)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 5;
        try {
            object2 = b;
            enum_ = DeviceBindViewModel$Status.NET_ERROR;
            n10 = enum_.ordinal();
            object2[n10] = (DeviceBindViewModel$Status)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = DeviceBindViewModel$BindOperateState.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_START;
            n10 = enum_.ordinal();
            object2[n10] = (DeviceBindViewModel$Status)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_BIND_SUCCESS;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_ACTIVATION;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_BIND_FAIL;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_ALREADY_BIND;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_BIND_OTHERS;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_UNBIND_SUCCESS;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_UNBIND_FAIL;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_NOT_BIND;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_DEVICE_ERROR;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_FORCE_UPDATE;
            n16 = ((Enum)object).ordinal();
            nArray[n16] = n14 = 11;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

