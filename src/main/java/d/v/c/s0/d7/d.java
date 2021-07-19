/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;
import d.v.c.w0.si;

public final class d
implements Observer {
    public final /* synthetic */ si a;

    public /* synthetic */ d(si si2) {
        this.a = si2;
    }

    public final void onChanged(Object object) {
        si si2 = this.a;
        object = (Boolean)object;
        u.D(si2, (Boolean)object);
    }
}

