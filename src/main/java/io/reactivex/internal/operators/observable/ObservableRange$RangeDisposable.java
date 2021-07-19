/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange$RangeDisposable
extends BasicIntQueueDisposable {
    private static final long serialVersionUID = 396518478098735504L;
    public final g0 downstream;
    public final long end;
    public boolean fused;
    public long index;

    public ObservableRange$RangeDisposable(g0 g02, long l10, long l11) {
        this.downstream = g02;
        this.index = l10;
        this.end = l11;
    }

    public void clear() {
        long l10;
        this.index = l10 = this.end;
        this.lazySet(1);
    }

    public void dispose() {
        this.set(1);
    }

    public boolean isDisposed() {
        int n10 = this.get();
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isEmpty() {
        long l10 = this.index;
        long l11 = this.end;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public Integer poll() {
        long l10 = this.index;
        long l11 = this.end;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.index = l11 = 1L + l10;
            return (int)l10;
        }
        this.lazySet(1);
        return null;
    }

    public int requestFusion(int n10) {
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            this.fused = n11;
            return n11;
        }
        return 0;
    }

    public void run() {
        long l10;
        boolean bl2 = this.fused;
        if (bl2) {
            return;
        }
        g0 g02 = this.downstream;
        long l11 = this.end;
        long l12 = this.index;
        while ((l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) != false && (l10 = (long)this.get()) == false) {
            l10 = (int)l12;
            Integer n10 = (int)l10;
            g02.onNext(n10);
            long l13 = 1L;
            l12 += l13;
        }
        int n11 = this.get();
        if (n11 == 0) {
            n11 = 1;
            this.lazySet(n11);
            g02.onComplete();
        }
    }
}

