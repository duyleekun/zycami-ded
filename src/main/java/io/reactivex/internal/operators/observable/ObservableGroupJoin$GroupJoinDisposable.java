/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.c;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightEndObserver;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$a;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin$GroupJoinDisposable
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

    public ObservableGroupJoin$GroupJoinDisposable(g0 serializable, o o10, o o11, c c10) {
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
        if (n10 != 0) {
            return;
        }
        this.cancelled = true;
        this.cancelAll();
        n10 = this.getAndIncrement();
        if (n10 == 0) {
            e.a.w0.f.a a10 = this.queue;
            a10.clear();
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
        Object object = this.queue;
        g0 g02 = this.downstream;
        boolean bl3 = bl2 = true;
        block6: while (true) {
            Object object2;
            int n11;
            Object object3;
            boolean bl4;
            boolean bl5;
            if (bl5 = this.cancelled) {
                ((e.a.w0.f.a)object).clear();
                return;
            }
            Object object4 = (Throwable)this.error.get();
            if (object4 != null) {
                ((e.a.w0.f.a)object).clear();
                this.cancelAll();
                this.errorAll(g02);
                return;
            }
            object4 = this.active;
            bl5 = ((AtomicInteger)object4).get();
            Object object5 = null;
            if (!bl5) {
                bl5 = bl2;
            } else {
                bl5 = false;
                object4 = null;
            }
            Object object6 = (Integer)((e.a.w0.f.a)object).poll();
            if (object6 == null) {
                bl4 = bl2;
            } else {
                bl4 = false;
                object3 = null;
            }
            if (bl5 && bl4) {
                object = this.lefts.values().iterator();
                while (true) {
                    if (!(bl2 = (boolean)object.hasNext())) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        g02.onComplete();
                        return;
                    }
                    UnicastSubject unicastSubject = (UnicastSubject)object.next();
                    unicastSubject.onComplete();
                }
            }
            if (bl4) {
                bl3 = -bl3;
                if (bl3 = this.addAndGet((int)(bl3 ? 1 : 0))) continue;
                return;
            }
            object4 = ((e.a.w0.f.a)object).poll();
            object3 = LEFT_VALUE;
            if (object6 == object3) {
                object5 = UnicastSubject.m8();
                n11 = this.leftIndex;
                bl4 = n11 + 1;
                this.leftIndex = bl4;
                object3 = this.lefts;
                object2 = n11;
                object3.put(object2, object5);
                try {
                    object3 = this.leftEnd;
                    object3 = object3.apply(object4);
                    object2 = "The leftEnd returned a null ObservableSource";
                    object3 = e.a.w0.b.a.g(object3, (String)object2);
                    object3 = (e0)object3;
                    object2 = new ObservableGroupJoin$LeftRightEndObserver(this, bl2, n11);
                    this.disposables.b((b)object2);
                }
                catch (Throwable throwable) {
                    this.fail(throwable, g02, (e.a.w0.f.a)object);
                    return;
                }
                object3.subscribe((g0)object2);
                object6 = (Throwable)this.error.get();
                if (object6 != null) {
                    ((e.a.w0.f.a)object).clear();
                    this.cancelAll();
                    this.errorAll(g02);
                    return;
                }
                try {
                    object6 = this.resultSelector;
                    object4 = object6.apply(object4, object5);
                    object6 = "The resultSelector returned a null value";
                    object4 = e.a.w0.b.a.g(object4, (String)object6);
                    g02.onNext(object4);
                    object4 = this.rights.values().iterator();
                }
                catch (Throwable throwable) {
                    this.fail(throwable, g02, (e.a.w0.f.a)object);
                    return;
                }
                while (true) {
                    if ((n11 = (int)(object4.hasNext() ? 1 : 0)) == 0) continue block6;
                    object6 = object4.next();
                    ((UnicastSubject)object5).onNext(object6);
                }
            }
            object3 = RIGHT_VALUE;
            if (object6 == object3) {
                n11 = this.rightIndex;
                bl4 = n11 + 1;
                this.rightIndex = bl4;
                object3 = this.rights;
                object2 = n11;
                object3.put(object2, object4);
                try {
                    object3 = this.rightEnd;
                    object3 = object3.apply(object4);
                    object2 = "The rightEnd returned a null ObservableSource";
                    object3 = e.a.w0.b.a.g(object3, (String)object2);
                    object3 = (e0)object3;
                    object2 = new ObservableGroupJoin$LeftRightEndObserver(this, false, n11);
                    this.disposables.b((b)object2);
                }
                catch (Throwable throwable) {
                    this.fail(throwable, g02, (e.a.w0.f.a)object);
                    return;
                }
                object3.subscribe((g0)object2);
                object5 = (Throwable)this.error.get();
                if (object5 != null) {
                    ((e.a.w0.f.a)object).clear();
                    this.cancelAll();
                    this.errorAll(g02);
                    return;
                }
                object5 = this.lefts.values().iterator();
                while (true) {
                    if ((n11 = (int)(object5.hasNext() ? 1 : 0)) == 0) continue block6;
                    object6 = (UnicastSubject)object5.next();
                    ((UnicastSubject)object6).onNext(object4);
                }
            }
            object5 = LEFT_CLOSE;
            if (object6 == object5) {
                object4 = (ObservableGroupJoin$LeftRightEndObserver)object4;
                object5 = this.lefts;
                n11 = ((ObservableGroupJoin$LeftRightEndObserver)object4).index;
                object6 = n11;
                object5 = (UnicastSubject)object5.remove(object6);
                object6 = this.disposables;
                ((e.a.s0.a)object6).a((b)object4);
                if (object5 == null) continue;
                ((UnicastSubject)object5).onComplete();
                continue;
            }
            object5 = RIGHT_CLOSE;
            if (object6 != object5) continue;
            object4 = (ObservableGroupJoin$LeftRightEndObserver)object4;
            object5 = this.rights;
            n11 = ((ObservableGroupJoin$LeftRightEndObserver)object4).index;
            object6 = n11;
            object5.remove(object6);
            object5 = this.disposables;
            ((e.a.s0.a)object5).a((b)object4);
        }
    }

    public void errorAll(g0 g02) {
        boolean bl2;
        Throwable throwable = ExceptionHelper.c(this.error);
        Iterator iterator2 = this.lefts.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            UnicastSubject unicastSubject = (UnicastSubject)iterator2.next();
            unicastSubject.onError(throwable);
        }
        this.lefts.clear();
        this.rights.clear();
        g02.onError(throwable);
    }

    public void fail(Throwable throwable, g0 g02, e.a.w0.f.a a10) {
        a.b(throwable);
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
            e.a.a1.a.Y(throwable);
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
            e.a.a1.a.Y((Throwable)serializable);
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

