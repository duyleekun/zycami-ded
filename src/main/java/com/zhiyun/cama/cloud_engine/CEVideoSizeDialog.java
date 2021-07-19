/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.graphics.Color
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.cloud_engine;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CEVideoSizeDialog$a;
import com.zhiyun.common.util.Windows;
import d.v.c.w0.t2;
import d.v.f.g.a;

public class CEVideoSizeDialog
extends a {
    private t2 f;

    private void u() {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        dialog = this.getDialog().getWindow();
        if (dialog == null) {
            return;
        }
        int n10 = -1;
        dialog.setLayout(n10, n10);
        dialog.setDimAmount(0.0f);
        int n11 = Color.parseColor((String)"#E60E0E16");
        ColorDrawable colorDrawable = new ColorDrawable(n11);
        dialog.setBackgroundDrawable((Drawable)colorDrawable);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onStart() {
        super.onStart();
        this.u();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Windows.a((View)this.f.a);
    }

    public int s() {
        return 2131558490;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (t2)viewDataBinding;
        this.f = viewDataBinding;
        CEVideoSizeDialog$a cEVideoSizeDialog$a = new CEVideoSizeDialog$a(this);
        ((t2)viewDataBinding).z(cEVideoSizeDialog$a);
    }
}

