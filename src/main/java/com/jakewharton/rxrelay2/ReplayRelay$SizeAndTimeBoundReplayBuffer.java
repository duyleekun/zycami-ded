/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.ReplayRelay$ReplayDisposable;
import com.jakewharton.rxrelay2.ReplayRelay$TimedNode;
import com.jakewharton.rxrelay2.ReplayRelay$a;
import e.a.g0;
import e.a.h0;
import java.lang.reflect.Array;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayRelay$SizeAndTimeBoundReplayBuffer
extends AtomicReference
implements ReplayRelay$a {
    private static final long serialVersionUID = -8056260896137901749L;
    public volatile ReplayRelay$TimedNode head;
    public final long maxAge;
    public final int maxSize;
    public final h0 scheduler;
    public int size;
    public ReplayRelay$TimedNode tail;
    public final TimeUnit unit;

    public ReplayRelay$SizeAndTimeBoundReplayBuffer(int n10, long l10, TimeUnit object, h0 h02) {
        if (n10 > 0) {
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                ReplayRelay$TimedNode replayRelay$TimedNode;
                Objects.requireNonNull(object, "unit == null");
                Objects.requireNonNull(h02, "scheduler == null");
                this.maxSize = n10;
                this.maxAge = l10;
                this.unit = object;
                this.scheduler = h02;
                this.tail = replayRelay$TimedNode = new ReplayRelay$TimedNode(null, l11);
                this.head = replayRelay$TimedNode;
                return;
            }
            ((StringBuilder)object).append("maxAge > 0 required but it was ");
            ((StringBuilder)object).append(l10);
            String string2 = ((StringBuilder)object).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxSize > 0 required but it was ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public void add(Object object) {
        int n10;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        ReplayRelay$TimedNode replayRelay$TimedNode = new ReplayRelay$TimedNode(object, l10);
        object = this.tail;
        this.tail = replayRelay$TimedNode;
        this.size = n10 = this.size + 1;
        ((AtomicReference)object).set(replayRelay$TimedNode);
        this.trim();
    }

    public ReplayRelay$TimedNode getHead() {
        ReplayRelay$TimedNode replayRelay$TimedNode = this.head;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        long l11 = this.maxAge;
        ReplayRelay$TimedNode replayRelay$TimedNode2 = (ReplayRelay$TimedNode)replayRelay$TimedNode.get();
        while (true) {
            long l12;
            long l13;
            long l14;
            ReplayRelay$TimedNode replayRelay$TimedNode3 = replayRelay$TimedNode2;
            replayRelay$TimedNode2 = replayRelay$TimedNode;
            replayRelay$TimedNode = replayRelay$TimedNode3;
            if (replayRelay$TimedNode3 == null || (l14 = (l13 = (l12 = replayRelay$TimedNode3.time) - (l10 -= l11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) break;
            replayRelay$TimedNode2 = (ReplayRelay$TimedNode)replayRelay$TimedNode3.get();
        }
        return replayRelay$TimedNode2;
    }

    public Object getValue() {
        ReplayRelay$TimedNode replayRelay$TimedNode = this.head;
        while (true) {
            Object object;
            if ((object = (ReplayRelay$TimedNode)replayRelay$TimedNode.get()) == null) {
                object = this.scheduler;
                TimeUnit timeUnit = this.unit;
                long l10 = ((h0)object).d(timeUnit);
                long l11 = this.maxAge;
                l11 = replayRelay$TimedNode.time;
                long l12 = l11 - (l10 -= l11);
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 < 0) {
                    return null;
                }
                return replayRelay$TimedNode.value;
            }
            replayRelay$TimedNode = object;
        }
    }

    public Object[] getValues(Object[] objectArray) {
        ReplayRelay$TimedNode replayRelay$TimedNode = this.getHead();
        int n10 = this.size(replayRelay$TimedNode);
        int n11 = 0;
        if (n10 == 0) {
            int n12 = objectArray.length;
            if (n12 != 0) {
                objectArray[0] = null;
            }
        } else {
            int n13 = objectArray.length;
            if (n13 < n10) {
                objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n10);
            }
            while (n11 != n10) {
                Object object;
                replayRelay$TimedNode = (ReplayRelay$TimedNode)replayRelay$TimedNode.get();
                objectArray[n11] = object = replayRelay$TimedNode.value;
                ++n11;
            }
            int n14 = objectArray.length;
            if (n14 > n10) {
                objectArray[n10] = null;
            }
        }
        return objectArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void replay(ReplayRelay$ReplayDisposable replayRelay$ReplayDisposable) {
        int n10 = replayRelay$ReplayDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = 1;
        g0 g02 = replayRelay$ReplayDisposable.downstream;
        Object object = (ReplayRelay$TimedNode)replayRelay$ReplayDisposable.index;
        if (object == null) {
            object = this.getHead();
        }
        block0: while (true) {
            boolean bl2;
            if (bl2 = replayRelay$ReplayDisposable.cancelled) {
                replayRelay$ReplayDisposable.index = null;
                return;
            }
            while (true) {
                if (bl2 = replayRelay$ReplayDisposable.cancelled) {
                    replayRelay$ReplayDisposable.index = null;
                    return;
                }
                ReplayRelay$TimedNode replayRelay$TimedNode = (ReplayRelay$TimedNode)((AtomicReference)object).get();
                if (replayRelay$TimedNode == null) {
                    Object v10 = ((AtomicReference)object).get();
                    if (v10 != null) continue block0;
                    replayRelay$ReplayDisposable.index = object;
                    n10 = -n10;
                    if ((n10 = replayRelay$ReplayDisposable.addAndGet(n10)) == 0) return;
                    continue block0;
                }
                object = replayRelay$TimedNode.value;
                g02.onNext(object);
                object = replayRelay$TimedNode;
            }
            break;
        }
    }

    public int size() {
        ReplayRelay$TimedNode replayRelay$TimedNode = this.getHead();
        return this.size(replayRelay$TimedNode);
    }

    public int size(ReplayRelay$TimedNode replayRelay$TimedNode) {
        int n10;
        int n11;
        for (n11 = 0; n11 != (n10 = -1 >>> 1) && (replayRelay$TimedNode = (ReplayRelay$TimedNode)replayRelay$TimedNode.get()) != null; ++n11) {
        }
        return n11;
    }

    public void trim() {
        Object object;
        int n10 = this.size;
        int n11 = this.maxSize;
        int n12 = 1;
        if (n10 > n11) {
            this.size = n10 -= n12;
            this.head = object = (ReplayRelay$TimedNode)this.head.get();
        }
        object = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = ((h0)object).d(timeUnit);
        long l11 = this.maxAge;
        l10 -= l11;
        ReplayRelay$TimedNode replayRelay$TimedNode = this.head;
        while (true) {
            int n13;
            ReplayRelay$TimedNode replayRelay$TimedNode2;
            block8: {
                block6: {
                    block7: {
                        block5: {
                            int n14;
                            if ((n14 = this.size) > n12) break block5;
                            this.head = replayRelay$TimedNode;
                            break block6;
                        }
                        replayRelay$TimedNode2 = (ReplayRelay$TimedNode)replayRelay$TimedNode.get();
                        if (replayRelay$TimedNode2 != null) break block7;
                        this.head = replayRelay$TimedNode;
                        break block6;
                    }
                    long l12 = replayRelay$TimedNode2.time;
                    long l13 = l12 - l10;
                    Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object2 <= 0) break block8;
                    this.head = replayRelay$TimedNode;
                }
                return;
            }
            this.size = n13 = this.size - n12;
            replayRelay$TimedNode = replayRelay$TimedNode2;
        }
    }

    public void trimHead() {
        ReplayRelay$TimedNode replayRelay$TimedNode = this.head;
        Object object = replayRelay$TimedNode.value;
        if (object != null) {
            long l10 = 0L;
            object = new ReplayRelay$TimedNode(null, l10);
            replayRelay$TimedNode = replayRelay$TimedNode.get();
            ((AtomicReference)object).lazySet(replayRelay$TimedNode);
            this.head = object;
        }
    }
}

