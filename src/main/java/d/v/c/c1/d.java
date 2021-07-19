/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.c.c1;

import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.q0.e;
import d.v.c.x1.p.c;
import d.v.h.f.a;
import d.v.j.b;

public class d
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private c c;

    public d() {
        Integer n10 = 0;
        Object object = new MutableLiveData(n10);
        this.a = object;
        object = new MutableLiveData();
        this.b = object;
        this.c = object = new c();
    }

    public int b(int n10, a a10) {
        SparseArray sparseArray;
        if (a10 != null && (sparseArray = a10.m()) != null) {
            return d.v.j.b.o(((Float)a10.m().get(n10)).floatValue());
        }
        return 0;
    }

    public int c(a a10) {
        SparseArray sparseArray;
        if (a10 != null && (sparseArray = a10.m()) != null) {
            a10 = a10.m();
            int n10 = this.f();
            return d.v.j.b.o(((Float)a10.get(n10)).floatValue());
        }
        return 0;
    }

    public MutableLiveData d() {
        return this.b;
    }

    public MutableLiveData e() {
        return this.a;
    }

    public int f() {
        int n10;
        Object object = this.e().getValue();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = (Integer)this.e().getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public e g() {
        return (e)this.c.a();
    }

    public void i(e e10) {
        this.c.b(e10);
    }
}

