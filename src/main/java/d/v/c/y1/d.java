/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.util.Size
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.y1;

import android.app.Dialog;
import android.util.Size;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.common.util.Windows;
import d.v.c.q0.b;
import d.v.c.w0.f6;
import d.v.c.y1.d$a;
import d.v.c.y1.d$b;

public class d
extends b {
    private f6 g;
    private d$b h;
    private int i;
    private boolean j;
    private boolean k;

    public d() {
        boolean bl2;
        this.j = bl2 = true;
        this.k = bl2;
    }

    public static /* synthetic */ d$b w(d d10) {
        return d10.h;
    }

    public static d x() {
        d d10 = new d();
        return d10;
    }

    private void y() {
        Window window;
        Dialog dialog = this.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            dialog = dialog.getWindow();
            dialog.getAttributes().windowAnimations = 2132017745;
            int n10 = 2131099771;
            dialog.setBackgroundDrawableResource(n10);
            window = dialog.getDecorView();
            Size size = null;
            window.setPadding(0, 0, 0, 0);
            window = dialog.getAttributes();
            window.width = -1;
            int n11 = this.i;
            if (n11 <= 0) {
                size = Windows.o(this.requireContext());
                n11 = size.getHeight() / 2;
            }
            window.height = n11;
            window.gravity = 80;
            size = null;
            window.dimAmount = 0.0f;
            window.flags = n11 = window.flags | 2;
            dialog.setAttributes((WindowManager.LayoutParams)window);
        }
    }

    public d A(boolean bl2) {
        this.j = bl2;
        f6 f62 = this.g;
        if (f62 != null) {
            f62 = f62.a;
            f62.setEnabled(bl2);
        }
        return this;
    }

    public d B(boolean bl2) {
        this.k = bl2;
        f6 f62 = this.g;
        if (f62 != null) {
            f62 = f62.b;
            f62.setEnabled(bl2);
        }
        return this;
    }

    public d C(d$b d$b) {
        this.h = d$b;
        return this;
    }

    public int s() {
        return 2131558564;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (f6)viewDataBinding;
        this.g = viewDataBinding;
        d$a d$a = new d$a(this);
        ((f6)viewDataBinding).z(d$a);
        viewDataBinding = this.g.a;
        boolean bl2 = this.j;
        viewDataBinding.setEnabled(bl2);
        viewDataBinding = this.g.b;
        bl2 = this.k;
        viewDataBinding.setEnabled(bl2);
        this.y();
    }

    public d z(int n10) {
        this.i = n10;
        return this;
    }
}

