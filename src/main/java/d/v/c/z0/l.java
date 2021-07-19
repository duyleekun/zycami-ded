/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.z0;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.e.i.h;

public class l
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;

    public l() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
        this.d = mutableLiveData = new MutableLiveData();
        this.e = mutableLiveData = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.f = mutableLiveData = new MutableLiveData(bl2);
    }

    public MutableLiveData b() {
        return this.c;
    }

    public MutableLiveData c() {
        return this.b;
    }

    public MutableLiveData d() {
        return this.f;
    }

    public MutableLiveData e() {
        return this.d;
    }

    public MutableLiveData f() {
        return this.e;
    }

    public MutableLiveData g() {
        return this.a;
    }

    public void i(String string2) {
        h.g(this.c, string2);
    }

    public void j(String string2) {
        h.g(this.b, string2);
    }

    public void k(boolean bl2) {
        MutableLiveData mutableLiveData = this.f;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void l(String string2) {
        h.g(this.d, string2);
    }

    public void m(String string2) {
        h.g(this.e, string2);
    }

    public void n(String string2) {
        h.g(this.a, string2);
    }
}

