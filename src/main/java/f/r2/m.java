/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.r2.b;
import f.r2.p;
import java.util.concurrent.TimeUnit;

public final class m
extends b
implements p {
    public static final m c;

    static {
        m m10;
        c = m10 = new m();
    }

    private m() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        super(timeUnit);
    }

    public long c() {
        return System.nanoTime();
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}

