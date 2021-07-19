/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.concurrent.Callable;

public class HandlerScheduledExecutorService$2
implements Callable {
    public final /* synthetic */ HandlerScheduledExecutorService this$0;
    public final /* synthetic */ Runnable val$command;

    public HandlerScheduledExecutorService$2(HandlerScheduledExecutorService handlerScheduledExecutorService, Runnable runnable) {
        this.this$0 = handlerScheduledExecutorService;
        this.val$command = runnable;
    }

    public Void call() {
        this.val$command.run();
        return null;
    }
}

