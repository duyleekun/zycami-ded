/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.r2.b;
import f.r2.d;
import java.util.concurrent.TimeUnit;

public final class n
extends b {
    private long c;

    public n() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        super(timeUnit);
    }

    private final void d(double d10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TestTimeSource will overflow if its reading ");
        long l10 = this.c;
        stringBuilder.append(l10);
        stringBuilder.append("ns is advanced by ");
        String string2 = d.X(d10);
        stringBuilder.append(string2);
        stringBuilder.append('.');
        string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public long c() {
        return this.c;
    }

    public final void e(double d10) {
        TimeUnit timeUnit = this.b();
        double d11 = d.R(d10, timeUnit);
        long l10 = (long)d11;
        long l11 = Long.MIN_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l13 = Long.MAX_VALUE;
        if (l12 != false && (l12 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) != false) {
            long l14;
            long l15;
            long l16 = this.c;
            l11 = l16 + l10;
            long l17 = 0L;
            long l18 = (l10 ^= l16) - l17;
            Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object >= 0 && (l15 = (l14 = (l16 ^= l11) - l17) == 0L ? 0 : (l14 < 0L ? -1 : 1)) < 0) {
                this.d(d10);
            }
        } else {
            double d12;
            l10 = this.c;
            double d13 = (double)l10 + d11;
            double d14 = d13 - (d11 = (double)l13);
            Object object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object > 0 || (object = (d12 = d13 - (d11 = (double)l11)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) < 0) {
                this.d(d10);
            }
            l11 = (long)d13;
        }
        this.c = l11;
    }
}

