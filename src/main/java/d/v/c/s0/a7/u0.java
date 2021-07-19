/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.s0.a7;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.a7.t0;

public abstract class u0
extends t0 {
    private boolean f = false;
    private int g;

    private void y() {
        Context context = this.getContext();
        if (context != null && (context = this.getDialog()) != null && (context = this.getDialog().getWindow()) != null) {
            int n10;
            float f10;
            int n11;
            context = this.getDialog().getWindow();
            View view = context.getDecorView();
            View view2 = null;
            view.setPadding(0, 0, 0, 0);
            view = context.getAttributes();
            view.gravity = 0x800003;
            int n12 = this.k();
            int n13 = 2;
            if (n12 != 0 && n12 != n13) {
                n11 = 0;
                f10 = 0.0f;
            } else {
                n11 = -90;
                f10 = 0.0f / 0.0f;
            }
            view.width = n10 = this.w();
            view.height = n10 = Windows.l(this.requireContext()).getHeight();
            n10 = 0;
            view.dimAmount = 0.0f;
            context.setAttributes((WindowManager.LayoutParams)view);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            context.setBackgroundDrawable((Drawable)colorDrawable);
            view2 = this.getView();
            if (view2 != null) {
                f10 = n11;
                view2.setRotation(f10);
                if (n12 != 0 && n12 != n13) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    layoutParams.width = n13 = view.width;
                    layoutParams = view2.getLayoutParams();
                    layoutParams.height = n13 = view.height;
                    layoutParams = view2.getLayoutParams();
                    view2.setLayoutParams(layoutParams);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    n12 = (int)(this.x() ? 1 : 0);
                    if (n12 != 0) {
                        view.width = n12 = -1;
                        context.setAttributes((WindowManager.LayoutParams)view);
                        context = view2.getLayoutParams();
                        context.width = n12;
                    }
                } else {
                    context = view2.getLayoutParams();
                    context.width = n12 = view.height;
                    context = view2.getLayoutParams();
                    context.height = n12 = view.width;
                    context = view2.getLayoutParams();
                    view2.setLayoutParams((ViewGroup.LayoutParams)context);
                    int n14 = view.width / n13;
                    int n15 = view.height / n13;
                    float f11 = n14 -= n15;
                    view2.setTranslationX(f11);
                    n14 = -n14;
                    float f12 = n14;
                    view2.setTranslationY(f12);
                }
            }
        }
    }

    public void A(boolean bl2) {
        this.f = bl2;
    }

    public void onResume() {
        super.onResume();
        this.y();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n10 = 1024;
            dialog.setFlags(n10, n10);
        }
    }

    public void p(int n10) {
        super.p(n10);
        this.y();
    }

    public int w() {
        return this.g;
    }

    public boolean x() {
        return this.f;
    }

    public void z(int n10) {
        this.g = n10;
    }
}

