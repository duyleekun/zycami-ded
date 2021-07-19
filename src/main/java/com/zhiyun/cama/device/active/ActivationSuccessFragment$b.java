/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.zhiyun.cama.device.active;

import android.content.Intent;
import com.zhiyun.cama.device.active.ActivationSuccessFragment;

public class ActivationSuccessFragment$b {
    public final /* synthetic */ ActivationSuccessFragment a;

    public ActivationSuccessFragment$b(ActivationSuccessFragment activationSuccessFragment) {
        this.a = activationSuccessFragment;
    }

    public void a() {
        Intent intent = new Intent();
        intent.putExtra("bind", "success");
        this.a.requireActivity().setResult(-1, intent);
        this.a.requireActivity().finish();
    }
}

