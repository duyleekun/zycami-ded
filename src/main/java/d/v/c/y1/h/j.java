/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.h;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.i1.i2;
import d.v.c.y1.h.j$a;
import d.v.e.i.h;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.h.h.b;
import d.v.j0.d;
import java.util.List;

public class j
extends ViewModel {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    private m2$d f;

    public j() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        Boolean bl2 = Boolean.FALSE;
        this.c = mutableLiveData = new MutableLiveData(bl2);
        this.d = mutableLiveData = new MutableLiveData();
        this.e = mutableLiveData = new MutableLiveData();
    }

    public void b() {
        this.l(false);
        this.j(0);
    }

    public void c(i2 i22, String string2, String string3) {
        int n10;
        this.l(true);
        int n11 = d.v.v.q.h.m();
        Object object = i22.H1();
        boolean bl2 = d.v.j.b.h(n11, (List)object);
        if (!bl2 && (n10 = (int)(string2.equals(object = ((b)object.get(n11)).k()) ? 1 : 0)) != 0) {
            return;
        }
        n10 = 50;
        this.j(n10);
        boolean bl3 = i22.P2(string2, string3);
        if (bl3) {
            this.j(100);
            int n12 = -1;
            long l10 = n11 == n12 ? 0x400000L : 0x2000000L;
            i22.b3(l10);
        }
        this.l(false);
        this.k(bl3);
    }

    public MutableLiveData d() {
        return this.d;
    }

    public MutableLiveData e() {
        return this.e;
    }

    public MutableLiveData f() {
        return this.c;
    }

    public MutableLiveData g() {
        return this.a;
    }

    public MutableLiveData i() {
        return this.b;
    }

    public void j(int n10) {
        MutableLiveData mutableLiveData = this.d;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void k(boolean bl2) {
        MutableLiveData mutableLiveData = this.e;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void l(boolean bl2) {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl3 = bl2;
        h.g(mutableLiveData, bl3);
    }

    public void m(String string2) {
        h.g(this.a, string2);
    }

    public void n(int n10) {
        MutableLiveData mutableLiveData = this.b;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void o(d object) {
        boolean bl2;
        m2$d m2$d = this.f;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            return;
        }
        j$a j$a = new j$a(this, (d)object);
        this.f = object = m2.i(0L, 500L, j$a);
    }

    public void p() {
        m2.a(this.f);
        this.f = null;
    }
}

