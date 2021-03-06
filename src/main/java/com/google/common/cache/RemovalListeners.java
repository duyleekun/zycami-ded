/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1;
import java.util.concurrent.Executor;

public final class RemovalListeners {
    private RemovalListeners() {
    }

    public static RemovalListener asynchronous(RemovalListener removalListener, Executor executor) {
        Preconditions.checkNotNull(removalListener);
        Preconditions.checkNotNull(executor);
        RemovalListeners$1 removalListeners$1 = new RemovalListeners$1(executor, removalListener);
        return removalListeners$1;
    }
}

