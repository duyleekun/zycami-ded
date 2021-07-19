/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.a1.a;
import e.a.h0$c;
import e.a.w0.g.l$c;
import java.util.concurrent.TimeUnit;

public final class l$a
implements Runnable {
    private final Runnable a;
    private final l$c b;
    private final long c;

    public l$a(Runnable runnable, l$c c10, long l10) {
        this.a = runnable;
        this.b = c10;
        this.c = l10;
    }

    public void run() {
        Object object = this.b;
        boolean bl2 = ((l$c)object).d;
        if (!bl2) {
            long l10 = this.c;
            object = this.b;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long l11 = ((h0$c)object).a(timeUnit);
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                l10 -= l11;
                try {
                    Thread.sleep(l10);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    e.a.a1.a.Y(interruptedException);
                    return;
                }
            }
            object = this.b;
            bl2 = ((l$c)object).d;
            if (!bl2) {
                object = this.a;
                object.run();
            }
        }
    }
}

