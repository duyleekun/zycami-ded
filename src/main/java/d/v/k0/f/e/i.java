/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.e.t;
import e.a.b0;
import e.a.c0;
import java.util.concurrent.atomic.AtomicReference;

public final class i
implements c0 {
    public final /* synthetic */ t a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ i(t t10, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3) {
        this.a = t10;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = atomicReference3;
    }

    public final void subscribe(b0 b02) {
        t t10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        AtomicReference atomicReference3 = this.d;
        t10.q(atomicReference, atomicReference2, atomicReference3, b02);
    }
}

