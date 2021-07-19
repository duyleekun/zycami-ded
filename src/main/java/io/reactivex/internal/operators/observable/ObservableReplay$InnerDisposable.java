/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableReplay$InnerDisposable
extends AtomicInteger
implements b {
    private static final long serialVersionUID = 2728361546769921047L;
    public volatile boolean cancelled;
    public final g0 child;
    public Object index;
    public final ObservableReplay$ReplayObserver parent;

    public ObservableReplay$InnerDisposable(ObservableReplay$ReplayObserver replayObserver, g0 g02) {
        this.parent = replayObserver;
        this.child = g02;
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = true;
            this.parent.remove(this);
            bl2 = false;
            this.index = null;
        }
    }

    public Object index() {
        return this.index;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}

