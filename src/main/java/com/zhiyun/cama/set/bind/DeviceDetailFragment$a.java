/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;

public class DeviceDetailFragment$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState;
        int n12 = DeviceBindViewModel$BindOperateState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_START;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_BIND_SUCCESS;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_DEVICE_ERROR;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_BIND_FAIL;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_ALREADY_BIND;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_BIND_OTHERS;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_UNBIND_SUCCESS;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_UNBIND_FAIL;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_NOT_BIND;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_ACTIVATION;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_FORCE_UPDATE;
            n11 = deviceBindViewModel$BindOperateState.ordinal();
            nArray[n11] = n10 = 11;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

