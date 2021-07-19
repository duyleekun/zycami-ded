/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import java.util.concurrent.ExecutionException;

public class ImmediateFuture$ImmediateFailedFuture
extends ImmediateFuture {
    private final Throwable mCause;

    public ImmediateFuture$ImmediateFailedFuture(Throwable throwable) {
        this.mCause = throwable;
    }

    public Object get() {
        Throwable throwable = this.mCause;
        ExecutionException executionException = new ExecutionException(throwable);
        throw executionException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("[status=FAILURE, cause=[");
        object = this.mCause;
        stringBuilder.append(object);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}

