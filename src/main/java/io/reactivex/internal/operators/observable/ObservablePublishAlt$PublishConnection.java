/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservablePublishAlt$InnerDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishAlt$PublishConnection
extends AtomicReference
implements g0,
b {
    public static final ObservablePublishAlt$InnerDisposable[] EMPTY = new ObservablePublishAlt$InnerDisposable[0];
    public static final ObservablePublishAlt$InnerDisposable[] TERMINATED = new ObservablePublishAlt$InnerDisposable[0];
    private static final long serialVersionUID = -3251430252873581268L;
    public final AtomicBoolean connect;
    public final AtomicReference current;
    public Throwable error;
    public final AtomicReference upstream;

    public ObservablePublishAlt$PublishConnection(AtomicReference observablePublishAlt$InnerDisposableArray) {
        AtomicBoolean atomicBoolean;
        this.connect = atomicBoolean = new AtomicBoolean();
        this.current = observablePublishAlt$InnerDisposableArray;
        this.upstream = observablePublishAlt$InnerDisposableArray = new AtomicReference();
        observablePublishAlt$InnerDisposableArray = EMPTY;
        this.lazySet(observablePublishAlt$InnerDisposableArray);
    }

    public boolean add(ObservablePublishAlt$InnerDisposable observablePublishAlt$InnerDisposable) {
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray;
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray2;
        boolean bl2;
        do {
            ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray3;
            if ((observablePublishAlt$InnerDisposableArray2 = (ObservablePublishAlt$InnerDisposable[])this.get()) == (observablePublishAlt$InnerDisposableArray3 = TERMINATED)) {
                return false;
            }
            int n10 = observablePublishAlt$InnerDisposableArray2.length;
            int n11 = n10 + 1;
            observablePublishAlt$InnerDisposableArray = new ObservablePublishAlt$InnerDisposable[n11];
            System.arraycopy(observablePublishAlt$InnerDisposableArray2, 0, observablePublishAlt$InnerDisposableArray, 0, n10);
            observablePublishAlt$InnerDisposableArray[n10] = observablePublishAlt$InnerDisposable;
        } while (!(bl2 = this.compareAndSet(observablePublishAlt$InnerDisposableArray2, observablePublishAlt$InnerDisposableArray)));
        return true;
    }

    public void dispose() {
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray = TERMINATED;
        this.getAndSet(observablePublishAlt$InnerDisposableArray);
        this.current.compareAndSet(this, null);
        DisposableHelper.dispose(this.upstream);
    }

    public boolean isDisposed() {
        boolean bl2;
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray;
        Object v10 = this.get();
        if (v10 == (observablePublishAlt$InnerDisposableArray = TERMINATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray = this.upstream;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        observablePublishAlt$InnerDisposableArray.lazySet(disposableHelper);
        observablePublishAlt$InnerDisposableArray = TERMINATED;
        observablePublishAlt$InnerDisposableArray = this.getAndSet(observablePublishAlt$InnerDisposableArray);
        int n10 = observablePublishAlt$InnerDisposableArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            g0 g02 = observablePublishAlt$InnerDisposableArray[i10].downstream;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray = this.upstream;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        observablePublishAlt$InnerDisposableArray.lazySet(disposableHelper);
        observablePublishAlt$InnerDisposableArray = TERMINATED;
        observablePublishAlt$InnerDisposableArray = this.getAndSet(observablePublishAlt$InnerDisposableArray);
        int n10 = observablePublishAlt$InnerDisposableArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            g0 g02 = observablePublishAlt$InnerDisposableArray[i10].downstream;
            g02.onError(throwable);
        }
    }

    public void onNext(Object object) {
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray = (ObservablePublishAlt$InnerDisposable[])this.get();
        int n10 = observablePublishAlt$InnerDisposableArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            g0 g02 = observablePublishAlt$InnerDisposableArray[i10].downstream;
            g02.onNext(object);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void remove(ObservablePublishAlt$InnerDisposable observablePublishAlt$InnerDisposable) {
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray;
        ObservablePublishAlt$InnerDisposable[] observablePublishAlt$InnerDisposableArray2;
        boolean bl2;
        do {
            int n10;
            int n11;
            if ((n11 = (observablePublishAlt$InnerDisposableArray2 = (ObservablePublishAlt$InnerDisposable[])this.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            observablePublishAlt$InnerDisposableArray = null;
            for (n10 = 0; n10 < n11; ++n10) {
                ObservablePublishAlt$InnerDisposable observablePublishAlt$InnerDisposable2 = observablePublishAlt$InnerDisposableArray2[n10];
                if (observablePublishAlt$InnerDisposable2 != observablePublishAlt$InnerDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            observablePublishAlt$InnerDisposableArray = EMPTY;
            int n14 = 1;
            if (n11 == n14) continue;
            n10 = n11 + -1;
            observablePublishAlt$InnerDisposableArray = new ObservablePublishAlt$InnerDisposable[n10];
            System.arraycopy(observablePublishAlt$InnerDisposableArray2, 0, observablePublishAlt$InnerDisposableArray, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n14;
            System.arraycopy(observablePublishAlt$InnerDisposableArray2, n13, observablePublishAlt$InnerDisposableArray, n12, n11);
        } while (!(bl2 = this.compareAndSet(observablePublishAlt$InnerDisposableArray2, observablePublishAlt$InnerDisposableArray)));
    }
}

