/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.core.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.e0.ie.l;
import m.a.a;

public class BleViewModel$f
implements l {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$f(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void onFailed(Throwable object) {
        Object object2 = new Object[]{};
        m.a.a.z((Throwable)object, "getPitchAndRollFineTune failed", object2);
        object = this.a.K;
        object2 = Float.valueOf(0.0f);
        ((MutableLiveData)object).postValue(object2);
        this.a.J.postValue(object2);
    }

    public void s(Pair object) {
        Object[] objectArray = this.a.K;
        Object object2 = ((Pair)object).first;
        objectArray.postValue(object2);
        objectArray = this.a.J;
        object2 = ((Pair)object).second;
        objectArray.postValue(object2);
        object2 = ((Pair)object).first;
        object = ((Pair)object).second;
        objectArray = new Object[]{object2, object};
        m.a.a.i("getPitchFineTune: %s ,getRollFineTune: %s", objectArray);
    }
}

