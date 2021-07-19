/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.x0.c.d.i;
import d.v.c.x0.c.f.j;
import d.v.c.x1.p.c;
import d.v.e.i.h;
import d.v.h.d.d;

public class b
extends ViewModel {
    private d.v.e.i.j a;
    private c b;
    private final MutableLiveData c;
    private final MutableLiveData d;

    public b() {
        Object object = new d.v.e.i.j();
        this.a = object;
        this.b = object = new c();
        this.c = object = new MutableLiveData();
        this.d = object = new MutableLiveData();
    }

    public d.v.e.i.j b() {
        return this.a;
    }

    public j c() {
        return (j)this.d.getValue();
    }

    public i d() {
        return (i)this.c.getValue();
    }

    public d e() {
        return (d)this.b.a();
    }

    public void f(int n10) {
        d.v.e.i.j j10 = this.a;
        Integer n11 = n10;
        h.g(j10, n11);
    }

    public void g(j j10) {
        h.g(this.d, j10);
    }

    public void i(i i10) {
        h.g(this.c, i10);
    }

    public void j(d d10) {
        this.b.b(d10);
    }
}

