/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.LinearLayout
 */
package com.chad.library.adapter.base;

import android.widget.LinearLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import f.h2.t.n0;
import f.m2.h;
import kotlin.jvm.internal.MutablePropertyReference0;

public final class BaseQuickAdapter$headerLayout$1
extends MutablePropertyReference0 {
    public BaseQuickAdapter$headerLayout$1(BaseQuickAdapter baseQuickAdapter) {
        super(baseQuickAdapter);
    }

    public Object get() {
        return BaseQuickAdapter.access$getMHeaderLayout$p((BaseQuickAdapter)this.receiver);
    }

    public String getName() {
        return "mHeaderLayout";
    }

    public h getOwner() {
        return n0.d(BaseQuickAdapter.class);
    }

    public String getSignature() {
        return "getMHeaderLayout()Landroid/widget/LinearLayout;";
    }

    public void set(Object object) {
        BaseQuickAdapter baseQuickAdapter = (BaseQuickAdapter)this.receiver;
        object = (LinearLayout)object;
        BaseQuickAdapter.access$setMHeaderLayout$p(baseQuickAdapter, (LinearLayout)object);
    }
}

