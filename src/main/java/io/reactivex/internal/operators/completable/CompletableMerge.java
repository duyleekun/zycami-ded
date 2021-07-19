/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import i.g.c;
import io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber;

public final class CompletableMerge
extends a {
    public final c a;
    public final int b;
    public final boolean c;

    public CompletableMerge(c c10, int n10, boolean bl2) {
        this.a = c10;
        this.b = n10;
        this.c = bl2;
    }

    public void L0(d d10) {
        int n10 = this.b;
        boolean bl2 = this.c;
        CompletableMerge$CompletableMergeSubscriber completableMerge$CompletableMergeSubscriber = new CompletableMerge$CompletableMergeSubscriber(d10, n10, bl2);
        this.a.subscribe(completableMerge$CompletableMergeSubscriber);
    }
}

