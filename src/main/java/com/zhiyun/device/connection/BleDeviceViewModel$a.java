/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.device.connection.BleDeviceViewModel$ScanFailType;
import com.zhiyun.device.connection.BleDeviceViewModel$ShowStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.g.e.q;
import d.v.g.e.q$b;

public class BleDeviceViewModel$a
extends q$b {
    public final /* synthetic */ BleDeviceViewModel a;

    public BleDeviceViewModel$a(BleDeviceViewModel bleDeviceViewModel) {
        this.a = bleDeviceViewModel;
    }

    public void f() {
        super.f();
        BleDeviceViewModel.c(this.a, false);
    }

    public void g(Stabilizer object) {
        Object object2 = BleDeviceViewModel.d(this.a);
        BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus = BleDeviceViewModel$ShowStatus.SHOW_STATE_DEVICE_LIST;
        ((MutableLiveData)object2).setValue((Object)bleDeviceViewModel$ShowStatus);
        object2 = new BleDevice((Stabilizer)object);
        object = BleDeviceViewModel.f(this.a);
        boolean bl2 = object.contains(object2);
        if (!bl2) {
            BleDeviceViewModel.f(this.a).add(object2);
            object = BleDeviceViewModel.g(this.a);
            ((MutableLiveData)object).setValue(object2);
        }
    }

    public void i() {
        super.i();
        MutableLiveData mutableLiveData = BleDeviceViewModel.k(this.a);
        BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType = BleDeviceViewModel$ScanFailType.FAIL_TYPE_LOCATION_UNABLE;
        mutableLiveData.setValue((Object)bleDeviceViewModel$ScanFailType);
    }

    public void j() {
        super.j();
        Object object = this.a;
        boolean bl2 = BleDeviceViewModel.b((BleDeviceViewModel)object);
        if (bl2) {
            BleDeviceViewModel.c(this.a, false);
            return;
        }
        object = BleDeviceViewModel.d(this.a);
        Object object2 = BleDeviceViewModel.f(this.a);
        boolean bl3 = object2.isEmpty();
        object2 = bl3 && !(bl3 = ((BleConnection)(object2 = BleConnection.W())).c0()) ? BleDeviceViewModel$ShowStatus.SHOW_STATE_NO_DEVICE : BleDeviceViewModel$ShowStatus.SHOW_STATE_DEVICE_LIST;
        ((MutableLiveData)object).setValue(object2);
        object = BleDeviceViewModel.f(this.a);
        bl2 = object.isEmpty();
        if (!bl2) {
            object = BleDeviceViewModel.j(this.a);
            long l10 = 10000L;
            q$b q$b = BleDeviceViewModel.i(this.a);
            ((q)object).c(l10, q$b);
        }
    }

    public void n() {
        super.n();
        MutableLiveData mutableLiveData = BleDeviceViewModel.k(this.a);
        Enum enum_ = BleDeviceViewModel$ScanFailType.FAIL_TYPE_BLUETOOTH_UNABLE;
        mutableLiveData.setValue(enum_);
        mutableLiveData = BleDeviceViewModel.d(this.a);
        enum_ = BleDeviceViewModel$ShowStatus.SHOW_STATE_FAIL;
        mutableLiveData.setValue(enum_);
    }

    public void onFailed(Throwable object) {
        super.onFailed((Throwable)object);
        object = BleDeviceViewModel.k(this.a);
        Enum enum_ = BleDeviceViewModel$ScanFailType.FAIL_TYPE_OTHER;
        ((MutableLiveData)object).setValue(enum_);
        object = BleDeviceViewModel.d(this.a);
        enum_ = BleDeviceViewModel$ShowStatus.SHOW_STATE_FAIL;
        ((MutableLiveData)object).setValue(enum_);
    }

    public void r() {
        super.r();
        MutableLiveData mutableLiveData = BleDeviceViewModel.k(this.a);
        BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType = BleDeviceViewModel$ScanFailType.FAIL_TYPE_LOCATION_PERMISSION;
        mutableLiveData.setValue((Object)bleDeviceViewModel$ScanFailType);
    }
}

