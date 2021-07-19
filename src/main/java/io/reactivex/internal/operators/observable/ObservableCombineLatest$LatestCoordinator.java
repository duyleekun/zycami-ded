/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.internal.operators.observable.ObservableCombineLatest$CombinerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableCombineLatest$LatestCoordinator
extends AtomicInteger
implements b {
    private static final long serialVersionUID = 8567835998786448817L;
    public int active;
    public volatile boolean cancelled;
    public final o combiner;
    public int complete;
    public final boolean delayError;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public Object[] latest;
    public final ObservableCombineLatest$CombinerObserver[] observers;
    public final e.a.w0.f.a queue;

    public ObservableCombineLatest$LatestCoordinator(g0 object, o o10, int n10, int n11, boolean bl2) {
        AtomicThrowable atomicThrowable;
        this.errors = atomicThrowable = new AtomicThrowable();
        this.downstream = object;
        this.combiner = o10;
        this.delayError = bl2;
        object = new Object[n10];
        this.latest = object;
        object = new ObservableCombineLatest$CombinerObserver[n10];
        o10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            ObservableCombineLatest$CombinerObserver observableCombineLatest$CombinerObserver = new ObservableCombineLatest$CombinerObserver(this, i10);
            object[i10] = observableCombineLatest$CombinerObserver;
        }
        this.observers = object;
        super(n11);
        this.queue = object;
    }

    public void cancelSources() {
        for (ObservableCombineLatest$CombinerObserver observableCombineLatest$CombinerObserver : this.observers) {
            observableCombineLatest$CombinerObserver.dispose();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear(e.a.w0.f.a a10) {
        synchronized (this) {
            this.latest = null;
        }
        a10.clear();
    }

    public void dispose() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            this.cancelSources();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                e.a.w0.f.a a10 = this.queue;
                this.clear(a10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        Object object3 = this.queue;
        g0 g02 = this.downstream;
        boolean bl2 = this.delayError;
        int n12 = n10 = 1;
        while (true) {
            Object object2;
            boolean bl3;
            if (bl3 = this.cancelled) {
                this.clear((e.a.w0.f.a)object3);
                return;
            }
            if (!bl2 && (object2 = this.errors.get()) != null) {
                this.cancelSources();
                this.clear((e.a.w0.f.a)object3);
                object3 = this.errors.terminate();
                g02.onError((Throwable)object3);
                return;
            }
            bl3 = this.done;
            Object object = (Object[])((e.a.w0.f.a)object3).poll();
            int n13 = object == null ? n10 : 0;
            if (bl3 && n13 != 0) {
                this.clear((e.a.w0.f.a)object3);
                object3 = this.errors.terminate();
                if (object3 == null) {
                    g02.onComplete();
                    return;
                }
                g02.onError((Throwable)object3);
                return;
            }
            if (n13 != 0) {
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            try {
                object2 = this.combiner;
                object2 = object2.apply(object);
                object = "The combiner returned a null value";
                object2 = e.a.w0.b.a.g(object2, (String)object);
                g02.onNext(object2);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.errors.addThrowable(throwable);
                this.cancelSources();
                this.clear((e.a.w0.f.a)object3);
                object3 = this.errors.terminate();
                g02.onError((Throwable)object3);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void innerComplete(int n10) {
        block11: {
            int n11;
            block10: {
                int n12;
                // MONITORENTER : this
                Object[] objectArray = this.latest;
                if (objectArray == null) {
                    // MONITOREXIT : this
                    return;
                }
                Object object = objectArray[n10];
                n11 = 1;
                if (object == null) {
                    n10 = n11;
                } else {
                    n10 = 0;
                    object = null;
                }
                if (n10 != 0) break block10;
                this.complete = n12 = this.complete + n11;
                int n13 = objectArray.length;
                if (n12 != n13) break block11;
            }
            this.done = n11;
        }
        // MONITOREXIT : this
        if (n10 != 0) {
            this.cancelSources();
        }
        this.drain();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerError(int n10, Throwable objectArray) {
        int n11;
        block10: {
            float f10;
            float f11;
            block12: {
                AtomicThrowable atomicThrowable = this.errors;
                n11 = (int)(atomicThrowable.addThrowable((Throwable)objectArray) ? 1 : 0);
                if (n11 == 0) {
                    a.Y((Throwable)objectArray);
                    return;
                }
                int n12 = this.delayError;
                n11 = 1;
                f11 = Float.MIN_VALUE;
                if (n12 == 0) break block10;
                synchronized (this) {
                    block11: {
                        int n13;
                        objectArray = this.latest;
                        if (objectArray == null) {
                            return;
                        }
                        Object object = objectArray[n10];
                        if (object == null) {
                            n10 = n11;
                            f10 = f11;
                        } else {
                            n10 = 0;
                            f10 = 0.0f;
                            object = null;
                        }
                        if (n10 != 0) break block11;
                        this.complete = n13 = this.complete + n11;
                        n12 = objectArray.length;
                        if (n13 != n12) break block12;
                    }
                    this.done = n11;
                }
            }
            n11 = n10;
            f11 = f10;
        }
        if (n11 != 0) {
            this.cancelSources();
        }
        this.drain();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerNext(int n10, Object object) {
        synchronized (this) {
            Object[] objectArray = this.latest;
            if (objectArray == null) {
                return;
            }
            Object object2 = objectArray[n10];
            int n11 = this.active;
            if (object2 == null) {
                this.active = ++n11;
            }
            objectArray[n10] = object;
            n10 = objectArray.length;
            if (n11 != n10) return;
            e.a.w0.f.a a10 = this.queue;
            object = objectArray.clone();
            a10.offer(object);
            n10 = 1;
        }
        if (n10 == 0) return;
        this.drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(e0[] e0Array) {
        boolean bl2;
        ObservableCombineLatest$CombinerObserver[] observableCombineLatest$CombinerObserverArray = this.observers;
        int n10 = observableCombineLatest$CombinerObserverArray.length;
        this.downstream.onSubscribe(this);
        for (int i10 = 0; i10 < n10 && !(bl2 = this.done) && !(bl2 = this.cancelled); ++i10) {
            e0 e02 = e0Array[i10];
            ObservableCombineLatest$CombinerObserver observableCombineLatest$CombinerObserver = observableCombineLatest$CombinerObserverArray[i10];
            e02.subscribe(observableCombineLatest$CombinerObserver);
        }
    }
}

