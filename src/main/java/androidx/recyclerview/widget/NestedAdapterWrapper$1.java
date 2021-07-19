/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.NestedAdapterWrapper$Callback;
import androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

public class NestedAdapterWrapper$1
extends RecyclerView$AdapterDataObserver {
    public final /* synthetic */ NestedAdapterWrapper this$0;

    public NestedAdapterWrapper$1(NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = nestedAdapterWrapper;
    }

    public void onChanged() {
        int n10;
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount = n10 = nestedAdapterWrapper.adapter.getItemCount();
        nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onChanged(nestedAdapterWrapper);
    }

    public void onItemRangeChanged(int n10, int n11) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, n10, n11, null);
    }

    public void onItemRangeChanged(int n10, int n11, Object object) {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onItemRangeChanged(nestedAdapterWrapper, n10, n11, object);
    }

    public void onItemRangeInserted(int n10, int n11) {
        Object object;
        int n12;
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount = n12 = nestedAdapterWrapper.mCachedItemCount + n11;
        NestedAdapterWrapper$Callback nestedAdapterWrapper$Callback = nestedAdapterWrapper.mCallback;
        nestedAdapterWrapper$Callback.onItemRangeInserted(nestedAdapterWrapper, n10, n11);
        Object object2 = this.this$0;
        n11 = object2.mCachedItemCount;
        if (n11 > 0 && (object2 = object2.adapter.getStateRestorationPolicy()) == (object = RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY)) {
            object2 = this.this$0;
            object = object2.mCallback;
            object.onStateRestorationPolicyChanged((NestedAdapterWrapper)object2);
        }
    }

    public void onItemRangeMoved(int n10, int n11, int n12) {
        int n13 = 1;
        if (n12 != n13) {
            n13 = 0;
        }
        Preconditions.checkArgument(n13 != 0, "moving more than 1 item is not supported in RecyclerView");
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onItemRangeMoved(nestedAdapterWrapper, n10, n11);
    }

    public void onItemRangeRemoved(int n10, int n11) {
        Object object;
        int n12;
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCachedItemCount = n12 = nestedAdapterWrapper.mCachedItemCount - n11;
        NestedAdapterWrapper$Callback nestedAdapterWrapper$Callback = nestedAdapterWrapper.mCallback;
        nestedAdapterWrapper$Callback.onItemRangeRemoved(nestedAdapterWrapper, n10, n11);
        Object object2 = this.this$0;
        n11 = object2.mCachedItemCount;
        int n13 = 1;
        if (n11 < n13 && (object2 = object2.adapter.getStateRestorationPolicy()) == (object = RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY)) {
            object2 = this.this$0;
            object = object2.mCallback;
            object.onStateRestorationPolicyChanged((NestedAdapterWrapper)object2);
        }
    }

    public void onStateRestorationPolicyChanged() {
        NestedAdapterWrapper nestedAdapterWrapper = this.this$0;
        nestedAdapterWrapper.mCallback.onStateRestorationPolicyChanged(nestedAdapterWrapper);
    }
}

