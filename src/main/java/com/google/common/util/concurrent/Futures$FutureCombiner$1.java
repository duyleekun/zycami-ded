/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$FutureCombiner;
import java.util.concurrent.Callable;

public class Futures$FutureCombiner$1
implements Callable {
    public final /* synthetic */ Futures.FutureCombiner this$0;
    public final /* synthetic */ Runnable val$combiner;

    public Futures$FutureCombiner$1(Futures.FutureCombiner futureCombiner, Runnable runnable) {
        this.this$0 = futureCombiner;
        this.val$combiner = runnable;
    }

    public Void call() {
        this.val$combiner.run();
        return null;
    }
}

