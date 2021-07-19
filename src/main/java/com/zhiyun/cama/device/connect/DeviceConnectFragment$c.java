/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.connect;

import com.zhiyun.cama.device.connect.DeviceConnectFragment;
import com.zhiyun.device.connection.BleConnection;
import d.v.c.x1.l;

public class DeviceConnectFragment$c {
    public final /* synthetic */ DeviceConnectFragment a;

    public DeviceConnectFragment$c(DeviceConnectFragment deviceConnectFragment) {
        this.a = deviceConnectFragment;
    }

    public void a() {
        DeviceConnectFragment.k(this.a);
    }

    public void b() {
        DeviceConnectFragment.l(this.a);
    }

    public void c() {
        BleConnection.W().R();
        l.d(this.a, 2131361899);
    }
}

