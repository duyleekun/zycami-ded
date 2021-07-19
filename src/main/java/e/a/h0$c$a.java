/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.c1.a;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class h0$c$a
implements Runnable,
a {
    public final Runnable a;
    public final SequentialDisposable b;
    public final long c;
    public long d;
    public long e;
    public long f;
    public final /* synthetic */ h0$c g;

    public h0$c$a(h0$c h0$c, long l10, Runnable runnable, long l11, SequentialDisposable sequentialDisposable, long l12) {
        this.g = h0$c;
        this.a = runnable;
        this.b = sequentialDisposable;
        this.c = l12;
        this.e = l11;
        this.f = l10;
    }

    public Runnable getWrappedRunnable() {
        return this.a;
    }

    public void run() {
        this.a.run();
        b b10 = this.b;
        boolean n10 = ((SequentialDisposable)b10).isDisposed();
        if (!n10) {
            long l10;
            long l11;
            long l12;
            b10 = this.g;
            Object object = TimeUnit.NANOSECONDS;
            long l13 = ((h0$c)b10).a((TimeUnit)((Object)object));
            long l14 = h0.a;
            long l15 = l13 + l14;
            long l16 = this.e;
            long l17 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            l15 = 1L;
            if (l17 >= 0 && (l12 = (l11 = l13 - (l16 = l16 + (l10 = this.c) + l14)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
                l14 = this.f;
                this.d = l16 = this.d + l15;
                l14 += (l16 *= l10);
            } else {
                l14 = this.c;
                l16 = l13 + l14;
                this.d = l10 = this.d + l15;
                l14 *= l10;
                this.f = l14 = l16 - l14;
                l14 = l16;
            }
            this.e = l13;
            b10 = this.b;
            h0$c h0$c = this.g;
            object = h0$c.c(this, l14 -= l13, (TimeUnit)((Object)object));
            ((SequentialDisposable)b10).replace((b)object);
        }
    }
}

