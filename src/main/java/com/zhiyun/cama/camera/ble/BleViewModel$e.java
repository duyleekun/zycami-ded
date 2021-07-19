/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.e0.ie.e;
import m.a.a;

public class BleViewModel$e
implements e {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$e(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void e() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onMovingPoint: ", objectArray);
    }

    public void k() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onMovingStart: ", objectArray);
    }

    public void l() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onMovingCancel: ", objectArray);
    }

    public void o() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onMovingEnd: ", objectArray);
    }

    public void onFailed(Throwable objectArray) {
        objectArray = new Object[]{};
        m.a.a.b("onFailed: ", objectArray);
    }
}

