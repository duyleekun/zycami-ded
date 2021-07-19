/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

public final class DeviceBindViewModel$BindOperateState
extends Enum {
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_ACTIVATION;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_ALREADY_BIND;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_BIND_FAIL;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_BIND_OTHERS;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_BIND_SUCCESS;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_DEVICE_ERROR;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_FORCE_UPDATE;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_NOT_BIND;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_START;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_UNBIND_FAIL;
    public static final /* enum */ DeviceBindViewModel$BindOperateState BIND_OPERATE_STATE_UNBIND_SUCCESS;
    private static final /* synthetic */ DeviceBindViewModel$BindOperateState[] a;

    static {
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState2;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState3;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState4;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState5;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState6;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState7;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState8;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState9;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState10;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState11;
        BIND_OPERATE_STATE_START = deviceBindViewModel$BindOperateState11 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_START", 0);
        int n10 = 1;
        BIND_OPERATE_STATE_UNBIND_SUCCESS = deviceBindViewModel$BindOperateState10 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_UNBIND_SUCCESS", n10);
        int n11 = 2;
        BIND_OPERATE_STATE_NOT_BIND = deviceBindViewModel$BindOperateState9 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_NOT_BIND", n11);
        BIND_OPERATE_STATE_UNBIND_FAIL = deviceBindViewModel$BindOperateState8 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_UNBIND_FAIL", 3);
        BIND_OPERATE_STATE_BIND_SUCCESS = deviceBindViewModel$BindOperateState7 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_BIND_SUCCESS", 4);
        BIND_OPERATE_STATE_BIND_FAIL = deviceBindViewModel$BindOperateState6 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_BIND_FAIL", 5);
        BIND_OPERATE_STATE_FORCE_UPDATE = deviceBindViewModel$BindOperateState5 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_FORCE_UPDATE", 6);
        BIND_OPERATE_STATE_ACTIVATION = deviceBindViewModel$BindOperateState4 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_ACTIVATION", 7);
        BIND_OPERATE_STATE_ALREADY_BIND = deviceBindViewModel$BindOperateState3 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_ALREADY_BIND", 8);
        BIND_OPERATE_STATE_BIND_OTHERS = deviceBindViewModel$BindOperateState2 = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_BIND_OTHERS", 9);
        int n12 = 10;
        BIND_OPERATE_STATE_DEVICE_ERROR = deviceBindViewModel$BindOperateState = new DeviceBindViewModel$BindOperateState("BIND_OPERATE_STATE_DEVICE_ERROR", n12);
        DeviceBindViewModel$BindOperateState[] deviceBindViewModel$BindOperateStateArray = new DeviceBindViewModel$BindOperateState[11];
        deviceBindViewModel$BindOperateStateArray[0] = deviceBindViewModel$BindOperateState11;
        deviceBindViewModel$BindOperateStateArray[n10] = deviceBindViewModel$BindOperateState10;
        deviceBindViewModel$BindOperateStateArray[n11] = deviceBindViewModel$BindOperateState9;
        deviceBindViewModel$BindOperateStateArray[3] = deviceBindViewModel$BindOperateState8;
        deviceBindViewModel$BindOperateStateArray[4] = deviceBindViewModel$BindOperateState7;
        deviceBindViewModel$BindOperateStateArray[5] = deviceBindViewModel$BindOperateState6;
        deviceBindViewModel$BindOperateStateArray[6] = deviceBindViewModel$BindOperateState5;
        deviceBindViewModel$BindOperateStateArray[7] = deviceBindViewModel$BindOperateState4;
        deviceBindViewModel$BindOperateStateArray[8] = deviceBindViewModel$BindOperateState3;
        deviceBindViewModel$BindOperateStateArray[9] = deviceBindViewModel$BindOperateState2;
        deviceBindViewModel$BindOperateStateArray[n12] = deviceBindViewModel$BindOperateState;
        a = deviceBindViewModel$BindOperateStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DeviceBindViewModel$BindOperateState() {
        void var2_-1;
        void var1_-1;
    }

    public static DeviceBindViewModel$BindOperateState valueOf(String string2) {
        return Enum.valueOf(DeviceBindViewModel$BindOperateState.class, string2);
    }

    public static DeviceBindViewModel$BindOperateState[] values() {
        return (DeviceBindViewModel$BindOperateState[])a.clone();
    }
}

