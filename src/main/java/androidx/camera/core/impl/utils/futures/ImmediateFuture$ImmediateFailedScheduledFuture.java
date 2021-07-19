/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class ImmediateFuture$ImmediateFailedScheduledFuture
extends ImmediateFuture$ImmediateFailedFuture
implements ScheduledFuture {
    public ImmediateFuture$ImmediateFailedScheduledFuture(Throwable throwable) {
        super(throwable);
    }

    public int compareTo(Delayed delayed) {
        return -1;
    }

    public long getDelay(TimeUnit timeUnit) {
        return 0L;
    }
}

