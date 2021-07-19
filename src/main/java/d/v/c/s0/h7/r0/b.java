/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import androidx.lifecycle.Observer;
import d.v.c.s0.h7.r0.r;

public final class b
implements Observer {
    public final /* synthetic */ r a;

    public /* synthetic */ b(r r10) {
        this.a = r10;
    }

    public final void onChanged(Object object) {
        r r10 = this.a;
        object = (Boolean)object;
        r10.v((Boolean)object);
    }
}

