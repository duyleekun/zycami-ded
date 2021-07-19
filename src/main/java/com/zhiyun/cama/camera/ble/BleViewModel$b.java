/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.stabilizer.Stabilizer$k;
import m.a.a;

public class BleViewModel$b
extends Stabilizer$k {
    public final /* synthetic */ BleViewModel e;

    public BleViewModel$b(BleViewModel bleViewModel) {
        this.e = bleViewModel;
    }

    public void f(int n10) {
        Object object = n10;
        Object object2 = new Object[]{object};
        object = "\u4e00\u952e\u6821\u51c6\u8fdb\u5ea6: %d";
        m.a.a.i((String)object, (Object[])object2);
        object2 = this.e.b;
        boolean bl2 = ((LiveData)object2).hasActiveObservers();
        if (bl2) {
            object2 = this.e.q;
            Integer n11 = n10;
            ((MutableLiveData)object2).postValue(n11);
        }
    }
}

