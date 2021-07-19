/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.y1.f.q;
import d.v.e.i.h;

public class u
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private final MutableLiveData c;
    private MutableLiveData d;

    public u() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.b = mutableLiveData = new MutableLiveData(bl2);
        bl2 = Boolean.TRUE;
        this.c = mutableLiveData = new MutableLiveData(bl2);
        this.d = mutableLiveData = new MutableLiveData();
    }

    public MutableLiveData b() {
        return this.b;
    }

    public MutableLiveData c() {
        return this.a;
    }

    public MutableLiveData d() {
        return this.c;
    }

    public MutableLiveData e() {
        return this.d;
    }

    public void f(boolean bl2) {
        MutableLiveData mutableLiveData = this.b;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void g(int n10) {
        MutableLiveData mutableLiveData = this.a;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void i(q q10) {
        h.g(this.d, q10);
    }

    public void j() {
        Object object = this.c.getValue();
        if (object == null) {
            return;
        }
        object = this.c;
        Boolean bl2 = (Boolean)((LiveData)object).getValue() ^ true;
        h.e((MutableLiveData)object, bl2);
    }
}

