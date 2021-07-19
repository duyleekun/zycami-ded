/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.z0.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher$ParallelDispatcher;

public final class ParallelFromPublisher
extends a {
    public final c a;
    public final int b;
    public final int c;

    public ParallelFromPublisher(c c10, int n10, int n11) {
        this.a = c10;
        this.b = n10;
        this.c = n11;
    }

    public int G() {
        return this.b;
    }

    public void a(d[] dArray) {
        boolean bl2 = this.U(dArray);
        if (!bl2) {
            return;
        }
        c c10 = this.a;
        int n10 = this.c;
        ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = new ParallelFromPublisher$ParallelDispatcher(dArray, n10);
        c10.subscribe(parallelFromPublisher$ParallelDispatcher);
    }
}

