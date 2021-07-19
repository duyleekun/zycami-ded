/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable;
import io.reactivex.internal.operators.observable.ObservableReplay$e;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay$ReplayObserver
extends AtomicReference
implements g0,
b {
    public static final ObservableReplay$InnerDisposable[] EMPTY = new ObservableReplay$InnerDisposable[0];
    public static final ObservableReplay$InnerDisposable[] TERMINATED = new ObservableReplay$InnerDisposable[0];
    private static final long serialVersionUID = -533785617179540163L;
    public final ObservableReplay$e buffer;
    public boolean done;
    public final AtomicReference observers;
    public final AtomicBoolean shouldConnect;

    public ObservableReplay$ReplayObserver(ObservableReplay$e serializable) {
        this.buffer = serializable;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray = EMPTY;
        this.observers = serializable = new Serializable(observableReplay$InnerDisposableArray);
        this.shouldConnect = serializable;
    }

    public boolean add(ObservableReplay$InnerDisposable observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((observableReplay$InnerDisposableArray2 = (ObservableReplay$InnerDisposable[])this.observers.get()) == (object = TERMINATED)) {
                return false;
            }
            int n10 = observableReplay$InnerDisposableArray2.length;
            int n11 = n10 + 1;
            observableReplay$InnerDisposableArray = new ObservableReplay$InnerDisposable[n11];
            System.arraycopy(observableReplay$InnerDisposableArray2, 0, observableReplay$InnerDisposableArray, 0, n10);
            observableReplay$InnerDisposableArray[n10] = observableReplay$InnerDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.observers)).compareAndSet(observableReplay$InnerDisposableArray2, observableReplay$InnerDisposableArray)));
        return true;
    }

    public void dispose() {
        AtomicReference atomicReference = this.observers;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray = TERMINATED;
        atomicReference.set(observableReplay$InnerDisposableArray);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray;
        Object v10 = this.observers.get();
        if (v10 == (observableReplay$InnerDisposableArray = TERMINATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            ObservableReplay$e observableReplay$e = this.buffer;
            observableReplay$e.complete();
            this.replayFinal();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            ObservableReplay$e observableReplay$e = this.buffer;
            observableReplay$e.error(throwable);
            this.replayFinal();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (!bl2) {
            ObservableReplay$e observableReplay$e = this.buffer;
            observableReplay$e.next(object);
            this.replay();
        }
    }

    public void onSubscribe(b b10) {
        boolean bl2 = DisposableHelper.setOnce(this, b10);
        if (bl2) {
            this.replay();
        }
    }

    public void remove(ObservableReplay$InnerDisposable observableReplay$InnerDisposable) {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            int n10;
            ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray3;
            int n11;
            int n12;
            if ((n12 = (observableReplay$InnerDisposableArray2 = (ObservableReplay$InnerDisposable[])this.observers.get()).length) == 0) {
                return;
            }
            int n13 = -1;
            int n14 = 0;
            for (n11 = 0; n11 < n12; ++n11) {
                observableReplay$InnerDisposableArray3 = observableReplay$InnerDisposableArray2[n11];
                n10 = observableReplay$InnerDisposableArray3.equals(observableReplay$InnerDisposable);
                if (n10 == 0) continue;
                n13 = n11;
                break;
            }
            if (n13 < 0) {
                return;
            }
            n11 = 1;
            if (n12 == n11) {
                observableReplay$InnerDisposableArray = EMPTY;
                continue;
            }
            n10 = n12 + -1;
            observableReplay$InnerDisposableArray3 = new ObservableReplay$InnerDisposable[n10];
            System.arraycopy(observableReplay$InnerDisposableArray2, 0, observableReplay$InnerDisposableArray3, 0, n13);
            n14 = n13 + 1;
            n12 = n12 - n13 - n11;
            System.arraycopy(observableReplay$InnerDisposableArray2, n14, observableReplay$InnerDisposableArray3, n13, n12);
            observableReplay$InnerDisposableArray = observableReplay$InnerDisposableArray3;
        } while (!(bl2 = (atomicReference = this.observers).compareAndSet(observableReplay$InnerDisposableArray2, observableReplay$InnerDisposableArray)));
    }

    public void replay() {
        for (ObservableReplay$InnerDisposable observableReplay$InnerDisposable : (ObservableReplay$InnerDisposable[])this.observers.get()) {
            ObservableReplay$e observableReplay$e = this.buffer;
            observableReplay$e.replay(observableReplay$InnerDisposable);
        }
    }

    public void replayFinal() {
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray = this.observers;
        ObservableReplay$InnerDisposable[] observableReplay$InnerDisposableArray2 = TERMINATED;
        for (ObservableReplay$InnerDisposable observableReplay$InnerDisposable : observableReplay$InnerDisposableArray.getAndSet(observableReplay$InnerDisposableArray2)) {
            ObservableReplay$e observableReplay$e = this.buffer;
            observableReplay$e.replay(observableReplay$InnerDisposable);
        }
    }
}

