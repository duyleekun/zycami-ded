/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 */
package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zan;

public final class zao
extends zabr {
    private final /* synthetic */ Dialog zadl;
    private final /* synthetic */ zan zadm;

    public zao(zan zan2, Dialog dialog) {
        this.zadm = zan2;
        this.zadl = dialog;
    }

    public final void zas() {
        this.zadm.zadk.zaq();
        Dialog dialog = this.zadl;
        boolean bl2 = dialog.isShowing();
        if (bl2) {
            dialog = this.zadl;
            dialog.dismiss();
        }
    }
}

