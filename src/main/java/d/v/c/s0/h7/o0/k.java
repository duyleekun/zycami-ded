/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.o0.v0;

public final class k
implements Observer {
    public final /* synthetic */ v0 a;

    public /* synthetic */ k(v0 v02) {
        this.a = v02;
    }

    public final void onChanged(Object object) {
        v0 v02 = this.a;
        object = (Integer)object;
        v02.y((Integer)object);
    }
}

