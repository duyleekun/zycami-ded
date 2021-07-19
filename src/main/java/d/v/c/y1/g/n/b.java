/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g.n;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import d.v.c.x1.p.c;

public class b
extends ViewModel {
    private MutableLiveData a;
    private c b;

    public b() {
        Object object = new MutableLiveData();
        this.a = object;
        this.b = object = new c();
    }

    public MutableLiveData b() {
        return this.a;
    }

    public float c() {
        return ((Float)this.b.a()).floatValue();
    }

    public void d(float f10) {
        c c10 = this.b;
        Float f11 = Float.valueOf(f10);
        c10.b(f11);
    }
}

