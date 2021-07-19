/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap$SwitchMapObserver
extends AtomicInteger
implements g0,
b {
    public static final ObservableSwitchMap$SwitchMapInnerObserver CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    public final AtomicReference active;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public final o mapper;
    public volatile long unique;
    public b upstream;

    static {
        ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver;
        CANCELLED = observableSwitchMap$SwitchMapInnerObserver = new ObservableSwitchMap$SwitchMapInnerObserver(null, -1, 1);
        observableSwitchMap$SwitchMapInnerObserver.cancel();
    }

    public ObservableSwitchMap$SwitchMapObserver(g0 object, o o10, int n10, boolean bl2) {
        AtomicReference atomicReference;
        this.active = atomicReference = new AtomicReference();
        this.downstream = object;
        this.mapper = o10;
        this.bufferSize = n10;
        this.delayErrors = bl2;
        this.errors = object = new AtomicThrowable();
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            b b10 = this.upstream;
            b10.dispose();
            this.disposeInner();
        }
    }

    public void disposeInner() {
        ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver;
        ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver2 = (ObservableSwitchMap$SwitchMapInnerObserver)this.active.get();
        if (observableSwitchMap$SwitchMapInnerObserver2 != (observableSwitchMap$SwitchMapInnerObserver = CANCELLED) && (observableSwitchMap$SwitchMapInnerObserver2 = this.active.getAndSet(observableSwitchMap$SwitchMapInnerObserver)) != observableSwitchMap$SwitchMapInnerObserver && observableSwitchMap$SwitchMapInnerObserver2 != null) {
            observableSwitchMap$SwitchMapInnerObserver2.cancel();
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
        g0 g02 = this.downstream;
        Serializable serializable = this.active;
        boolean bl2 = this.delayErrors;
        int n12 = n10 = 1;
        block2: while (true) {
            block29: {
                ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver;
                Object object;
                int n13;
                if ((n13 = this.cancelled) != 0) {
                    return;
                }
                n13 = this.done;
                if (n13 != 0) {
                    Object v10 = ((AtomicReference)serializable).get();
                    if (v10 == null) {
                        n13 = n10;
                    } else {
                        n13 = 0;
                        Object var8_10 = null;
                    }
                    if (bl2) {
                        if (n13 != 0) {
                            serializable = (Throwable)this.errors.get();
                            if (serializable != null) {
                                g02.onError((Throwable)serializable);
                                return;
                            }
                            g02.onComplete();
                            return;
                        }
                    } else {
                        object = (Throwable)this.errors.get();
                        if (object != null) {
                            serializable = this.errors.terminate();
                            g02.onError((Throwable)serializable);
                            return;
                        }
                        if (n13 != 0) {
                            g02.onComplete();
                            return;
                        }
                    }
                }
                if ((observableSwitchMap$SwitchMapInnerObserver = (ObservableSwitchMap$SwitchMapInnerObserver)((AtomicReference)serializable).get()) == null || (object = observableSwitchMap$SwitchMapInnerObserver.queue) == null) break block29;
                int n14 = observableSwitchMap$SwitchMapInnerObserver.done;
                if (n14 != 0) {
                    n14 = object.isEmpty();
                    if (bl2) {
                        if (n14 != 0) {
                            ((AtomicReference)serializable).compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                            continue;
                        }
                    } else {
                        Throwable throwable = (Throwable)this.errors.get();
                        if (throwable != null) {
                            serializable = this.errors.terminate();
                            g02.onError((Throwable)serializable);
                            return;
                        }
                        if (n14 != 0) {
                            ((AtomicReference)serializable).compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                            continue;
                        }
                    }
                }
                n14 = 0;
                b b10 = null;
                while (true) {
                    Object object2;
                    block33: {
                        block32: {
                            int n15;
                            block31: {
                                block30: {
                                    Throwable throwable;
                                    boolean bl3;
                                    if (bl3 = this.cancelled) {
                                        return;
                                    }
                                    Object v11 = ((AtomicReference)serializable).get();
                                    if (observableSwitchMap$SwitchMapInnerObserver != v11) break block30;
                                    if (!bl2 && (throwable = (Throwable)this.errors.get()) != null) {
                                        serializable = this.errors.terminate();
                                        g02.onError((Throwable)serializable);
                                        return;
                                    }
                                    bl3 = observableSwitchMap$SwitchMapInnerObserver.done;
                                    try {
                                        object2 = object.poll();
                                    }
                                    catch (Throwable throwable2) {
                                        e.a.t0.a.b(throwable2);
                                        object2 = this.errors;
                                        ((AtomicThrowable)object2).addThrowable(throwable2);
                                        ((AtomicReference)serializable).compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                                        if (!bl2) {
                                            this.disposeInner();
                                            b10 = this.upstream;
                                            b10.dispose();
                                            this.done = n10;
                                        } else {
                                            observableSwitchMap$SwitchMapInnerObserver.cancel();
                                        }
                                        n14 = n10;
                                        object2 = null;
                                    }
                                    n15 = object2 == null ? n10 : 0;
                                    if (!bl3 || n15 == 0) break block31;
                                    ((AtomicReference)serializable).compareAndSet(observableSwitchMap$SwitchMapInnerObserver, null);
                                }
                                n14 = n10;
                                break block32;
                            }
                            if (n15 == 0) break block33;
                        }
                        if (n14 == 0) break;
                        continue block2;
                    }
                    g02.onNext(object2);
                }
            }
            n12 = -n12;
            if ((n12 = this.addAndGet(n12)) == 0) break;
        }
    }

    public void innerError(ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver, Throwable object) {
        AtomicThrowable atomicThrowable;
        long l10 = observableSwitchMap$SwitchMapInnerObserver.index;
        long l11 = this.unique;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false && (object2 = (Object)(atomicThrowable = this.errors).addThrowable((Throwable)object)) != false) {
            boolean bl2 = this.delayErrors;
            object2 = 1;
            if (!bl2) {
                object = this.upstream;
                object.dispose();
                this.done = object2;
            }
            observableSwitchMap$SwitchMapInnerObserver.done = object2;
            this.drain();
        } else {
            a.Y((Throwable)object);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            this.drain();
        }
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable;
        boolean bl2 = this.done;
        if (!bl2 && (bl2 = (atomicThrowable = this.errors).addThrowable(throwable))) {
            boolean bl3 = this.delayErrors;
            if (!bl3) {
                this.disposeInner();
            }
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        AtomicReference atomicReference;
        ObservableSwitchMap$SwitchMapInnerObserver observableSwitchMap$SwitchMapInnerObserver;
        long l10 = this.unique;
        long l11 = 1L;
        this.unique = l10 += l11;
        Object object2 = (ObservableSwitchMap$SwitchMapInnerObserver)this.active.get();
        if (object2 != null) {
            ((ObservableSwitchMap$SwitchMapInnerObserver)object2).cancel();
        }
        object2 = this.mapper;
        object = object2.apply(object);
        object2 = "The ObservableSource returned is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (e0)object;
            int n10 = this.bufferSize;
            object2 = new ObservableSwitchMap$SwitchMapInnerObserver(this, l10, n10);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        while ((observableSwitchMap$SwitchMapInnerObserver = (ObservableSwitchMap$SwitchMapInnerObserver)this.active.get()) != (atomicReference = CANCELLED)) {
            atomicReference = this.active;
            boolean bl2 = atomicReference.compareAndSet(observableSwitchMap$SwitchMapInnerObserver, object2);
            if (!bl2) continue;
            object.subscribe((g0)object2);
            break;
        }
        return;
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

