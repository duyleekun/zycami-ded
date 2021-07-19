/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.device.active;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.device.active.ActivationPrepareFragment;
import d.v.c.y0.a.p$c;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.g0.s;

public class ActivationPrepareFragment$a
implements p$c {
    public final /* synthetic */ ActivationPrepareFragment a;

    public ActivationPrepareFragment$a(ActivationPrepareFragment activationPrepareFragment) {
        this.a = activationPrepareFragment;
    }

    /*
     * WARNING - void declaration
     */
    public void b(boolean bl2) {
        void var1_4;
        s.j();
        ActivationPrepareFragment.m((ActivationPrepareFragment)this.a).a.setChecked(false);
        Context context = this.a.requireContext();
        if (bl2) {
            int n10 = 2131953261;
        } else {
            int n11 = 2131951968;
        }
        n2.e(g.m(context, (int)var1_4));
    }

    public void c(UserInfo object) {
        s.j();
        ActivationPrepareFragment.j(this.a).f0();
        MutableLiveData mutableLiveData = ActivationPrepareFragment.j(this.a).R();
        Integer n10 = ((UserInfo)object).getId();
        mutableLiveData.setValue(n10);
        mutableLiveData = ActivationPrepareFragment.j(this.a).Q();
        object = ActivationPrepareFragment.l(this.a, (UserInfo)object);
        mutableLiveData.setValue(object);
        NavHostFragment.findNavController(this.a).navigate(2131361869);
    }
}

