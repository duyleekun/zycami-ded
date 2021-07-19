/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.binder.QuickDataBindingItemBinder$BinderDataBindingHolder;
import f.h2.t.f0;

public abstract class QuickDataBindingItemBinder
extends BaseItemBinder {
    public abstract ViewDataBinding onCreateDataBinding(LayoutInflater var1, ViewGroup var2, int var3);

    public QuickDataBindingItemBinder$BinderDataBindingHolder onCreateViewHolder(ViewGroup object, int n10) {
        f0.q(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        f0.h(layoutInflater, "LayoutInflater.from(parent.context)");
        object = this.onCreateDataBinding(layoutInflater, (ViewGroup)object, n10);
        QuickDataBindingItemBinder$BinderDataBindingHolder quickDataBindingItemBinder$BinderDataBindingHolder = new QuickDataBindingItemBinder$BinderDataBindingHolder((ViewDataBinding)object);
        return quickDataBindingItemBinder$BinderDataBindingHolder;
    }
}

