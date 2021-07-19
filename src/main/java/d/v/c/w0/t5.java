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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.zhiyun.cama.album.AlbumDetailFragment$c;

public abstract class t5
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final TextView f;
    public final View g;
    public final ViewPager2 h;
    public ObservableField i;
    public ObservableBoolean j;
    public AlbumDetailFragment.c k;

    public t5(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, View view2, ViewPager2 viewPager2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = textView;
        this.g = view2;
        this.h = viewPager2;
    }

    public static t5 A(LayoutInflater layoutInflater, Object object) {
        return (t5)ViewDataBinding.inflateInternal(layoutInflater, 2131558558, null, false, object);
    }

    public static t5 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t5.t(view, dataBindingComponent);
    }

    public static t5 t(View view, Object object) {
        return (t5)ViewDataBinding.bind(object, view, 2131558558);
    }

    public static t5 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t5.A(layoutInflater, dataBindingComponent);
    }

    public static t5 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t5.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t5 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t5)ViewDataBinding.inflateInternal(layoutInflater, 2131558558, viewGroup, bl2, object);
    }

    public abstract void B(AlbumDetailFragment.c var1);

    public abstract void C(ObservableBoolean var1);

    public abstract void D(ObservableField var1);

    public AlbumDetailFragment.c u() {
        return this.k;
    }

    public ObservableBoolean v() {
        return this.j;
    }

    public ObservableField w() {
        return this.i;
    }
}

