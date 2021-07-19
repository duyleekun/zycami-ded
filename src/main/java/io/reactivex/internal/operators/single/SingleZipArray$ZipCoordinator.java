/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.operators.single.SingleZipArray$ZipSingleObserver;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleZipArray$ZipCoordinator
extends AtomicInteger
implements b {
    private static final long serialVersionUID = -5556924161382950569L;
    public final l0 downstream;
    public final SingleZipArray$ZipSingleObserver[] observers;
    public final Object[] values;
    public final o zipper;

    public SingleZipArray$ZipCoordinator(l0 objectArray, int n10, o o10) {
        super(n10);
        this.downstream = objectArray;
        this.zipper = o10;
        objectArray = new SingleZipArray$ZipSingleObserver[n10];
        o10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            SingleZipArray$ZipSingleObserver singleZipArray$ZipSingleObserver = new SingleZipArray$ZipSingleObserver(this, i10);
            objectArray[i10] = singleZipArray$ZipSingleObserver;
        }
        this.observers = objectArray;
        objectArray = new Object[n10];
        this.values = objectArray;
    }

    public void dispose() {
        int n10 = this.getAndSet(0);
        if (n10 > 0) {
            for (SingleZipArray$ZipSingleObserver singleZipArray$ZipSingleObserver : this.observers) {
                singleZipArray$ZipSingleObserver.dispose();
            }
        }
    }

    public void disposeExcept(int n10) {
        SingleZipArray$ZipSingleObserver[] singleZipArray$ZipSingleObserverArray = this.observers;
        int n11 = singleZipArray$ZipSingleObserverArray.length;
        SingleZipArray$ZipSingleObserver singleZipArray$ZipSingleObserver = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            SingleZipArray$ZipSingleObserver singleZipArray$ZipSingleObserver2 = singleZipArray$ZipSingleObserverArray[i10];
            singleZipArray$ZipSingleObserver2.dispose();
        }
        while (++n10 < n11) {
            singleZipArray$ZipSingleObserver = singleZipArray$ZipSingleObserverArray[n10];
            singleZipArray$ZipSingleObserver.dispose();
        }
    }

    public void innerError(Throwable throwable, int n10) {
        int n11 = this.getAndSet(0);
        if (n11 > 0) {
            this.disposeExcept(n10);
            l0 l02 = this.downstream;
            l02.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void innerSuccess(Object object, int n10) {
        Object[] objectArray = this.values;
        objectArray[n10] = object;
        int n11 = this.decrementAndGet();
        if (n11 == 0) {
            object = this.zipper;
            Object object2 = this.values;
            object = object.apply(object2);
            object2 = "The zipper returned a null value";
            try {
                object = a.g(object, (String)object2);
                object2 = this.downstream;
                object2.onSuccess(object);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.downstream;
                object2.onError(throwable);
            }
        }
    }

    public boolean isDisposed() {
        int n10 = this.get();
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }
}

