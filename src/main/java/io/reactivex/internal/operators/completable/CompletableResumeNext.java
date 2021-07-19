/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.v0.o;
import io.reactivex.internal.operators.completable.CompletableResumeNext$ResumeNextObserver;

public final class CompletableResumeNext
extends a {
    public final g a;
    public final o b;

    public CompletableResumeNext(g g10, o o10) {
        this.a = g10;
        this.b = o10;
    }

    public void L0(d d10) {
        o o10 = this.b;
        CompletableResumeNext$ResumeNextObserver completableResumeNext$ResumeNextObserver = new CompletableResumeNext$ResumeNextObserver(d10, o10);
        d10.onSubscribe(completableResumeNext$ResumeNextObserver);
        this.a.f(completableResumeNext$ResumeNextObserver);
    }
}

