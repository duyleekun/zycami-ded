/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.data.local.entity.AppDeviceInfo;
import d.v.p.a;
import d.v.p.a$c;

public class BleConnection$a
implements a$c {
    public final /* synthetic */ BleConnection a;

    public BleConnection$a(BleConnection bleConnection) {
        this.a = bleConnection;
    }

    public void a() {
    }

    public void b(double d10, double d11) {
        Object object;
        Object object2;
        AppDeviceInfo appDeviceInfo = BleConnection.a(this.a);
        if (appDeviceInfo != null) {
            appDeviceInfo = BleConnection.a(this.a);
            Object object3 = String.valueOf(d11);
            appDeviceInfo.setLatitude((String)object3);
            object3 = BleConnection.a(this.a);
            object2 = String.valueOf(d10);
            ((AppDeviceInfo)object3).setLongitude((String)object2);
            object2 = this.a;
            object = BleConnection.a((BleConnection)object2);
            BleConnection.n((BleConnection)object2, (AppDeviceInfo)object);
        }
        object2 = BleConnection.C(this.a);
        object = BleConnection.A(this.a);
        ((a)object2).f((a$c)object);
    }
}

