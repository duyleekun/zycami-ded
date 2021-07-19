/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.MoreExecutors$5;

public class MoreExecutors$5$1
implements Runnable {
    public final /* synthetic */ MoreExecutors$5 this$0;
    public final /* synthetic */ Runnable val$command;

    public MoreExecutors$5$1(MoreExecutors$5 var1_1, Runnable runnable) {
        this.this$0 = var1_1;
        this.val$command = runnable;
    }

    public void run() {
        this.this$0.thrownFromDelegate = false;
        this.val$command.run();
    }
}

