/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.w0.c.j;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueDisposable
extends AtomicInteger
implements j {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called");
        throw object;
    }

    public final boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called");
        throw object;
    }
}

