/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.content;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class ContextCompat$MainHandlerExecutor
implements Executor {
    private final Handler mHandler;

    public ContextCompat$MainHandlerExecutor(Handler handler) {
        this.mHandler = handler;
    }

    public void execute(Runnable object) {
        Object object2 = this.mHandler;
        boolean bl2 = object2.post((Runnable)object);
        if (bl2) {
            return;
        }
        object2 = new StringBuilder();
        Handler handler = this.mHandler;
        ((StringBuilder)object2).append(handler);
        ((StringBuilder)object2).append(" is shutting down");
        object2 = ((StringBuilder)object2).toString();
        object = new RejectedExecutionException((String)object2);
        throw object;
    }
}

