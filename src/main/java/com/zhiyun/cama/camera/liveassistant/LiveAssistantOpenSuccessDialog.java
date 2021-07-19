/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 */
package com.zhiyun.cama.camera.liveassistant;

import android.app.Dialog;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantOpenSuccessDialog$a;
import d.v.c.v0.u.z;
import d.v.c.w0.ce;
import d.v.e.l.h2;
import d.v.f.g.a;

public class LiveAssistantOpenSuccessDialog
extends a {
    private ce f;

    private void u() {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        dialog = this.getDialog().getWindow();
        if (dialog == null) {
            return;
        }
        int n10 = h2.b(300.0f);
        dialog.setLayout(n10, -2);
        dialog.setBackgroundDrawableResource(2131231975);
    }

    public void onPause() {
        super.onPause();
        z z10 = z.m();
        boolean bl2 = this.f.a.isChecked() ^ true;
        z10.M(bl2);
    }

    public void onStart() {
        super.onStart();
        this.u();
    }

    public int s() {
        return 2131558679;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (ce)viewDataBinding;
        this.f = viewDataBinding;
        LiveAssistantOpenSuccessDialog$a liveAssistantOpenSuccessDialog$a = new LiveAssistantOpenSuccessDialog$a(this);
        ((ce)viewDataBinding).z(liveAssistantOpenSuccessDialog$a);
    }
}

