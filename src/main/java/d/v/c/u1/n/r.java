/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import androidx.lifecycle.Observer;
import d.v.c.u1.n.d0;

public final class r
implements Observer {
    public final /* synthetic */ d0 a;

    public /* synthetic */ r(d0 d02) {
        this.a = d02;
    }

    public final void onChanged(Object object) {
        d0 d02 = this.a;
        object = (Integer)object;
        d02.b0((Integer)object);
    }
}

