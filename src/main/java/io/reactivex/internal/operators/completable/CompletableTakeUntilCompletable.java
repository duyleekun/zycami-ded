/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver;

public final class CompletableTakeUntilCompletable
extends a {
    public final a a;
    public final g b;

    public CompletableTakeUntilCompletable(a a10, g g10) {
        this.a = a10;
        this.b = g10;
    }

    public void L0(d object) {
        CompletableTakeUntilCompletable$TakeUntilMainObserver completableTakeUntilCompletable$TakeUntilMainObserver = new CompletableTakeUntilCompletable$TakeUntilMainObserver((d)object);
        object.onSubscribe(completableTakeUntilCompletable$TakeUntilMainObserver);
        object = this.b;
        CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver completableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver = completableTakeUntilCompletable$TakeUntilMainObserver.other;
        object.f(completableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver);
        this.a.f(completableTakeUntilCompletable$TakeUntilMainObserver);
    }
}

