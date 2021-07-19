/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Futures$CallbackListener
implements Runnable {
    public final FutureCallback mCallback;
    public final Future mFuture;

    public Futures$CallbackListener(Future future, FutureCallback futureCallback) {
        this.mFuture = future;
        this.mCallback = futureCallback;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        void var1_4;
        block4: {
            Object object;
            try {
                object = this.mFuture;
                object = Futures.getDone((Future)object);
            }
            catch (Error error) {
                break block4;
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
                break block4;
            }
            catch (ExecutionException executionException) {
                FutureCallback futureCallback = this.mCallback;
                Throwable throwable = executionException.getCause();
                futureCallback.onFailure(throwable);
                return;
            }
            this.mCallback.onSuccess(object);
            return;
        }
        this.mCallback.onFailure((Throwable)var1_4);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = Futures$CallbackListener.class.getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append(",");
        object = this.mCallback;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

