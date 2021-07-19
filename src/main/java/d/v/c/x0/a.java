/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.x0;

import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import d.v.c.q0.b;
import d.v.c.w0.r3;

public class a
extends b {
    private r3 g;
    private AnimationDrawable h;

    public void dismiss() {
        super.dismiss();
        AnimationDrawable animationDrawable = this.h;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            this.getDialog().setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            WindowManager.LayoutParams layoutParams = dialog.getAttributes();
            layoutParams.width = n10 = 300;
            layoutParams.height = n10;
            layoutParams.gravity = n10 = 17;
            dialog.setAttributes(layoutParams);
        }
    }

    public void q(FragmentManager fragmentManager) {
        super.q(fragmentManager);
        fragmentManager = this.h;
        if (fragmentManager != null) {
            fragmentManager.start();
        }
    }

    public int s() {
        return 2131558520;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (r3)viewDataBinding;
        this.g = viewDataBinding;
        viewDataBinding = (AnimationDrawable)((r3)viewDataBinding).a.getBackground();
        this.h = viewDataBinding;
    }
}

