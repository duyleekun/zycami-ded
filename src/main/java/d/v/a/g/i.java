/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.a.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.AccountMainFragment$b;

public abstract class i
extends ViewDataBinding {
    public final ImageView a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final TextView i;
    public final TextView j;
    public final VideoView k;
    public AccountMainFragment$b l;

    public i(Object object, View view, int n10, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, VideoView videoView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
        this.i = textView;
        this.j = textView2;
        this.k = videoView;
    }

    public static i s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.i.t(view, dataBindingComponent);
    }

    public static i t(View view, Object object) {
        int n10 = R$layout.me_account_main_frag;
        return (i)ViewDataBinding.bind(object, view, n10);
    }

    public static i v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.i.y(layoutInflater, dataBindingComponent);
    }

    public static i w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d.v.a.g.i.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static i x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.me_account_main_frag;
        return (i)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static i y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.me_account_main_frag;
        return (i)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public AccountMainFragment$b u() {
        return this.l;
    }

    public abstract void z(AccountMainFragment$b var1);
}

