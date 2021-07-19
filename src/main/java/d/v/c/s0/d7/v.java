/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Size
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.LinearLayout
 */
package d.v.c.s0.d7;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.d7.v$a;
import d.v.c.s0.d7.v$b;
import d.v.c.s0.d7.v$c;
import d.v.c.s0.d7.v$d;
import d.v.c.w0.d9;
import d.v.c.w0.eb;
import d.v.e.l.h2;
import d.v.f.f.e;
import d.v.g0.o;
import java.util.List;

public class v
extends DialogFragment {
    private d9 a;
    private v$b b;
    private List c;
    private v$d d;
    private v$c e;
    private e f;
    private int g = 3;

    public static /* synthetic */ int h(v v10, int n10) {
        v10.g = n10;
        return n10;
    }

    public static /* synthetic */ void i(v v10, int n10) {
        v10.t(n10);
    }

    public static /* synthetic */ v$d j(v v10) {
        return v10.d;
    }

    public static /* synthetic */ v$c k(v v10) {
        return v10.e;
    }

    private void l() {
        Object object;
        int n10;
        List list = this.c;
        if (list == null) {
            return;
        }
        this.a.a.removeAllViews();
        list = null;
        for (int i10 = 0; i10 < (n10 = (object = this.c).size()); ++i10) {
            object = this.getLayoutInflater();
            int n11 = 2131558633;
            LinearLayout linearLayout = this.a.a;
            object = (eb)DataBindingUtil.inflate((LayoutInflater)object, n11, (ViewGroup)linearLayout, false);
            ((ViewDataBinding)object).setLifecycleOwner(this);
            Object object2 = (o)this.c.get(i10);
            ((eb)object).C((o)object2);
            object2 = this.b;
            ((eb)object).B((v$b)object2);
            object2 = i10;
            ((eb)object).D((Integer)object2);
            object2 = this.a.a;
            object = ((ViewDataBinding)object).getRoot();
            object2.addView((View)object);
        }
    }

    public static v m() {
        v v10 = new v();
        return v10;
    }

    private void n() {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        v$a v$a = new v$a(this, (Context)fragmentActivity);
        this.f = v$a;
    }

    private void o(int n10, int n11, int n12) {
        float f10;
        Object object = this.getView();
        int n13 = 2;
        float[] fArray = new float[n13];
        fArray[0] = f10 = (float)n10;
        f10 = n11;
        n11 = 1;
        fArray[n11] = f10;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)object, (String)"rotation", (float[])fArray);
        long l10 = 0L;
        objectAnimator.setDuration(l10).start();
        objectAnimator = this.getView();
        object = new float[n13];
        object[0] = (View)0.0f;
        float f11 = n12;
        object[n11] = (View)f11;
        ObjectAnimator.ofFloat((Object)objectAnimator, (String)"translationX", (float[])object).setDuration(l10).start();
    }

    private void p(int n10) {
        block4: {
            int n11;
            block2: {
                block3: {
                    if (n10 == 0) break block2;
                    n11 = 1;
                    if (n10 == n11) break block3;
                    n11 = 2;
                    if (n10 == n11) break block2;
                    n11 = 3;
                    if (n10 != n11) break block4;
                }
                n10 = 90;
                this.o(n10, 0, 0);
                break block4;
            }
            Size size = Windows.o(this.requireContext());
            n10 = size.getWidth() / 4;
            n11 = -90;
            this.o(0, n11, n10);
        }
    }

    private void t(int n10) {
        this.p(n10);
    }

    private void u(Dialog dialog) {
        Window window;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int n10;
            dialog = dialog.getWindow();
            dialog.getAttributes().windowAnimations = 2132017745;
            window = dialog.getAttributes();
            window.gravity = 80;
            window.width = n10 = -1;
            window.height = n10;
            window.flags = n10 = window.flags | 2;
            dialog.setAttributes((WindowManager.LayoutParams)window);
            dialog.setBackgroundDrawableResource(2131099771);
            dialog = dialog.getDecorView();
            float f10 = 20.0f;
            n10 = h2.b(f10);
            float f11 = 32.0f;
            int n11 = h2.b(f11);
            int n12 = h2.b(f10);
            int n13 = h2.b(f11);
            dialog.setPadding(n10, n11, n12, n13);
            dialog.requestLayout();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = this.getDialog();
        this.u((Dialog)bundle);
        this.l();
        this.n();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup object, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(2131558602, (ViewGroup)object, false);
        object = d9.s((View)layoutInflater);
        this.a = object;
        ((ViewDataBinding)object).setLifecycleOwner(this);
        this.b = object = new v$b(this);
        this.a.z((v$b)object);
        return layoutInflater;
    }

    public void onPause() {
        super.onPause();
        e e10 = this.f;
        if (e10 != null) {
            e10.disable();
        }
    }

    public void onResume() {
        super.onResume();
        e e10 = this.f;
        if (e10 != null) {
            e10.enable();
        }
        if ((e10 = this.getDialog()) != null && (e10 = this.getDialog().getWindow()) != null) {
            e10 = this.getDialog().getWindow();
            int n10 = 8;
            e10.clearFlags(n10);
            e10 = this.getDialog().getWindow();
            Windows.p((Window)e10);
        }
        int n11 = this.g;
        this.t(n11);
    }

    public v q(List list) {
        this.c = list;
        return this;
    }

    public v r(v$c v$c) {
        this.e = v$c;
        return this;
    }

    public v s(v$d v$d) {
        this.d = v$d;
        return this;
    }

    public void v(FragmentManager fragmentManager, String string2, int n10) {
        super.show(fragmentManager, string2);
        this.g = n10;
    }
}

