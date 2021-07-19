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
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.widget.SideBar;
import com.zhiyun.account.me.country.CountryChooseActivity$b;

public abstract class o
extends ViewDataBinding {
    public final ImageView a;
    public final RecyclerView b;
    public final SideBar c;
    public final TextView d;
    public CountryChooseActivity$b e;
    public boolean f;

    public o(Object object, View view, int n10, ImageView imageView, RecyclerView recyclerView, SideBar sideBar, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = recyclerView;
        this.c = sideBar;
        this.d = textView;
    }

    public static o s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return o.t(view, dataBindingComponent);
    }

    public static o t(View view, Object object) {
        int n10 = R$layout.me_country_act;
        return (o)ViewDataBinding.bind(object, view, n10);
    }

    public static o w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return o.z(layoutInflater, dataBindingComponent);
    }

    public static o x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return o.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static o y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_country_act;
        return (o)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static o z(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_country_act;
        return (o)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public abstract void A(CountryChooseActivity$b var1);

    public abstract void B(boolean var1);

    public CountryChooseActivity$b u() {
        return this.e;
    }

    public boolean v() {
        return this.f;
    }
}

