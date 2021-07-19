/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.w0;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;

public final class d0
extends j {
    public final c b;
    public final o c;
    public final boolean d;
    public final int e;
    public final int f;

    public d0(c c10, o o10, boolean bl2, int n10, int n11) {
        this.b = c10;
        this.c = o10;
        this.d = bl2;
        this.e = n10;
        this.f = n11;
    }

    public void m6(d d10) {
        c c10 = this.b;
        o o10 = this.c;
        boolean bl2 = w0.b(c10, d10, o10);
        if (bl2) {
            return;
        }
        c10 = this.b;
        o10 = this.c;
        boolean bl3 = this.d;
        int n10 = this.e;
        int n11 = this.f;
        d10 = FlowableFlatMap.K8(d10, o10, bl3, n10, n11);
        c10.subscribe(d10);
    }
}

