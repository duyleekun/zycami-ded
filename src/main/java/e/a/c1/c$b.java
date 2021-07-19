/*
 * Decompiled with CFR 0.151.
 */
package e.a.c1;

import e.a.c1.c$a;
import e.a.w0.b.a;

public final class c$b
implements Comparable {
    public final long a;
    public final Runnable b;
    public final c$a c;
    public final long d;

    public c$b(c$a c$a, long l10, Runnable runnable, long l11) {
        this.a = l10;
        this.b = runnable;
        this.c = c$a;
        this.d = l11;
    }

    public int a(c$b c$b) {
        long l10 = this.a;
        long l11 = c$b.a;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = this.d;
            l11 = c$b.d;
            return e.a.w0.b.a.b(l10, l11);
        }
        return e.a.w0.b.a.b(l10, l11);
    }

    public String toString() {
        Object object = this.a;
        Object[] objectArray = new Object[]{object, object = this.b.toString()};
        return String.format("TimedRunnable(time = %d, run = %s)", objectArray);
    }
}

