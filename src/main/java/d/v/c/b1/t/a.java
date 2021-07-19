/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1.t;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public final class a
implements IntConsumer {
    public final /* synthetic */ AtomicInteger a;

    public /* synthetic */ a(AtomicInteger atomicInteger) {
        this.a = atomicInteger;
    }

    public final void accept(int n10) {
        this.a.set(n10);
    }
}

