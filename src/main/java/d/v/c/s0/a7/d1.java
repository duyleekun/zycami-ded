/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Size
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.s0.a7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.common.util.StatusBarUtil;
import com.zhiyun.common.util.Windows;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import d.v.c.s0.a7.d1$a;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.w0.f1;
import d.v.f.g.a;
import d.v.i0.b;

public class d1
extends a {
    private f1 f;
    private u6 g;
    private s6 h;
    private BleViewModel i;
    private KeyFunc j;

    public d1() {
        KeyFunc keyFunc;
        this.j = keyFunc = KeyFunc.DEFAULT;
    }

    public static d1 A() {
        d1 d12 = new d1();
        return d12;
    }

    private void B() {
        Context context = this.getContext();
        if (context != null && (context = this.getDialog()) != null && (context = this.getDialog().getWindow()) != null) {
            float f10;
            int n10;
            float f11;
            int n11;
            context = this.getDialog().getWindow();
            int n12 = 2;
            float f12 = 2.8E-45f;
            context.addFlags(n12);
            View view = context.getDecorView();
            View view2 = null;
            view.setPadding(0, 0, 0, 0);
            view = context.getAttributes();
            view.gravity = 48;
            int n13 = this.k();
            if (n13 != 0 && n13 != n12) {
                n11 = 0;
                f11 = 0.0f;
            } else {
                n11 = -90;
                f11 = 0.0f / 0.0f;
            }
            Size size = Windows.l(this.requireContext());
            view.height = n10 = size.getHeight();
            int n14 = size.getWidth();
            Context context2 = this.getContext();
            n10 = StatusBarUtil.b(context2);
            view.width = n14 -= n10;
            n14 = 1062836634;
            view.dimAmount = f10 = 0.85f;
            context.setAttributes((WindowManager.LayoutParams)view);
            size = new ColorDrawable(0);
            context.setBackgroundDrawable((Drawable)size);
            view2 = this.getView();
            if (view2 != null) {
                f11 = n11;
                view2.setRotation(f11);
                if (n13 != 0 && n13 != n12) {
                    n12 = -1;
                    f12 = 0.0f / 0.0f;
                    view.width = n12;
                    context.setAttributes((WindowManager.LayoutParams)view);
                    view2.getLayoutParams().width = n12;
                    context = view2.getLayoutParams();
                    context.height = n12 = view.height;
                    context = view2.getLayoutParams();
                    view2.setLayoutParams((ViewGroup.LayoutParams)context);
                    boolean bl2 = false;
                    float f13 = 0.0f;
                    context = null;
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                } else {
                    context = view2.getLayoutParams();
                    context.width = n13 = view.height;
                    context = view2.getLayoutParams();
                    context.height = n13 = view.width;
                    context = view2.getLayoutParams();
                    view2.setLayoutParams((ViewGroup.LayoutParams)context);
                    int n15 = view.width / n12;
                    int n16 = view.height / n12;
                    f12 = n15 -= n16;
                    view2.setTranslationX(f12);
                    n15 = -n15;
                    float f14 = n15;
                    view2.setTranslationY(f14);
                }
            }
        }
    }

    public static /* synthetic */ s6 u(d1 d12) {
        return d12.h;
    }

    public static /* synthetic */ KeyFunc v(d1 d12) {
        return d12.j;
    }

    public static /* synthetic */ KeyFunc w(d1 d12, KeyFunc keyFunc) {
        d12.j = keyFunc;
        return keyFunc;
    }

    public static /* synthetic */ BleViewModel x(d1 d12) {
        return d12.i;
    }

    public static /* synthetic */ u6 y(d1 d12) {
        return d12.g;
    }

    public void onResume() {
        Context context;
        super.onResume();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11 && (context = this.getContext()) != null && (context = this.getDialog()) != null && (context = this.getDialog().getWindow()) != null) {
            int n12;
            context = this.getDialog().getWindow();
            WindowManager.LayoutParams layoutParams = context.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = n12 = 1;
            context.setAttributes(layoutParams);
        }
        this.B();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        this.setCancelable(false);
        object = b.c(this.requireActivity());
        object2 = (u6)((ViewModelProvider)object).get(u6.class);
        this.g = object2;
        object2 = (s6)((ViewModelProvider)object).get(s6.class);
        this.h = object2;
        this.i = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        object = this.f;
        object2 = this.h;
        ((f1)object).A((s6)object2);
        this.z();
    }

    public void p(int n10) {
        super.p(n10);
        this.B();
    }

    public int s() {
        return 2131558469;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (f1)viewDataBinding;
        this.f = viewDataBinding;
        d1$a d1$a = new d1$a(this);
        ((f1)viewDataBinding).B(d1$a);
    }

    public void z() {
        ViewModel viewModel = this.h;
        int n10 = 1;
        ((s6)viewModel).U(n10);
        this.h.T(n10);
        this.h.N(n10);
        this.h.K(false);
        viewModel = this.i;
        KeyFunc keyFunc = KeyFunc.NONE;
        ((BleViewModel)viewModel).m1(keyFunc);
    }
}

