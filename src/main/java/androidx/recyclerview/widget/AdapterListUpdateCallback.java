/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;

public final class AdapterListUpdateCallback
implements ListUpdateCallback {
    private final RecyclerView$Adapter mAdapter;

    public AdapterListUpdateCallback(RecyclerView$Adapter recyclerView$Adapter) {
        this.mAdapter = recyclerView$Adapter;
    }

    public void onChanged(int n10, int n11, Object object) {
        this.mAdapter.notifyItemRangeChanged(n10, n11, object);
    }

    public void onInserted(int n10, int n11) {
        this.mAdapter.notifyItemRangeInserted(n10, n11);
    }

    public void onMoved(int n10, int n11) {
        this.mAdapter.notifyItemMoved(n10, n11);
    }

    public void onRemoved(int n10, int n11) {
        this.mAdapter.notifyItemRangeRemoved(n10, n11);
    }
}

