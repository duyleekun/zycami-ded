/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.MyDeviceFragment$c;
import d.v.c.q1.g0;

public abstract class uf
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final ImageView d;
    public final RecyclerView e;
    public final Button f;
    public final StatusView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final View k;
    public MyDeviceFragment$c l;
    public g0 m;
    public DeviceBindViewModel n;

    public uf(Object object, View view, int n10, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, Button button, StatusView statusView, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = recyclerView;
        this.f = button;
        this.g = statusView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = view2;
    }

    public static uf A(LayoutInflater layoutInflater, Object object) {
        return (uf)ViewDataBinding.inflateInternal(layoutInflater, 2131558718, null, false, object);
    }

    public static uf s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uf.t(view, dataBindingComponent);
    }

    public static uf t(View view, Object object) {
        return (uf)ViewDataBinding.bind(object, view, 2131558718);
    }

    public static uf x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uf.A(layoutInflater, dataBindingComponent);
    }

    public static uf y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return uf.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static uf z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (uf)ViewDataBinding.inflateInternal(layoutInflater, 2131558718, viewGroup, bl2, object);
    }

    public abstract void B(DeviceBindViewModel var1);

    public abstract void C(MyDeviceFragment$c var1);

    public abstract void D(g0 var1);

    public DeviceBindViewModel u() {
        return this.n;
    }

    public MyDeviceFragment$c v() {
        return this.l;
    }

    public g0 w() {
        return this.m;
    }
}

