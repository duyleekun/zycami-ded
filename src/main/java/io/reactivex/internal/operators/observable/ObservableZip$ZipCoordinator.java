/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.operators.observable.ObservableZip$a;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableZip$ZipCoordinator
extends AtomicInteger
implements b {
    private static final long serialVersionUID = 2983708048395377667L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public final g0 downstream;
    public final ObservableZip$a[] observers;
    public final Object[] row;
    public final o zipper;

    public ObservableZip$ZipCoordinator(g0 objectArray, o o10, int n10, boolean bl2) {
        this.downstream = objectArray;
        this.zipper = o10;
        objectArray = new ObservableZip$a[n10];
        this.observers = objectArray;
        objectArray = new Object[n10];
        this.row = objectArray;
        this.delayError = bl2;
    }

    public void cancel() {
        this.clear();
        this.cancelSources();
    }

    public void cancelSources() {
        for (ObservableZip$a observableZip$a : this.observers) {
            observableZip$a.a();
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, g0 g02, boolean bl4, ObservableZip$a observableZip$a) {
        boolean bl5 = this.cancelled;
        boolean bl6 = true;
        if (bl5) {
            this.cancel();
            return bl6;
        }
        if (bl2) {
            if (bl4) {
                if (bl3) {
                    Throwable throwable = observableZip$a.d;
                    this.cancelled = bl6;
                    this.cancel();
                    if (throwable != null) {
                        g02.onError(throwable);
                    } else {
                        g02.onComplete();
                    }
                    return bl6;
                }
            } else {
                Throwable throwable = observableZip$a.d;
                if (throwable != null) {
                    this.cancelled = bl6;
                    this.cancel();
                    g02.onError(throwable);
                    return bl6;
                }
                if (bl3) {
                    this.cancelled = bl6;
                    this.cancel();
                    g02.onComplete();
                    return bl6;
                }
            }
        }
        return false;
    }

    public void clear() {
        ObservableZip$a[] observableZip$aArray = this.observers;
        int n10 = observableZip$aArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            e.a.w0.f.a a10 = observableZip$aArray[i10].b;
            a10.clear();
        }
    }

    public void dispose() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            this.cancelSources();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                this.clear();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        ObservableZip$ZipCoordinator observableZip$ZipCoordinator = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        ObservableZip$a[] observableZip$aArray = this.observers;
        g0 g02 = this.downstream;
        Object[] objectArray = this.row;
        boolean bl2 = this.delayError;
        boolean bl3 = true;
        float f10 = Float.MIN_VALUE;
        boolean bl4 = bl3;
        while (true) {
            int n11;
            Object object;
            int n12 = observableZip$aArray.length;
            int n13 = 0;
            int n14 = 0;
            for (int i10 = 0; i10 < n12; ++n14, ++i10) {
                ObservableZip$a observableZip$a = observableZip$aArray[i10];
                object = objectArray[n14];
                if (object == null) {
                    boolean bl5 = observableZip$a.c;
                    object = observableZip$a.b;
                    Object object2 = ((e.a.w0.f.a)object).poll();
                    boolean bl6 = object2 == null ? bl3 : false;
                    object = this;
                    n11 = (int)(this.checkTerminated(bl5, bl6, g02, bl2, observableZip$a) ? 1 : 0);
                    if (n11 != 0) {
                        return;
                    }
                    if (!bl6) {
                        objectArray[n14] = object2;
                        continue;
                    }
                    ++n13;
                    continue;
                }
                n11 = (int)(observableZip$a.c ? 1 : 0);
                if (n11 == 0 || bl2 || (object = observableZip$a.d) == null) continue;
                observableZip$ZipCoordinator.cancelled = bl3;
                this.cancel();
                g02.onError((Throwable)object);
                return;
            }
            if (n13 != 0) {
                n11 = -bl4;
                if (bl4 = observableZip$ZipCoordinator.addAndGet(n11)) continue;
                return;
            }
            try {
                object = observableZip$ZipCoordinator.zipper;
                Object object3 = objectArray.clone();
                object = object.apply(object3);
                object3 = "The zipper returned a null value";
                object = a.g(object, (String)object3);
                g02.onNext(object);
                n11 = 0;
                object = null;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                g02.onError(throwable);
                return;
            }
            Arrays.fill(objectArray, null);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void subscribe(e0[] e0Array, int n10) {
        ObservableZip$a[] observableZip$aArray = this.observers;
        int n11 = observableZip$aArray.length;
        int n12 = 0;
        ObservableZip$a observableZip$a = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            ObservableZip$a observableZip$a2;
            observableZip$aArray[i10] = observableZip$a2 = new ObservableZip$a(this, n10);
        }
        this.lazySet(0);
        Object object = this.downstream;
        object.onSubscribe(this);
        while (n12 < n11) {
            n10 = (int)(this.cancelled ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            object = e0Array[n12];
            observableZip$a = observableZip$aArray[n12];
            object.subscribe(observableZip$a);
            ++n12;
        }
    }
}

