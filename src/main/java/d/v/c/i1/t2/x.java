/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import d.v.c.i1.t2.m0;

public final class x
implements Observer {
    public final /* synthetic */ m0 a;

    public /* synthetic */ x(m0 m02) {
        this.a = m02;
    }

    public final void onChanged(Object object) {
        m0 m02 = this.a;
        object = (Boolean)object;
        m02.P((Boolean)object);
    }
}

