/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.e.t;
import e.a.v0.a;
import java.util.concurrent.atomic.AtomicReference;

public final class k
implements a {
    public final /* synthetic */ t a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ k(t t10, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3) {
        this.a = t10;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = atomicReference3;
    }

    public final void run() {
        t t10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        AtomicReference atomicReference3 = this.d;
        t10.t(atomicReference, atomicReference2, atomicReference3);
    }
}

