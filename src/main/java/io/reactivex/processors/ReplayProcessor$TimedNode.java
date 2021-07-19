/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import java.util.concurrent.atomic.AtomicReference;

public final class ReplayProcessor$TimedNode
extends AtomicReference {
    private static final long serialVersionUID = 6404226426336033100L;
    public final long time;
    public final Object value;

    public ReplayProcessor$TimedNode(Object object, long l10) {
        this.value = object;
        this.time = l10;
    }
}

