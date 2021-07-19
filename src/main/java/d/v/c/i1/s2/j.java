/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import androidx.lifecycle.Observer;
import d.v.c.i1.s2.r;

public final class j
implements Observer {
    public final /* synthetic */ r a;

    public /* synthetic */ j(r r10) {
        this.a = r10;
    }

    public final void onChanged(Object object) {
        r r10 = this.a;
        object = (Integer)object;
        r10.Q((Integer)object);
    }
}

