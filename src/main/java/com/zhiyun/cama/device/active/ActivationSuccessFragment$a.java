/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.active;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.device.active.ActivationSuccessFragment;

public class ActivationSuccessFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ ActivationSuccessFragment a;

    public ActivationSuccessFragment$a(ActivationSuccessFragment activationSuccessFragment, boolean bl2) {
        this.a = activationSuccessFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        this.a.requireActivity().finish();
    }
}

