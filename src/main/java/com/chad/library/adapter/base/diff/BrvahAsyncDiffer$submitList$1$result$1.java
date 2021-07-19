/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1;
import java.util.List;

public final class BrvahAsyncDiffer$submitList$1$result$1
extends DiffUtil$Callback {
    public final /* synthetic */ BrvahAsyncDiffer$submitList$1 this$0;

    public BrvahAsyncDiffer$submitList$1$result$1(BrvahAsyncDiffer$submitList$1 brvahAsyncDiffer$submitList$1) {
        this.this$0 = brvahAsyncDiffer$submitList$1;
    }

    public boolean areContentsTheSame(int n10, int n11) {
        Object object = this.this$0.$oldList.get(n10);
        List list = this.this$0.$newList;
        Object e10 = list.get(n11);
        if (object != null && e10 != null) {
            return BrvahAsyncDiffer.access$getConfig$p(this.this$0.this$0).getDiffCallback().areContentsTheSame(object, e10);
        }
        if (object == null && e10 == null) {
            return true;
        }
        object = new Object();
        throw object;
    }

    public boolean areItemsTheSame(int n10, int n11) {
        Object e10 = this.this$0.$oldList.get(n10);
        Object object = this.this$0.$newList;
        Object e11 = object.get(n11);
        if (e10 != null && e11 != null) {
            object = BrvahAsyncDiffer.access$getConfig$p(this.this$0.this$0).getDiffCallback();
            n10 = (int)(((DiffUtil$ItemCallback)object).areItemsTheSame(e10, e11) ? 1 : 0);
        } else if (e10 == null && e11 == null) {
            n10 = 1;
        } else {
            n10 = 0;
            e10 = null;
        }
        return n10 != 0;
    }

    public Object getChangePayload(int n10, int n11) {
        Object object = this.this$0.$oldList.get(n10);
        List list = this.this$0.$newList;
        Object e10 = list.get(n11);
        if (object != null && e10 != null) {
            return BrvahAsyncDiffer.access$getConfig$p(this.this$0.this$0).getDiffCallback().getChangePayload(object, e10);
        }
        object = new Object();
        throw object;
    }

    public int getNewListSize() {
        return this.this$0.$newList.size();
    }

    public int getOldListSize() {
        return this.this$0.$oldList.size();
    }
}

