/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingValueReference;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalCache$Segment$1
implements Runnable {
    public final /* synthetic */ LocalCache$Segment this$0;
    public final /* synthetic */ int val$hash;
    public final /* synthetic */ Object val$key;
    public final /* synthetic */ ListenableFuture val$loadingFuture;
    public final /* synthetic */ LocalCache$LoadingValueReference val$loadingValueReference;

    public LocalCache$Segment$1(LocalCache$Segment localCache$Segment, Object object, int n10, LocalCache$LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
        this.this$0 = localCache$Segment;
        this.val$key = object;
        this.val$hash = n10;
        this.val$loadingValueReference = loadingValueReference;
        this.val$loadingFuture = listenableFuture;
    }

    public void run() {
        LocalCache$Segment localCache$Segment = this.this$0;
        Object object = this.val$key;
        int n10 = this.val$hash;
        Object object2 = this.val$loadingValueReference;
        ListenableFuture listenableFuture = this.val$loadingFuture;
        try {
            localCache$Segment.getAndRecordStats(object, n10, (LocalCache$LoadingValueReference)object2, listenableFuture);
        }
        catch (Throwable throwable) {
            object = LocalCache.logger;
            Level level = Level.WARNING;
            object2 = "Exception thrown during refresh";
            ((Logger)object).log(level, (String)object2, throwable);
            object = this.val$loadingValueReference;
            ((LocalCache$LoadingValueReference)object).setException(throwable);
        }
    }
}

