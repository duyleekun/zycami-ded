/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c;

import d.v.k0.f.c.h;
import e.a.b0;
import e.a.c0;
import java.util.concurrent.atomic.AtomicReference;

public final class a
implements c0 {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ a(AtomicReference atomicReference, int n10, int n11, boolean bl2) {
        this.a = atomicReference;
        this.b = n10;
        this.c = n11;
        this.d = bl2;
    }

    public final void subscribe(b0 b02) {
        AtomicReference atomicReference = this.a;
        int n10 = this.b;
        int n11 = this.c;
        boolean bl2 = this.d;
        h.f(atomicReference, n10, n11, bl2, b02);
    }
}

