/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class RequestExecutor$HandlerExecutor
implements Executor {
    private final Handler mHandler;

    public RequestExecutor$HandlerExecutor(Handler handler) {
        this.mHandler = handler = (Handler)Preconditions.checkNotNull(handler);
    }

    public void execute(Runnable object) {
        Object object2 = this.mHandler;
        boolean bl2 = object2.post((Runnable)(object = (Runnable)Preconditions.checkNotNull(object)));
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

