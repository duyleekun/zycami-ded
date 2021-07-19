/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateSuccessfulFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class ImmediateFuture
implements ListenableFuture {
    private static final String TAG = "ImmediateFuture";

    public static ListenableFuture nullFuture() {
        return ImmediateFuture$ImmediateSuccessfulFuture.NULL_FUTURE;
    }

    public void addListener(Runnable object, Executor object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        try {
            object2.execute((Runnable)object);
        }
        catch (RuntimeException runtimeException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Experienced RuntimeException while attempting to notify ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append(" on Executor ");
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            object2 = TAG;
            Logger.e((String)object2, (String)object, runtimeException);
        }
    }

    public boolean cancel(boolean bl2) {
        return false;
    }

    public abstract Object get();

    public Object get(long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        return this.get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}

