/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublishSubject$PublishDisposable
extends AtomicBoolean
implements b {
    private static final long serialVersionUID = 3562861878281475070L;
    public final g0 downstream;
    public final PublishSubject parent;

    public PublishSubject$PublishDisposable(g0 g02, PublishSubject publishSubject) {
        this.downstream = g02;
        this.parent = publishSubject;
    }

    public void dispose() {
        PublishSubject publishSubject = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            publishSubject = this.parent;
            publishSubject.o8(this);
        }
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onComplete() {
        boolean bl2 = this.get();
        if (!bl2) {
            g0 g02 = this.downstream;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.get();
        if (bl2) {
            a.Y(throwable);
        } else {
            g0 g02 = this.downstream;
            g02.onError(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.get();
        if (!bl2) {
            g0 g02 = this.downstream;
            g02.onNext(object);
        }
    }
}

