/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.TimeoutFuture;
import com.google.common.util.concurrent.TimeoutFuture$TimeoutFutureException;
import java.util.concurrent.TimeUnit;

public final class TimeoutFuture$Fire
implements Runnable {
    public TimeoutFuture timeoutFutureRef;

    public TimeoutFuture$Fire(TimeoutFuture timeoutFuture) {
        this.timeoutFutureRef = timeoutFuture;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        Object object;
        Object object2;
        Object object3;
        boolean bl2;
        ListenableFuture listenableFuture;
        TimeoutFuture timeoutFuture;
        block29: {
            timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null) {
                return;
            }
            listenableFuture = TimeoutFuture.access$000(timeoutFuture);
            if (listenableFuture == null) {
                return;
            }
            this.timeoutFutureRef = null;
            bl2 = listenableFuture.isDone();
            if (bl2) {
                timeoutFuture.setFuture(listenableFuture);
                return;
            }
            bl2 = true;
            object3 = TimeoutFuture.access$100(timeoutFuture);
            TimeoutFuture.access$102(timeoutFuture, null);
            object2 = "Timed out";
            if (object3 == null) break block29;
            try {
                object = TimeUnit.MILLISECONDS;
            }
            catch (Throwable throwable) {
                object = new TimeoutFuture$TimeoutFutureException((String)object2, null);
                timeoutFuture.setException((Throwable)object);
                throw throwable;
            }
            long l10 = object3.getDelay((TimeUnit)((Object)object));
            l10 = Math.abs(l10);
            long l11 = 10;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 > 0) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                String string2 = " (timeout delayed by ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(l10);
                object = " ms after scheduled time)";
                ((StringBuilder)object3).append((String)object);
                object2 = object3 = ((StringBuilder)object3).toString();
            }
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object2);
        object = ": ";
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(listenableFuture);
        object3 = ((StringBuilder)object3).toString();
        object2 = new TimeoutFuture$TimeoutFutureException((String)object3, null);
        timeoutFuture.setException((Throwable)object2);
        return;
        finally {
            listenableFuture.cancel(bl2);
        }
    }
}

