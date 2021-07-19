/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.set.bind;

import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.stabilizer.Stabilizer;

public class DeviceBindViewModel$a
implements BleConnection$j {
    public final /* synthetic */ DeviceBindViewModel a;

    public DeviceBindViewModel$a(DeviceBindViewModel deviceBindViewModel) {
        this.a = deviceBindViewModel;
    }

    public void a() {
        DeviceBindViewModel.c(this.a, false);
        this.a.T(true);
    }

    public void b(Stabilizer stabilizer) {
    }

    public void c(Throwable throwable, Stabilizer stabilizer) {
    }

    public void d(Stabilizer object) {
        object = this.a;
        boolean bl2 = DeviceBindViewModel.b((DeviceBindViewModel)object);
        if (!bl2) {
            DeviceBindViewModel.c(this.a, true);
            object = this.a;
            ((DeviceBindViewModel)object).T(false);
        }
    }

    public void e(Stabilizer stabilizer) {
        DeviceBindViewModel.c(this.a, false);
        this.a.T(true);
    }

    public void f(boolean bl2) {
        DeviceBindViewModel.c(this.a, false);
        this.a.T(true);
    }

    public void g() {
        DeviceBindViewModel.c(this.a, false);
        this.a.T(true);
    }

    public void h() {
        DeviceBindViewModel.c(this.a, false);
        this.a.T(true);
    }
}

