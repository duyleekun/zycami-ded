/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1;

import d.v.c.x1.n$a;
import d.v.c.x1.n$b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class n {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static volatile boolean b = false;
    private static volatile boolean c = false;

    public static /* synthetic */ boolean a(boolean bl2) {
        c = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean b() {
        return b;
    }

    public static void c() {
        b = true;
    }

    public static boolean d() {
        return c;
    }

    public static void e(n$b n$b) {
        b = false;
        c = false;
        ExecutorService executorService = a;
        n$a n$a = new n$a(n$b);
        executorService.execute(n$a);
    }
}

