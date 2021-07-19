/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.g0;
import e.a.h0;
import e.a.w0.b.a;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.ReplaySubject$ReplayDisposable;
import io.reactivex.subjects.ReplaySubject$TimedNode;
import io.reactivex.subjects.ReplaySubject$a;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject$SizeAndTimeBoundReplayBuffer
extends AtomicReference
implements ReplaySubject$a {
    private static final long serialVersionUID = -8056260896137901749L;
    public volatile boolean done;
    public volatile ReplaySubject$TimedNode head;
    public final long maxAge;
    public final int maxSize;
    public final h0 scheduler;
    public int size;
    public ReplaySubject$TimedNode tail;
    public final TimeUnit unit;

    public ReplaySubject$SizeAndTimeBoundReplayBuffer(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        Object object;
        long l11;
        this.maxSize = n10 = a.h(n10, "maxSize");
        this.maxAge = l11 = a.i(l10, "maxAge");
        this.unit = object = (TimeUnit)((Object)a.g((Object)timeUnit, "unit is null"));
        object = (h0)a.g(h02, "scheduler is null");
        this.scheduler = object;
        super(null, 0L);
        this.tail = object;
        this.head = object;
    }

    public void add(Object object) {
        int n10;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        ReplaySubject$TimedNode replaySubject$TimedNode = new ReplaySubject$TimedNode(object, l10);
        object = this.tail;
        this.tail = replaySubject$TimedNode;
        this.size = n10 = this.size + 1;
        ((AtomicReference)object).set(replaySubject$TimedNode);
        this.trim();
    }

    public void addFinal(Object object) {
        ReplaySubject$TimedNode replaySubject$TimedNode = new ReplaySubject$TimedNode(object, Long.MAX_VALUE);
        object = this.tail;
        this.tail = replaySubject$TimedNode;
        int n10 = this.size;
        int n11 = 1;
        this.size = n10 += n11;
        ((AtomicReference)object).lazySet(replaySubject$TimedNode);
        this.trimFinal();
        this.done = n11;
    }

    public ReplaySubject$TimedNode getHead() {
        ReplaySubject$TimedNode replaySubject$TimedNode = this.head;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        long l11 = this.maxAge;
        ReplaySubject$TimedNode replaySubject$TimedNode2 = (ReplaySubject$TimedNode)replaySubject$TimedNode.get();
        while (true) {
            long l12;
            long l13;
            long l14;
            ReplaySubject$TimedNode replaySubject$TimedNode3 = replaySubject$TimedNode2;
            replaySubject$TimedNode2 = replaySubject$TimedNode;
            replaySubject$TimedNode = replaySubject$TimedNode3;
            if (replaySubject$TimedNode3 == null || (l14 = (l13 = (l12 = replaySubject$TimedNode3.time) - (l10 -= l11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) break;
            replaySubject$TimedNode2 = (ReplaySubject$TimedNode)replaySubject$TimedNode3.get();
        }
        return replaySubject$TimedNode2;
    }

    public Object getValue() {
        Object object = this.head;
        boolean bl2 = false;
        ReplaySubject$TimedNode replaySubject$TimedNode = null;
        while (true) {
            Object object2;
            if ((object2 = (ReplaySubject$TimedNode)((AtomicReference)object).get()) == null) {
                object2 = this.scheduler;
                TimeUnit timeUnit = this.unit;
                long l10 = ((h0)object2).d(timeUnit);
                long l11 = this.maxAge;
                l11 = ((ReplaySubject$TimedNode)object).time;
                long l12 = l11 - (l10 -= l11);
                Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 < 0) {
                    return null;
                }
                object = ((ReplaySubject$TimedNode)object).value;
                if (object == null) {
                    return null;
                }
                bl2 = NotificationLite.isComplete(object);
                if (!bl2 && !(bl2 = NotificationLite.isError(object))) {
                    return object;
                }
                return replaySubject$TimedNode.value;
            }
            replaySubject$TimedNode = object;
            object = object2;
        }
    }

    public Object[] getValues(Object[] objectArray) {
        ReplaySubject$TimedNode replaySubject$TimedNode = this.getHead();
        int n10 = this.size(replaySubject$TimedNode);
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
                replaySubject$TimedNode = (ReplaySubject$TimedNode)replaySubject$TimedNode.get();
                objectArray[n11] = object = replaySubject$TimedNode.value;
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
    public void replay(ReplaySubject$ReplayDisposable replaySubject$ReplayDisposable) {
        int n10 = replaySubject$ReplayDisposable.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        g0 g02 = replaySubject$ReplayDisposable.downstream;
        Object object = (ReplaySubject$TimedNode)replaySubject$ReplayDisposable.index;
        int n11 = 1;
        if (object == null) {
            object = this.getHead();
        }
        int n12 = n11;
        block0: while (true) {
            boolean bl2;
            if (bl2 = replaySubject$ReplayDisposable.cancelled) {
                replaySubject$ReplayDisposable.index = null;
                return;
            }
            while (true) {
                Object v10;
                if (bl2 = replaySubject$ReplayDisposable.cancelled) {
                    replaySubject$ReplayDisposable.index = null;
                    return;
                }
                ReplaySubject$TimedNode replaySubject$TimedNode = (ReplaySubject$TimedNode)((AtomicReference)object).get();
                if (replaySubject$TimedNode == null) {
                    Object v11 = ((AtomicReference)object).get();
                    if (v11 != null) continue block0;
                    replaySubject$ReplayDisposable.index = object;
                    n12 = -n12;
                    if ((n12 = replaySubject$ReplayDisposable.addAndGet(n12)) == 0) return;
                    continue block0;
                }
                object = replaySubject$TimedNode.value;
                boolean bl3 = this.done;
                if (bl3 && (v10 = replaySubject$TimedNode.get()) == null) {
                    n12 = (int)(NotificationLite.isComplete(object) ? 1 : 0);
                    if (n12 != 0) {
                        g02.onComplete();
                    } else {
                        object = NotificationLite.getError(object);
                        g02.onError((Throwable)object);
                    }
                    replaySubject$ReplayDisposable.index = null;
                    replaySubject$ReplayDisposable.cancelled = n11;
                    return;
                }
                g02.onNext(object);
                object = replaySubject$TimedNode;
            }
            break;
        }
    }

    public int size() {
        ReplaySubject$TimedNode replaySubject$TimedNode = this.getHead();
        return this.size(replaySubject$TimedNode);
    }

    public int size(ReplaySubject$TimedNode object) {
        int n10;
        int n11;
        for (n11 = 0; n11 != (n10 = -1 >>> 1); ++n11) {
            ReplaySubject$TimedNode replaySubject$TimedNode = (ReplaySubject$TimedNode)((AtomicReference)object).get();
            if (replaySubject$TimedNode == null) {
                boolean bl2;
                object = ((ReplaySubject$TimedNode)object).value;
                n10 = (int)(NotificationLite.isComplete(object) ? 1 : 0);
                if (n10 == 0 && !(bl2 = NotificationLite.isError(object))) break;
                n11 += -1;
                break;
            }
            object = replaySubject$TimedNode;
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
            this.head = object = (ReplaySubject$TimedNode)this.head.get();
        }
        object = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = ((h0)object).d(timeUnit);
        long l11 = this.maxAge;
        l10 -= l11;
        ReplaySubject$TimedNode replaySubject$TimedNode = this.head;
        while (true) {
            int n13;
            ReplaySubject$TimedNode replaySubject$TimedNode2;
            block8: {
                block6: {
                    block7: {
                        block5: {
                            int n14;
                            if ((n14 = this.size) > n12) break block5;
                            this.head = replaySubject$TimedNode;
                            break block6;
                        }
                        replaySubject$TimedNode2 = (ReplaySubject$TimedNode)replaySubject$TimedNode.get();
                        if (replaySubject$TimedNode2 != null) break block7;
                        this.head = replaySubject$TimedNode;
                        break block6;
                    }
                    long l12 = replaySubject$TimedNode2.time;
                    long l13 = l12 - l10;
                    Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object2 <= 0) break block8;
                    this.head = replaySubject$TimedNode;
                }
                return;
            }
            this.size = n13 = this.size - n12;
            replaySubject$TimedNode = replaySubject$TimedNode2;
        }
    }

    public void trimFinal() {
        Object object = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = ((h0)object).d(timeUnit);
        long l11 = this.maxAge;
        l10 -= l11;
        ReplaySubject$TimedNode replaySubject$TimedNode = this.head;
        while (true) {
            ReplaySubject$TimedNode replaySubject$TimedNode2;
            block10: {
                block9: {
                    long l12;
                    block8: {
                        replaySubject$TimedNode2 = (ReplaySubject$TimedNode)replaySubject$TimedNode.get();
                        Object v10 = replaySubject$TimedNode2.get();
                        l12 = 0L;
                        if (v10 != null) break block8;
                        object = replaySubject$TimedNode.value;
                        if (object != null) {
                            object = new ReplaySubject$TimedNode(null, l12);
                            timeUnit = replaySubject$TimedNode.get();
                            ((AtomicReference)object).lazySet(timeUnit);
                            this.head = object;
                        } else {
                            this.head = replaySubject$TimedNode;
                        }
                        break block9;
                    }
                    long l13 = replaySubject$TimedNode2.time;
                    long l14 = l13 - l10;
                    Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object2 <= 0) break block10;
                    object = replaySubject$TimedNode.value;
                    if (object != null) {
                        object = new ReplaySubject$TimedNode(null, l12);
                        timeUnit = replaySubject$TimedNode.get();
                        ((AtomicReference)object).lazySet(timeUnit);
                        this.head = object;
                    } else {
                        this.head = replaySubject$TimedNode;
                    }
                }
                return;
            }
            replaySubject$TimedNode = replaySubject$TimedNode2;
        }
    }

    public void trimHead() {
        ReplaySubject$TimedNode replaySubject$TimedNode = this.head;
        Object object = replaySubject$TimedNode.value;
        if (object != null) {
            long l10 = 0L;
            object = new ReplaySubject$TimedNode(null, l10);
            replaySubject$TimedNode = replaySubject$TimedNode.get();
            ((AtomicReference)object).lazySet(replaySubject$TimedNode);
            this.head = object;
        }
    }
}

