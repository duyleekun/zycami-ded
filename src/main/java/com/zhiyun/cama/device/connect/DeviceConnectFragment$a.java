/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.connect;

import com.zhiyun.cama.device.connect.DeviceConnectFragment;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.a.f.c.b;

public class DeviceConnectFragment$a
extends d.v.c.y0.b.v.b {
    public final /* synthetic */ DeviceConnectFragment c;

    public DeviceConnectFragment$a(DeviceConnectFragment deviceConnectFragment) {
        this.c = deviceConnectFragment;
    }

    public void h(BleDevice object, int n10) {
        Object object2 = b.N();
        n10 = (int)(((b)object2).s() ? 1 : 0);
        String string2 = null;
        if (n10 != 0) {
            n10 = b.N().i().getId();
            string2 = String.valueOf(n10);
            object2 = b.N().i().getToken();
        } else {
            n10 = 0;
            object2 = null;
        }
        BleDeviceViewModel bleDeviceViewModel = DeviceConnectFragment.j(this.c);
        object = ((BleDevice)object).a;
        bleDeviceViewModel.r((Stabilizer)object, string2, (String)object2);
    }
}

