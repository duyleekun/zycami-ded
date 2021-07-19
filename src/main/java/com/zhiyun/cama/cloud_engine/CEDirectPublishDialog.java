/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 */
package com.zhiyun.cama.cloud_engine;

import android.app.Dialog;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CEDirectPublishDialog$a;
import d.v.c.v0.u.z;
import d.v.c.w0.n2;
import d.v.e.l.h2;
import d.v.f.g.a;

public class CEDirectPublishDialog
extends a {
    private n2 f;

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
        boolean bl2 = this.f.b.isChecked() ^ true;
        z10.O(bl2);
    }

    public void onStart() {
        super.onStart();
        this.u();
    }

    public int s() {
        return 2131558486;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (n2)viewDataBinding;
        this.f = viewDataBinding;
        CEDirectPublishDialog$a cEDirectPublishDialog$a = new CEDirectPublishDialog$a(this);
        ((n2)viewDataBinding).z(cEDirectPublishDialog$a);
    }
}

