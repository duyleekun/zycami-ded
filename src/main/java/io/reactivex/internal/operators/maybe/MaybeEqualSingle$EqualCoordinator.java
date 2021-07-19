/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.v0.d;
import e.a.w;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle$EqualObserver;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeEqualSingle$EqualCoordinator
extends AtomicInteger
implements b {
    public final l0 downstream;
    public final d isEqual;
    public final MaybeEqualSingle$EqualObserver observer1;
    public final MaybeEqualSingle$EqualObserver observer2;

    public MaybeEqualSingle$EqualCoordinator(l0 object, d d10) {
        super(2);
        this.downstream = object;
        this.isEqual = d10;
        this.observer1 = object = new MaybeEqualSingle$EqualObserver(this);
        this.observer2 = object = new MaybeEqualSingle$EqualObserver(this);
    }

    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        block5: {
            Object object;
            Object object2;
            int n10;
            block6: {
                d d10;
                n10 = this.decrementAndGet();
                if (n10) break block5;
                object2 = this.observer1.value;
                object = this.observer2.value;
                if (object2 == null || object == null) break block6;
                try {
                    d10 = this.isEqual;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                n10 = d10.a(object2, object);
                object = this.downstream;
                object2 = n10 != 0;
                object.onSuccess(object2);
                break block5;
            }
            l0 l02 = this.downstream;
            if (object2 == null && object == null) {
                n10 = 1;
            } else {
                n10 = 0;
                object2 = null;
            }
            object2 = n10 != 0;
            l02.onSuccess(object2);
        }
    }

    public void error(MaybeEqualSingle$EqualObserver object, Throwable throwable) {
        MaybeEqualSingle$EqualObserver maybeEqualSingle$EqualObserver = null;
        int n10 = this.getAndSet(0);
        if (n10 > 0) {
            maybeEqualSingle$EqualObserver = this.observer1;
            if (object == maybeEqualSingle$EqualObserver) {
                object = this.observer2;
                ((MaybeEqualSingle$EqualObserver)object).dispose();
            } else {
                maybeEqualSingle$EqualObserver.dispose();
            }
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.observer1.get());
    }

    public void subscribe(w object, w w10) {
        MaybeEqualSingle$EqualObserver maybeEqualSingle$EqualObserver = this.observer1;
        object.g(maybeEqualSingle$EqualObserver);
        object = this.observer2;
        w10.g((t)object);
    }
}

