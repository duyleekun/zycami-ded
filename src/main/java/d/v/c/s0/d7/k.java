/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;
import d.v.c.w0.si;

public final class k
implements Observer {
    public final /* synthetic */ si a;

    public /* synthetic */ k(si si2) {
        this.a = si2;
    }

    public final void onChanged(Object object) {
        si si2 = this.a;
        object = (Boolean)object;
        u.E(si2, (Boolean)object);
    }
}

