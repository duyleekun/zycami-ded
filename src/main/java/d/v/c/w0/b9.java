/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.device.firmware.FirmwareUpgradeFragment$b;
import d.v.c.y0.c.o;

public abstract class b9
extends ViewDataBinding {
    public final ImageView a;
    public final ProgressBar b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final View k;
    public String l;
    public FirmwareUpgradeFragment$b m;
    public o n;

    public b9(Object object, View view, int n10, ImageView imageView, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = progressBar;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = view2;
    }

    public static b9 A(LayoutInflater layoutInflater, Object object) {
        return (b9)ViewDataBinding.inflateInternal(layoutInflater, 2131558601, null, false, object);
    }

    public static b9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b9.t(view, dataBindingComponent);
    }

    public static b9 t(View view, Object object) {
        return (b9)ViewDataBinding.bind(object, view, 2131558601);
    }

    public static b9 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b9.A(layoutInflater, dataBindingComponent);
    }

    public static b9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b9.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b9 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b9)ViewDataBinding.inflateInternal(layoutInflater, 2131558601, viewGroup, bl2, object);
    }

    public abstract void B(FirmwareUpgradeFragment$b var1);

    public abstract void C(String var1);

    public abstract void D(o var1);

    public FirmwareUpgradeFragment$b u() {
        return this.m;
    }

    public String v() {
        return this.l;
    }

    public o w() {
        return this.n;
    }
}

