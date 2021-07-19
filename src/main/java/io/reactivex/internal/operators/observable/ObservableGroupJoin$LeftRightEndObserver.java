/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$a;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin$LeftRightEndObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final ObservableGroupJoin$a parent;

    public ObservableGroupJoin$LeftRightEndObserver(ObservableGroupJoin$a observableGroupJoin$a, boolean bl2, int n10) {
        this.parent = observableGroupJoin$a;
        this.isLeft = bl2;
        this.index = n10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        ObservableGroupJoin$a observableGroupJoin$a = this.parent;
        boolean bl2 = this.isLeft;
        observableGroupJoin$a.innerClose(bl2, this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerCloseError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = DisposableHelper.dispose(this);
        if (bl2) {
            object = this.parent;
            boolean bl3 = this.isLeft;
            object.innerClose(bl3, this);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

