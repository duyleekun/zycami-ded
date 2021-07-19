/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.h0;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.processors.ReplayProcessor$ReplaySubscription;
import io.reactivex.processors.ReplayProcessor$TimedNode;
import io.reactivex.processors.ReplayProcessor$a;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayProcessor$b
implements ReplayProcessor$a {
    public final int a;
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public int e;
    public volatile ReplayProcessor$TimedNode f;
    public ReplayProcessor$TimedNode g;
    public Throwable h;
    public volatile boolean i;

    public ReplayProcessor$b(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        Object object;
        long l11;
        this.a = n10 = e.a.w0.b.a.h(n10, "maxSize");
        this.b = l11 = e.a.w0.b.a.i(l10, "maxAge");
        this.c = object = (TimeUnit)((Object)e.a.w0.b.a.g((Object)timeUnit, "unit is null"));
        object = (h0)e.a.w0.b.a.g(h02, "scheduler is null");
        this.d = object;
        super(null, 0L);
        this.g = object;
        this.f = object;
    }

    public void a(ReplayProcessor$ReplaySubscription serializable) {
        int n10;
        int n11 = serializable.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        d d10 = serializable.downstream;
        Object object = (ReplayProcessor$TimedNode)serializable.index;
        if (object == null) {
            object = this.b();
        }
        long l10 = serializable.emitted;
        int n12 = n10 = 1;
        do {
            long l11;
            AtomicLong atomicLong = serializable.requested;
            long l12 = atomicLong.get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                boolean bl2 = serializable.cancelled;
                if (bl2) {
                    serializable.index = null;
                    return;
                }
                bl2 = this.i;
                ReplayProcessor$TimedNode replayProcessor$TimedNode = (ReplayProcessor$TimedNode)((AtomicReference)object).get();
                int n13 = replayProcessor$TimedNode == null ? n10 : 0;
                if (bl2 && n13 != 0) {
                    serializable.index = null;
                    serializable.cancelled = n10;
                    serializable = this.h;
                    if (serializable == null) {
                        d10.onComplete();
                    } else {
                        d10.onError((Throwable)serializable);
                    }
                    return;
                }
                if (n13 != 0) break;
                object = replayProcessor$TimedNode.value;
                d10.onNext(object);
                long l13 = 1L;
                l10 += l13;
                object = replayProcessor$TimedNode;
            }
            if (l11 == false) {
                boolean bl3 = serializable.cancelled;
                if (bl3) {
                    serializable.index = null;
                    return;
                }
                bl3 = this.i;
                if (bl3 && (atomicLong = ((AtomicReference)object).get()) == null) {
                    serializable.index = null;
                    serializable.cancelled = n10;
                    serializable = this.h;
                    if (serializable == null) {
                        d10.onComplete();
                    } else {
                        d10.onError((Throwable)serializable);
                    }
                    return;
                }
            }
            serializable.index = object;
            serializable.emitted = l10;
            n12 = -n12;
        } while ((n12 = serializable.addAndGet(n12)) != 0);
    }

    public ReplayProcessor$TimedNode b() {
        ReplayProcessor$TimedNode replayProcessor$TimedNode = this.f;
        h0 h02 = this.d;
        TimeUnit timeUnit = this.c;
        long l10 = h02.d(timeUnit);
        long l11 = this.b;
        ReplayProcessor$TimedNode replayProcessor$TimedNode2 = (ReplayProcessor$TimedNode)replayProcessor$TimedNode.get();
        while (true) {
            long l12;
            long l13;
            long l14;
            ReplayProcessor$TimedNode replayProcessor$TimedNode3 = replayProcessor$TimedNode2;
            replayProcessor$TimedNode2 = replayProcessor$TimedNode;
            replayProcessor$TimedNode = replayProcessor$TimedNode3;
            if (replayProcessor$TimedNode3 == null || (l14 = (l13 = (l12 = replayProcessor$TimedNode3.time) - (l10 -= l11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) break;
            replayProcessor$TimedNode2 = (ReplayProcessor$TimedNode)replayProcessor$TimedNode3.get();
        }
        return replayProcessor$TimedNode2;
    }

    public int c(ReplayProcessor$TimedNode replayProcessor$TimedNode) {
        int n10;
        int n11;
        for (n11 = 0; n11 != (n10 = -1 >>> 1) && (replayProcessor$TimedNode = (ReplayProcessor$TimedNode)replayProcessor$TimedNode.get()) != null; ++n11) {
        }
        return n11;
    }

    public void complete() {
        this.e();
        this.i = true;
    }

    public void d() {
        Object object;
        int n10 = this.e;
        int n11 = this.a;
        int n12 = 1;
        if (n10 > n11) {
            this.e = n10 -= n12;
            this.f = object = (ReplayProcessor$TimedNode)this.f.get();
        }
        object = this.d;
        TimeUnit timeUnit = this.c;
        long l10 = ((h0)object).d(timeUnit);
        long l11 = this.b;
        l10 -= l11;
        ReplayProcessor$TimedNode replayProcessor$TimedNode = this.f;
        while (true) {
            int n13;
            ReplayProcessor$TimedNode replayProcessor$TimedNode2;
            block8: {
                block6: {
                    block7: {
                        block5: {
                            int n14;
                            if ((n14 = this.e) > n12) break block5;
                            this.f = replayProcessor$TimedNode;
                            break block6;
                        }
                        replayProcessor$TimedNode2 = (ReplayProcessor$TimedNode)replayProcessor$TimedNode.get();
                        if (replayProcessor$TimedNode2 != null) break block7;
                        this.f = replayProcessor$TimedNode;
                        break block6;
                    }
                    long l12 = replayProcessor$TimedNode2.time;
                    long l13 = l12 - l10;
                    Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object2 <= 0) break block8;
                    this.f = replayProcessor$TimedNode;
                }
                return;
            }
            this.e = n13 = this.e - n12;
            replayProcessor$TimedNode = replayProcessor$TimedNode2;
        }
    }

    public void e() {
        Object object = this.d;
        TimeUnit timeUnit = this.c;
        long l10 = ((h0)object).d(timeUnit);
        long l11 = this.b;
        l10 -= l11;
        ReplayProcessor$TimedNode replayProcessor$TimedNode = this.f;
        while (true) {
            ReplayProcessor$TimedNode replayProcessor$TimedNode2;
            block8: {
                block7: {
                    long l12;
                    block6: {
                        replayProcessor$TimedNode2 = (ReplayProcessor$TimedNode)replayProcessor$TimedNode.get();
                        l12 = 0L;
                        if (replayProcessor$TimedNode2 != null) break block6;
                        object = replayProcessor$TimedNode.value;
                        this.f = object != null ? (object = new ReplayProcessor$TimedNode(null, l12)) : replayProcessor$TimedNode;
                        break block7;
                    }
                    long l13 = replayProcessor$TimedNode2.time;
                    long l14 = l13 - l10;
                    Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object2 <= 0) break block8;
                    object = replayProcessor$TimedNode.value;
                    if (object != null) {
                        object = new ReplayProcessor$TimedNode(null, l12);
                        timeUnit = replayProcessor$TimedNode.get();
                        ((AtomicReference)object).lazySet(timeUnit);
                        this.f = object;
                    } else {
                        this.f = replayProcessor$TimedNode;
                    }
                }
                return;
            }
            replayProcessor$TimedNode = replayProcessor$TimedNode2;
        }
    }

    public void error(Throwable throwable) {
        this.e();
        this.h = throwable;
        this.i = true;
    }

    public Throwable getError() {
        return this.h;
    }

    public Object getValue() {
        ReplayProcessor$TimedNode replayProcessor$TimedNode = this.f;
        while (true) {
            Object object;
            if ((object = (ReplayProcessor$TimedNode)replayProcessor$TimedNode.get()) == null) {
                object = this.d;
                TimeUnit timeUnit = this.c;
                long l10 = ((h0)object).d(timeUnit);
                long l11 = this.b;
                l11 = replayProcessor$TimedNode.time;
                long l12 = l11 - (l10 -= l11);
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 < 0) {
                    return null;
                }
                return replayProcessor$TimedNode.value;
            }
            replayProcessor$TimedNode = object;
        }
    }

    public Object[] getValues(Object[] objectArray) {
        ReplayProcessor$TimedNode replayProcessor$TimedNode = this.b();
        int n10 = this.c(replayProcessor$TimedNode);
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
                replayProcessor$TimedNode = (ReplayProcessor$TimedNode)replayProcessor$TimedNode.get();
                objectArray[n11] = object = replayProcessor$TimedNode.value;
                ++n11;
            }
            int n14 = objectArray.length;
            if (n14 > n10) {
                objectArray[n10] = null;
            }
        }
        return objectArray;
    }

    public boolean isDone() {
        return this.i;
    }

    public void next(Object object) {
        int n10;
        h0 h02 = this.d;
        TimeUnit timeUnit = this.c;
        long l10 = h02.d(timeUnit);
        ReplayProcessor$TimedNode replayProcessor$TimedNode = new ReplayProcessor$TimedNode(object, l10);
        object = this.g;
        this.g = replayProcessor$TimedNode;
        this.e = n10 = this.e + 1;
        ((AtomicReference)object).set(replayProcessor$TimedNode);
        this.d();
    }

    public int size() {
        ReplayProcessor$TimedNode replayProcessor$TimedNode = this.b();
        return this.c(replayProcessor$TimedNode);
    }

    public void trimHead() {
        Object object = this.f.value;
        if (object != null) {
            long l10 = 0L;
            object = new ReplayProcessor$TimedNode(null, l10);
            Object v10 = this.f.get();
            ((AtomicReference)object).lazySet(v10);
            this.f = object;
        }
    }
}

