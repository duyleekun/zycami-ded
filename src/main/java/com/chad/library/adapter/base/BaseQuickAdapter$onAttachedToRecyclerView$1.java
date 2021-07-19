/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import f.h2.t.f0;

public final class BaseQuickAdapter$onAttachedToRecyclerView$1
extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ GridLayoutManager$SpanSizeLookup $defSpanSizeLookup;
    public final /* synthetic */ RecyclerView$LayoutManager $manager;
    public final /* synthetic */ BaseQuickAdapter this$0;

    public BaseQuickAdapter$onAttachedToRecyclerView$1(BaseQuickAdapter baseQuickAdapter, RecyclerView$LayoutManager recyclerView$LayoutManager, GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup) {
        this.this$0 = baseQuickAdapter;
        this.$manager = recyclerView$LayoutManager;
        this.$defSpanSizeLookup = gridLayoutManager$SpanSizeLookup;
    }

    public int getSpanSize(int n10) {
        Object object;
        Object object2 = this.this$0;
        int n11 = ((BaseQuickAdapter)object2).getItemViewType(n10);
        int n12 = 1;
        int n13 = 0x10000111;
        if (n11 == n13 && (n13 = (int)(((BaseQuickAdapter)(object = this.this$0)).getHeaderViewAsFlow() ? 1 : 0)) != 0) {
            return n12;
        }
        n13 = 0x10000333;
        if (n11 == n13 && (n13 = (int)(((BaseQuickAdapter)(object = this.this$0)).getFooterViewAsFlow() ? 1 : 0)) != 0) {
            return n12;
        }
        Object object3 = BaseQuickAdapter.access$getMSpanSizeLookup$p(this.this$0);
        if (object3 == null) {
            object3 = this.this$0;
            if ((n11 = (int)(((BaseQuickAdapter)object3).isFixedViewType(n11) ? 1 : 0)) != 0) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager)this.$manager;
                n10 = gridLayoutManager.getSpanCount();
            } else {
                object2 = this.$defSpanSizeLookup;
                n10 = ((GridLayoutManager$SpanSizeLookup)object2).getSpanSize(n10);
            }
        } else {
            object3 = this.this$0;
            n12 = (int)(((BaseQuickAdapter)object3).isFixedViewType(n11) ? 1 : 0);
            if (n12 != 0) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager)this.$manager;
                n10 = gridLayoutManager.getSpanCount();
            } else {
                object3 = BaseQuickAdapter.access$getMSpanSizeLookup$p(this.this$0);
                if (object3 == null) {
                    f0.L();
                }
                object = (GridLayoutManager)this.$manager;
                BaseQuickAdapter baseQuickAdapter = this.this$0;
                int n14 = baseQuickAdapter.getHeaderLayoutCount();
                n10 -= n14;
                n10 = object3.getSpanSize((GridLayoutManager)object, n11, n10);
            }
        }
        return n10;
    }
}

