/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$a;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin$LeftRightObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = 1883890389173668373L;
    public final boolean isLeft;
    public final ObservableGroupJoin$a parent;

    public ObservableGroupJoin$LeftRightObserver(ObservableGroupJoin$a observableGroupJoin$a, boolean bl2) {
        this.parent = observableGroupJoin$a;
        this.isLeft = bl2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onNext(Object object) {
        ObservableGroupJoin$a observableGroupJoin$a = this.parent;
        boolean bl2 = this.isLeft;
        observableGroupJoin$a.innerValue(bl2, object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

