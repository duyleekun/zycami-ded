/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableAmb$a;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb$AmbInnerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = -1185974347409665484L;
    public final g0 downstream;
    public final int index;
    public final ObservableAmb$a parent;
    public boolean won;

    public ObservableAmb$AmbInnerObserver(ObservableAmb$a a10, int n10, g0 g02) {
        this.parent = a10;
        this.index = n10;
        this.downstream = g02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        boolean bl2 = this.won;
        if (bl2) {
            g0 g02 = this.downstream;
            g02.onComplete();
        } else {
            Object object = this.parent;
            int n10 = this.index;
            bl2 = ((ObservableAmb$a)object).b(n10);
            if (bl2) {
                this.won = bl2 = true;
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.won;
        if (bl2) {
            g0 g02 = this.downstream;
            g02.onError(throwable);
        } else {
            Object object = this.parent;
            int n10 = this.index;
            bl2 = ((ObservableAmb$a)object).b(n10);
            if (bl2) {
                this.won = bl2 = true;
                object = this.downstream;
                object.onError(throwable);
            } else {
                a.Y(throwable);
            }
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.won;
        if (bl2) {
            g0 g02 = this.downstream;
            g02.onNext(object);
        } else {
            Object object2 = this.parent;
            int n10 = this.index;
            bl2 = ((ObservableAmb$a)object2).b(n10);
            if (bl2) {
                this.won = bl2 = true;
                object2 = this.downstream;
                object2.onNext(object);
            } else {
                object = (b)this.get();
                object.dispose();
            }
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

