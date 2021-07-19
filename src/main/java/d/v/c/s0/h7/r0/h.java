/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.r0.t;

public final class h
implements Observer {
    public final /* synthetic */ t a;

    public /* synthetic */ h(t t10) {
        this.a = t10;
    }

    public final void onChanged(Object object) {
        t t10 = this.a;
        object = (Integer)object;
        t10.B((Integer)object);
    }
}

