/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer$1;
import androidx.recyclerview.widget.DiffUtil$Callback;
import java.util.List;

public class AsyncListDiffer$1$1
extends DiffUtil$Callback {
    public final /* synthetic */ AsyncListDiffer$1 this$1;

    public AsyncListDiffer$1$1(AsyncListDiffer$1 asyncListDiffer$1) {
        this.this$1 = asyncListDiffer$1;
    }

    public boolean areContentsTheSame(int n10, int n11) {
        Object object = this.this$1.val$oldList.get(n10);
        List list = this.this$1.val$newList;
        Object e10 = list.get(n11);
        if (object != null && e10 != null) {
            return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(object, e10);
        }
        if (object == null && e10 == null) {
            return true;
        }
        object = new Object();
        throw object;
    }

    public boolean areItemsTheSame(int n10, int n11) {
        Object e10 = this.this$1.val$oldList.get(n10);
        List list = this.this$1.val$newList;
        Object e11 = list.get(n11);
        if (e10 != null && e11 != null) {
            return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(e10, e11);
        }
        if (e10 == null && e11 == null) {
            n10 = 1;
        } else {
            n10 = 0;
            e10 = null;
        }
        return n10 != 0;
    }

    public Object getChangePayload(int n10, int n11) {
        Object object = this.this$1.val$oldList.get(n10);
        List list = this.this$1.val$newList;
        Object e10 = list.get(n11);
        if (object != null && e10 != null) {
            return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(object, e10);
        }
        object = new Object();
        throw object;
    }

    public int getNewListSize() {
        return this.this$1.val$newList.size();
    }

    public int getOldListSize() {
        return this.this$1.val$oldList.size();
    }
}

