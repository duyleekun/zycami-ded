/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class ResolvableFuture
extends AbstractResolvableFuture {
    private ResolvableFuture() {
    }

    public static ResolvableFuture create() {
        ResolvableFuture resolvableFuture = new ResolvableFuture();
        return resolvableFuture;
    }

    public boolean set(Object object) {
        return super.set(object);
    }

    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    public boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}

