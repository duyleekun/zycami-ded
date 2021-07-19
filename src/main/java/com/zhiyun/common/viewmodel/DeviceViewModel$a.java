/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.viewmodel;

import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import d.v.e.l.b1$c;

public class DeviceViewModel$a
implements b1$c {
    public final /* synthetic */ DeviceViewModel a;

    public DeviceViewModel$a(DeviceViewModel deviceViewModel) {
        this.a = deviceViewModel;
    }

    private void e(DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent) {
        this.a.c.postValue((Object)deviceViewModel$NetWorkEvent);
    }

    public void a(boolean bl2) {
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent = DeviceViewModel$NetWorkEvent.NET_WORK_MOBILE_CONNECTED;
        this.e(deviceViewModel$NetWorkEvent);
    }

    public void b() {
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_DISCONNECTED;
        this.e(deviceViewModel$NetWorkEvent);
    }

    public void c(boolean bl2) {
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent = DeviceViewModel$NetWorkEvent.NET_WORK_WIFI_CONNECTED;
        this.e(deviceViewModel$NetWorkEvent);
    }

    public void d() {
        DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent = DeviceViewModel$NetWorkEvent.NET_WORK_MOBILE_DISCONNECTED;
        this.e(deviceViewModel$NetWorkEvent);
    }
}

