/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = 8042919737683345351L;
    public volatile Object item;
    public final FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber parent;

    public FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber$SwitchMapMaybeObserver(FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber switchMapMaybeSubscriber) {
        this.parent = switchMapMaybeSubscriber;
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

