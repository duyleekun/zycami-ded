/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout;
import com.zhiyun.cama.cloud_engine.CETemplateFragment$b;

public abstract class p2
extends ViewDataBinding {
    public final ImageView a;
    public final TextView b;
    public final RecyclerView c;
    public final CEPullToRefreshLayout d;
    public final TextView e;
    public final TextView f;
    public ObservableField g;
    public CETemplateFragment.b h;

    public p2(Object object, View view, int n10, ImageView imageView, TextView textView, RecyclerView recyclerView, CEPullToRefreshLayout cEPullToRefreshLayout, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = imageView;
        this.b = textView;
        this.c = recyclerView;
        this.d = cEPullToRefreshLayout;
        this.e = textView2;
        this.f = textView3;
    }

    public static p2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p2.t(view, dataBindingComponent);
    }

    public static p2 t(View view, Object object) {
        return (p2)ViewDataBinding.bind(object, view, 2131558488);
    }

    public static p2 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p2.z(layoutInflater, dataBindingComponent);
    }

    public static p2 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p2.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p2 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p2)ViewDataBinding.inflateInternal(layoutInflater, 2131558488, viewGroup, bl2, object);
    }

    public static p2 z(LayoutInflater layoutInflater, Object object) {
        return (p2)ViewDataBinding.inflateInternal(layoutInflater, 2131558488, null, false, object);
    }

    public abstract void A(CETemplateFragment.b var1);

    public abstract void B(ObservableField var1);

    public CETemplateFragment.b u() {
        return this.h;
    }

    public ObservableField v() {
        return this.g;
    }
}

