/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;
import d.v.c.w0.si;

public final class h
implements Observer {
    public final /* synthetic */ u a;
    public final /* synthetic */ si b;

    public /* synthetic */ h(u u10, si si2) {
        this.a = u10;
        this.b = si2;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        si si2 = this.b;
        object = (Boolean)object;
        u10.I(si2, (Boolean)object);
    }
}

