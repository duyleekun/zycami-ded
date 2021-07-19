/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import d.v.c.i1.t2.k0;

public final class u
implements Observer {
    public final /* synthetic */ k0 a;

    public /* synthetic */ u(k0 k02) {
        this.a = k02;
    }

    public final void onChanged(Object object) {
        k0 k02 = this.a;
        object = (Boolean)object;
        k02.P((Boolean)object);
    }
}

