/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture$1$1;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class HandlerScheduledExecutorService$HandlerScheduledFuture$1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ HandlerScheduledExecutorService$HandlerScheduledFuture this$0;
    public final /* synthetic */ Handler val$handler;
    public final /* synthetic */ Callable val$task;

    public HandlerScheduledExecutorService$HandlerScheduledFuture$1(HandlerScheduledExecutorService$HandlerScheduledFuture handlerScheduledExecutorService$HandlerScheduledFuture, Handler handler, Callable callable) {
        this.this$0 = handlerScheduledExecutorService$HandlerScheduledFuture;
        this.val$handler = handler;
        this.val$task = callable;
    }

    public Object attachCompleter(CallbackToFutureAdapter$Completer object) {
        Object object2 = new HandlerScheduledExecutorService$HandlerScheduledFuture$1$1(this);
        Executor executor = CameraXExecutors.directExecutor();
        ((CallbackToFutureAdapter$Completer)object).addCancellationListener((Runnable)object2, executor);
        this.this$0.mCompleter.set(object);
        object = new StringBuilder();
        ((StringBuilder)object).append("HandlerScheduledFuture-");
        object2 = this.val$task.toString();
        ((StringBuilder)object).append((String)object2);
        return ((StringBuilder)object).toString();
    }
}

