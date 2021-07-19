/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.t0.a;
import e.a.v0.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableBufferBoundary$BufferBoundarySubscriber
extends AtomicInteger
implements e.a.o,
e {
    private static final long serialVersionUID = -8466418554264089604L;
    public final o bufferClose;
    public final c bufferOpen;
    public final Callable bufferSupplier;
    public Map buffers;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final d downstream;
    public long emitted;
    public final AtomicThrowable errors;
    public long index;
    public final e.a.w0.f.a queue;
    public final AtomicLong requested;
    public final e.a.s0.a subscribers;
    public final AtomicReference upstream;

    public FlowableBufferBoundary$BufferBoundarySubscriber(d atomicThrowable, c c10, o o10, Callable callable) {
        this.downstream = atomicThrowable;
        this.bufferSupplier = callable;
        this.bufferOpen = c10;
        this.bufferClose = o10;
        int n10 = j.f0();
        atomicThrowable = new e.a.w0.f.a(n10);
        this.queue = atomicThrowable;
        atomicThrowable = new e.a.s0.a();
        this.subscribers = atomicThrowable;
        atomicThrowable = new AtomicLong();
        this.requested = atomicThrowable;
        atomicThrowable = new AtomicReference();
        this.upstream = atomicThrowable;
        this.buffers = atomicThrowable;
        this.errors = atomicThrowable = new AtomicThrowable();
    }

    public void boundaryError(e.a.s0.b b10, Throwable throwable) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.c(b10);
        this.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancel() {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.cancel((AtomicReference)object);
        if (n10 == 0) return;
        this.cancelled = true;
        this.subscribers.dispose();
        synchronized (this) {
            n10 = 0;
            object = null;
            this.buffers = null;
        }
        n10 = this.getAndIncrement();
        if (n10 == 0) return;
        object = this.queue;
        ((e.a.w0.f.a)object).clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close(FlowableBufferBoundary$BufferCloseSubscriber object, long l10) {
        e.a.s0.a a10 = this.subscribers;
        a10.c((e.a.s0.b)object);
        object = this.subscribers;
        int n10 = ((e.a.s0.a)object).g();
        int n11 = 1;
        if (n10 == 0) {
            object = this.upstream;
            SubscriptionHelper.cancel((AtomicReference)object);
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        // MONITORENTER : this
        Map map = this.buffers;
        if (map == null) {
            // MONITOREXIT : this
            return;
        }
        e.a.w0.f.a a11 = this.queue;
        Long l11 = l10;
        l11 = map.remove(l11);
        a11.offer(l11);
        // MONITOREXIT : this
        if (n10 != 0) {
            this.done = n11;
        }
        this.drain();
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        long l10 = this.emitted;
        d d10 = this.downstream;
        e.a.w0.f.a a10 = this.queue;
        int n12 = n10 = 1;
        do {
            long l11;
            AtomicLong atomicLong = this.requested;
            long l12 = atomicLong.get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                Object object;
                boolean bl2 = this.cancelled;
                if (bl2) {
                    a10.clear();
                    return;
                }
                bl2 = this.done;
                if (bl2 && (object = this.errors.get()) != null) {
                    a10.clear();
                    Throwable throwable = this.errors.terminate();
                    d10.onError(throwable);
                    return;
                }
                object = (Collection)a10.poll();
                int n13 = object == null ? n10 : 0;
                if (bl2 && n13 != 0) {
                    d10.onComplete();
                    return;
                }
                if (n13 != 0) break;
                d10.onNext(object);
                long l13 = 1L;
                l10 += l13;
            }
            if (l11 == false) {
                boolean bl3 = this.cancelled;
                if (bl3) {
                    a10.clear();
                    return;
                }
                bl3 = this.done;
                if (bl3) {
                    atomicLong = this.errors.get();
                    if (atomicLong != null) {
                        a10.clear();
                        Throwable throwable = this.errors.terminate();
                        d10.onError(throwable);
                        return;
                    }
                    bl3 = a10.isEmpty();
                    if (bl3) {
                        d10.onComplete();
                        return;
                    }
                }
            }
            this.emitted = l10;
            n12 = -n12;
        } while ((n12 = this.addAndGet(n12)) != 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        Object object = this.subscribers;
        ((e.a.s0.a)object).dispose();
        synchronized (this) {
            object = this.buffers;
            if (object == null) {
                return;
            }
            object = object.values();
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = null;
                    this.buffers = null;
                    // MONITOREXIT @DISABLED, blocks:[2, 3, 4] lbl14 : MonitorExitStatement: MONITOREXIT : this
                    this.done = true;
                    this.drain();
                    return;
                }
                Object object2 = object.next();
                object2 = (Collection)object2;
                e.a.w0.f.a a10 = this.queue;
                a10.offer(object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.subscribers.dispose();
            synchronized (this) {
                bl3 = false;
                throwable = null;
                this.buffers = null;
            }
            this.done = bl3 = true;
            this.drain();
            return;
        }
        e.a.a1.a.Y(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Iterator iterator2 = this.buffers;
            if (iterator2 == null) {
                return;
            }
            iterator2 = iterator2.values();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object2 = iterator2.next();
                object2 = (Collection)object2;
                object2.add((Object)object);
            }
            return;
        }
    }

    public void onSubscribe(e e10) {
        AtomicReference atomicReference = this.upstream;
        boolean bl2 = SubscriptionHelper.setOnce(atomicReference, e10);
        if (bl2) {
            atomicReference = new FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber(this);
            this.subscribers.b((e.a.s0.b)((Object)atomicReference));
            c c10 = this.bufferOpen;
            c10.subscribe((d)((Object)atomicReference));
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void open(Object object) {
        long l10;
        Object object2;
        try {
            long l11;
            object2 = this.bufferSupplier;
            object2 = object2.call();
            Object object3 = "The bufferSupplier returned a null Collection";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            object2 = (Collection)object2;
            object3 = this.bufferClose;
            object = object3.apply(object);
            object3 = "The bufferClose returned a null Publisher";
            object = e.a.w0.b.a.g(object, (String)object3);
            object = (c)object;
            l10 = this.index;
            this.index = l11 = 1L + l10;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            SubscriptionHelper.cancel(this.upstream);
            this.onError(throwable);
            return;
        }
        synchronized (this) {
            Map map = this.buffers;
            if (map == null) {
                return;
            }
            Long l12 = l10;
            map.put(l12, object2);
        }
        object2 = new FlowableBufferBoundary$BufferCloseSubscriber(this, l10);
        this.subscribers.b((e.a.s0.b)object2);
        object.subscribe((d)object2);
    }

    public void openComplete(FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber object) {
        e.a.s0.a a10 = this.subscribers;
        a10.c((e.a.s0.b)object);
        object = this.subscribers;
        int n10 = ((e.a.s0.a)object).g();
        if (n10 == 0) {
            object = this.upstream;
            SubscriptionHelper.cancel((AtomicReference)object);
            n10 = 1;
            this.done = n10;
            this.drain();
        }
    }

    public void request(long l10) {
        b.a(this.requested, l10);
        this.drain();
    }
}

