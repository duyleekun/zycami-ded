/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.queue;

import e.a.w0.c.n;
import e.a.w0.i.l;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue
extends AtomicReferenceArray
implements n {
    private static final Integer a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    public final AtomicLong consumerIndex;
    public final int lookAheadStep;
    public final int mask;
    public final AtomicLong producerIndex;
    public long producerLookAhead;

    public SpscArrayQueue(int n10) {
        AtomicLong atomicLong;
        int n11 = l.b(n10);
        super(n11);
        this.mask = n11 = this.length() + -1;
        this.producerIndex = atomicLong = new AtomicLong();
        this.consumerIndex = atomicLong = new AtomicLong();
        n10 /= 4;
        n11 = a;
        this.lookAheadStep = n10 = Math.min(n10, n11);
    }

    public int calcElementOffset(long l10) {
        int n10 = (int)l10;
        int n11 = this.mask;
        return n10 & n11;
    }

    public int calcElementOffset(long l10, int n10) {
        return (int)l10 & n10;
    }

    public void clear() {
        boolean bl2;
        Object object;
        while ((object = this.poll()) != null || !(bl2 = this.isEmpty())) {
        }
    }

    public boolean isEmpty() {
        AtomicLong atomicLong;
        long l10;
        AtomicLong atomicLong2 = this.producerIndex;
        long l11 = atomicLong2.get();
        long l12 = l11 - (l10 = (atomicLong = this.consumerIndex).get());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            atomicLong2 = null;
        }
        return (boolean)object;
    }

    public Object lvElement(int n10) {
        return this.get(n10);
    }

    public boolean offer(Object object) {
        Object object2 = "Null is not a valid element";
        Objects.requireNonNull(object, (String)object2);
        int n10 = this.mask;
        AtomicLong atomicLong = this.producerIndex;
        long l10 = atomicLong.get();
        int n11 = this.calcElementOffset(l10, n10);
        long l11 = this.producerLookAhead;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l12 = this.lookAheadStep;
            l11 = (long)l12 + l10;
            object2 = this.lvElement(n10 = this.calcElementOffset(l11, n10));
            if (object2 == null) {
                this.producerLookAhead = l11;
            } else {
                object2 = this.lvElement(n11);
                if (object2 != null) {
                    return false;
                }
            }
        }
        this.soElement(n11, object);
        this.soProducerIndex(++l10);
        return true;
    }

    public boolean offer(Object object, Object object2) {
        boolean bl2 = this.offer(object);
        if (bl2 && (bl2 = this.offer(object2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Object poll() {
        AtomicLong atomicLong = this.consumerIndex;
        long l10 = atomicLong.get();
        int n10 = this.calcElementOffset(l10);
        Object object = this.lvElement(n10);
        if (object == null) {
            return null;
        }
        this.soConsumerIndex(++l10);
        this.soElement(n10, null);
        return object;
    }

    public void soConsumerIndex(long l10) {
        this.consumerIndex.lazySet(l10);
    }

    public void soElement(int n10, Object object) {
        this.lazySet(n10, object);
    }

    public void soProducerIndex(long l10) {
        this.producerIndex.lazySet(l10);
    }
}

