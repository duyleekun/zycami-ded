/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.s0.b;
import e.a.v0.g;
import e.a.w0.a.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount$RefConnection
extends AtomicReference
implements Runnable,
g {
    private static final long serialVersionUID = -4552101107598366241L;
    public boolean connected;
    public boolean disconnectedEarly;
    public final ObservableRefCount parent;
    public long subscriberCount;
    public b timer;

    public ObservableRefCount$RefConnection(ObservableRefCount observableRefCount) {
        this.parent = observableRefCount;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void accept(b b10) {
        DisposableHelper.replace(this, b10);
        ObservableRefCount observableRefCount = this.parent;
        synchronized (observableRefCount) {
            boolean bl2 = this.disconnectedEarly;
            if (bl2) {
                Object object = this.parent;
                object = ((ObservableRefCount)object).a;
                object = (c)object;
                object.m(b10);
            }
            return;
        }
    }

    public void run() {
        this.parent.l8(this);
    }
}

