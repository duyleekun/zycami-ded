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
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeLastTimed$TakeLastTimedObserver
extends AtomicBoolean
implements g0,
b {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final long count;
    public final boolean delayError;
    public final g0 downstream;
    public Throwable error;
    public final a queue;
    public final h0 scheduler;
    public final long time;
    public final TimeUnit unit;
    public b upstream;

    public ObservableTakeLastTimed$TakeLastTimedObserver(g0 object, long l10, long l11, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        this.downstream = object;
        this.count = l10;
        this.time = l11;
        this.unit = timeUnit;
        this.scheduler = h02;
        this.queue = object = new a(n10);
        this.delayError = bl2;
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            this.upstream.dispose();
            bl2 = this.compareAndSet(false, bl2);
            if (bl2) {
                a a10 = this.queue;
                a10.clear();
            }
        }
    }

    public void drain() {
        Throwable throwable = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (!bl3) {
            return;
        }
        g0 g02 = this.downstream;
        a a10 = this.queue;
        boolean bl4 = this.delayError;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        long l11 = this.time;
        l10 -= l11;
        while (true) {
            Object object;
            boolean bl5;
            Object object2;
            Object object3;
            if ((object3 = this.cancelled) != 0) {
                a10.clear();
                return;
            }
            if (!bl4 && (object2 = this.error) != null) {
                a10.clear();
                g02.onError((Throwable)object2);
                return;
            }
            object2 = a10.poll();
            if (object2 == null) {
                bl5 = bl2;
            } else {
                bl5 = false;
                object = null;
            }
            if (bl5) {
                throwable = this.error;
                if (throwable != null) {
                    g02.onError(throwable);
                } else {
                    g02.onComplete();
                }
                return;
            }
            object = a10.poll();
            long l12 = (Long)(object2 = (Long)object2);
            long l13 = l12 - l10;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 < 0) continue;
            g02.onNext(object);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.drain();
    }

    public void onNext(Object object) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        a a10 = this.queue;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l14 = h02.d(timeUnit);
        long l15 = this.time;
        long l16 = this.count;
        long l17 = Long.MAX_VALUE;
        long l18 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
        int n11 = 1;
        l18 = l18 == false ? (long)n11 : (long)0;
        Long l19 = l14;
        a10.offer(l19, object);
        while ((n10 = a10.isEmpty()) == 0 && ((n10 = (l13 = (l12 = ((Long)(object = (Long)a10.peek())).longValue()) - (l11 = l14 - l15)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) <= 0 || l18 == false && (n10 = (int)((l10 = (l12 = (long)(a10.m() >> n11)) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0)) {
            a10.poll();
            a10.poll();
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

