/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.disposables;

import e.a.s0.b;
import e.a.w0.b.a;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ReferenceDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(Object object) {
        object = a.g(object, "value is null");
        super(object);
    }

    public final void dispose() {
        Object v10 = this.get();
        if (v10 != null && (v10 = this.getAndSet(null)) != null) {
            this.onDisposed(v10);
        }
    }

    public final boolean isDisposed() {
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

    public abstract void onDisposed(Object var1);
}

