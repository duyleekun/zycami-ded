/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import d.v.g.g.c1;

public final class i
implements Observer {
    public final /* synthetic */ c1 a;

    public /* synthetic */ i(c1 c12) {
        this.a = c12;
    }

    public final void onChanged(Object object) {
        c1 c12 = this.a;
        object = (Pair)object;
        c1.J(c12, (Pair)object);
    }
}

