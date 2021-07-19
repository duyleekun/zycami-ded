/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.s0.d7.z;

public abstract class wd
extends ViewDataBinding {
    public final CheckBox a;
    public final RecyclerView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public CameraFragment$j h;
    public z i;

    public wd(Object object, View view, int n10, CheckBox checkBox, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = recyclerView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
    }

    public static wd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wd.t(view, dataBindingComponent);
    }

    public static wd t(View view, Object object) {
        return (wd)ViewDataBinding.bind(object, view, 2131558676);
    }

    public static wd w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wd.z(layoutInflater, dataBindingComponent);
    }

    public static wd x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return wd.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static wd y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (wd)ViewDataBinding.inflateInternal(layoutInflater, 2131558676, viewGroup, bl2, object);
    }

    public static wd z(LayoutInflater layoutInflater, Object object) {
        return (wd)ViewDataBinding.inflateInternal(layoutInflater, 2131558676, null, false, object);
    }

    public abstract void A(CameraFragment$j var1);

    public abstract void B(z var1);

    public CameraFragment$j u() {
        return this.h;
    }

    public z v() {
        return this.i;
    }
}

