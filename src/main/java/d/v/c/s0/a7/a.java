/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import d.v.c.s0.a7.t0;
import d.v.c.s0.s6;

public final class a
implements Observer {
    public final /* synthetic */ t0 a;
    public final /* synthetic */ s6 b;

    public /* synthetic */ a(t0 t02, s6 s62) {
        this.a = t02;
        this.b = s62;
    }

    public final void onChanged(Object object) {
        t0 t02 = this.a;
        s6 s62 = this.b;
        object = (Boolean)object;
        t02.v(s62, (Boolean)object);
    }
}

