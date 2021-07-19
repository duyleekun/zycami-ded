/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import e.a.w0.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed$SkipLastTimedObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public final g0 downstream;
    public Throwable error;
    public final a queue;
    public final h0 scheduler;
    public final long time;
    public final TimeUnit unit;
    public b upstream;

    public ObservableSkipLastTimed$SkipLastTimedObserver(g0 object, long l10, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        this.downstream = object;
        this.time = l10;
        this.unit = timeUnit;
        this.scheduler = h02;
        this.queue = object = new a(n10);
        this.delayError = bl2;
    }

    public void dispose() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.upstream;
            object.dispose();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.queue;
                ((a)object).clear();
            }
        }
    }

    public void drain() {
        int n10;
        ObservableSkipLastTimed$SkipLastTimedObserver observableSkipLastTimed$SkipLastTimedObserver = this;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        g0 g02 = this.downstream;
        Object object = this.queue;
        boolean bl2 = this.delayError;
        TimeUnit timeUnit = this.unit;
        h0 h02 = this.scheduler;
        long l10 = this.time;
        int n12 = n10 = 1;
        while (true) {
            Object object2;
            long l11;
            long l12;
            long l13;
            boolean bl3;
            if (bl3 = observableSkipLastTimed$SkipLastTimedObserver.cancelled) {
                observableSkipLastTimed$SkipLastTimedObserver.queue.clear();
                return;
            }
            bl3 = observableSkipLastTimed$SkipLastTimedObserver.done;
            Long l14 = (Long)((a)object).peek();
            int n13 = l14 == null ? n10 : 0;
            long l15 = h02.d(timeUnit);
            if (n13 == 0 && (l13 = (l12 = (l11 = l14.longValue()) - (l15 -= l10)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                n13 = n10;
            }
            if (bl3) {
                if (bl2) {
                    if (n13 != 0) {
                        object = observableSkipLastTimed$SkipLastTimedObserver.error;
                        if (object != null) {
                            g02.onError((Throwable)object);
                        } else {
                            g02.onComplete();
                        }
                        return;
                    }
                } else {
                    object2 = observableSkipLastTimed$SkipLastTimedObserver.error;
                    if (object2 != null) {
                        observableSkipLastTimed$SkipLastTimedObserver.queue.clear();
                        g02.onError((Throwable)object2);
                        return;
                    }
                    if (n13 != 0) {
                        g02.onComplete();
                        return;
                    }
                }
            }
            if (n13 != 0) {
                n12 = -n12;
                if ((n12 = observableSkipLastTimed$SkipLastTimedObserver.addAndGet(n12)) != 0) continue;
                return;
            }
            ((a)object).poll();
            object2 = ((a)object).poll();
            g02.onNext(object2);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        a a10 = this.queue;
        Object object2 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        object2 = ((h0)object2).d(timeUnit);
        a10.offer(object2, object);
        this.drain();
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

