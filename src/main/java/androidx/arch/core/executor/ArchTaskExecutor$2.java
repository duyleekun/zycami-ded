/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

public final class ArchTaskExecutor$2
implements Executor {
    public void execute(Runnable runnable) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
    }
}

