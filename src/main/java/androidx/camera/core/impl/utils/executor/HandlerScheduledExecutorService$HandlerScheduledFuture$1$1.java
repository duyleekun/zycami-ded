/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService$HandlerScheduledFuture$1;
import java.util.concurrent.atomic.AtomicReference;

public class HandlerScheduledExecutorService$HandlerScheduledFuture$1$1
implements Runnable {
    public final /* synthetic */ HandlerScheduledExecutorService$HandlerScheduledFuture$1 this$1;

    public HandlerScheduledExecutorService$HandlerScheduledFuture$1$1(HandlerScheduledExecutorService$HandlerScheduledFuture$1 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        Object object = this.this$1.this$0.mCompleter;
        Handler handler = null;
        if ((object = ((AtomicReference)object).getAndSet(null)) != null) {
            object = this.this$1;
            handler = ((HandlerScheduledExecutorService$HandlerScheduledFuture$1)object).val$handler;
            object = ((HandlerScheduledExecutorService$HandlerScheduledFuture$1)object).this$0;
            handler.removeCallbacks((Runnable)object);
        }
    }
}

