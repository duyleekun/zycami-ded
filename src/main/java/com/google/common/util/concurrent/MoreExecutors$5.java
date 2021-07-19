/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.MoreExecutors$5$1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class MoreExecutors$5
implements Executor {
    public boolean thrownFromDelegate = true;
    public final /* synthetic */ Executor val$delegate;
    public final /* synthetic */ AbstractFuture val$future;

    public MoreExecutors$5(Executor executor, AbstractFuture abstractFuture) {
        this.val$delegate = executor;
        this.val$future = abstractFuture;
    }

    public void execute(Runnable runnable) {
        block5: {
            Object object = this.val$delegate;
            MoreExecutors$5$1 moreExecutors$5$1 = new MoreExecutors$5$1(this, runnable);
            try {
                object.execute(moreExecutors$5$1);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                boolean bl2 = this.thrownFromDelegate;
                if (!bl2) break block5;
                object = this.val$future;
                ((AbstractFuture)object).setException(rejectedExecutionException);
            }
        }
    }
}

