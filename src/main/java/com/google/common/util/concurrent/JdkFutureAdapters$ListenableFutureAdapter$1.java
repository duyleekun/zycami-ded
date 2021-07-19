/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.Future;

public class JdkFutureAdapters$ListenableFutureAdapter$1
implements Runnable {
    public final /* synthetic */ JdkFutureAdapters$ListenableFutureAdapter this$0;

    public JdkFutureAdapters$ListenableFutureAdapter$1(JdkFutureAdapters$ListenableFutureAdapter listenableFutureAdapter) {
        this.this$0 = listenableFutureAdapter;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter = this.this$0;
            Future future = JdkFutureAdapters$ListenableFutureAdapter.access$000(jdkFutureAdapters$ListenableFutureAdapter);
            Uninterruptibles.getUninterruptibly(future);
        }
        catch (Throwable throwable) {}
        JdkFutureAdapters$ListenableFutureAdapter.access$100(this.this$0).execute();
    }
}

