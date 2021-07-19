/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.chad.library.adapter.base.viewholder;

import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public class BaseDataBindingHolder
extends BaseViewHolder {
    private final ViewDataBinding dataBinding;

    public BaseDataBindingHolder(View object) {
        f0.q(object, "view");
        super((View)object);
        object = DataBindingUtil.bind(object);
        this.dataBinding = object;
    }

    public final ViewDataBinding getDataBinding() {
        return this.dataBinding;
    }
}

