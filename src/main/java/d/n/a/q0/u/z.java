/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import e.a.h0;
import java.util.concurrent.TimeUnit;

public class z {
    public final long a;
    public final TimeUnit b;
    public final h0 c;

    public z(long l10, TimeUnit timeUnit, h0 h02) {
        this.a = l10;
        this.b = timeUnit;
        this.c = h02;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{value=");
        long l10 = this.a;
        stringBuilder.append(l10);
        stringBuilder.append(", timeUnit=");
        TimeUnit timeUnit = this.b;
        stringBuilder.append((Object)timeUnit);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

