/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.method.MovementMethod
 *  android.text.method.ScrollingMovementMethod
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager$LayoutParams
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.z0;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.ViewDataBinding;
import d.v.c.w0.yg;
import d.v.c.z0.g;
import d.v.c.z0.k$a;
import d.v.c.z0.k$b;
import d.v.c.z0.k$c;
import d.v.c.z0.l;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.i0.b;

public class k
extends a {
    private d.v.f.f.a f;
    private d.v.f.f.a g;
    private CompoundButton.OnCheckedChangeListener h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private k$b s;
    private yg t;
    private l u;

    private k() {
        int n10;
        this.i = n10 = h2.b(300.0f);
        this.j = -2;
        this.q = true;
    }

    private k(k$b k$b) {
        boolean bl2;
        d.v.f.f.a a10;
        int n10;
        this.i = n10 = h2.b(300.0f);
        this.j = -2;
        this.q = true;
        this.s = k$b;
        this.f = a10 = k$b.a(k$b);
        this.g = a10 = k$b.b(this.s);
        a10 = k$b.l(this.s);
        this.h = a10;
        n10 = k$b.o(k$b);
        if (n10 != 0) {
            this.i = n10 = k$b.o(k$b);
        }
        if ((n10 = k$b.p(k$b)) != 0) {
            this.j = n10 = k$b.p(k$b);
        }
        n10 = (int)(k$b.q(k$b) ? 1 : 0);
        this.k = n10;
        n10 = (int)(k$b.r(k$b) ? 1 : 0);
        this.l = n10;
        n10 = (int)(k$b.s(k$b) ? 1 : 0);
        this.m = n10;
        n10 = (int)(k$b.t(k$b) ? 1 : 0);
        this.n = n10;
        n10 = (int)(k$b.u(k$b) ? 1 : 0);
        this.p = n10;
        n10 = (int)(k$b.c(k$b) ? 1 : 0);
        this.o = n10;
        n10 = (int)(k$b.d(k$b) ? 1 : 0);
        this.q = n10;
        this.r = bl2 = k$b.e(k$b);
    }

    public /* synthetic */ k(k$b k$b, k$a k$a) {
        this(k$b);
    }

    public static /* synthetic */ void B(k k10, CompoundButton compoundButton, boolean bl2) {
        k10.z(compoundButton, bl2);
    }

    private void C() {
        this.dismissAllowingStateLoss();
        d.v.f.f.a a10 = this.f;
        if (a10 != null) {
            a10.a(this);
        }
    }

    private void D() {
        d.v.f.f.a a10;
        boolean bl2 = this.r;
        if (bl2) {
            this.dismissAllowingStateLoss();
        }
        if ((a10 = this.g) != null) {
            a10.a(this);
        }
    }

    private void E() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog();
            int n10 = 0;
            float f10 = 0.0f;
            ViewGroup.LayoutParams layoutParams = null;
            dialog.setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            colorDrawable = dialog.getAttributes();
            int n11 = this.k;
            if (n11 != 0) {
                int n12;
                n11 = this.k();
                int n13 = 2;
                if (n11 != 0 && n11 != n13) {
                    colorDrawable.width = n12 = this.i;
                    colorDrawable.height = n12 = this.j;
                } else {
                    colorDrawable.width = n10 = this.j;
                    colorDrawable.height = n10 = this.i;
                    n10 = -90;
                    f10 = 0.0f / 0.0f;
                }
                colorDrawable.gravity = n12 = 17;
                dialog.setAttributes((WindowManager.LayoutParams)colorDrawable);
                dialog = this.getView();
                if (dialog != null) {
                    int n14;
                    f10 = n10;
                    dialog.setRotation(f10);
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.width = n14 = this.i;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.height = n14 = this.j;
                    layoutParams = dialog.getLayoutParams();
                    dialog.setLayoutParams(layoutParams);
                    if (n11 != 0 && n11 != n13) {
                        n10 = 0;
                        f10 = 0.0f;
                        layoutParams = null;
                        dialog.setTranslationX(0.0f);
                        dialog.setTranslationY(0.0f);
                    } else {
                        n10 = this.j / n13;
                        n14 = this.i / n13;
                        float f11 = n10 -= n14;
                        dialog.setTranslationX(f11);
                        n10 = -n10;
                        f10 = n10;
                        dialog.setTranslationY(f10);
                    }
                }
            } else {
                colorDrawable.width = n10 = this.i;
                colorDrawable.height = n10 = this.j;
                dialog.setAttributes((WindowManager.LayoutParams)colorDrawable);
            }
        }
    }

    public static /* synthetic */ int u(k k10) {
        return k10.j;
    }

    public static /* synthetic */ int v(k k10, int n10) {
        k10.j = n10;
        return n10;
    }

    public static /* synthetic */ void w(k k10) {
        k10.E();
    }

    public static /* synthetic */ void x(k k10) {
        k10.C();
    }

    public static /* synthetic */ void y(k k10) {
        k10.D();
    }

    private void z(CompoundButton compoundButton, boolean bl2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.h;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, bl2);
        }
    }

    public boolean A() {
        return this.t.a.isChecked();
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (l)b.a(this).get(l.class);
        this.u = object;
    }

    public void onResume() {
        boolean bl2;
        super.onResume();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n10 = 1024;
            dialog.setFlags(n10, n10);
        }
        if (bl2 = this.k) {
            dialog = this.getView();
            if (dialog != null) {
                dialog = this.getView().getViewTreeObserver();
                k$a k$a = new k$a(this);
                dialog.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)k$a);
            }
        } else {
            this.E();
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        int n10;
        k$b k$b;
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.s;
        if (object == null) {
            this.dismissAllowingStateLoss();
            return;
        }
        object2 = this.u;
        object = k$b.f((k$b)object);
        ((l)object2).n((String)object);
        object = this.u;
        object2 = k$b.g(this.s);
        ((l)object).j((String)object2);
        object = this.u;
        object2 = k$b.h(this.s);
        ((l)object).i((String)object2);
        object = this.u;
        object2 = k$b.i(this.s);
        ((l)object).l((String)object2);
        object = this.u;
        object2 = k$b.j(this.s);
        ((l)object).m((String)object2);
        object = this.u;
        object2 = this.s;
        int n11 = k$b.r((k$b)object2);
        ((l)object).k(n11 != 0);
        object = this.s;
        int n12 = k$b.k((k$b)object);
        n11 = -1;
        if (n12 != n11) {
            object = this.t.f;
            k$b = this.s;
            n10 = k$b.k(k$b);
            object.setHeight(n10);
        }
        if ((n12 = k$b.m((k$b)(object = this.s))) != n11) {
            object = this.t.f;
            k$b = this.s;
            n10 = k$b.m(k$b);
            object.setTextColor(n10);
        }
        if ((n12 = k$b.n((k$b)(object = this.s))) != n11) {
            object = this.t.f;
            object2 = this.s;
            n11 = k$b.n((k$b)object2);
            object.setGravity(n11);
        }
        this.setCancelable(false);
    }

    public void p(int n10) {
        super.p(n10);
        n10 = (int)(this.k ? 1 : 0);
        if (n10 != 0) {
            this.E();
        }
    }

    public int s() {
        return 2131558768;
    }

    public void t(ViewDataBinding object) {
        int n10;
        super.t((ViewDataBinding)object);
        this.t = object = (yg)object;
        int n11 = 0;
        float f10 = 0.0f;
        Object object2 = null;
        Object object3 = new k$c(this, null);
        ((yg)object).A((k$c)object3);
        object = this.t;
        object3 = this.u;
        ((yg)object).B((l)object3);
        object = this.t.a;
        object3 = new g(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object3);
        boolean n12 = this.m;
        object3 = null;
        if (n12) {
            object = new ConstraintSet();
            object2 = this.t.b;
            ((ConstraintSet)object).clone((ConstraintLayout)((Object)object2));
            n10 = this.t.a.getId();
            int n13 = 6;
            int n14 = 6;
            f10 = 30.0f;
            int n15 = h2.b(f10);
            object2 = object;
            ((ConstraintSet)object).connect(n10, n13, 0, n14, n15);
            n11 = this.t.a.getId();
            ((ConstraintSet)object).constrainWidth(n11, 0);
            object2 = this.t.b;
            ((ConstraintSet)object).applyTo((ConstraintLayout)((Object)object2));
        }
        int n16 = 1;
        object = Typeface.defaultFromStyle((int)n16);
        object3 = Typeface.defaultFromStyle((int)0);
        object2 = this.t.h;
        n10 = this.n;
        Object object4 = n10 != 0 ? object : object3;
        object2.setTypeface((Typeface)object4);
        object2 = this.t.d;
        n10 = (int)(this.p ? 1 : 0);
        object4 = n10 != 0 ? object : object3;
        object2.setTypeface((Typeface)object4);
        object2 = this.t.e;
        n10 = (int)(this.o ? 1 : 0);
        object4 = n10 != 0 ? object : object3;
        object2.setTypeface((Typeface)object4);
        object2 = this.t.f;
        n10 = (int)(this.q ? 1 : 0);
        if (n10 == 0) {
            object = object3;
        }
        object2.setTypeface((Typeface)object);
        object = this.t.f;
        object3 = ScrollingMovementMethod.getInstance();
        object.setMovementMethod((MovementMethod)object3);
    }
}

