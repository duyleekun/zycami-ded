/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservableAmb$AmbInnerObserver;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAmb$a
implements b {
    public final g0 a;
    public final ObservableAmb$AmbInnerObserver[] b;
    public final AtomicInteger c;

    public ObservableAmb$a(g0 observableAmb$AmbInnerObserverArray, int n10) {
        AtomicInteger atomicInteger;
        this.c = atomicInteger = new AtomicInteger();
        this.a = observableAmb$AmbInnerObserverArray;
        observableAmb$AmbInnerObserverArray = new ObservableAmb$AmbInnerObserver[n10];
        this.b = observableAmb$AmbInnerObserverArray;
    }

    public void a(e0[] e0Array) {
        ObservableAmb$AmbInnerObserver observableAmb$AmbInnerObserver;
        ObservableAmb$AmbInnerObserver[] observableAmb$AmbInnerObserverArray = this.b;
        int n10 = observableAmb$AmbInnerObserverArray.length;
        int n11 = 0;
        int n12 = 0;
        Object object = null;
        while (n12 < n10) {
            int n13 = n12 + 1;
            g0 g02 = this.a;
            observableAmb$AmbInnerObserverArray[n12] = observableAmb$AmbInnerObserver = new ObservableAmb$AmbInnerObserver(this, n13, g02);
            n12 = n13;
        }
        this.c.lazySet(0);
        object = this.a;
        object.onSubscribe(this);
        while (n11 < n10) {
            object = this.c;
            n12 = ((AtomicInteger)object).get();
            if (n12 != 0) {
                return;
            }
            object = e0Array[n11];
            observableAmb$AmbInnerObserver = observableAmb$AmbInnerObserverArray[n11];
            object.subscribe(observableAmb$AmbInnerObserver);
            ++n11;
        }
    }

    public boolean b(int n10) {
        Object object = this.c;
        int n11 = object.get();
        boolean bl2 = true;
        int n12 = 0;
        ObservableAmb$AmbInnerObserver observableAmb$AmbInnerObserver = null;
        if (n11 == 0) {
            object = this.c;
            n11 = (int)(object.compareAndSet(0, n10) ? 1 : 0);
            if (n11 != 0) {
                object = this.b;
                int n13 = ((ObservableAmb$AmbInnerObserver[])object).length;
                while (n12 < n13) {
                    int n14 = n12 + 1;
                    if (n14 != n10) {
                        observableAmb$AmbInnerObserver = object[n12];
                        observableAmb$AmbInnerObserver.dispose();
                    }
                    n12 = n14;
                }
                return bl2;
            }
            return false;
        }
        if (n11 != n10) {
            bl2 = false;
        }
        return bl2;
    }

    public void dispose() {
        int n10;
        ObservableAmb$AmbInnerObserver[] observableAmb$AmbInnerObserverArray = this.c;
        int n11 = observableAmb$AmbInnerObserverArray.get();
        if (n11 != (n10 = -1)) {
            this.c.lazySet(n10);
            for (ObservableAmb$AmbInnerObserver observableAmb$AmbInnerObserver : this.b) {
                observableAmb$AmbInnerObserver.dispose();
            }
        }
    }

    public boolean isDisposed() {
        int n10;
        AtomicInteger atomicInteger = this.c;
        int n11 = atomicInteger.get();
        if (n11 == (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            atomicInteger = null;
        }
        return n11 != 0;
    }
}

