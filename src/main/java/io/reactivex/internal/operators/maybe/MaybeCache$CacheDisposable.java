/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.operators.maybe.MaybeCache;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache$CacheDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = -5791853038359966195L;
    public final t downstream;

    public MaybeCache$CacheDisposable(t t10, MaybeCache maybeCache) {
        super(maybeCache);
        this.downstream = t10;
    }

    public void dispose() {
        MaybeCache maybeCache = this.getAndSet(null);
        if (maybeCache != null) {
            maybeCache.f2(this);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        Object v10 = this.get();
        if (v10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }
}

