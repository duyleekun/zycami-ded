/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

public final class DirectExecutor
implements Executor {
    private static volatile DirectExecutor sDirectExecutor;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Executor getInstance() {
        Object object = sDirectExecutor;
        if (object != null) {
            return sDirectExecutor;
        }
        object = DirectExecutor.class;
        synchronized (object) {
            DirectExecutor directExecutor = sDirectExecutor;
            if (directExecutor == null) {
                sDirectExecutor = directExecutor = new DirectExecutor();
            }
            return sDirectExecutor;
        }
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}

