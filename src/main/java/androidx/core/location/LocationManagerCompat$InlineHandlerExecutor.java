/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.core.location;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class LocationManagerCompat$InlineHandlerExecutor
implements Executor {
    private final Handler mHandler;

    public LocationManagerCompat$InlineHandlerExecutor(Handler handler) {
        this.mHandler = handler = (Handler)Preconditions.checkNotNull(handler);
    }

    public void execute(Runnable object) {
        Looper looper;
        Object object2;
        block4: {
            block3: {
                block2: {
                    object2 = Looper.myLooper();
                    if (object2 != (looper = this.mHandler.getLooper())) break block2;
                    object.run();
                    break block3;
                }
                object2 = this.mHandler;
                boolean bl2 = object2.post((Runnable)(object = (Runnable)Preconditions.checkNotNull(object)));
                if (!bl2) break block4;
            }
            return;
        }
        object2 = new StringBuilder();
        looper = this.mHandler;
        ((StringBuilder)object2).append(looper);
        ((StringBuilder)object2).append(" is shutting down");
        object2 = ((StringBuilder)object2).toString();
        object = new RejectedExecutionException((String)object2);
        throw object;
    }
}

