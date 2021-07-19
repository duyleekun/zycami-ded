/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;

public final class j
implements Observer {
    public final /* synthetic */ u a;

    public /* synthetic */ j(u u10) {
        this.a = u10;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        object = (Boolean)object;
        u10.y((Boolean)object);
    }
}

