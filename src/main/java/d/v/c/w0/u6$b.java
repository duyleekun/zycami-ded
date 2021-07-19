/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.databinding.InverseBindingListener;
import androidx.lifecycle.MutableLiveData;
import d.v.c.b2.p;
import d.v.c.b2.w.e;
import d.v.c.i1.h2;
import d.v.c.w0.u6;

public class u6$b
implements InverseBindingListener {
    public final /* synthetic */ u6 a;

    public u6$b(u6 u62) {
        this.a = u62;
    }

    public void onChange() {
        e e10 = p.P(u6.E(this.a));
        Object object = this.a.A;
        boolean bl2 = true;
        boolean bl3 = object != null ? bl2 : false;
        if (bl3) {
            if ((object = ((h2)object).C0()) == null) {
                bl2 = false;
            }
            if (bl2) {
                ((MutableLiveData)object).setValue(e10);
            }
        }
    }
}

