/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable;
import io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver;
import io.reactivex.internal.operators.observable.ObservableReplay$a;
import io.reactivex.internal.operators.observable.ObservableReplay$e;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay$g
implements e0 {
    private final AtomicReference a;
    private final ObservableReplay$a b;

    public ObservableReplay$g(AtomicReference atomicReference, ObservableReplay$a observableReplay$a) {
        this.a = atomicReference;
        this.b = observableReplay$a;
    }

    public void subscribe(g0 g02) {
        Serializable serializable;
        Object object;
        while ((object = (ObservableReplay$ReplayObserver)this.a.get()) == null) {
            object = this.b.call();
            object = this.a;
            serializable = new ObservableReplay$ReplayObserver((ObservableReplay$e)object);
            boolean bl2 = ((AtomicReference)object).compareAndSet(null, serializable);
            if (!bl2) continue;
            object = serializable;
            break;
        }
        serializable = new ObservableReplay$InnerDisposable((ObservableReplay$ReplayObserver)object, g02);
        g02.onSubscribe((b)((Object)serializable));
        ((ObservableReplay$ReplayObserver)object).add((ObservableReplay$InnerDisposable)serializable);
        boolean bl3 = ((ObservableReplay$InnerDisposable)serializable).isDisposed();
        if (bl3) {
            ((ObservableReplay$ReplayObserver)object).remove((ObservableReplay$InnerDisposable)serializable);
            return;
        }
        ((ObservableReplay$ReplayObserver)object).buffer.replay((ObservableReplay$InnerDisposable)serializable);
    }
}

