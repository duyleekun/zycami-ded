/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import f.h2.t.f0;

public final class BrvahListUpdateCallback
implements ListUpdateCallback {
    private final BaseQuickAdapter mAdapter;

    public BrvahListUpdateCallback(BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "mAdapter");
        this.mAdapter = baseQuickAdapter;
    }

    public void onChanged(int n10, int n11, Object object) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        int n12 = baseQuickAdapter.getHeaderLayoutCount();
        baseQuickAdapter.notifyItemRangeChanged(n10 += n12, n11, object);
    }

    public void onInserted(int n10, int n11) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        int n12 = baseQuickAdapter.getHeaderLayoutCount();
        baseQuickAdapter.notifyItemRangeInserted(n10 += n12, n11);
    }

    public void onMoved(int n10, int n11) {
        BaseQuickAdapter baseQuickAdapter = this.mAdapter;
        int n12 = baseQuickAdapter.getHeaderLayoutCount();
        n10 += n12;
        n12 = this.mAdapter.getHeaderLayoutCount();
        baseQuickAdapter.notifyItemMoved(n10, n11 += n12);
    }

    public void onRemoved(int n10, int n11) {
        int n12;
        int n13;
        Object object = this.mAdapter.getMLoadMoreModule$com_github_CymChad_brvah();
        if (object != null && (n13 = ((BaseLoadMoreModule)object).hasLoadMoreView()) == (n12 = 1) && (n13 = ((BaseQuickAdapter)(object = this.mAdapter)).getItemCount()) == 0) {
            object = this.mAdapter;
            int n14 = ((BaseQuickAdapter)object).getHeaderLayoutCount();
            ((RecyclerView$Adapter)object).notifyItemRangeRemoved(n10 += n14, n11 += n12);
        } else {
            object = this.mAdapter;
            n12 = ((BaseQuickAdapter)object).getHeaderLayoutCount();
            ((RecyclerView$Adapter)object).notifyItemRangeRemoved(n10 += n12, n11);
        }
    }
}

