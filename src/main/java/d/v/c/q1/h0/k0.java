/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.q1.h0;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import d.v.c.q1.h0.k0$a;
import d.v.c.q1.h0.k0$b;
import d.v.c.w0.h3;
import d.v.e.l.h2;
import d.v.e0.td;
import d.v.f.g.c;
import d.v.i0.b;

public class k0
extends c {
    private static td g;
    private DeviceBindViewModel e;
    private k0$b f;

    public static /* synthetic */ DeviceBindViewModel s(k0 k02) {
        return k02.e;
    }

    public static /* synthetic */ k0$b t(k0 k02) {
        return k02.f;
    }

    public static k0 u(td object) {
        g = object;
        object = new k0();
        return object;
    }

    private void v() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            int n10;
            int n11;
            this.getDialog().setCanceledOnTouchOutside(false);
            dialog = this.getDialog().getWindow();
            dialog.getDecorView().setPadding(0, 0, 0, 0);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            WindowManager.LayoutParams layoutParams = dialog.getAttributes();
            layoutParams.gravity = 17;
            float f10 = 300.0f;
            layoutParams.width = n11 = h2.b(f10);
            layoutParams.height = n10 = h2.b(f10);
            dialog.setAttributes(layoutParams);
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (DeviceBindViewModel)b.c(this.requireActivity()).get(DeviceBindViewModel.class);
        this.e = object;
    }

    public View onCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        object = (h3)DataBindingUtil.inflate((LayoutInflater)object, 2131558514, object2, false);
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object2 = new k0$a(this);
        ((h3)object).A((k0$a)object2);
        object2 = g;
        ((h3)object).B((td)object2);
        return ((ViewDataBinding)object).getRoot();
    }

    public void onResume() {
        super.onResume();
        this.v();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.setCancelable(false);
    }

    public void w(k0$b k0$b) {
        this.f = k0$b;
    }
}

