/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.q0.x;

public final class c
implements Observer {
    public final /* synthetic */ x a;

    public /* synthetic */ c(x x10) {
        this.a = x10;
    }

    public final void onChanged(Object object) {
        x x10 = this.a;
        object = (Integer)object;
        x10.z((Integer)object);
    }
}

