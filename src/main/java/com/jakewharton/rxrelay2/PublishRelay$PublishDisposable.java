/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.PublishRelay;
import e.a.g0;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class PublishRelay$PublishDisposable
extends AtomicBoolean
implements b {
    private static final long serialVersionUID = 3562861878281475070L;
    public final g0 downstream;
    public final PublishRelay parent;

    public PublishRelay$PublishDisposable(g0 g02, PublishRelay publishRelay) {
        this.downstream = g02;
        this.parent = publishRelay;
    }

    public void dispose() {
        PublishRelay publishRelay = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            publishRelay = this.parent;
            publishRelay.l8(this);
        }
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onNext(Object object) {
        boolean bl2 = this.get();
        if (!bl2) {
            g0 g02 = this.downstream;
            g02.onNext(object);
        }
    }
}

