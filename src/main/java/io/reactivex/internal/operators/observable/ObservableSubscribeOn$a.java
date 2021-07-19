/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn$SubscribeOnObserver;

public final class ObservableSubscribeOn$a
implements Runnable {
    private final ObservableSubscribeOn$SubscribeOnObserver a;
    public final /* synthetic */ ObservableSubscribeOn b;

    public ObservableSubscribeOn$a(ObservableSubscribeOn observableSubscribeOn, ObservableSubscribeOn$SubscribeOnObserver subscribeOnObserver) {
        this.b = observableSubscribeOn;
        this.a = subscribeOnObserver;
    }

    public void run() {
        e0 e02 = this.b.a;
        ObservableSubscribeOn$SubscribeOnObserver observableSubscribeOn$SubscribeOnObserver = this.a;
        e02.subscribe(observableSubscribeOn$SubscribeOnObserver);
    }
}

