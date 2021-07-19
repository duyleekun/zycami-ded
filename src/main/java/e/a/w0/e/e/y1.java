/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.w0.e.e.a;
import e.a.w0.e.e.y1$a;
import e.a.w0.e.e.y1$b;
import e.a.w0.e.e.y1$c;
import e.a.y0.l;
import java.util.concurrent.TimeUnit;

public final class y1
extends a {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final long f;
    public final int g;
    public final boolean h;

    public y1(e0 e02, long l10, long l11, TimeUnit timeUnit, h0 h02, long l12, int n10, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = l11;
        this.d = timeUnit;
        this.e = h02;
        this.f = l12;
        this.g = n10;
        this.h = bl2;
    }

    public void K5(g0 object) {
        l l10 = new l((g0)object);
        long l11 = this.b;
        long l12 = this.c;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            long l14 = this.f;
            l12 = Long.MAX_VALUE;
            long l15 = l14 - l12;
            object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 == false) {
                object = this.a;
                l11 = this.b;
                TimeUnit timeUnit = this.d;
                h0 h02 = this.e;
                int n10 = this.g;
                y1$b y1$b = new y1$b(l10, l11, timeUnit, h02, n10);
                object.subscribe(y1$b);
                return;
            }
            object = this.a;
            TimeUnit timeUnit = this.d;
            h0 h03 = this.e;
            int n11 = this.g;
            boolean bl2 = this.h;
            y1$a y1$a = new y1$a(l10, l11, timeUnit, h03, n11, l14, bl2);
            object.subscribe(y1$a);
            return;
        }
        object = this.a;
        TimeUnit timeUnit = this.d;
        h0$c h0$c = this.e.c();
        int n12 = this.g;
        y1$c y1$c = new y1$c(l10, l11, l12, timeUnit, h0$c, n12);
        object.subscribe(y1$c);
    }
}

