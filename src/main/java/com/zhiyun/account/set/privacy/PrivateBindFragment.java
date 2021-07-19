/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.set.privacy;

import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.set.privacy.PrivateBindFragment$a;
import d.v.a.g.a0;
import d.v.f.h.a;

public class PrivateBindFragment
extends a {
    private a0 b;

    public int h() {
        return R$layout.set_private_bind_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (a0)viewDataBinding;
        this.b = viewDataBinding;
        PrivateBindFragment$a privateBindFragment$a = new PrivateBindFragment$a(this);
        ((a0)viewDataBinding).z(privateBindFragment$a);
    }
}

