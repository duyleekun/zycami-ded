/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.queue;

import e.a.w0.c.n;
import io.reactivex.internal.queue.MpscLinkedQueue$LinkedQueueNode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue
implements n {
    private final AtomicReference a;
    private final AtomicReference b;

    public MpscLinkedQueue() {
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode;
        this.a = mpscLinkedQueue$LinkedQueueNode = new AtomicReference();
        this.b = mpscLinkedQueue$LinkedQueueNode = new AtomicReference();
        mpscLinkedQueue$LinkedQueueNode = new MpscLinkedQueue$LinkedQueueNode();
        this.d(mpscLinkedQueue$LinkedQueueNode);
        this.e(mpscLinkedQueue$LinkedQueueNode);
    }

    public MpscLinkedQueue$LinkedQueueNode a() {
        return (MpscLinkedQueue$LinkedQueueNode)this.b.get();
    }

    public MpscLinkedQueue$LinkedQueueNode b() {
        return (MpscLinkedQueue$LinkedQueueNode)this.b.get();
    }

    public MpscLinkedQueue$LinkedQueueNode c() {
        return (MpscLinkedQueue$LinkedQueueNode)this.a.get();
    }

    public void clear() {
        boolean bl2;
        Object object;
        while ((object = this.poll()) != null && !(bl2 = this.isEmpty())) {
        }
    }

    public void d(MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode) {
        this.b.lazySet(mpscLinkedQueue$LinkedQueueNode);
    }

    public MpscLinkedQueue$LinkedQueueNode e(MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode) {
        return this.a.getAndSet(mpscLinkedQueue$LinkedQueueNode);
    }

    public boolean isEmpty() {
        boolean bl2;
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode;
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode2 = this.b();
        if (mpscLinkedQueue$LinkedQueueNode2 == (mpscLinkedQueue$LinkedQueueNode = this.c())) {
            bl2 = true;
        } else {
            bl2 = false;
            mpscLinkedQueue$LinkedQueueNode2 = null;
        }
        return bl2;
    }

    public boolean offer(Object object) {
        Objects.requireNonNull(object, "Null is not a valid element");
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode = new MpscLinkedQueue$LinkedQueueNode(object);
        this.e(mpscLinkedQueue$LinkedQueueNode).soNext(mpscLinkedQueue$LinkedQueueNode);
        return true;
    }

    public boolean offer(Object object, Object object2) {
        this.offer(object);
        this.offer(object2);
        return true;
    }

    public Object poll() {
        Object object = this.a();
        MpscLinkedQueue$LinkedQueueNode mpscLinkedQueue$LinkedQueueNode = ((MpscLinkedQueue$LinkedQueueNode)object).lvNext();
        if (mpscLinkedQueue$LinkedQueueNode != null) {
            object = mpscLinkedQueue$LinkedQueueNode.getAndNullValue();
            this.d(mpscLinkedQueue$LinkedQueueNode);
            return object;
        }
        mpscLinkedQueue$LinkedQueueNode = this.c();
        if (object != mpscLinkedQueue$LinkedQueueNode) {
            while ((mpscLinkedQueue$LinkedQueueNode = ((MpscLinkedQueue$LinkedQueueNode)object).lvNext()) == null) {
            }
            object = mpscLinkedQueue$LinkedQueueNode.getAndNullValue();
            this.d(mpscLinkedQueue$LinkedQueueNode);
            return object;
        }
        return null;
    }
}

