/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.DialogRedirect;

public final class zae
extends DialogRedirect {
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaoh;
    private final /* synthetic */ LifecycleFragment zaoi;

    public zae(Intent intent, LifecycleFragment lifecycleFragment, int n10) {
        this.zaoh = intent;
        this.zaoi = lifecycleFragment;
        this.val$requestCode = n10;
    }

    public final void redirect() {
        Intent intent = this.zaoh;
        if (intent != null) {
            LifecycleFragment lifecycleFragment = this.zaoi;
            int n10 = this.val$requestCode;
            lifecycleFragment.startActivityForResult(intent, n10);
        }
    }
}

