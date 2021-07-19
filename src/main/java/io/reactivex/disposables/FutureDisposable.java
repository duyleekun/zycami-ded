/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.disposables;

import e.a.s0.b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = 6545242830671168775L;
    private final boolean allowInterrupt;

    public FutureDisposable(Future future, boolean bl2) {
        super(future);
        this.allowInterrupt = bl2;
    }

    public void dispose() {
        Future future = this.getAndSet(null);
        if (future != null) {
            boolean bl2 = this.allowInterrupt;
            future.cancel(bl2);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        Future future = (Future)this.get();
        if (future != null && !(bl2 = future.isDone())) {
            bl2 = false;
            future = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

