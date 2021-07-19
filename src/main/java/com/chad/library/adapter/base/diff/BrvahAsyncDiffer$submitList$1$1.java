/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil$DiffResult;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1;
import java.util.List;

public final class BrvahAsyncDiffer$submitList$1$1
implements Runnable {
    public final /* synthetic */ DiffUtil$DiffResult $result;
    public final /* synthetic */ BrvahAsyncDiffer$submitList$1 this$0;

    public BrvahAsyncDiffer$submitList$1$1(BrvahAsyncDiffer$submitList$1 var1_1, DiffUtil$DiffResult diffUtil$DiffResult) {
        this.this$0 = var1_1;
        this.$result = diffUtil$DiffResult;
    }

    public final void run() {
        BrvahAsyncDiffer brvahAsyncDiffer = this.this$0.this$0;
        int n10 = BrvahAsyncDiffer.access$getMMaxScheduledGeneration$p(brvahAsyncDiffer);
        Runnable runnable = this.this$0;
        int n11 = runnable.$runGeneration;
        if (n10 == n11) {
            brvahAsyncDiffer = runnable.this$0;
            List list = runnable.$newList;
            DiffUtil$DiffResult diffUtil$DiffResult = this.$result;
            runnable = runnable.$commitCallback;
            BrvahAsyncDiffer.access$latchList(brvahAsyncDiffer, list, diffUtil$DiffResult, runnable);
        }
    }
}

