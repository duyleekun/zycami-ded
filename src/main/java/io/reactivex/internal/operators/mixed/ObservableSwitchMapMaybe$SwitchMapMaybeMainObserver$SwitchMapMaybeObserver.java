/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = 8042919737683345351L;
    public volatile Object item;
    public final ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver parent;

    public ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver(ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver switchMapMaybeMainObserver) {
        this.parent = switchMapMaybeMainObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.item = object;
        this.parent.drain();
    }
}

