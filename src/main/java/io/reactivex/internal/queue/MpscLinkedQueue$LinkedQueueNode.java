/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue$LinkedQueueNode
extends AtomicReference {
    private static final long serialVersionUID = 2404266111789071508L;
    private Object value;

    public MpscLinkedQueue$LinkedQueueNode() {
    }

    public MpscLinkedQueue$LinkedQueueNode(Object object) {
        this.spValue(object);
    }

    public Object getAndNullValue() {
        Object object = this.lpValue();
        this.spValue(null);
        return object;
    }

    public Object lpValue() {
        return this.value;
    }

    public MpscLinkedQueue$LinkedQueueNode lvNext() {
        return (MpscLinkedQueue$LinkedQueueNode)this.get();
    }

    public void soNext(MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode) {
        this.lazySet(mpscLinkedQueue$LinkedQueueNode);
    }

    public void spValue(Object object) {
        this.value = object;
    }
}

