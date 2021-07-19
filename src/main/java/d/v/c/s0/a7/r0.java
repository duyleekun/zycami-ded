/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import d.v.c.s0.a7.b1;

public final class r0
implements Observer {
    public final /* synthetic */ b1 a;

    public /* synthetic */ r0(b1 b12) {
        this.a = b12;
    }

    public final void onChanged(Object object) {
        b1 b12 = this.a;
        int n10 = (Integer)object;
        b12.A(n10);
    }
}

