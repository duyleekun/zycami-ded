/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import i.g.c;
import io.reactivex.internal.operators.completable.CompletableConcat$CompletableConcatSubscriber;

public final class CompletableConcat
extends a {
    public final c a;
    public final int b;

    public CompletableConcat(c c10, int n10) {
        this.a = c10;
        this.b = n10;
    }

    public void L0(d d10) {
        c c10 = this.a;
        int n10 = this.b;
        CompletableConcat$CompletableConcatSubscriber completableConcat$CompletableConcatSubscriber = new CompletableConcat$CompletableConcatSubscriber(d10, n10);
        c10.subscribe(completableConcat$CompletableConcatSubscriber);
    }
}

