/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow$WindowExactObserver
extends AtomicInteger
implements g0,
b,
Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    public volatile boolean cancelled;
    public final int capacityHint;
    public final long count;
    public final g0 downstream;
    public long size;
    public b upstream;
    public UnicastSubject window;

    public ObservableWindow$WindowExactObserver(g0 g02, long l10, int n10) {
        this.downstream = g02;
        this.count = l10;
        this.capacityHint = n10;
    }

    public void dispose() {
        this.cancelled = true;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        UnicastSubject unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        UnicastSubject unicastSubject = this.window;
        if (unicastSubject != null) {
            this.window = null;
            unicastSubject.onError(throwable);
        }
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2;
        UnicastSubject unicastSubject = this.window;
        if (unicastSubject == null && !(bl2 = this.cancelled)) {
            int n10 = this.capacityHint;
            this.window = unicastSubject = UnicastSubject.o8(n10, this);
            g0 g02 = this.downstream;
            g02.onNext(unicastSubject);
        }
        if (unicastSubject != null) {
            long l10;
            unicastSubject.onNext(object);
            this.size = l10 = this.size + 1L;
            long l11 = this.count;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 >= 0) {
                this.size = l10 = 0L;
                object = null;
                this.window = null;
                unicastSubject.onComplete();
                l12 = (long)this.cancelled;
                if (l12 != false) {
                    object = this.upstream;
                    object.dispose();
                }
            }
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void run() {
        boolean bl2 = this.cancelled;
        if (bl2) {
            b b10 = this.upstream;
            b10.dispose();
        }
    }
}

