/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.firmware;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.firmware.FirmwareUpgradeViewModel;
import d.v.e.i.h;
import d.v.e0.ce;
import d.v.e0.ie.d;
import e.a.b0;
import m.a.a;

public class FirmwareUpgradeViewModel$c
implements d {
    public boolean a;
    public final /* synthetic */ b0 b;
    public final /* synthetic */ FirmwareUpgradeViewModel c;

    public FirmwareUpgradeViewModel$c(FirmwareUpgradeViewModel firmwareUpgradeViewModel, b0 b02) {
        this.c = firmwareUpgradeViewModel;
        this.b = b02;
    }

    public void a() {
        Object object = new Object[]{};
        m.a.a.b("skipSucceeded", (Object[])object);
        object = this.b;
        Integer n10 = 876;
        object.onNext(n10);
    }

    public void b() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("uploadStarted", objectArray);
    }

    public void c() {
        Object object = new Object[]{};
        m.a.a.b("uploadSuccessfully", (Object[])object);
        object = FirmwareUpgradeViewModel.b(this.c);
        Integer n10 = 7;
        ((MutableLiveData)object).setValue(n10);
        object = FirmwareUpgradeViewModel.b(this.c);
        int n11 = 8;
        n10 = n11;
        ((MutableLiveData)object).setValue(n10);
        object = FirmwareUpgradeViewModel.c(this.c);
        Object object2 = 0;
        ((MutableLiveData)object).setValue(object2);
        boolean bl2 = this.a;
        if (bl2) {
            return;
        }
        object2 = this.b;
        object = 850;
        object2.onNext(object);
        this.b.onComplete();
    }

    public void d(Throwable object) {
        Object object2 = new Object[]{};
        m.a.a.g((Throwable)object, "uploadFailed", object2);
        object = this.b;
        object2 = 520;
        object.onNext(object2);
    }

    public void e(int n10) {
        Object object = new Object[1];
        Integer n11 = n10;
        object[0] = n11;
        m.a.a.u("upgradeProgressChanged: [progress] = %s", object);
        object = FirmwareUpgradeViewModel.c(this.c);
        Integer n12 = n10;
        h.e((MutableLiveData)object, n12);
    }

    public void f(int n10) {
        Object object = new Object[1];
        Integer n11 = n10;
        object[0] = n11;
        m.a.a.u("uploadProgressChanged: [progress] = %s", object);
        object = FirmwareUpgradeViewModel.c(this.c);
        Integer n12 = n10;
        h.e((MutableLiveData)object, n12);
    }

    public void g() {
        Object[] objectArray = new Object[]{};
        m.a.a.e("upgradeFailed", objectArray);
        ce.E0().e7();
    }

    public void h(boolean bl2) {
        Object[] objectArray = new Object[1];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        m.a.a.b("startConnectAndScan: [needWait] = %s", objectArray);
        this.a = bl2;
    }

    public void i() {
        Object object = new Object[]{};
        m.a.a.e("skipFailed", (Object[])object);
        object = this.b;
        Integer n10 = 210;
        object.onNext(n10);
    }

    public void j() {
        Object object = new Object[]{};
        m.a.a.e("connectDeviceFailed", (Object[])object);
        object = this.b;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SCAN_OR_CONNECT_FAILED");
        object.onError(illegalArgumentException);
    }

    public void k() {
        Object object = new Object[]{};
        m.a.a.b("upgradeSucceeded", (Object[])object);
        object = this.b;
        Integer n10 = 926;
        object.onNext(n10);
        this.b.onComplete();
    }
}

