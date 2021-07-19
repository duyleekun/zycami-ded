/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.e.h.d;

public class j1
extends ViewModel {
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;

    public j1() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        Object object = new MutableLiveData();
        this.b = object;
        object = new MutableLiveData();
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = Boolean.FALSE;
        mutableLiveData.setValue(object);
        this.c();
    }

    public int b() {
        return d.v.e.h.d.c((Integer)this.e.getValue());
    }

    public void c() {
        MutableLiveData mutableLiveData = this.e;
        Object object = -1;
        mutableLiveData.setValue(object);
        mutableLiveData = this.b;
        object = 0;
        mutableLiveData.setValue(object);
        mutableLiveData = this.c;
        object = "";
        mutableLiveData.setValue(object);
        this.d.setValue(object);
    }
}

