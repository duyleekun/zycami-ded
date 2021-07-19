/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.album.AlbumInfoDialog$a;
import com.zhiyun.cama.album.AlbumSection;

public abstract class d3
extends ViewDataBinding {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public String h;
    public Boolean i;
    public AlbumSection j;
    public AlbumInfoDialog.a k;

    public d3(Object object, View view, int n10, TextView textView, TextView textView2, TextView textView3, View view2, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view, n10);
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = view2;
        this.e = textView4;
        this.f = textView5;
        this.g = textView6;
    }

    public static d3 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d3)ViewDataBinding.inflateInternal(layoutInflater, 2131558512, viewGroup, bl2, object);
    }

    public static d3 B(LayoutInflater layoutInflater, Object object) {
        return (d3)ViewDataBinding.inflateInternal(layoutInflater, 2131558512, null, false, object);
    }

    public static d3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d3.t(view, dataBindingComponent);
    }

    public static d3 t(View view, Object object) {
        return (d3)ViewDataBinding.bind(object, view, 2131558512);
    }

    public static d3 y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d3.B(layoutInflater, dataBindingComponent);
    }

    public static d3 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d3.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(AlbumInfoDialog.a var1);

    public abstract void D(String var1);

    public abstract void E(Boolean var1);

    public abstract void F(AlbumSection var1);

    public AlbumInfoDialog.a u() {
        return this.k;
    }

    public String v() {
        return this.h;
    }

    public Boolean w() {
        return this.i;
    }

    public AlbumSection x() {
        return this.j;
    }
}

