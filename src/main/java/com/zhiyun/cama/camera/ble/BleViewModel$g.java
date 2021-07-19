/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.e0.ie.l;
import m.a.a;

public class BleViewModel$g
implements l {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ BleViewModel c;

    public BleViewModel$g(BleViewModel bleViewModel, float f10, float f11) {
        this.c = bleViewModel;
        this.a = f10;
        this.b = f11;
    }

    public void onFailed(Throwable throwable) {
        Object[] objectArray = new Object[2];
        Float f10 = Float.valueOf(this.a);
        objectArray[0] = f10;
        f10 = Float.valueOf(this.b);
        objectArray[1] = f10;
        m.a.a.z(throwable, "setPitchFineTune: %s ,setRollFineTune: %s", objectArray);
    }

    public void s(Void objectArray) {
        objectArray = new Object[2];
        Float f10 = Float.valueOf(this.a);
        objectArray[0] = f10;
        f10 = Float.valueOf(this.b);
        objectArray[1] = f10;
        m.a.a.i("setPitchFineTune: %s ,setRollFineTune: %s", objectArray);
    }
}

