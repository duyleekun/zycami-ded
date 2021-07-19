/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableGroupBy$a;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableGroupBy$GroupByObserver
extends AtomicInteger
implements g0,
b {
    public static final Object NULL_KEY;
    private static final long serialVersionUID = -3688291656102519502L;
    public final int bufferSize;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public final g0 downstream;
    public final Map groups;
    public final o keySelector;
    public b upstream;
    public final o valueSelector;

    static {
        Object object;
        NULL_KEY = object = new Object();
    }

    public ObservableGroupBy$GroupByObserver(g0 concurrentHashMap, o o10, o o11, int n10, boolean bl2) {
        AtomicBoolean atomicBoolean;
        this.cancelled = atomicBoolean = new AtomicBoolean();
        this.downstream = concurrentHashMap;
        this.keySelector = o10;
        this.valueSelector = o11;
        this.bufferSize = n10;
        this.delayError = bl2;
        this.groups = concurrentHashMap = new ConcurrentHashMap();
        this.lazySet(1);
    }

    public void cancel(Object object) {
        if (object == null) {
            object = NULL_KEY;
        }
        Map map = this.groups;
        map.remove(object);
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            object = this.upstream;
            object.dispose();
        }
    }

    public void dispose() {
        int n10;
        Object object = this.cancelled;
        boolean bl2 = true;
        boolean n102 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (n102 && (n10 = this.decrementAndGet()) == 0) {
            object = this.upstream;
            object.dispose();
        }
    }

    public boolean isDisposed() {
        return this.cancelled.get();
    }

    public void onComplete() {
        boolean bl2;
        Object object = this.groups.values();
        Object object2 = new ArrayList(object);
        object = this.groups;
        object.clear();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            object = (ObservableGroupBy$a)object2.next();
            ((ObservableGroupBy$a)object).onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2;
        Object object = this.groups.values();
        Object object2 = new ArrayList(object);
        object = this.groups;
        object.clear();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            object = (ObservableGroupBy$a)object2.next();
            ((ObservableGroupBy$a)object).onError(throwable);
        }
        this.downstream.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        Object object3;
        Object object2;
        try {
            object2 = this.keySelector;
            object2 = object2.apply(object);
            object3 = object2 != null ? object2 : NULL_KEY;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        Object object4 = (ObservableGroupBy$a)this.groups.get(object3);
        if (object4 == null) {
            object4 = this.cancelled;
            boolean n10 = ((AtomicBoolean)object4).get();
            if (n10) {
                return;
            }
            int n11 = this.bufferSize;
            boolean bl2 = this.delayError;
            object4 = ObservableGroupBy$a.i8(object2, n11, this, bl2);
            this.groups.put(object3, object4);
            this.getAndIncrement();
            object2 = this.downstream;
            object2.onNext(object4);
        }
        try {
            object2 = this.valueSelector;
            object = object2.apply(object);
            object2 = "The value supplied is null";
            object = a.g(object, (String)object2);
            ((ObservableGroupBy$a)object4).onNext(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
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

