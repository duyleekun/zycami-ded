/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.w0;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;

public final class n
extends j {
    public final c b;
    public final o c;
    public final int d;
    public final ErrorMode e;

    public n(c c10, o o10, int n10, ErrorMode errorMode) {
        this.b = c10;
        this.c = o10;
        this.d = n10;
        this.e = errorMode;
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
        int n10 = this.d;
        ErrorMode errorMode = this.e;
        d10 = FlowableConcatMap.K8(d10, o10, n10, errorMode);
        c10.subscribe(d10);
    }
}

