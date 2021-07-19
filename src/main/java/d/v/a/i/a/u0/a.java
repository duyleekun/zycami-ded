/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.a.i.a.u0;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import d.v.a.g.k;
import d.v.e.l.h2;

public class a
extends d.v.f.g.a {
    private k f;

    public static a u() {
        a a10 = new a();
        return a10;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            this.getDialog().getWindow().setLayout(-1, -2);
            dialog = this.getDialog().getWindow();
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            dialog = this.getDialog().getWindow().getDecorView();
            float f10 = 30.0f;
            int n10 = h2.b(f10);
            int n11 = h2.b(f10);
            dialog.setPadding(n10, 0, n11, 0);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view = this.getDialog();
        if (view != null) {
            view = this.getDialog();
            bundle = null;
            view.setCanceledOnTouchOutside(false);
        }
    }

    public int s() {
        return R$layout.me_account_self_login_dialog;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (k)viewDataBinding;
        this.f = viewDataBinding;
    }
}

