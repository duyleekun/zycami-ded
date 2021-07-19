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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.publish.UploadWorksFragment$a;
import d.v.c.n1.l2;

public abstract class mi
extends ViewDataBinding {
    public final ImageView a;
    public final ProgressBar b;
    public final RecyclerView c;
    public final TextView d;
    public final TextView e;
    public ObservableBoolean f;
    public l2 g;
    public UploadWorksFragment$a h;

    public mi(Object object, View view, int n10, ImageView imageView, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = progressBar;
        this.c = recyclerView;
        this.d = textView;
        this.e = textView2;
    }

    public static mi A(LayoutInflater layoutInflater, Object object) {
        return (mi)ViewDataBinding.inflateInternal(layoutInflater, 2131558805, null, false, object);
    }

    public static mi s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mi.t(view, dataBindingComponent);
    }

    public static mi t(View view, Object object) {
        return (mi)ViewDataBinding.bind(object, view, 2131558805);
    }

    public static mi x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mi.A(layoutInflater, dataBindingComponent);
    }

    public static mi y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return mi.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static mi z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (mi)ViewDataBinding.inflateInternal(layoutInflater, 2131558805, viewGroup, bl2, object);
    }

    public abstract void B(ObservableBoolean var1);

    public abstract void C(UploadWorksFragment$a var1);

    public abstract void D(l2 var1);

    public ObservableBoolean u() {
        return this.f;
    }

    public UploadWorksFragment$a v() {
        return this.h;
    }

    public l2 w() {
        return this.g;
    }
}

