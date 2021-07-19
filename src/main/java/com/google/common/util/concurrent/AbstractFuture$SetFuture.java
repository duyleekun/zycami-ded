/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.ListenableFuture;

public final class AbstractFuture$SetFuture
implements Runnable {
    public final ListenableFuture future;
    public final AbstractFuture owner;

    public AbstractFuture$SetFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
        this.owner = abstractFuture;
        this.future = listenableFuture;
    }

    public void run() {
        AbstractFuture abstractFuture;
        Object object = AbstractFuture.access$400(this.owner);
        if (object != this) {
            return;
        }
        object = AbstractFuture.access$500(this.future);
        AbstractFuture$AtomicHelper abstractFuture$AtomicHelper = AbstractFuture.access$200();
        boolean bl2 = abstractFuture$AtomicHelper.casValue(abstractFuture = this.owner, this, object);
        if (bl2) {
            object = this.owner;
            AbstractFuture.access$600((AbstractFuture)object);
        }
    }
}

