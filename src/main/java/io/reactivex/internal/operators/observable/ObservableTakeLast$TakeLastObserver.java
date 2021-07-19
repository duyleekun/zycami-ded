/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast$TakeLastObserver
extends ArrayDeque
implements g0,
b {
    private static final long serialVersionUID = 7240042530241604978L;
    public volatile boolean cancelled;
    public final int count;
    public final g0 downstream;
    public b upstream;

    public ObservableTakeLast$TakeLastObserver(g0 g02, int n10) {
        this.downstream = g02;
        this.count = n10;
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            b b10 = this.upstream;
            b10.dispose();
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        g0 g02 = this.downstream;
        boolean bl2;
        while (!(bl2 = this.cancelled)) {
            Object e10 = this.poll();
            if (e10 == null) {
                bl2 = this.cancelled;
                if (!bl2) {
                    g02.onComplete();
                }
                return;
            }
            g02.onNext(e10);
        }
        return;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10 = this.count;
        int n11 = this.size();
        if (n10 == n11) {
            this.poll();
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

