/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightEndObserver;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$a;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin$JoinDisposable
extends AtomicInteger
implements b,
ObservableGroupJoin$a {
    public static final Integer LEFT_CLOSE;
    public static final Integer LEFT_VALUE;
    public static final Integer RIGHT_CLOSE;
    public static final Integer RIGHT_VALUE;
    private static final long serialVersionUID = -6071216598687999801L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final e.a.s0.a disposables;
    public final g0 downstream;
    public final AtomicReference error;
    public final o leftEnd;
    public int leftIndex;
    public final Map lefts;
    public final e.a.w0.f.a queue;
    public final c resultSelector;
    public final o rightEnd;
    public int rightIndex;
    public final Map rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    public ObservableJoin$JoinDisposable(g0 serializable, o o10, o o11, c c10) {
        this.downstream = serializable;
        serializable = new Serializable();
        this.disposables = serializable;
        int n10 = z.b0();
        serializable = new Serializable(n10);
        this.queue = serializable;
        this.lefts = serializable = new Serializable();
        this.rights = serializable = new Serializable();
        this.error = serializable;
        this.leftEnd = o10;
        this.rightEnd = o11;
        this.resultSelector = c10;
        super(2);
        this.active = serializable;
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    public void dispose() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            this.cancelAll();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                e.a.w0.f.a a10 = this.queue;
                a10.clear();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        boolean bl2;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        e.a.w0.f.a a10 = this.queue;
        g0 g02 = this.downstream;
        boolean bl3 = bl2 = true;
        block8: while (true) {
            int n11;
            Object object;
            boolean bl4;
            boolean bl5;
            if (bl5 = this.cancelled) {
                a10.clear();
                return;
            }
            Object object2 = (Throwable)this.error.get();
            if (object2 != null) {
                a10.clear();
                this.cancelAll();
                this.errorAll(g02);
                return;
            }
            object2 = this.active;
            bl5 = ((AtomicInteger)object2).get();
            int n12 = 0;
            Object object3 = null;
            if (!bl5) {
                bl5 = bl2;
            } else {
                bl5 = false;
                object2 = null;
            }
            Object object4 = (Integer)a10.poll();
            if (object4 == null) {
                bl4 = bl2;
            } else {
                bl4 = false;
                object = null;
            }
            if (bl5 && bl4) {
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                g02.onComplete();
                return;
            }
            if (bl4) {
                bl3 = -bl3;
                if (bl3 = this.addAndGet((int)(bl3 ? 1 : 0))) continue;
                return;
            }
            object2 = a10.poll();
            object = LEFT_VALUE;
            String string2 = "The resultSelector returned a null value";
            if (object4 == object) {
                n12 = this.leftIndex;
                this.leftIndex = n11 = n12 + 1;
                object4 = this.lefts;
                object = n12;
                object4.put(object, object2);
                try {
                    object4 = this.leftEnd;
                    object4 = object4.apply(object2);
                    object = "The leftEnd returned a null ObservableSource";
                    object4 = e.a.w0.b.a.g(object4, (String)object);
                    object4 = (e0)object4;
                    object = new ObservableGroupJoin$LeftRightEndObserver(this, bl2, n12);
                    this.disposables.b((b)object);
                }
                catch (Throwable throwable) {
                    this.fail(throwable, g02, a10);
                    return;
                }
                object4.subscribe((g0)object);
                object3 = (Throwable)this.error.get();
                if (object3 != null) {
                    a10.clear();
                    this.cancelAll();
                    this.errorAll(g02);
                    return;
                }
                object3 = this.rights.values().iterator();
                while (true) {
                    if ((n11 = (int)(object3.hasNext() ? 1 : 0)) == 0) continue block8;
                    object4 = object3.next();
                    try {
                        object = this.resultSelector;
                        object4 = object.apply(object2, object4);
                        object4 = e.a.w0.b.a.g(object4, string2);
                        g02.onNext(object4);
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable, g02, a10);
                        return;
                    }
                }
            }
            object = RIGHT_VALUE;
            if (object4 == object) {
                n11 = this.rightIndex;
                bl4 = n11 + 1;
                this.rightIndex = bl4;
                object = this.rights;
                Object object5 = n11;
                object.put(object5, object2);
                try {
                    object = this.rightEnd;
                    object = object.apply(object2);
                    object5 = "The rightEnd returned a null ObservableSource";
                    object = e.a.w0.b.a.g(object, (String)object5);
                    object = (e0)object;
                    object5 = new ObservableGroupJoin$LeftRightEndObserver(this, false, n11);
                    this.disposables.b((b)object5);
                }
                catch (Throwable throwable) {
                    this.fail(throwable, g02, a10);
                    return;
                }
                object.subscribe((g0)object5);
                object3 = (Throwable)this.error.get();
                if (object3 != null) {
                    a10.clear();
                    this.cancelAll();
                    this.errorAll(g02);
                    return;
                }
                object3 = this.lefts.values().iterator();
                while (true) {
                    if ((n11 = (int)(object3.hasNext() ? 1 : 0)) == 0) continue block8;
                    object4 = object3.next();
                    try {
                        object = this.resultSelector;
                        object4 = object.apply(object4, object2);
                        object4 = e.a.w0.b.a.g(object4, string2);
                        g02.onNext(object4);
                    }
                    catch (Throwable throwable) {
                        this.fail(throwable, g02, a10);
                        return;
                    }
                }
            }
            object3 = LEFT_CLOSE;
            if (object4 == object3) {
                object2 = (ObservableGroupJoin$LeftRightEndObserver)object2;
                object3 = this.lefts;
                n11 = ((ObservableGroupJoin$LeftRightEndObserver)object2).index;
                object4 = n11;
                object3.remove(object4);
                object3 = this.disposables;
                ((e.a.s0.a)object3).a((b)object2);
                continue;
            }
            object2 = (ObservableGroupJoin$LeftRightEndObserver)object2;
            object3 = this.rights;
            n11 = ((ObservableGroupJoin$LeftRightEndObserver)object2).index;
            object4 = n11;
            object3.remove(object4);
            object3 = this.disposables;
            ((e.a.s0.a)object3).a((b)object2);
        }
    }

    public void errorAll(g0 g02) {
        Throwable throwable = ExceptionHelper.c(this.error);
        this.lefts.clear();
        this.rights.clear();
        g02.onError(throwable);
    }

    public void fail(Throwable throwable, g0 g02, e.a.w0.f.a a10) {
        e.a.t0.a.b(throwable);
        ExceptionHelper.a(this.error, throwable);
        a10.clear();
        this.cancelAll();
        this.errorAll(g02);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerClose(boolean bl2, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver) {
        synchronized (this) {
            e.a.w0.f.a a10 = this.queue;
            Integer n10 = bl2 ? LEFT_CLOSE : RIGHT_CLOSE;
            a10.offer(n10, observableGroupJoin$LeftRightEndObserver);
        }
        this.drain();
    }

    public void innerCloseError(Throwable throwable) {
        AtomicReference atomicReference = this.error;
        boolean bl2 = ExceptionHelper.a(atomicReference, throwable);
        if (bl2) {
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver) {
        this.disposables.c(observableGroupJoin$LeftRightObserver);
        this.active.decrementAndGet();
        this.drain();
    }

    public void innerError(Throwable serializable) {
        AtomicReference atomicReference = this.error;
        boolean bl2 = ExceptionHelper.a(atomicReference, (Throwable)serializable);
        if (bl2) {
            serializable = this.active;
            ((AtomicInteger)serializable).decrementAndGet();
            this.drain();
        } else {
            a.Y((Throwable)serializable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerValue(boolean bl2, Object object) {
        synchronized (this) {
            e.a.w0.f.a a10 = this.queue;
            Integer n10 = bl2 ? LEFT_VALUE : RIGHT_VALUE;
            a10.offer(n10, object);
        }
        this.drain();
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}

