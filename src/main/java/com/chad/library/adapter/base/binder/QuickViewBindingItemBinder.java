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
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.binder.QuickViewBindingItemBinder$BinderVBHolder;
import f.h2.t.f0;

public abstract class QuickViewBindingItemBinder
extends BaseItemBinder {
    public abstract ViewBinding onCreateViewBinding(LayoutInflater var1, ViewGroup var2, int var3);

    public QuickViewBindingItemBinder$BinderVBHolder onCreateViewHolder(ViewGroup object, int n10) {
        f0.q(object, "parent");
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        f0.h(layoutInflater, "LayoutInflater.from(parent.context)");
        object = this.onCreateViewBinding(layoutInflater, (ViewGroup)object, n10);
        QuickViewBindingItemBinder$BinderVBHolder quickViewBindingItemBinder$BinderVBHolder = new QuickViewBindingItemBinder$BinderVBHolder((ViewBinding)object);
        return quickViewBindingItemBinder$BinderVBHolder;
    }
}

