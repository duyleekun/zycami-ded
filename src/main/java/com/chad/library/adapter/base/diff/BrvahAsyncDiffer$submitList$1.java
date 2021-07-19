/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1$1;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1$result$1;
import f.h2.t.f0;
import java.util.List;
import java.util.concurrent.Executor;

public final class BrvahAsyncDiffer$submitList$1
implements Runnable {
    public final /* synthetic */ Runnable $commitCallback;
    public final /* synthetic */ List $newList;
    public final /* synthetic */ List $oldList;
    public final /* synthetic */ int $runGeneration;
    public final /* synthetic */ BrvahAsyncDiffer this$0;

    public BrvahAsyncDiffer$submitList$1(BrvahAsyncDiffer brvahAsyncDiffer, List list, List list2, int n10, Runnable runnable) {
        this.this$0 = brvahAsyncDiffer;
        this.$oldList = list;
        this.$newList = list2;
        this.$runGeneration = n10;
        this.$commitCallback = runnable;
    }

    public final void run() {
        Object object = new BrvahAsyncDiffer$submitList$1$result$1(this);
        object = DiffUtil.calculateDiff((DiffUtil$Callback)object);
        f0.h(object, "DiffUtil.calculateDiff(o\u2026         }\n            })");
        Executor executor = BrvahAsyncDiffer.access$getMMainThreadExecutor$p(this.this$0);
        BrvahAsyncDiffer$submitList$1$1 brvahAsyncDiffer$submitList$1$1 = new BrvahAsyncDiffer$submitList$1$1(this, (DiffUtil$DiffResult)object);
        executor.execute(brvahAsyncDiffer$submitList$1$1);
    }
}

