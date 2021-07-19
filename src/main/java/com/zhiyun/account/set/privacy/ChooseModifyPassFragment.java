/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.account.set.privacy;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.set.privacy.ChooseModifyPassFragment$a;
import d.v.a.g.g0;
import d.v.a.j.c.y;
import d.v.f.h.a;
import d.v.i0.b;

public class ChooseModifyPassFragment
extends a {
    private g0 b;
    private y c;

    public static /* synthetic */ y j(ChooseModifyPassFragment chooseModifyPassFragment) {
        return chooseModifyPassFragment.c;
    }

    public int h() {
        return R$layout.set_private_choose_modify_pass;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (g0)viewDataBinding;
        this.b = viewDataBinding;
        ChooseModifyPassFragment$a chooseModifyPassFragment$a = new ChooseModifyPassFragment$a(this);
        ((g0)viewDataBinding).z(chooseModifyPassFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (y)d.v.i0.b.c(this.requireActivity()).get(y.class);
        this.c = object;
    }
}

