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
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView$WhenMappings;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public abstract class BaseLoadMoreView {
    private final void isVisible(View view, boolean n10) {
        n10 = n10 != 0 ? 0 : 8;
        view.setVisibility(n10);
    }

    public void convert(BaseViewHolder baseViewHolder, int n10, LoadMoreStatus loadMoreStatus) {
        f0.q(baseViewHolder, "holder");
        f0.q((Object)loadMoreStatus, "loadMoreStatus");
        Object object = BaseLoadMoreView$WhenMappings.$EnumSwitchMapping$0;
        int n11 = loadMoreStatus.ordinal();
        n10 = object[n11];
        n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n12 = 4;
                    if (n10 == n12) {
                        object = this.getLoadingView(baseViewHolder);
                        this.isVisible((View)object, false);
                        object = this.getLoadComplete(baseViewHolder);
                        this.isVisible((View)object, false);
                        object = this.getLoadFailView(baseViewHolder);
                        this.isVisible((View)object, false);
                        baseViewHolder = this.getLoadEndView(baseViewHolder);
                        this.isVisible((View)baseViewHolder, n11 != 0);
                    }
                } else {
                    object = this.getLoadingView(baseViewHolder);
                    this.isVisible((View)object, false);
                    object = this.getLoadComplete(baseViewHolder);
                    this.isVisible((View)object, false);
                    object = this.getLoadFailView(baseViewHolder);
                    this.isVisible((View)object, n11 != 0);
                    baseViewHolder = this.getLoadEndView(baseViewHolder);
                    this.isVisible((View)baseViewHolder, false);
                }
            } else {
                object = this.getLoadingView(baseViewHolder);
                this.isVisible((View)object, n11 != 0);
                object = this.getLoadComplete(baseViewHolder);
                this.isVisible((View)object, false);
                object = this.getLoadFailView(baseViewHolder);
                this.isVisible((View)object, false);
                baseViewHolder = this.getLoadEndView(baseViewHolder);
                this.isVisible((View)baseViewHolder, false);
            }
        } else {
            object = this.getLoadingView(baseViewHolder);
            this.isVisible((View)object, false);
            object = this.getLoadComplete(baseViewHolder);
            this.isVisible((View)object, n11 != 0);
            object = this.getLoadFailView(baseViewHolder);
            this.isVisible((View)object, false);
            baseViewHolder = this.getLoadEndView(baseViewHolder);
            this.isVisible((View)baseViewHolder, false);
        }
    }

    public abstract View getLoadComplete(BaseViewHolder var1);

    public abstract View getLoadEndView(BaseViewHolder var1);

    public abstract View getLoadFailView(BaseViewHolder var1);

    public abstract View getLoadingView(BaseViewHolder var1);

    public abstract View getRootView(ViewGroup var1);
}

