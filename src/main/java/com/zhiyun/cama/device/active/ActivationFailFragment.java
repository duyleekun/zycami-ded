/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.zhiyun.cama.device.active;

import android.os.Bundle;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.device.active.ActivationFailFragment$a;
import com.zhiyun.cama.device.active.ActivationFailFragment$b;
import com.zhiyun.device.active.ActivationViewModel;
import d.v.c.w0.l5;
import d.v.f.h.a;
import d.v.i0.b;

public class ActivationFailFragment
extends a {
    private l5 b;

    public int h() {
        return 2131558554;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (l5)object;
        this.b = object;
        object = (ActivationViewModel)d.v.i0.b.c(this.requireActivity()).get(ActivationViewModel.class);
        this.b.B((ActivationViewModel)object);
        object = this.b;
        ActivationFailFragment$b activationFailFragment$b = new ActivationFailFragment$b(this);
        ((l5)object).A(activationFailFragment$b);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.requireActivity().getOnBackPressedDispatcher();
        ActivationFailFragment$a activationFailFragment$a = new ActivationFailFragment$a(this, true);
        ((OnBackPressedDispatcher)object).addCallback(this, activationFailFragment$a);
    }
}

