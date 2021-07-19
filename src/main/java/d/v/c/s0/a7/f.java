/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import d.v.c.s0.a7.y0;

public final class f
implements Observer {
    public final /* synthetic */ y0 a;

    public /* synthetic */ f(y0 y02) {
        this.a = y02;
    }

    public final void onChanged(Object object) {
        y0 y02 = this.a;
        object = (Boolean)object;
        y02.I((Boolean)object);
    }
}

