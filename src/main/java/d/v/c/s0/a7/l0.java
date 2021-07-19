/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import d.v.c.s0.a7.l1;

public final class l0
implements Observer {
    public final /* synthetic */ l1 a;

    public /* synthetic */ l0(l1 l12) {
        this.a = l12;
    }

    public final void onChanged(Object object) {
        l1 l12 = this.a;
        object = (Float)object;
        l12.N((Float)object);
    }
}

