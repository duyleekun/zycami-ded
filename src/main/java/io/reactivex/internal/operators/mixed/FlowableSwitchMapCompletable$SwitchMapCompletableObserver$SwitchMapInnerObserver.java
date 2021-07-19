/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$SwitchMapCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver
extends AtomicReference
implements d {
    private static final long serialVersionUID = -8003404460084760287L;
    public final FlowableSwitchMapCompletable$SwitchMapCompletableObserver parent;

    public FlowableSwitchMapCompletable$SwitchMapCompletableObserver$SwitchMapInnerObserver(FlowableSwitchMapCompletable$SwitchMapCompletableObserver switchMapCompletableObserver) {
        this.parent = switchMapCompletableObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.b(this);
    }

    public void onError(Throwable throwable) {
        this.parent.c(this, throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

