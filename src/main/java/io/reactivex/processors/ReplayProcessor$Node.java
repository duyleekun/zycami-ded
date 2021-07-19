/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import java.util.concurrent.atomic.AtomicReference;

public final class ReplayProcessor$Node
extends AtomicReference {
    private static final long serialVersionUID = 6404226426336033100L;
    public final Object value;

    public ReplayProcessor$Node(Object object) {
        this.value = object;
    }
}

