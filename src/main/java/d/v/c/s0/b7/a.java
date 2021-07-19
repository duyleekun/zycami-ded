/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.b7;

import androidx.lifecycle.Observer;
import d.v.c.s0.b7.k;

public final class a
implements Observer {
    public final /* synthetic */ k a;

    public /* synthetic */ a(k k10) {
        this.a = k10;
    }

    public final void onChanged(Object object) {
        k k10 = this.a;
        object = (Integer)object;
        k10.t((Integer)object);
    }
}

