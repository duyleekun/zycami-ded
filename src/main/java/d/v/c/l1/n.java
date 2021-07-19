/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import d.v.c.l1.b0;
import e.a.k0;
import e.a.m0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n
implements m0 {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ AtomicBoolean c;

    public /* synthetic */ n(b0 b02, Object object, AtomicBoolean atomicBoolean) {
        this.a = b02;
        this.b = object;
        this.c = atomicBoolean;
    }

    public final void subscribe(k0 k02) {
        b0 b02 = this.a;
        Object object = this.b;
        AtomicBoolean atomicBoolean = this.c;
        b02.m(object, atomicBoolean, k02);
    }
}

