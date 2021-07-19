/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.KeyEvent
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.i1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.i1.k1;
import d.v.c.i1.l2$a;
import d.v.c.q0.b;
import d.v.c.w0.h4;

public class l2
extends b {
    public static /* synthetic */ g w(l2 l22) {
        return l22.f;
    }

    public static /* synthetic */ boolean x(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        n11 = n10 == n11 ? 1 : 0;
        return n11 != 0;
    }

    private void y() {
        Window window;
        Dialog dialog = this.getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int n10;
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            k1 k12 = k1.a;
            dialog.setOnKeyListener((DialogInterface.OnKeyListener)k12);
            dialog = dialog.getWindow();
            k12 = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)k12);
            k12 = dialog.getDecorView();
            k12.setPadding(0, 0, 0, 0);
            window = dialog.getAttributes();
            window.width = n10 = -1;
            window.height = n10;
            dialog.setAttributes((WindowManager.LayoutParams)window);
        }
    }

    public int s() {
        return 2131558528;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (h4)viewDataBinding;
        Object object = this.f;
        ((h4)viewDataBinding).B((i2)object);
        object = new l2$a(this);
        ((h4)viewDataBinding).A((l2$a)object);
        this.y();
    }
}

