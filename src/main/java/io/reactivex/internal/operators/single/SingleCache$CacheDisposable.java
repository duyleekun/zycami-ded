/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.operators.single.SingleCache;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleCache$CacheDisposable
extends AtomicBoolean
implements b {
    private static final long serialVersionUID = 7514387411091976596L;
    public final l0 downstream;
    public final SingleCache parent;

    public SingleCache$CacheDisposable(l0 l02, SingleCache singleCache) {
        this.downstream = l02;
        this.parent = singleCache;
    }

    public void dispose() {
        SingleCache singleCache = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            singleCache = this.parent;
            singleCache.O1(this);
        }
    }

    public boolean isDisposed() {
        return this.get();
    }
}

