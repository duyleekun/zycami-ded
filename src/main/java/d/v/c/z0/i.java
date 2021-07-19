/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.z0;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.c.i0;
import d.v.c.i0$b;
import d.v.c.w0.b4;
import d.v.c.z0.e;
import d.v.c.z0.i$a;
import d.v.c.z0.i$b;
import d.v.c.z0.i$c;
import d.v.c.z0.k;
import d.v.c.z0.k$b;
import d.v.f.g.a;
import d.v.f.i.g;

public class i
extends a {
    private b4 f;
    private k g;
    private i$c h;
    private i0$b i;

    private void A() {
        Object object = new i$a(this);
        this.i = object;
        object = i0.e();
        i0$b i0$b = this.i;
        ((i0)object).b(i0$b);
    }

    private void B() {
        i0.e().E();
    }

    public static /* synthetic */ boolean C(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        n11 = n10 == n11 ? 1 : 0;
        return n11 != 0;
    }

    private void D() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            this.getDialog().setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            Object object = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)object);
            WindowManager.LayoutParams layoutParams = dialog.getAttributes();
            layoutParams.width = n10 = -1;
            layoutParams.height = n10;
            dialog.setAttributes(layoutParams);
            layoutParams = this.getDialog();
            object = e.a;
            layoutParams.setOnKeyListener((DialogInterface.OnKeyListener)object);
            StatusBarUtil.v((Window)dialog);
        }
    }

    private void F() {
        boolean bl2;
        k k10 = this.g;
        if (k10 != null && !(bl2 = k10.isVisible())) {
            k10 = this.g;
            FragmentManager fragmentManager = this.getChildFragmentManager();
            k10.q(fragmentManager);
        }
    }

    public static /* synthetic */ b4 u(i i10) {
        return i10.f;
    }

    public static /* synthetic */ k v(i i10) {
        return i10.g;
    }

    public static /* synthetic */ i$c w(i i10) {
        return i10.h;
    }

    public static /* synthetic */ void x(i i10) {
        i10.B();
    }

    public static /* synthetic */ void y(i i10) {
        i10.F();
    }

    private void z() {
        Object object = new k$b();
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131952831);
        object = ((k$b)object).J(string2);
        string2 = d.v.f.i.g.m(this.requireContext(), 2131952830);
        object = ((k$b)object).y(string2).M(0x800003);
        string2 = d.v.f.i.g.m(this.requireContext(), 2131952804);
        this.g = object = ((k$b)object).H(string2, true, null).B(false).v();
    }

    public void E(i$c i$c) {
        this.h = i$c;
    }

    public void onDestroy() {
        super.onDestroy();
        i0 i02 = i0.e();
        i0$b i0$b = this.i;
        i02.C(i0$b);
    }

    public void onStart() {
        super.onStart();
        this.D();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.z();
        this.A();
        this.B();
    }

    public int s() {
        return 2131558525;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (b4)viewDataBinding;
        this.f = viewDataBinding;
        i$b i$b = new i$b(this);
        ((b4)viewDataBinding).z(i$b);
    }
}

