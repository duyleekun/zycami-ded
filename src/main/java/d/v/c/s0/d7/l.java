/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;
import d.v.c.w0.x0;

public final class l
implements Observer {
    public final /* synthetic */ x0 a;

    public /* synthetic */ l(x0 x02) {
        this.a = x02;
    }

    public final void onChanged(Object object) {
        x0 x02 = this.a;
        object = (Pair)object;
        u.L(x02, (Pair)object);
    }
}

