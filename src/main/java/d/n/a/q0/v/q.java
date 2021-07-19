/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import d.n.a.q0.v.n;
import d.n.a.q0.v.o;
import e.a.h0;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class q
implements n {
    private static final int d = 5;
    private static final long e = TimeUnit.SECONDS.toMillis(30);
    private final long[] a;
    private final o b;
    private final h0 c;

    public q(o o10, h0 h02) {
        long[] lArray = new long[5];
        this.a = lArray;
        this.b = o10;
        this.c = h02;
    }

    private int b() {
        int n10;
        long l10 = Long.MAX_VALUE;
        int n11 = -1;
        for (int i10 = 0; i10 < (n10 = 5); ++i10) {
            long[] lArray = this.a;
            long l11 = lArray[i10];
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 >= 0) continue;
            n11 = i10;
            l10 = l11;
        }
        return n11;
    }

    public void a(boolean bl2) {
        this.b.a(bl2);
        int n10 = this.b();
        long l10 = this.a[n10];
        h0 h02 = this.c;
        Object object = TimeUnit.MILLISECONDS;
        long l11 = h02.d((TimeUnit)((Object)object));
        long l12 = l11 - l10;
        long l13 = e;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 >= 0) {
            this.a[n10] = l11;
            return;
        }
        object = new Date(l10 += l13);
        BleScanException bleScanException = new BleScanException(0x7FFFFFFE, (Date)object);
        throw bleScanException;
    }
}

