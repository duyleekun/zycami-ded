/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.active;

import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.device.active.ActivationAccountFragment;

public class ActivationAccountFragment$a {
    public final /* synthetic */ ActivationAccountFragment a;

    public ActivationAccountFragment$a(ActivationAccountFragment activationAccountFragment) {
        this.a = activationAccountFragment;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).navigate(2131361867);
    }

    public void b() {
        AccountActivity.h(this.a.getActivity());
    }
}

