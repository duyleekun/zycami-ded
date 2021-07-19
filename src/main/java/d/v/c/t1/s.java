/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.v0.f;
import d.v.c.v0.u.z;

public class s
extends ViewModel {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public int h;
    public int i;
    public int j;
    public final MutableLiveData k;
    private final LiveData l;
    private boolean m;

    public s() {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        this.a = mutableLiveData2 = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
        Object object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        object = new MutableLiveData();
        this.g = object;
        this.h = 0;
        object = new MutableLiveData();
        this.k = object;
        object = d.v.c.v0.f.b().c();
        this.l = object;
        object = Boolean.FALSE;
        mutableLiveData2.setValue(object);
        mutableLiveData.setValue(object);
    }

    public boolean b() {
        return z.m().d();
    }

    public MutableLiveData c() {
        return this.c;
    }

    public boolean d() {
        return z.m().j();
    }

    public MutableLiveData e() {
        return this.a;
    }

    public MutableLiveData f() {
        return this.b;
    }

    public LiveData g() {
        return this.l;
    }

    public void i(int n10) {
        d.v.c.v0.f.b().d(n10);
    }

    public boolean j() {
        return this.m;
    }

    public void k() {
        d.v.c.v0.f.b().e();
    }

    public void l(boolean bl2) {
        z.m().F(bl2);
    }

    public void m(boolean bl2) {
        this.m = bl2;
    }

    public void n(boolean bl2) {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public void o(boolean bl2) {
        z z10 = z.m();
        z10.J(bl2);
        if (bl2) {
            bl2 = false;
            this.p(false);
            this.n(false);
        }
    }

    public void p(boolean bl2) {
        MutableLiveData mutableLiveData = this.a;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public void r(String string2) {
        this.b.setValue(string2);
    }
}

