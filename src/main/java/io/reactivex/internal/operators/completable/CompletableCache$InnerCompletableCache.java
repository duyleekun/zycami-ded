/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.operators.completable.CompletableCache;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableCache$InnerCompletableCache
extends AtomicBoolean
implements b {
    private static final long serialVersionUID = 8943152917179642732L;
    public final d downstream;
    public final /* synthetic */ CompletableCache this$0;

    public CompletableCache$InnerCompletableCache(CompletableCache completableCache, d d10) {
        this.this$0 = completableCache;
        this.downstream = d10;
    }

    public void dispose() {
        CompletableCache completableCache = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            completableCache = this.this$0;
            completableCache.i1(this);
        }
    }

    public boolean isDisposed() {
        return this.get();
    }
}

