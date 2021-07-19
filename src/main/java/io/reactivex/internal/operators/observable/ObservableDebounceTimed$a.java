/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed$DebounceEmitter;
import java.util.concurrent.TimeUnit;

public final class ObservableDebounceTimed$a
implements g0,
b {
    public final g0 a;
    public final long b;
    public final TimeUnit c;
    public final h0$c d;
    public b e;
    public b f;
    public volatile long g;
    public boolean h;

    public ObservableDebounceTimed$a(g0 g02, long l10, TimeUnit timeUnit, h0$c h0$c) {
        this.a = g02;
        this.b = l10;
        this.c = timeUnit;
        this.d = h0$c;
    }

    public void a(long l10, Object object, ObservableDebounceTimed$DebounceEmitter observableDebounceTimed$DebounceEmitter) {
        long l11 = this.g;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            g0 g02 = this.a;
            g02.onNext(object);
            observableDebounceTimed$DebounceEmitter.dispose();
        }
    }

    public void dispose() {
        this.e.dispose();
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.h;
        if (bl2) {
            return;
        }
        this.h = bl2 = true;
        b b10 = this.f;
        if (b10 != null) {
            b10.dispose();
        }
        if ((b10 = (ObservableDebounceTimed$DebounceEmitter)b10) != null) {
            ((ObservableDebounceTimed$DebounceEmitter)b10).run();
        }
        this.a.onComplete();
        this.d.dispose();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.h;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        b b10 = this.f;
        if (b10 != null) {
            b10.dispose();
        }
        this.h = true;
        this.a.onError(throwable);
        this.d.dispose();
    }

    public void onNext(Object object) {
        boolean bl2 = this.h;
        if (bl2) {
            return;
        }
        long l10 = this.g;
        long l11 = 1L;
        this.g = l10 += l11;
        b b10 = this.f;
        if (b10 != null) {
            b10.dispose();
        }
        this.f = b10 = new ObservableDebounceTimed$DebounceEmitter(object, l10, this);
        object = this.d;
        l10 = this.b;
        TimeUnit timeUnit = this.c;
        object = ((h0$c)object).c((Runnable)((Object)b10), l10, timeUnit);
        ((ObservableDebounceTimed$DebounceEmitter)b10).setResource((b)object);
    }

    public void onSubscribe(b object) {
        b b10 = this.e;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.e = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

