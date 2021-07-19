/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import d.v.c.q1.g0;

public final class c0
implements Observer {
    public final /* synthetic */ g0 a;

    public /* synthetic */ c0(g0 g02) {
        this.a = g02;
    }

    public final void onChanged(Object object) {
        g0 g02 = this.a;
        object = (Pair)object;
        g0.L(g02, (Pair)object);
    }
}

