/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import d.v.j.e.i.d1;
import java.util.List;
import java.util.function.Consumer;

public final class n0
implements Consumer {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ long b;

    public /* synthetic */ n0(d1 d12, long l10) {
        this.a = d12;
        this.b = l10;
    }

    public final void accept(Object object) {
        d1 d12 = this.a;
        long l10 = this.b;
        object = (List)object;
        d12.Q(l10, (List)object);
    }
}

