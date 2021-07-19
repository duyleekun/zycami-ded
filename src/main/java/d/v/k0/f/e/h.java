/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.e.t;
import e.a.v0.a;
import java.util.concurrent.atomic.AtomicReference;

public final class h
implements a {
    public final /* synthetic */ t a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;

    public /* synthetic */ h(t t10, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.a = t10;
        this.b = atomicReference;
        this.c = atomicReference2;
    }

    public final void run() {
        t t10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        t10.n(atomicReference, atomicReference2);
    }
}

