/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$JoystickEvent;
import m.a.a;

public class BleViewModel$a
extends d.v.e0.ke.a {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$a(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void a() {
        Object object = this.a;
        boolean bl2 = ((BleViewModel)object).J();
        if (!bl2) {
            return;
        }
        object = new Object[1];
        BleViewModel$JoystickEvent bleViewModel$JoystickEvent = BleViewModel$JoystickEvent.DOWN;
        object[0] = bleViewModel$JoystickEvent;
        String string2 = "joystick: %s";
        m.a.a.i(string2, (Object[])object);
        object = this.a.b;
        bl2 = ((LiveData)object).hasActiveObservers();
        if (bl2) {
            object = this.a.p;
            ((MutableLiveData)object).postValue((Object)bleViewModel$JoystickEvent);
        }
    }
}

