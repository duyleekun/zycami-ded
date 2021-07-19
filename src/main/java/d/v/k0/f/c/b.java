/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c;

import d.v.k0.f.c.h;
import e.a.v0.a;
import java.util.concurrent.atomic.AtomicReference;

public final class b
implements a {
    public final /* synthetic */ h a;
    public final /* synthetic */ AtomicReference b;

    public /* synthetic */ b(h h10, AtomicReference atomicReference) {
        this.a = h10;
        this.b = atomicReference;
    }

    public final void run() {
        h h10 = this.a;
        AtomicReference atomicReference = this.b;
        h10.h(atomicReference);
    }
}

