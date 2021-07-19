/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn$SubscribeOnObserver;

public final class CompletableSubscribeOn
extends a {
    public final g a;
    public final h0 b;

    public CompletableSubscribeOn(g g10, h0 h02) {
        this.a = g10;
        this.b = h02;
    }

    public void L0(d object) {
        g g10 = this.a;
        CompletableSubscribeOn$SubscribeOnObserver completableSubscribeOn$SubscribeOnObserver = new CompletableSubscribeOn$SubscribeOnObserver((d)object, g10);
        object.onSubscribe(completableSubscribeOn$SubscribeOnObserver);
        object = this.b.e(completableSubscribeOn$SubscribeOnObserver);
        completableSubscribeOn$SubscribeOnObserver.task.replace((b)object);
    }
}

