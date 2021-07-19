/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

public final class FlowableReplay$Node
extends AtomicReference {
    private static final long serialVersionUID = 245354315435971818L;
    public final long index;
    public final Object value;

    public FlowableReplay$Node(Object object, long l10) {
        this.value = object;
        this.index = l10;
    }
}

