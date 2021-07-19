/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p1;

import androidx.lifecycle.MutableLiveData;
import d.v.c.p1.e;
import d.v.e.i.h;
import d.v.h.e.b;

public class e$a
implements b {
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
    }

    public void j(int n10) {
        this.a.r(n10, false);
        MutableLiveData mutableLiveData = e.b(this.a);
        Integer n11 = e.c(this.a).m(n10);
        h.g(mutableLiveData, n11);
    }
}

