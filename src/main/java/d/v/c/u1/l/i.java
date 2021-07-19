/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import d.v.c.u1.l.l;

public final class i
implements Observer {
    public final /* synthetic */ l a;

    public /* synthetic */ i(l l10) {
        this.a = l10;
    }

    public final void onChanged(Object object) {
        l l10 = this.a;
        object = (Pair)object;
        l10.Z((Pair)object);
    }
}

