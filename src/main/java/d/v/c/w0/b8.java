/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$d;

public abstract class b8
extends ViewDataBinding {
    public final ImageView a;
    public final ConstraintLayout b;
    public final LinearLayout c;
    public final SwipeRefreshLayout d;
    public final TabLayout e;
    public final ViewPager f;
    public EditorTemplateListFragment$d g;

    public b8(Object object, View view, int n10, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout, SwipeRefreshLayout swipeRefreshLayout, TabLayout tabLayout, ViewPager viewPager) {
        super(object, view, n10);
        this.a = imageView;
        this.b = constraintLayout;
        this.c = linearLayout;
        this.d = swipeRefreshLayout;
        this.e = tabLayout;
        this.f = viewPager;
    }

    public static b8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b8.t(view, dataBindingComponent);
    }

    public static b8 t(View view, Object object) {
        return (b8)ViewDataBinding.bind(object, view, 2131558588);
    }

    public static b8 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b8.y(layoutInflater, dataBindingComponent);
    }

    public static b8 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b8.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b8)ViewDataBinding.inflateInternal(layoutInflater, 2131558588, viewGroup, bl2, object);
    }

    public static b8 y(LayoutInflater layoutInflater, Object object) {
        return (b8)ViewDataBinding.inflateInternal(layoutInflater, 2131558588, null, false, object);
    }

    public EditorTemplateListFragment$d u() {
        return this.g;
    }

    public abstract void z(EditorTemplateListFragment$d var1);
}

