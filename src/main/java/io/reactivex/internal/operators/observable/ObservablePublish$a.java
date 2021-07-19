/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish$a
implements g0,
b {
    public static final ObservablePublish$InnerDisposable[] e = new ObservablePublish$InnerDisposable[0];
    public static final ObservablePublish$InnerDisposable[] f = new ObservablePublish$InnerDisposable[0];
    public final AtomicReference a;
    public final AtomicReference b;
    public final AtomicBoolean c;
    public final AtomicReference d;

    public ObservablePublish$a(AtomicReference serializable) {
        AtomicReference<ObservablePublish$InnerDisposable[]> atomicReference;
        this.d = atomicReference = new AtomicReference<ObservablePublish$InnerDisposable[]>();
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray = e;
        this.b = atomicReference = new AtomicReference<ObservablePublish$InnerDisposable[]>(observablePublish$InnerDisposableArray);
        this.a = serializable;
        this.c = serializable;
    }

    public boolean a(ObservablePublish$InnerDisposable observablePublish$InnerDisposable) {
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((observablePublish$InnerDisposableArray2 = (ObservablePublish$InnerDisposable[])this.b.get()) == (object = f)) {
                return false;
            }
            int n10 = observablePublish$InnerDisposableArray2.length;
            int n11 = n10 + 1;
            observablePublish$InnerDisposableArray = new ObservablePublish$InnerDisposable[n11];
            System.arraycopy(observablePublish$InnerDisposableArray2, 0, observablePublish$InnerDisposableArray, 0, n10);
            observablePublish$InnerDisposableArray[n10] = observablePublish$InnerDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(observablePublish$InnerDisposableArray2, observablePublish$InnerDisposableArray)));
        return true;
    }

    public void b(ObservablePublish$InnerDisposable observablePublish$InnerDisposable) {
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            int n10;
            ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray3;
            int n11;
            int n12;
            if ((n12 = (observablePublish$InnerDisposableArray2 = (ObservablePublish$InnerDisposable[])this.b.get()).length) == 0) {
                return;
            }
            int n13 = -1;
            int n14 = 0;
            for (n11 = 0; n11 < n12; ++n11) {
                observablePublish$InnerDisposableArray3 = observablePublish$InnerDisposableArray2[n11];
                n10 = observablePublish$InnerDisposableArray3.equals(observablePublish$InnerDisposable);
                if (n10 == 0) continue;
                n13 = n11;
                break;
            }
            if (n13 < 0) {
                return;
            }
            n11 = 1;
            if (n12 == n11) {
                observablePublish$InnerDisposableArray = e;
                continue;
            }
            n10 = n12 + -1;
            observablePublish$InnerDisposableArray3 = new ObservablePublish$InnerDisposable[n10];
            System.arraycopy(observablePublish$InnerDisposableArray2, 0, observablePublish$InnerDisposableArray3, 0, n13);
            n14 = n13 + 1;
            n12 = n12 - n13 - n11;
            System.arraycopy(observablePublish$InnerDisposableArray2, n14, observablePublish$InnerDisposableArray3, n13, n12);
            observablePublish$InnerDisposableArray = observablePublish$InnerDisposableArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(observablePublish$InnerDisposableArray2, observablePublish$InnerDisposableArray)));
    }

    public void dispose() {
        Object object = this.b;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray = f;
        if ((object = ((AtomicReference)object).getAndSet(observablePublish$InnerDisposableArray)) != observablePublish$InnerDisposableArray) {
            object = this.a;
            observablePublish$InnerDisposableArray = null;
            ((AtomicReference)object).compareAndSet(this, null);
            object = this.d;
            DisposableHelper.dispose((AtomicReference)object);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray;
        Object v10 = this.b.get();
        if (v10 == (observablePublish$InnerDisposableArray = f)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        this.a.compareAndSet(this, null);
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray = this.b;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray2 = f;
        observablePublish$InnerDisposableArray = observablePublish$InnerDisposableArray.getAndSet(observablePublish$InnerDisposableArray2);
        int n10 = observablePublish$InnerDisposableArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            g0 g02 = observablePublish$InnerDisposableArray[i10].child;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.a.compareAndSet(this, null);
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray = this.b;
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray2 = f;
        observablePublish$InnerDisposableArray = observablePublish$InnerDisposableArray.getAndSet(observablePublish$InnerDisposableArray2);
        int n10 = observablePublish$InnerDisposableArray.length;
        if (n10 != 0) {
            n10 = observablePublish$InnerDisposableArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                g0 g02 = observablePublish$InnerDisposableArray[i10].child;
                g02.onError(throwable);
            }
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        ObservablePublish$InnerDisposable[] observablePublish$InnerDisposableArray = (ObservablePublish$InnerDisposable[])this.b.get();
        int n10 = observablePublish$InnerDisposableArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            g0 g02 = observablePublish$InnerDisposableArray[i10].child;
            g02.onNext(object);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.d, b10);
    }
}

