/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.p0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.p0.p;

public final class k
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ k(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (Integer)object;
        p10.C((Integer)object);
    }
}

