/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.viewmodel;

public final class DeviceViewModel$NetWorkEvent
extends Enum {
    public static final /* enum */ DeviceViewModel$NetWorkEvent NET_WORK_MOBILE_CONNECTED;
    public static final /* enum */ DeviceViewModel$NetWorkEvent NET_WORK_MOBILE_DISCONNECTED;
    public static final /* enum */ DeviceViewModel$NetWorkEvent NET_WORK_WIFI_CONNECTED;
    public static final /* enum */ DeviceViewModel$NetWorkEvent NET_WORK_WIFI_DISCONNECTED;
    private static final /* synthetic */ DeviceViewModel$NetWorkEvent[] a;

    static {
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent;
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent2;
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent3;
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent4;
        NET_WORK_WIFI_CONNECTED = deviceViewModel$NetWorkEvent4 = new DeviceViewModel$NetWorkEvent("NET_WORK_WIFI_CONNECTED", 0);
        int n10 = 1;
        NET_WORK_WIFI_DISCONNECTED = deviceViewModel$NetWorkEvent3 = new DeviceViewModel$NetWorkEvent("NET_WORK_WIFI_DISCONNECTED", n10);
        int n11 = 2;
        NET_WORK_MOBILE_CONNECTED = deviceViewModel$NetWorkEvent2 = new DeviceViewModel$NetWorkEvent("NET_WORK_MOBILE_CONNECTED", n11);
        int n12 = 3;
        NET_WORK_MOBILE_DISCONNECTED = deviceViewModel$NetWorkEvent = new DeviceViewModel$NetWorkEvent("NET_WORK_MOBILE_DISCONNECTED", n12);
        DeviceViewModel$NetWorkEvent[] deviceViewModel$NetWorkEventArray = new DeviceViewModel$NetWorkEvent[4];
        deviceViewModel$NetWorkEventArray[0] = deviceViewModel$NetWorkEvent4;
        deviceViewModel$NetWorkEventArray[n10] = deviceViewModel$NetWorkEvent3;
        deviceViewModel$NetWorkEventArray[n11] = deviceViewModel$NetWorkEvent2;
        deviceViewModel$NetWorkEventArray[n12] = deviceViewModel$NetWorkEvent;
        a = deviceViewModel$NetWorkEventArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DeviceViewModel$NetWorkEvent() {
        void var2_-1;
        void var1_-1;
    }

    public static DeviceViewModel$NetWorkEvent valueOf(String string2) {
        return Enum.valueOf(DeviceViewModel$NetWorkEvent.class, string2);
    }

    public static DeviceViewModel$NetWorkEvent[] values() {
        return (DeviceViewModel$NetWorkEvent[])a.clone();
    }
}

