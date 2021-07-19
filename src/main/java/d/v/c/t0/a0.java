/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.t0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

public class a0
extends BaseLoadMoreView {
    public View getLoadComplete(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(2131362857);
    }

    public View getLoadEndView(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(2131362858);
    }

    public View getLoadFailView(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(2131362859);
    }

    public View getLoadingView(BaseViewHolder baseViewHolder) {
        return baseViewHolder.getView(2131362860);
    }

    public View getRootView(ViewGroup viewGroup) {
        return LayoutInflater.from((Context)viewGroup.getContext()).inflate(2131558487, viewGroup, false);
    }
}

