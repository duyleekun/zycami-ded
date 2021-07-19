/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import m.a.a;

public class BleViewModel$k
extends d.v.e0.ke.a {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$k(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void a() {
        Object object = this.a;
        boolean bl2 = ((BleViewModel)object).J();
        if (!bl2) {
            return;
        }
        object = new Object[]{};
        Object object2 = "ZoomIn start";
        m.a.a.i((String)object2, (Object[])object);
        object = this.a.b;
        bl2 = ((LiveData)object).hasActiveObservers();
        if (bl2) {
            object = this.a.j;
            object2 = Boolean.TRUE;
            ((MutableLiveData)object).postValue(object2);
        }
    }

    public void f() {
        Object object = this.a;
        boolean bl2 = ((BleViewModel)object).J();
        if (!bl2) {
            return;
        }
        object = new Object[]{};
        Object object2 = "ZoomIn stop";
        m.a.a.i((String)object2, (Object[])object);
        object = this.a.b;
        bl2 = ((LiveData)object).hasActiveObservers();
        if (bl2) {
            object = this.a.j;
            object2 = Boolean.FALSE;
            ((MutableLiveData)object).postValue(object2);
        }
    }
}

