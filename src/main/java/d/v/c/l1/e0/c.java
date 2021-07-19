/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 */
package d.v.c.l1.e0;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import d.v.c.w0.z3;
import d.v.e.l.h2;
import d.v.f.g.a;

public class c
extends a {
    private z3 f;
    private String g;

    private void w(Dialog dialog) {
        Window window;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            dialog = dialog.getWindow();
            dialog.setBackgroundDrawableResource(2131099771);
            float f10 = 300.0f;
            int n10 = h2.b(f10);
            float f11 = 115.0f;
            int n11 = h2.b(f11);
            dialog.setLayout(n10, n11);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = this.getDialog();
        this.w((Dialog)bundle);
    }

    public void onViewCreated(View object, Bundle bundle) {
        super.onViewCreated((View)object, bundle);
        object = this.g;
        if (object != null) {
            bundle = this.f.b;
            bundle.setText((CharSequence)object);
        }
    }

    public int s() {
        return 2131558524;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (z3)viewDataBinding;
        this.f = viewDataBinding;
    }

    public void u(String string2) {
        this.g = string2;
    }

    public void v() {
        this.setCancelable(false);
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog = this.getDialog();
            dialog.setCanceledOnTouchOutside(false);
        }
    }
}

