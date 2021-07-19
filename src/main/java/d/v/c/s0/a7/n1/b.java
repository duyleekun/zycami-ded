/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.n1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.e.i.h;

public class b
extends ViewModel {
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;

    public b() {
        MutableLiveData mutableLiveData;
        this.a = mutableLiveData = new MutableLiveData();
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
        this.d = mutableLiveData = new MutableLiveData();
    }

    public MutableLiveData b() {
        return this.b;
    }

    public MutableLiveData c() {
        return this.c;
    }

    public MutableLiveData d() {
        return this.d;
    }

    public MutableLiveData e() {
        return this.a;
    }

    public void f(String string2) {
        h.g(this.b, string2);
    }

    public void g(String string2) {
        h.g(this.c, string2);
    }

    public void i(String string2) {
        h.g(this.d, string2);
    }

    public void j(String string2) {
        h.g(this.a, string2);
    }
}

