/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.c2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.q0.e;
import d.v.e.i.h;

public class c
extends ViewModel {
    private final d.v.c.x1.p.c a;
    private final MutableLiveData b;

    public c() {
        Object object = new d.v.c.x1.p.c();
        this.a = object;
        this.b = object = new MutableLiveData();
    }

    public MutableLiveData b() {
        return this.b;
    }

    public e c() {
        return (e)this.a.a();
    }

    public void d(int n10) {
        MutableLiveData mutableLiveData = this.b;
        Integer n11 = n10;
        h.e(mutableLiveData, n11);
    }

    public void e(e e10) {
        this.a.b(e10);
    }
}

