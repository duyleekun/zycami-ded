/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;

public final class ImmediateFuture$ImmediateCancelledFuture
extends AbstractFuture$TrustedFuture {
    public ImmediateFuture$ImmediateCancelledFuture() {
        this.cancel(false);
    }
}

