/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingFuture;
import java.util.concurrent.Future;

public abstract class ForwardingFuture$SimpleForwardingFuture
extends ForwardingFuture {
    private final Future delegate;

    public ForwardingFuture$SimpleForwardingFuture(Future future) {
        this.delegate = future = (Future)Preconditions.checkNotNull(future);
    }

    public final Future delegate() {
        return this.delegate;
    }
}

