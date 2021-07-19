/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCache$a;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableCache$CacheDisposable
extends AtomicInteger
implements b {
    private static final long serialVersionUID = 6770240836423125754L;
    public volatile boolean disposed;
    public final g0 downstream;
    public long index;
    public ObservableCache$a node;
    public int offset;
    public final ObservableCache parent;

    public ObservableCache$CacheDisposable(g0 object, ObservableCache observableCache) {
        this.downstream = object;
        this.parent = observableCache;
        this.node = object = observableCache.f;
    }

    public void dispose() {
        boolean bl2 = this.disposed;
        if (!bl2) {
            this.disposed = bl2 = true;
            ObservableCache observableCache = this.parent;
            observableCache.l8(this);
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }
}

