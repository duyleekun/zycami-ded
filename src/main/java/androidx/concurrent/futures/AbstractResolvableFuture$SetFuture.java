/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper;
import com.google.common.util.concurrent.ListenableFuture;

public final class AbstractResolvableFuture$SetFuture
implements Runnable {
    public final ListenableFuture future;
    public final AbstractResolvableFuture owner;

    public AbstractResolvableFuture$SetFuture(AbstractResolvableFuture abstractResolvableFuture, ListenableFuture listenableFuture) {
        this.owner = abstractResolvableFuture;
        this.future = listenableFuture;
    }

    public void run() {
        Object object = this.owner.value;
        if (object != this) {
            return;
        }
        AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper = AbstractResolvableFuture.ATOMIC_HELPER;
        AbstractResolvableFuture abstractResolvableFuture = this.owner;
        object = AbstractResolvableFuture.getFutureValue(this.future);
        boolean bl2 = abstractResolvableFuture$AtomicHelper.casValue(abstractResolvableFuture, this, object);
        if (bl2) {
            object = this.owner;
            AbstractResolvableFuture.complete((AbstractResolvableFuture)object);
        }
    }
}

