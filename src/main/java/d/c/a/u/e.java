/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import d.c.a.u.e$a;
import d.c.a.u.e$b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class e {
    private static final Executor a;
    private static final Executor b;

    static {
        Executor executor = new e$a();
        a = executor;
        executor = new e$b();
        b = executor;
    }

    private e() {
    }

    public static Executor a() {
        return b;
    }

    public static Executor b() {
        return a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void c(ExecutorService object) {
        TimeUnit timeUnit;
        object.shutdownNow();
        try {
            timeUnit = TimeUnit.SECONDS;
        }
        catch (InterruptedException interruptedException) {
            object.shutdownNow();
            Thread.currentThread().interrupt();
            object = new RuntimeException(interruptedException);
            throw object;
        }
        long l10 = 5;
        boolean bl2 = object.awaitTermination(l10, timeUnit);
        if (bl2) return;
        object.shutdownNow();
        boolean bl3 = object.awaitTermination(l10, timeUnit);
        if (bl3) return;
        String string2 = "Failed to shutdown";
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }
}

