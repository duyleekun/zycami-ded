/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.s0.a7.n1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import d.v.c.s0.a7.n1.a$a;
import d.v.c.s0.a7.n1.a$b;
import d.v.c.s0.a7.n1.b;
import d.v.c.w0.n3;
import d.v.e.l.h2;

public class a
extends d.v.f.g.a {
    private d.v.f.f.a f;
    private d.v.f.f.a g;
    private int h;
    private int i;
    private a$a j;
    private n3 k;
    private b l;

    private a() {
        int n10;
        this.h = n10 = h2.b(300.0f);
        this.i = n10 = h2.b(187.0f);
    }

    public a(a$a a$a) {
        d.v.f.f.a a10;
        int n10;
        this.h = n10 = h2.b(300.0f);
        float f10 = 187.0f;
        this.i = n10 = h2.b(f10);
        this.j = a$a;
        this.f = a10 = a$a.a(a$a);
        this.g = a10 = a$a.b(this.j);
        n10 = a$a.c(a$a);
        if (n10 != 0) {
            this.h = n10 = a$a.c(a$a);
        }
        if ((n10 = a$a.d(a$a)) != 0) {
            int n11;
            this.i = n11 = a$a.d(a$a);
        }
    }

    public static /* synthetic */ d.v.f.f.a u(a a10) {
        return a10.g;
    }

    public static /* synthetic */ d.v.f.f.a v(a a10) {
        return a10.f;
    }

    private void w() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            dialog = this.getDialog();
            int n11 = 0;
            float f10 = 0.0f;
            ViewGroup.LayoutParams layoutParams = null;
            dialog.setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            colorDrawable = dialog.getAttributes();
            int n12 = this.k();
            int n13 = 2;
            if (n12 != 0 && n12 != n13) {
                colorDrawable.width = n10 = this.h;
                colorDrawable.height = n10 = this.i;
            } else {
                colorDrawable.width = n11 = this.i;
                colorDrawable.height = n11 = this.h;
                n11 = -90;
                f10 = 0.0f / 0.0f;
            }
            colorDrawable.gravity = n10 = 17;
            dialog.setAttributes((WindowManager.LayoutParams)colorDrawable);
            dialog = this.getView();
            if (dialog != null) {
                int n14;
                f10 = n11;
                dialog.setRotation(f10);
                layoutParams = dialog.getLayoutParams();
                layoutParams.width = n14 = this.h;
                layoutParams = dialog.getLayoutParams();
                layoutParams.height = n14 = this.i;
                layoutParams = dialog.getLayoutParams();
                dialog.setLayoutParams(layoutParams);
                if (n12 != 0 && n12 != n13) {
                    n11 = 0;
                    f10 = 0.0f;
                    layoutParams = null;
                    dialog.setTranslationX(0.0f);
                    dialog.setTranslationY(0.0f);
                } else {
                    n11 = this.i / n13;
                    n14 = this.h / n13;
                    float f11 = n11 -= n14;
                    dialog.setTranslationX(f11);
                    n11 = -n11;
                    f10 = n11;
                    dialog.setTranslationY(f10);
                }
            }
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (b)d.v.i0.b.a(this).get(b.class);
        this.l = object;
    }

    public void onResume() {
        super.onResume();
        this.w();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.l;
        object2 = a$a.e(this.j);
        ((b)object).j((String)object2);
        object = this.l;
        object2 = a$a.f(this.j);
        ((b)object).f((String)object2);
        object = this.l;
        object2 = a$a.g(this.j);
        ((b)object).g((String)object2);
        object = this.l;
        object2 = a$a.h(this.j);
        ((b)object).i((String)object2);
        object = this.j;
        boolean bl2 = a$a.i((a$a)object);
        if (bl2) {
            bl2 = false;
            object = null;
            this.setCancelable(false);
            object2 = this.getDialog();
            if (object2 != null) {
                object2 = this.getDialog();
                object2.setCanceledOnTouchOutside(false);
            }
        }
    }

    public void p(int n10) {
        super.p(n10);
        this.w();
    }

    public int s() {
        return 2131558518;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (n3)viewDataBinding;
        this.k = viewDataBinding;
        Object object = new a$b(this);
        ((n3)viewDataBinding).A((a$b)object);
        viewDataBinding = this.k;
        object = this.l;
        ((n3)viewDataBinding).B((b)object);
    }
}

