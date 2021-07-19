/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.zhiyun.cama.device.active;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.device.active.ActivationAccountFragment$a;
import com.zhiyun.device.active.ActivationViewModel;
import d.v.a.f.c.b;
import d.v.c.w0.j5;
import d.v.c.x1.l;
import d.v.f.h.a;

public class ActivationAccountFragment
extends a {
    private ActivationViewModel b;

    private String j(UserInfo object) {
        boolean bl2;
        String string2 = ((UserInfo)object).getMobile();
        object = string2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((UserInfo)object).getMobile()))) ? ((UserInfo)object).getMobile() : ((string2 = ((UserInfo)object).getMail()) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((UserInfo)object).getMail()))) ? ((UserInfo)object).getMail() : ((UserInfo)object).getNickname());
        return object;
    }

    public int h() {
        return 2131558553;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (j5)viewDataBinding;
        Object object = new ActivationAccountFragment$a(this);
        ((j5)viewDataBinding).A((ActivationAccountFragment$a)object);
        object = this.b;
        ((j5)viewDataBinding).B((ActivationViewModel)object);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (ActivationViewModel)d.v.i0.b.c(this.requireActivity()).get(ActivationViewModel.class);
        this.b = object;
    }

    public void onResume() {
        super.onResume();
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((b)object).s();
        if (bl2) {
            object = d.v.a.f.c.b.N().i();
            MutableLiveData mutableLiveData = this.b.R();
            int n10 = ((UserInfo)object).getId();
            Integer n11 = n10;
            mutableLiveData.setValue(n11);
            mutableLiveData = this.b.Q();
            object = this.j((UserInfo)object);
            mutableLiveData.setValue(object);
        } else {
            l.h(this);
        }
    }
}

