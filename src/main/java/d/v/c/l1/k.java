/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import d.v.c.l1.b0;
import e.a.v0.o;
import java.util.concurrent.atomic.AtomicBoolean;

public final class k
implements o {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ k(b0 b02, AtomicBoolean atomicBoolean) {
        this.a = b02;
        this.b = atomicBoolean;
    }

    public final Object apply(Object object) {
        b0 b02 = this.a;
        AtomicBoolean atomicBoolean = this.b;
        return b02.o(atomicBoolean, object);
    }
}

