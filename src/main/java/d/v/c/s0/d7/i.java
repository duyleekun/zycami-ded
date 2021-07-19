/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;

public final class i
implements Observer {
    public final /* synthetic */ u a;

    public /* synthetic */ i(u u10) {
        this.a = u10;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        object = (Integer)object;
        u10.A((Integer)object);
    }
}

