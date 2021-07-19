/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.os;

import android.os.Handler;
import androidx.core.os.ExecutorCompat$HandlerExecutor;
import java.util.concurrent.Executor;

public final class ExecutorCompat {
    private ExecutorCompat() {
    }

    public static Executor create(Handler handler) {
        ExecutorCompat$HandlerExecutor executorCompat$HandlerExecutor = new ExecutorCompat$HandlerExecutor(handler);
        return executorCompat$HandlerExecutor;
    }
}

