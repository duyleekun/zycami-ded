/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable;
import io.reactivex.internal.operators.observable.ObservableReplay$e;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

public final class ObservableReplay$UnboundedReplayBuffer
extends ArrayList
implements ObservableReplay$e {
    private static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public ObservableReplay$UnboundedReplayBuffer(int n10) {
        super(n10);
    }

    public void complete() {
        int n10;
        Object object = NotificationLite.complete();
        this.add(object);
        this.size = n10 = this.size + 1;
    }

    public void error(Throwable object) {
        int n10;
        object = NotificationLite.error((Throwable)object);
        this.add(object);
        this.size = n10 = this.size + 1;
    }

    public void next(Object object) {
        int n10;
        object = NotificationLite.next(object);
        this.add(object);
        this.size = n10 = this.size + 1;
    }

    public void replay(ObservableReplay$InnerDisposable observableReplay$InnerDisposable) {
        int n10 = observableReplay$InnerDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        g0 g02 = observableReplay$InnerDisposable.child;
        int n11 = 1;
        do {
            int n12;
            int n13;
            if ((n13 = observableReplay$InnerDisposable.isDisposed()) != 0) {
                return;
            }
            n13 = this.size;
            Integer n14 = (Integer)observableReplay$InnerDisposable.index();
            if (n14 != null) {
                n12 = n14;
            } else {
                n12 = 0;
                n14 = null;
            }
            while (n12 < n13) {
                Object e10 = this.get(n12);
                boolean bl2 = NotificationLite.accept(e10, g02);
                if (bl2) {
                    return;
                }
                bl2 = observableReplay$InnerDisposable.isDisposed();
                if (bl2) {
                    return;
                }
                ++n12;
            }
            Integer n15 = n12;
            observableReplay$InnerDisposable.index = n15;
            n11 = -n11;
        } while ((n11 = observableReplay$InnerDisposable.addAndGet(n11)) != 0);
    }
}

