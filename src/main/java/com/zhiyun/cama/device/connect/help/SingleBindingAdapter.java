/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.connect.help;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

public class SingleBindingAdapter
extends BaseQuickAdapter {
    public SingleBindingAdapter(int n10) {
        super(n10);
    }

    public void convert(BaseViewHolder object, Object object2) {
        object = DataBindingUtil.getBinding(((RecyclerView$ViewHolder)object).itemView);
        if (object != null) {
            int n10 = 75;
            ((ViewDataBinding)object).setVariable(n10, object2);
            ((ViewDataBinding)object).executePendingBindings();
        }
    }

    public void onItemViewHolderCreated(BaseViewHolder baseViewHolder, int n10) {
        super.onItemViewHolderCreated(baseViewHolder, n10);
        DataBindingUtil.bind(baseViewHolder.itemView);
    }
}

