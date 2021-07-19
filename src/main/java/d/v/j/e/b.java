/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.e.i.h;

public class b
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;

    public b() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
    }

    public MutableLiveData b() {
        return this.a;
    }

    public MutableLiveData c() {
        return this.b;
    }

    public MutableLiveData d() {
        return this.c;
    }

    public void e(Boolean bl2) {
        h.g(this.a, bl2);
    }

    public void f(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void g(boolean bl2) {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }
}

