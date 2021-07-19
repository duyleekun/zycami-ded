/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.y0.b.u;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import d.v.c.w0.d4;
import d.v.c.y0.b.u.c$a;
import d.v.f.g.a;

public class c
extends a {
    private d4 f;

    private void u() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            this.getDialog().setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            WindowManager.LayoutParams layoutParams = dialog.getAttributes();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.gravity = n10 = 80;
            dialog.setAttributes(layoutParams);
        }
    }

    public void onResume() {
        super.onResume();
        this.u();
    }

    public int s() {
        return 2131558526;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (d4)viewDataBinding;
        this.f = viewDataBinding;
        c$a c$a = new c$a(this);
        ((d4)viewDataBinding).z(c$a);
    }
}

