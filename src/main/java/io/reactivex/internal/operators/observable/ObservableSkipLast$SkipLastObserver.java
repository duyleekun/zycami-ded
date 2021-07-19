/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast$SkipLastObserver
extends ArrayDeque
implements g0,
b {
    private static final long serialVersionUID = -3807491841935125653L;
    public final g0 downstream;
    public final int skip;
    public b upstream;

    public ObservableSkipLast$SkipLastObserver(g0 g02, int n10) {
        super(n10);
        this.downstream = g02;
        this.skip = n10;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10 = this.skip;
        int n11 = this.size();
        if (n10 == n11) {
            g0 g02 = this.downstream;
            Object e10 = this.poll();
            g02.onNext(e10);
        }
        this.offer(object);
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
}

