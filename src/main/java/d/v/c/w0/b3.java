/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog$a;
import d.v.c.o0.u0;

public abstract class b3
extends ViewDataBinding {
    public final TextView a;
    public final View b;
    public final View c;
    public final View d;
    public final TextView e;
    public final ProgressBar f;
    public final TextView g;
    public u0 h;
    public AlbumDeleteConfirmDialog.a i;

    public b3(Object object, View view, int n10, TextView textView, View view2, View view3, View view4, TextView textView2, ProgressBar progressBar, TextView textView3) {
        super(object, view, n10);
        this.a = textView;
        this.b = view2;
        this.c = view3;
        this.d = view4;
        this.e = textView2;
        this.f = progressBar;
        this.g = textView3;
    }

    public static b3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b3.t(view, dataBindingComponent);
    }

    public static b3 t(View view, Object object) {
        return (b3)ViewDataBinding.bind(object, view, 2131558511);
    }

    public static b3 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b3.z(layoutInflater, dataBindingComponent);
    }

    public static b3 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b3.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b3 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b3)ViewDataBinding.inflateInternal(layoutInflater, 2131558511, viewGroup, bl2, object);
    }

    public static b3 z(LayoutInflater layoutInflater, Object object) {
        return (b3)ViewDataBinding.inflateInternal(layoutInflater, 2131558511, null, false, object);
    }

    public abstract void A(AlbumDeleteConfirmDialog.a var1);

    public abstract void B(u0 var1);

    public AlbumDeleteConfirmDialog.a u() {
        return this.i;
    }

    public u0 v() {
        return this.h;
    }
}

