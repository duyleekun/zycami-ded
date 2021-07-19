/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.cloud_engine;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.cloud_engine.CECompositingDialog;

public class CECompositingDialog$a
extends OnBackPressedCallback {
    public final /* synthetic */ CECompositingDialog a;

    public CECompositingDialog$a(CECompositingDialog cECompositingDialog, boolean bl2) {
        this.a = cECompositingDialog;
        super(bl2);
    }

    public void handleOnBackPressed() {
        CECompositingDialog.u(this.a);
    }
}

