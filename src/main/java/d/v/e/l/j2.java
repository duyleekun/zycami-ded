/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class j2
implements Executor {
    private final ExecutorService a;

    public j2() {
        ExecutorService executorService;
        this.a = executorService = Executors.newSingleThreadExecutor();
    }

    public void a() {
        block6: {
            ExecutorService executorService = this.a;
            executorService.shutdown();
            executorService = this.a;
            long l10 = 200L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            boolean bl2 = executorService.awaitTermination(l10, timeUnit);
            if (bl2) break block6;
            executorService = this.a;
            try {
                executorService.shutdownNow();
            }
            catch (InterruptedException interruptedException) {
                executorService = this.a;
                executorService.shutdownNow();
            }
        }
    }

    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }
}

