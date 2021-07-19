/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.m0;

public final class a0
implements Observer {
    public final /* synthetic */ m0 a;

    public /* synthetic */ a0(m0 m02) {
        this.a = m02;
    }

    public final void onChanged(Object object) {
        m0 m02 = this.a;
        object = (Long)object;
        m02.U((Long)object);
    }
}

