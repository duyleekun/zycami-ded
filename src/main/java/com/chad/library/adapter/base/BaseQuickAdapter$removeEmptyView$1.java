/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.FrameLayout
 */
package com.chad.library.adapter.base;

import android.widget.FrameLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import f.h2.t.n0;
import f.m2.h;
import kotlin.jvm.internal.MutablePropertyReference0;

public final class BaseQuickAdapter$removeEmptyView$1
extends MutablePropertyReference0 {
    public BaseQuickAdapter$removeEmptyView$1(BaseQuickAdapter baseQuickAdapter) {
        super(baseQuickAdapter);
    }

    public Object get() {
        return BaseQuickAdapter.access$getMEmptyLayout$p((BaseQuickAdapter)this.receiver);
    }

    public String getName() {
        return "mEmptyLayout";
    }

    public h getOwner() {
        return n0.d(BaseQuickAdapter.class);
    }

    public String getSignature() {
        return "getMEmptyLayout()Landroid/widget/FrameLayout;";
    }

    public void set(Object object) {
        BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter)this.receiver;
        object = (FrameLayout)object;
        BaseQuickAdapter.access$setMEmptyLayout$p(baseQuickAdapter, (FrameLayout)object);
    }
}

