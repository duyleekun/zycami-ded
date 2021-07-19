/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.lifecycle.Observer;
import d.v.c.h1.q;
import d.v.j.e.h.k;

public final class h
implements Observer {
    public final /* synthetic */ q a;

    public /* synthetic */ h(q q10) {
        this.a = q10;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        object = (k)object;
        q.w(q10, (k)object);
    }
}

