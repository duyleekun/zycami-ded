/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.d7.z;
import d.v.o.f.d;

public class z$b
implements d {
    public final /* synthetic */ z a;

    public z$b(z z10) {
        this.a = z10;
    }

    public void a(float f10, int n10, long l10) {
        z.l(this.a, l10);
    }

    public void b(boolean bl2) {
        if (bl2) {
            Object object = this.a.n;
            int n10 = 1;
            Integer n11 = n10;
            ((MutableLiveData)object).postValue(n11);
            object = this.a;
            ((z)object).C0();
        } else {
            MutableLiveData mutableLiveData = z.k(this.a);
            Integer n12 = 374;
            mutableLiveData.setValue(n12);
            mutableLiveData = this.a.n;
            boolean bl3 = false;
            n12 = 0;
            mutableLiveData.setValue(n12);
        }
    }

    public void c() {
    }

    public void d() {
        MutableLiveData mutableLiveData = this.a.n;
        Integer n10 = 0;
        mutableLiveData.setValue(n10);
    }

    public void e(String string2) {
    }
}

