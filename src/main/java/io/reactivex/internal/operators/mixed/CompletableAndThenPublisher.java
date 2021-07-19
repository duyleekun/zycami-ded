/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.g;
import e.a.j;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher$AndThenPublisherSubscriber;

public final class CompletableAndThenPublisher
extends j {
    public final g b;
    public final c c;

    public CompletableAndThenPublisher(g g10, c c10) {
        this.b = g10;
        this.c = c10;
    }

    public void m6(d d10) {
        g g10 = this.b;
        c c10 = this.c;
        CompletableAndThenPublisher$AndThenPublisherSubscriber completableAndThenPublisher$AndThenPublisherSubscriber = new CompletableAndThenPublisher$AndThenPublisherSubscriber(d10, c10);
        g10.f(completableAndThenPublisher$AndThenPublisherSubscriber);
    }
}

