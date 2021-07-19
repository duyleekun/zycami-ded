/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.a1.a;
import e.a.s0.b;
import e.a.w0.g.h;
import java.util.concurrent.CountDownLatch;

public final class c {
    private c() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static void a(CountDownLatch countDownLatch, b object) {
        long l10;
        long l11 = countDownLatch.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return;
        }
        try {
            c.b();
            countDownLatch.await();
            return;
        }
        catch (InterruptedException interruptedException) {
            object.dispose();
            Thread.currentThread().interrupt();
            object = new IllegalStateException("Interrupted while waiting for subscription to complete.", interruptedException);
            throw object;
        }
    }

    public static void b() {
        Object object;
        boolean bl2 = a.L();
        if (bl2 && ((bl2 = (object = Thread.currentThread()) instanceof h) || (bl2 = a.W()))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Attempt to block on a Scheduler ");
            String string2 = Thread.currentThread().getName();
            charSequence.append(string2);
            charSequence.append(" that doesn't support blocking operators as they may lead to deadlock");
            charSequence = charSequence.toString();
            object = new IllegalStateException((String)charSequence);
            throw object;
        }
    }
}

