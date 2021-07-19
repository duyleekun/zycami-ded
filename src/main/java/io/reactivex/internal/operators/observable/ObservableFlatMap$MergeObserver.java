/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.o;
import e.a.w0.c.n;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap$MergeObserver
extends AtomicInteger
implements b,
g0 {
    public static final ObservableFlatMap$InnerObserver[] CANCELLED;
    public static final ObservableFlatMap$InnerObserver[] EMPTY;
    private static final long serialVersionUID = -2117620485640801370L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public long lastId;
    public int lastIndex;
    public final o mapper;
    public final int maxConcurrency;
    public final AtomicReference observers;
    public volatile n queue;
    public Queue sources;
    public long uniqueId;
    public b upstream;
    public int wip;

    static {
        EMPTY = new ObservableFlatMap$InnerObserver[0];
        CANCELLED = new ObservableFlatMap$InnerObserver[0];
    }

    public ObservableFlatMap$MergeObserver(g0 arrayDeque, o observableFlatMap$InnerObserverArray, boolean bl2, int n10, int n11) {
        AtomicThrowable atomicThrowable;
        this.errors = atomicThrowable = new AtomicThrowable();
        this.downstream = arrayDeque;
        this.mapper = observableFlatMap$InnerObserverArray;
        this.delayErrors = bl2;
        this.maxConcurrency = n10;
        this.bufferSize = n11;
        int n12 = -1 >>> 1;
        if (n10 != n12) {
            this.sources = arrayDeque = new ArrayDeque(n10);
        }
        observableFlatMap$InnerObserverArray = EMPTY;
        super((ObservableFlatMap$InnerObserver[])observableFlatMap$InnerObserverArray);
        this.observers = arrayDeque;
    }

    public boolean addInner(ObservableFlatMap$InnerObserver observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray;
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray2;
        Object object;
        boolean bl2;
        do {
            if ((observableFlatMap$InnerObserverArray2 = (ObservableFlatMap$InnerObserver[])this.observers.get()) == (object = CANCELLED)) {
                observableFlatMap$InnerObserver.dispose();
                return false;
            }
            int n10 = observableFlatMap$InnerObserverArray2.length;
            int n11 = n10 + 1;
            observableFlatMap$InnerObserverArray = new ObservableFlatMap$InnerObserver[n11];
            System.arraycopy(observableFlatMap$InnerObserverArray2, 0, observableFlatMap$InnerObserverArray, 0, n10);
            observableFlatMap$InnerObserverArray[n10] = observableFlatMap$InnerObserver;
        } while (!(bl2 = ((AtomicReference)(object = this.observers)).compareAndSet(observableFlatMap$InnerObserverArray2, observableFlatMap$InnerObserverArray)));
        return true;
    }

    public boolean checkTerminate() {
        boolean bl2 = this.cancelled;
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        Throwable throwable = (Throwable)this.errors.get();
        boolean bl4 = this.delayErrors;
        if (!bl4 && throwable != null) {
            this.disposeAll();
            throwable = this.errors.terminate();
            Object object = ExceptionHelper.a;
            if (throwable != object) {
                object = this.downstream;
                object.onError(throwable);
            }
            return bl3;
        }
        return false;
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            Throwable throwable;
            Throwable throwable2;
            this.cancelled = true;
            bl2 = this.disposeAll();
            if (bl2 && (throwable2 = this.errors.terminate()) != null && throwable2 != (throwable = ExceptionHelper.a)) {
                e.a.a1.a.Y(throwable2);
            }
        }
    }

    public boolean disposeAll() {
        this.upstream.dispose();
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray = (ObservableFlatMap$InnerObserver[])this.observers.get();
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray2 = CANCELLED;
        if (observableFlatMap$InnerObserverArray != observableFlatMap$InnerObserverArray2 && (observableFlatMap$InnerObserverArray = this.observers.getAndSet(observableFlatMap$InnerObserverArray2)) != observableFlatMap$InnerObserverArray2) {
            for (ObservableFlatMap$InnerObserver observableFlatMap$InnerObserver : observableFlatMap$InnerObserverArray) {
                observableFlatMap$InnerObserver.dispose();
            }
            return true;
        }
        return false;
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drainLoop() {
        var1_1 = this.downstream;
        var3_3 = var2_2 = 1;
        block8: while (true) {
            block38: {
                block37: {
                    if ((var4_4 = this.checkTerminate()) != 0) {
                        return;
                    }
                    var5_5 = this.queue;
                    if (var5_5 != null) {
                        while (true) {
                            if ((var6_6 = this.checkTerminate()) != 0) {
                                return;
                            }
                            var7_7 = var5_5.poll();
                            if (var7_7 == null) break;
                            var1_1.onNext(var7_7);
                        }
                    }
                    var4_4 = this.done;
                    var7_7 = this.queue;
                    var8_8 = (ObservableFlatMap$InnerObserver[])this.observers.get();
                    var9_9 = var8_8.length;
                    var10_10 = this.maxConcurrency;
                    var11_11 = -1 >>> 1;
                    var12_12 = 0;
                    if (var10_10 != var11_11) {
                        synchronized (this) {
                            var13_13 = this.sources;
                            var10_10 = var13_13.size();
                        }
                    } else {
                        var10_10 = 0;
                        var13_13 = null;
                    }
                    if (var4_4 != 0 && (var7_7 == null || (var4_4 = var7_7.isEmpty()) != 0) && var9_9 == 0 && var10_10 == 0) {
                        var14_25 = this.errors.terminate();
                        if (var14_25 == (var15_26 = ExceptionHelper.a)) return;
                        if (var14_25 == null) {
                            var1_1.onComplete();
                            return;
                        }
                        var1_1.onError(var14_25);
                        return;
                    }
                    if (var9_9 == 0) ** GOTO lbl83
                    var16_14 = this.lastId;
                    var10_10 = this.lastIndex;
                    if (var9_9 <= var10_10) break block37;
                    var18_15 = var8_8[var10_10];
                    var19_16 = var18_15.id;
                    cfr_temp_0 = var19_16 - var16_14;
                    var21_17 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var21_17 == 0) break block38;
                }
                if (var9_9 <= var10_10) {
                    var10_10 = 0;
                    var13_13 = null;
                }
                var18_15 = null;
                for (var21_17 = 0; var21_17 < var9_9; ++var21_17) {
                    var22_18 = var8_8[var10_10];
                    var23_20 = var22_18.id;
                    cfr_temp_1 = var23_20 - var16_14;
                    var25_21 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                    if (var25_21 /* !! */  == false) break;
                    if (++var10_10 != var9_9) continue;
                    var10_10 = 0;
                    var13_13 = null;
                }
                this.lastIndex = var10_10;
                var5_5 = var8_8[var10_10];
                this.lastId = var16_14 = var5_5.id;
            }
            var4_4 = 0;
            var5_5 = null;
            var6_6 = 0;
            var7_7 = null;
            while (true) {
                block35: {
                    block36: {
                        block40: {
                            block41: {
                                block39: {
                                    if (var4_4 >= var9_9) break block39;
                                    var21_17 = (int)this.checkTerminate();
                                    if (var21_17 != 0) {
                                        return;
                                    }
                                    var18_15 = var8_8[var10_10];
                                    var22_18 = var18_15.queue;
                                    if (var22_18 == null) break block40;
                                    break block41;
                                }
                                this.lastIndex = var10_10;
                                var5_5 = var8_8[var10_10];
                                this.lastId = var28_24 = var5_5.id;
                                var12_12 = var6_6;
lbl83:
                                // 2 sources

                                if (var12_12 != 0) {
                                    var4_4 = this.maxConcurrency;
                                    if (var4_4 == var11_11) continue block8;
                                    break;
                                }
                                var3_3 = -var3_3;
                                if ((var3_3 = this.addAndGet(var3_3)) != 0) continue block8;
                                return;
                            }
                            try {
                                while ((var26_22 = var22_18.poll()) != null) {
                                    var1_1.onNext(var26_22);
                                    var27_23 = this.checkTerminate();
                                    if (!var27_23) continue;
                                    return;
                                }
                            }
                            catch (Throwable var22_19) {
                                a.b(var22_19);
                                var18_15.dispose();
                                var26_22 = this.errors;
                                var26_22.addThrowable(var22_19);
                                var25_21 /* !! */  = (long)this.checkTerminate();
                                if (var25_21 /* !! */  != false) {
                                    return;
                                }
                                this.removeInner(var18_15);
                                ++var6_6;
                                if (++var10_10 != var9_9) break block35;
                                break block36;
                            }
                        }
                        var25_21 /* !! */  = (long)var18_15.done;
                        var26_22 = var18_15.queue;
                        if (var25_21 /* !! */  != false && (var26_22 == null || (var25_21 /* !! */  = (long)var26_22.isEmpty()) != false)) {
                            this.removeInner(var18_15);
                            var21_17 = (int)this.checkTerminate();
                            if (var21_17 != 0) {
                                return;
                            }
                            ++var6_6;
                        }
                        if (++var10_10 != var9_9) break block35;
                    }
                    var10_10 = 0;
                    var13_13 = null;
                }
                ++var4_4;
            }
            while (true) {
                var4_4 = var12_12 + -1;
                if (var12_12 != 0) ** break;
                continue block8;
                synchronized (this) {
                    var7_7 = this.sources;
                    var7_7 = var7_7.poll();
                    var7_7 = (e0)var7_7;
                    if (var7_7 == null) {
                        this.wip = var6_6 = this.wip - var2_2;
                    } else {
                        // MONITOREXIT @DISABLED, blocks:[6, 8, 13, 14] lbl133 : MonitorExitStatement: MONITOREXIT : this
                        this.subscribeInner((e0)var7_7);
                    }
                }
                var12_12 = var4_4;
            }
            break;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        AtomicThrowable atomicThrowable = this.errors;
        bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        block6: {
            int n10;
            Object object2;
            int n11 = this.done;
            if (n11 != 0) {
                return;
            }
            try {
                object2 = this.mapper;
                object = object2.apply(object);
                object2 = "The mapper returned a null ObservableSource";
                object = e.a.w0.b.a.g(object, (String)object2);
                object = (e0)object;
                n11 = this.maxConcurrency;
                n10 = -1 >>> 1;
                if (n11 == n10) break block6;
            }
            catch (Throwable throwable) {
                a.b(throwable);
                this.upstream.dispose();
                this.onError(throwable);
                return;
            }
            synchronized (this) {
                n11 = this.wip;
                n10 = this.maxConcurrency;
                if (n11 == n10) {
                    object2 = this.sources;
                    object2.offer(object);
                    return;
                }
                this.wip = ++n11;
            }
        }
        this.subscribeInner((e0)object);
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

    public void removeInner(ObservableFlatMap$InnerObserver observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray;
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArray3;
            int n10;
            int n11;
            if ((n11 = (observableFlatMap$InnerObserverArray2 = (ObservableFlatMap$InnerObserver[])this.observers.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                observableFlatMap$InnerObserverArray3 = observableFlatMap$InnerObserverArray2[n10];
                if (observableFlatMap$InnerObserverArray3 != observableFlatMap$InnerObserver) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                observableFlatMap$InnerObserverArray = EMPTY;
                continue;
            }
            int n14 = n11 + -1;
            observableFlatMap$InnerObserverArray3 = new ObservableFlatMap$InnerObserver[n14];
            System.arraycopy(observableFlatMap$InnerObserverArray2, 0, observableFlatMap$InnerObserverArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(observableFlatMap$InnerObserverArray2, n13, observableFlatMap$InnerObserverArray3, n12, n11);
            observableFlatMap$InnerObserverArray = observableFlatMap$InnerObserverArray3;
        } while (!(bl2 = (atomicReference = this.observers).compareAndSet(observableFlatMap$InnerObserverArray2, observableFlatMap$InnerObserverArray)));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void subscribeInner(e0 object) {
        while (true) {
            int n10;
            Object object2;
            int n11;
            if ((n11 = object instanceof Callable) == 0) {
                long l10;
                long l11 = this.uniqueId;
                this.uniqueId = l10 = 1L + l11;
                object2 = new ObservableFlatMap$InnerObserver(this, l11);
                n10 = (int)(this.addInner((ObservableFlatMap$InnerObserver)object2) ? 1 : 0);
                if (n10 == 0) return;
                object.subscribe((g0)object2);
                return;
            }
            int n12 = this.tryEmitScalar((Callable)(object = (Callable)object));
            if (n12 == 0) return;
            n12 = this.maxConcurrency;
            n11 = -1 >>> 1;
            if (n12 == n11) return;
            n12 = 0;
            object = null;
            // MONITORENTER : this
            object2 = this.sources;
            object2 = object2.poll();
            object2 = (e0)object2;
            n10 = 1;
            if (object2 == null) {
                this.wip = n12 = this.wip - n10;
                n12 = n10;
            }
            // MONITOREXIT : this
            if (n12 != 0) {
                this.drain();
                return;
            }
            object = object2;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void tryEmit(Object var1_1, ObservableFlatMap$InnerObserver var2_2) {
        var3_3 = this.get();
        if (var3_3 != 0) ** GOTO lbl-1000
        var4_4 = null;
        var5_5 = 1;
        var3_3 = (int)this.compareAndSet(0, var5_5);
        if (var3_3 != 0) {
            var2_2 = this.downstream;
            var2_2.onNext(var1_1);
            var6_6 = this.decrementAndGet();
            if (var6_6 == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            if ((var4_4 = var2_2.queue) == null) {
                var5_5 = this.bufferSize;
                var2_2.queue = var4_4 = new e.a.w0.f.a(var5_5);
            }
            var4_4.offer(var1_1);
            var6_7 = this.getAndIncrement();
            if (var6_7 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public boolean tryEmitScalar(Callable object) {
        boolean bl2;
        block10: {
            bl2 = true;
            try {
                object = object.call();
                if (object != null) break block10;
                return bl2;
            }
            catch (Throwable throwable) {
                a.b(throwable);
                this.errors.addThrowable(throwable);
                this.drain();
                return bl2;
            }
        }
        int n10 = this.get();
        if (n10 == 0 && (n10 = (int)(this.compareAndSet(0, (int)(bl2 ? 1 : 0)) ? 1 : 0)) != 0) {
            g0 g02 = this.downstream;
            g02.onNext(object);
            int n11 = this.decrementAndGet();
            if (n11 == 0) {
                return bl2;
            }
        } else {
            int n12;
            n n13 = this.queue;
            if (n13 == null) {
                n10 = this.maxConcurrency;
                int n14 = -1 >>> 1;
                if (n10 == n14) {
                    n14 = this.bufferSize;
                    n13 = new e.a.w0.f.a(n14);
                } else {
                    n14 = this.maxConcurrency;
                    n13 = new SpscArrayQueue(n14);
                }
                this.queue = n13;
            }
            if ((n12 = n13.offer(object)) == 0) {
                object = new IllegalStateException("Scalar queue full?!");
                this.onError((Throwable)object);
                return bl2;
            }
            n12 = this.getAndIncrement();
            if (n12 != 0) {
                return false;
            }
        }
        this.drainLoop();
        return bl2;
    }
}

