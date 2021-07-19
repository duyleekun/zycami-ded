/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow$WindowSkipObserver
extends AtomicBoolean
implements g0,
b,
Runnable {
    private static final long serialVersionUID = 3366976432059579510L;
    public volatile boolean cancelled;
    public final int capacityHint;
    public final long count;
    public final g0 downstream;
    public long firstEmission;
    public long index;
    public final long skip;
    public b upstream;
    public final ArrayDeque windows;
    public final AtomicInteger wip;

    public ObservableWindow$WindowSkipObserver(g0 arrayDeque, long l10, long l11, int n10) {
        AtomicInteger atomicInteger;
        this.wip = atomicInteger = new AtomicInteger();
        this.downstream = arrayDeque;
        this.count = l10;
        this.skip = l11;
        this.capacityHint = n10;
        this.windows = arrayDeque = new ArrayDeque();
    }

    public void dispose() {
        this.cancelled = true;
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        boolean bl2;
        ArrayDeque arrayDeque = this.windows;
        while (!(bl2 = arrayDeque.isEmpty())) {
            UnicastSubject unicastSubject = (UnicastSubject)arrayDeque.poll();
            unicastSubject.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2;
        ArrayDeque arrayDeque = this.windows;
        while (!(bl2 = arrayDeque.isEmpty())) {
            UnicastSubject unicastSubject = (UnicastSubject)arrayDeque.poll();
            unicastSubject.onError(throwable);
        }
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2;
        ArrayDeque arrayDeque = this.windows;
        long l10 = this.index;
        long l11 = this.skip;
        long l12 = l10 % l11;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 == false && (object2 = (Object)this.cancelled) == false) {
            this.wip.getAndIncrement();
            object2 = this.capacityHint;
            UnicastSubject unicastSubject = UnicastSubject.o8((int)object2, this);
            arrayDeque.offer(unicastSubject);
            g0 g02 = this.downstream;
            g02.onNext(unicastSubject);
        }
        l12 = this.firstEmission;
        l13 = 1L;
        l12 += l13;
        Iterator iterator2 = arrayDeque.iterator();
        while (bl2 = iterator2.hasNext()) {
            UnicastSubject unicastSubject = (UnicastSubject)iterator2.next();
            unicastSubject.onNext(object);
        }
        long l15 = this.count;
        long l16 = l12 - l15;
        Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object3 >= 0) {
            object = (UnicastSubject)arrayDeque.poll();
            ((UnicastSubject)object).onComplete();
            object3 = arrayDeque.isEmpty();
            if (object3 != false && (object3 = (Object)this.cancelled) != false) {
                this.upstream.dispose();
                return;
            }
            this.firstEmission = l12 -= l11;
        } else {
            this.firstEmission = l12;
        }
        this.index = l10 += l13;
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

    public void run() {
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0 && (n10 = (int)(this.cancelled ? 1 : 0)) != 0) {
            object = this.upstream;
            object.dispose();
        }
    }
}

