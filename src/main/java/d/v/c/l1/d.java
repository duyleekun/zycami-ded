/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import d.v.c.l1.x;

public final class d
implements Observer {
    public final /* synthetic */ x a;

    public /* synthetic */ d(x x10) {
        this.a = x10;
    }

    public final void onChanged(Object object) {
        x x10 = this.a;
        object = (Pair)object;
        x10.l((Pair)object);
    }
}

