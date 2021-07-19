/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver$BufferOpenObserver;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary$BufferBoundaryObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = -8466418554264089604L;
    public final o bufferClose;
    public final e0 bufferOpen;
    public final Callable bufferSupplier;
    public Map buffers;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public long index;
    public final e.a.s0.a observers;
    public final e.a.w0.f.a queue;
    public final AtomicReference upstream;

    public ObservableBufferBoundary$BufferBoundaryObserver(g0 atomicThrowable, e0 e02, o o10, Callable callable) {
        this.downstream = atomicThrowable;
        this.bufferSupplier = callable;
        this.bufferOpen = e02;
        this.bufferClose = o10;
        int n10 = z.b0();
        atomicThrowable = new e.a.w0.f.a(n10);
        this.queue = atomicThrowable;
        atomicThrowable = new e.a.s0.a();
        this.observers = atomicThrowable;
        atomicThrowable = new AtomicReference();
        this.upstream = atomicThrowable;
        this.buffers = atomicThrowable;
        this.errors = atomicThrowable = new AtomicThrowable();
    }

    public void boundaryError(b b10, Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        this.observers.c(b10);
        this.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close(ObservableBufferBoundary$BufferCloseObserver object, long l10) {
        e.a.s0.a a10 = this.observers;
        a10.c((b)object);
        object = this.observers;
        int n10 = ((e.a.s0.a)object).g();
        int n11 = 1;
        if (n10 == 0) {
            object = this.upstream;
            DisposableHelper.dispose((AtomicReference)object);
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispose() {
        Object object = this.upstream;
        int n10 = DisposableHelper.dispose((AtomicReference)object);
        if (n10 == 0) return;
        this.cancelled = true;
        this.observers.dispose();
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

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        Object object = this.queue;
        int n12 = n10 = 1;
        while (true) {
            Object object2;
            boolean bl2;
            if (bl2 = this.cancelled) {
                ((e.a.w0.f.a)object).clear();
                return;
            }
            bl2 = this.done;
            if (bl2 && (object2 = this.errors.get()) != null) {
                ((e.a.w0.f.a)object).clear();
                object = this.errors.terminate();
                g02.onError((Throwable)object);
                return;
            }
            object2 = (Collection)((e.a.w0.f.a)object).poll();
            int n13 = object2 == null ? n10 : 0;
            if (bl2 && n13 != 0) {
                g02.onComplete();
                return;
            }
            if (n13 != 0) {
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            g02.onNext(object2);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.upstream.get());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        Object object = this.observers;
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
            this.observers.dispose();
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

    public void onSubscribe(b b10) {
        Object object = this.upstream;
        boolean bl2 = DisposableHelper.setOnce((AtomicReference)object, b10);
        if (bl2) {
            b10 = new ObservableBufferBoundary$BufferBoundaryObserver$BufferOpenObserver(this);
            this.observers.b(b10);
            object = this.bufferOpen;
            object.subscribe((g0)((Object)b10));
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
            object3 = "The bufferClose returned a null ObservableSource";
            object = e.a.w0.b.a.g(object, (String)object3);
            object = (e0)object;
            l10 = this.index;
            this.index = l11 = 1L + l10;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            DisposableHelper.dispose(this.upstream);
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
        object2 = new ObservableBufferBoundary$BufferCloseObserver(this, l10);
        this.observers.b((b)object2);
        object.subscribe((g0)object2);
    }

    public void openComplete(ObservableBufferBoundary$BufferBoundaryObserver$BufferOpenObserver object) {
        e.a.s0.a a10 = this.observers;
        a10.c((b)object);
        object = this.observers;
        int n10 = ((e.a.s0.a)object).g();
        if (n10 == 0) {
            object = this.upstream;
            DisposableHelper.dispose((AtomicReference)object);
            n10 = 1;
            this.done = n10;
            this.drain();
        }
    }
}

