/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservablePublish$a;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish$InnerDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = -1100270633763673112L;
    public final g0 child;

    public ObservablePublish$InnerDisposable(g0 g02) {
        this.child = g02;
    }

    public void dispose() {
        b b10 = this.getAndSet(this);
        if (b10 != null && b10 != this) {
            b10 = (ObservablePublish$a)b10;
            ((ObservablePublish$a)b10).b(this);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        Object v10 = this.get();
        if (v10 == this) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void setParent(ObservablePublish$a observablePublish$a) {
        boolean bl2 = this.compareAndSet(null, observablePublish$a);
        if (!bl2) {
            observablePublish$a.b(this);
        }
    }
}

