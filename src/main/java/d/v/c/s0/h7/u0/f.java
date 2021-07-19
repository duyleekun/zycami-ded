/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.u0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.u0.j;
import d.v.c.s0.h7.u0.k;
import d.v.c.w0.yh;

public final class f
implements Observer {
    public final /* synthetic */ j a;
    public final /* synthetic */ k b;
    public final /* synthetic */ yh c;

    public /* synthetic */ f(j j10, k k10, yh yh2) {
        this.a = j10;
        this.b = k10;
        this.c = yh2;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        k k10 = this.b;
        yh yh2 = this.c;
        object = (Integer)object;
        j10.n(k10, yh2, (Integer)object);
    }
}

