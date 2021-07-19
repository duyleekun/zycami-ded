/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.j;
import e.a.w0.c.o;
import e.a.w0.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap$SwitchMapInnerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = 3837284832786408377L;
    public final int bufferSize;
    public volatile boolean done;
    public final long index;
    public final ObservableSwitchMap$SwitchMapObserver parent;
    public volatile o queue;

    public ObservableSwitchMap$SwitchMapInnerObserver(ObservableSwitchMap$SwitchMapObserver switchMapObserver, long l10, int n10) {
        this.parent = switchMapObserver;
        this.index = l10;
        this.bufferSize = n10;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        long l10 = this.index;
        ObservableSwitchMap$SwitchMapObserver observableSwitchMap$SwitchMapObserver = this.parent;
        long l11 = observableSwitchMap$SwitchMapObserver.unique;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
            this.done = object;
            ObservableSwitchMap$SwitchMapObserver observableSwitchMap$SwitchMapObserver2 = this.parent;
            observableSwitchMap$SwitchMapObserver2.drain();
        }
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onNext(Object object) {
        long l10 = this.index;
        ObservableSwitchMap$SwitchMapObserver observableSwitchMap$SwitchMapObserver = this.parent;
        long l11 = observableSwitchMap$SwitchMapObserver.unique;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            if (object != null) {
                o o10 = this.queue;
                o10.offer(object);
            }
            object = this.parent;
            ((ObservableSwitchMap$SwitchMapObserver)object).drain();
        }
    }

    public void onSubscribe(b object) {
        int n10 = DisposableHelper.setOnce(this, (b)object);
        if (n10 != 0) {
            n10 = object instanceof j;
            if (n10 != 0) {
                int n11;
                n10 = (object = (j)object).requestFusion(7);
                if (n10 == (n11 = 1)) {
                    this.queue = object;
                    this.done = n11;
                    this.parent.drain();
                    return;
                }
                n11 = 2;
                if (n10 == n11) {
                    this.queue = object;
                    return;
                }
            }
            n10 = this.bufferSize;
            this.queue = object = new a(n10);
        }
    }
}

