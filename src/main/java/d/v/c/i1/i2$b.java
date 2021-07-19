/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.MutableLiveData;
import d.v.c.i1.i2;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.h.e.g;

public class i2$b
implements g {
    public final /* synthetic */ i2 a;

    public i2$b(i2 i22) {
        this.a = i22;
    }

    public void a(String object) {
        object = i2.d(this.a);
        Integer n10 = 4;
        h.g((MutableLiveData)object, n10);
        this.a.v3(-1);
    }

    public void b(String object) {
        object = i2.d(this.a);
        Integer n10 = 3;
        h.g((MutableLiveData)object, n10);
        this.a.G.l(true, 0x80000000L);
        this.a.v3(-1);
    }

    public void c(float f10) {
        Object object = i2.d(this.a);
        Integer n10 = 2;
        h.g((MutableLiveData)object, n10);
        object = this.a;
        int n11 = (int)(f10 * 100.0f);
        ((i2)object).v3(n11);
    }

    public void cancel() {
        j j10 = i2.d(this.a);
        Integer n10 = 5;
        h.g(j10, n10);
        this.a.v3(-1);
    }

    public void start() {
        j j10 = i2.d(this.a);
        Integer n10 = 1;
        h.g(j10, n10);
        this.a.v3(0);
    }
}

