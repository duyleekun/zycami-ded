/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners$1;
import com.google.common.cache.RemovalNotification;

public class RemovalListeners$1$1
implements Runnable {
    public final /* synthetic */ RemovalListeners$1 this$0;
    public final /* synthetic */ RemovalNotification val$notification;

    public RemovalListeners$1$1(RemovalListeners$1 var1_1, RemovalNotification removalNotification) {
        this.this$0 = var1_1;
        this.val$notification = removalNotification;
    }

    public void run() {
        RemovalListener removalListener = this.this$0.val$listener;
        RemovalNotification removalNotification = this.val$notification;
        removalListener.onRemoval(removalNotification);
    }
}

