/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.i1;
import d.v.z.n.g;
import e.a.b0;
import e.a.c0;
import java.util.function.Consumer;

public final class u0
implements c0 {
    public final /* synthetic */ i1 a;
    public final /* synthetic */ g b;
    public final /* synthetic */ Consumer c;

    public /* synthetic */ u0(i1 i12, g g10, Consumer consumer) {
        this.a = i12;
        this.b = g10;
        this.c = consumer;
    }

    public final void subscribe(b0 b02) {
        i1 i12 = this.a;
        g g10 = this.b;
        Consumer consumer = this.c;
        i12.T(g10, consumer, b02);
    }
}

