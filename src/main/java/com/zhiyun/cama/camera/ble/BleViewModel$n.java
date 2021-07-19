/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.e.i.e;
import m.a.a;

public class BleViewModel$n
extends d.v.e0.ke.a {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$n(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void a() {
        Object object = this.a;
        boolean bl2 = ((BleViewModel)object).J();
        if (!bl2) {
            return;
        }
        object = new Object[]{};
        Object object2 = "capture";
        m.a.a.i((String)object2, (Object[])object);
        object = this.a.b;
        bl2 = ((LiveData)object).hasActiveObservers();
        if (bl2) {
            object = this.a.m;
            object2 = e.a(Boolean.TRUE);
            ((MutableLiveData)object).postValue(object2);
        }
    }

    public void d() {
        Object object = this.a;
        boolean bl2 = ((BleViewModel)object).J();
        if (!bl2) {
            return;
        }
        object = new Object[]{};
        Object object2 = "switch mode";
        m.a.a.i((String)object2, (Object[])object);
        object = this.a.b;
        bl2 = ((LiveData)object).hasActiveObservers();
        if (bl2) {
            object = this.a.l;
            object2 = Boolean.TRUE;
            ((MutableLiveData)object).postValue(object2);
        }
    }

    public void e() {
        Object object = this.a;
        boolean bl2 = ((BleViewModel)object).J();
        if (!bl2) {
            return;
        }
        object = new Object[]{};
        Object object2 = "switch camera";
        m.a.a.i((String)object2, (Object[])object);
        object = this.a.b;
        bl2 = ((LiveData)object).hasActiveObservers();
        if (bl2) {
            object = this.a.n;
            object2 = Boolean.TRUE;
            ((MutableLiveData)object).postValue(object2);
        }
    }
}

