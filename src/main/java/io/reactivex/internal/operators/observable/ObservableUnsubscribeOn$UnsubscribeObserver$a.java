/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$UnsubscribeObserver;

public final class ObservableUnsubscribeOn$UnsubscribeObserver$a
implements Runnable {
    public final /* synthetic */ ObservableUnsubscribeOn$UnsubscribeObserver a;

    public ObservableUnsubscribeOn$UnsubscribeObserver$a(ObservableUnsubscribeOn$UnsubscribeObserver unsubscribeObserver) {
        this.a = unsubscribeObserver;
    }

    public void run() {
        this.a.upstream.dispose();
    }
}

