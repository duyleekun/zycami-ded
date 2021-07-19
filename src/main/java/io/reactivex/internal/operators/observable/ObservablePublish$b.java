/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable;
import io.reactivex.internal.operators.observable.ObservablePublish$a;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish$b
implements e0 {
    private final AtomicReference a;

    public ObservablePublish$b(AtomicReference atomicReference) {
        this.a = atomicReference;
    }

    public void subscribe(g0 g02) {
        ObservablePublish$InnerDisposable observablePublish$InnerDisposable = new ObservablePublish$InnerDisposable(g02);
        g02.onSubscribe(observablePublish$InnerDisposable);
        while (true) {
            boolean bl2;
            if ((g02 = (ObservablePublish$a)this.a.get()) == null || (bl2 = ((ObservablePublish$a)g02).isDisposed())) {
                AtomicReference atomicReference = this.a;
                atomicReference = this.a;
                ObservablePublish$a observablePublish$a = new ObservablePublish$a(atomicReference);
                boolean bl3 = atomicReference.compareAndSet(g02, observablePublish$a);
                if (!bl3) continue;
                g02 = observablePublish$a;
            }
            if (bl2 = ((ObservablePublish$a)g02).a(observablePublish$InnerDisposable)) break;
        }
        observablePublish$InnerDisposable.setParent((ObservablePublish$a)g02);
    }
}

