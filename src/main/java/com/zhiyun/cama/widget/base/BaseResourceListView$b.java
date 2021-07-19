/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.widget.base;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import com.zhiyun.cama.widget.base.BaseResourceListView$b$a;
import d.v.c.b2.v.c;
import d.v.f.d.b;
import d.v.f.d.b$b;

public class BaseResourceListView$b
extends b {
    private final d.v.c.b2.v.b g;
    public final /* synthetic */ BaseResourceListView h;

    public BaseResourceListView$b(BaseResourceListView baseResourceListView, LifecycleOwner lifecycleOwner, d.v.c.b2.v.b b10) {
        this.h = baseResourceListView;
        BaseResourceListView$b$a baseResourceListView$b$a = new BaseResourceListView$b$a(baseResourceListView);
        super(lifecycleOwner, b10, baseResourceListView$b$a);
        this.g = b10;
    }

    public void b(b$b b$b, int n10, ViewDataBinding viewDataBinding) {
        c c10 = BaseResourceListView.a(this.h);
        d.v.c.b2.v.b b10 = this.g;
        c10.a(this, b10, b$b, n10, viewDataBinding);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return BaseResourceListView.a(this.h).b(n10);
    }
}

