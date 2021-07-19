/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1$1;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

public final class RemovalListeners$1
implements RemovalListener {
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ RemovalListener val$listener;

    public RemovalListeners$1(Executor executor, RemovalListener removalListener) {
        this.val$executor = executor;
        this.val$listener = removalListener;
    }

    public void onRemoval(RemovalNotification removalNotification) {
        Executor executor = this.val$executor;
        RemovalListeners$1$1 removalListeners$1$1 = new RemovalListeners$1$1(this, removalNotification);
        executor.execute(removalListeners$1$1);
    }
}

