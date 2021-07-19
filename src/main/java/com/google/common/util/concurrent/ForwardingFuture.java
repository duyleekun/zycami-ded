/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingFuture
extends ForwardingObject
implements Future {
    public boolean cancel(boolean bl2) {
        return this.delegate().cancel(bl2);
    }

    public abstract Future delegate();

    public Object get() {
        return this.delegate().get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return this.delegate().get(l10, timeUnit);
    }

    public boolean isCancelled() {
        return this.delegate().isCancelled();
    }

    public boolean isDone() {
        return this.delegate().isDone();
    }
}

