/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.c.j;
import e.a.w0.c.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableObserveOn$ObserveOnObserver
extends BasicIntQueueDisposable
implements g0,
Runnable {
    private static final long serialVersionUID = 6576896619930983584L;
    public final int bufferSize;
    public final boolean delayError;
    public volatile boolean disposed;
    public volatile boolean done;
    public final g0 downstream;
    public Throwable error;
    public boolean outputFused;
    public o queue;
    public int sourceMode;
    public b upstream;
    public final h0$c worker;

    public ObservableObserveOn$ObserveOnObserver(g0 g02, h0$c h0$c, boolean bl2, int n10) {
        this.downstream = g02;
        this.worker = h0$c;
        this.delayError = bl2;
        this.bufferSize = n10;
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, g0 g02) {
        boolean bl4 = this.disposed;
        boolean bl5 = true;
        if (bl4) {
            this.queue.clear();
            return bl5;
        }
        if (bl2) {
            Throwable throwable = this.error;
            bl4 = this.delayError;
            if (bl4) {
                if (bl3) {
                    this.disposed = bl5;
                    if (throwable != null) {
                        g02.onError(throwable);
                    } else {
                        g02.onComplete();
                    }
                    this.worker.dispose();
                    return bl5;
                }
            } else {
                if (throwable != null) {
                    this.disposed = bl5;
                    this.queue.clear();
                    g02.onError(throwable);
                    this.worker.dispose();
                    return bl5;
                }
                if (bl3) {
                    this.disposed = bl5;
                    g02.onComplete();
                    this.worker.dispose();
                    return bl5;
                }
            }
        }
        return false;
    }

    public void clear() {
        this.queue.clear();
    }

    public void dispose() {
        int n10 = this.disposed;
        if (n10 == 0) {
            this.disposed = true;
            this.upstream.dispose();
            Object object = this.worker;
            object.dispose();
            n10 = this.outputFused;
            if (n10 == 0 && (n10 = this.getAndIncrement()) == 0) {
                object = this.queue;
                object.clear();
            }
        }
    }

    public void drainFused() {
        int n10;
        int n11 = n10 = 1;
        do {
            boolean bl2;
            if (bl2 = this.disposed) {
                return;
            }
            bl2 = this.done;
            Object object = this.error;
            boolean bl3 = this.delayError;
            if (!bl3 && bl2 && object != null) {
                this.disposed = n10;
                g0 g02 = this.downstream;
                Throwable throwable = this.error;
                g02.onError(throwable);
                this.worker.dispose();
                return;
            }
            object = this.downstream;
            bl3 = false;
            object.onNext(null);
            if (bl2) {
                this.disposed = n10;
                Object object2 = this.error;
                if (object2 != null) {
                    g0 g03 = this.downstream;
                    g03.onError((Throwable)object2);
                } else {
                    object2 = this.downstream;
                    object2.onComplete();
                }
                this.worker.dispose();
                return;
            }
            n11 = -n11;
        } while ((n11 = this.addAndGet(n11)) != 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drainNormal() {
        int n10;
        o o10 = this.queue;
        g0 g02 = this.downstream;
        int n11 = n10 = 1;
        block2: while (true) {
            boolean bl2 = this.done;
            boolean bl3 = o10.isEmpty();
            if (bl2 = this.checkTerminated(bl2, bl3, g02)) {
                return;
            }
            while (true) {
                Object object;
                block6: {
                    bl2 = this.done;
                    try {
                        object = o10.poll();
                        int n12 = object == null ? n10 : 0;
                        bl2 = this.checkTerminated(bl2, n12 != 0, g02);
                        if (bl2) {
                            return;
                        }
                        if (n12 == 0) break block6;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        this.disposed = n10;
                        this.upstream.dispose();
                        o10.clear();
                        g02.onError(throwable);
                        this.worker.dispose();
                        return;
                    }
                    n11 = -n11;
                    if ((n11 = this.addAndGet(n11)) != 0) continue block2;
                    return;
                }
                g02.onNext(object);
            }
            break;
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.schedule();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.schedule();
    }

    public void onNext(Object object) {
        int n10 = this.done;
        if (n10 != 0) {
            return;
        }
        n10 = this.sourceMode;
        int n11 = 2;
        if (n10 != n11) {
            o o10 = this.queue;
            o10.offer(object);
        }
        this.schedule();
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        int n10 = DisposableHelper.validate(b10, (b)object);
        if (n10 != 0) {
            this.upstream = object;
            n10 = object instanceof j;
            if (n10 != 0) {
                int n11;
                n10 = (object = (j)object).requestFusion(7);
                if (n10 == (n11 = 1)) {
                    this.sourceMode = n10;
                    this.queue = object;
                    this.done = n11;
                    this.downstream.onSubscribe(this);
                    this.schedule();
                    return;
                }
                n11 = 2;
                if (n10 == n11) {
                    this.sourceMode = n10;
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            n10 = this.bufferSize;
            this.queue = object = new e.a.w0.f.a(n10);
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public Object poll() {
        return this.queue.poll();
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }

    public void run() {
        boolean bl2 = this.outputFused;
        if (bl2) {
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    public void schedule() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            h0$c h0$c = this.worker;
            h0$c.b(this);
        }
    }
}

