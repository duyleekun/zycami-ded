/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver
extends AtomicReference
implements l0 {
    private static final long serialVersionUID = 8042919737683345351L;
    public volatile Object item;
    public final ObservableSwitchMapSingle$SwitchMapSingleMainObserver parent;

    public ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver(ObservableSwitchMapSingle$SwitchMapSingleMainObserver switchMapSingleMainObserver) {
        this.parent = switchMapSingleMainObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
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

