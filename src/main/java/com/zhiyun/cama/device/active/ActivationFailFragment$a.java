/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.device.active;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.device.active.ActivationFailFragment;

public class ActivationFailFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ ActivationFailFragment a;

    public ActivationFailFragment$a(ActivationFailFragment activationFailFragment, boolean bl2) {
        this.a = activationFailFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        this.a.requireActivity().finish();
    }
}

