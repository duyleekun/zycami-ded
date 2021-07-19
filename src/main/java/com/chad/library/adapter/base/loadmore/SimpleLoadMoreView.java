/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.R$id;
import com.chad.library.R$layout;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public final class SimpleLoadMoreView
extends BaseLoadMoreView {
    public View getLoadComplete(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        int n10 = R$id.load_more_load_complete_view;
        return baseViewHolder.getView(n10);
    }

    public View getLoadEndView(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        int n10 = R$id.load_more_load_end_view;
        return baseViewHolder.getView(n10);
    }

    public View getLoadFailView(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        int n10 = R$id.load_more_load_fail_view;
        return baseViewHolder.getView(n10);
    }

    public View getLoadingView(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        int n10 = R$id.load_more_loading_view;
        return baseViewHolder.getView(n10);
    }

    public View getRootView(ViewGroup viewGroup) {
        f0.q(viewGroup, "parent");
        int n10 = R$layout.brvah_quick_view_load_more;
        return AdapterUtilsKt.getItemView(viewGroup, n10);
    }
}

