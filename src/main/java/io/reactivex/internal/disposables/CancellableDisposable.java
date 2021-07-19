/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.disposables;

import e.a.a1.a;
import e.a.s0.b;
import e.a.v0.f;
import java.util.concurrent.atomic.AtomicReference;

public final class CancellableDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(f f10) {
        super(f10);
    }

    public void dispose() {
        Object object = this.get();
        if (object != null && (object = (f)this.getAndSet(null)) != null) {
            try {
                object.cancel();
            }
            catch (Exception exception) {
                e.a.t0.a.b(exception);
                a.Y(exception);
            }
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

