/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import androidx.lifecycle.Observer;
import d.v.c.i1.s2.r;

public final class o
implements Observer {
    public final /* synthetic */ r a;

    public /* synthetic */ o(r r10) {
        this.a = r10;
    }

    public final void onChanged(Object object) {
        r r10 = this.a;
        object = (Boolean)object;
        r10.U((Boolean)object);
    }
}

