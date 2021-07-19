/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.g1;
import d.v.z.n.g;
import e.a.b0;
import java.util.function.Consumer;

public final class c0
implements e.a.c0 {
    public final /* synthetic */ g1 a;
    public final /* synthetic */ g b;
    public final /* synthetic */ Consumer c;

    public /* synthetic */ c0(g1 g12, g g10, Consumer consumer) {
        this.a = g12;
        this.b = g10;
        this.c = consumer;
    }

    public final void subscribe(b0 b02) {
        g1 g12 = this.a;
        g g10 = this.b;
        Consumer consumer = this.c;
        g12.L(g10, consumer, b02);
    }
}

