/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment$a;
import d.v.c.w0.j4;
import d.v.c.x0.c.b;

public abstract class j8
extends ViewDataBinding {
    public final j4 a;
    public final TabLayout b;
    public final ViewPager c;
    public b d;
    public EditorTextMainFragment$a e;

    public j8(Object object, View view, int n10, j4 j42, TabLayout tabLayout, ViewPager viewPager) {
        super(object, view, n10);
        this.a = j42;
        this.b = tabLayout;
        this.c = viewPager;
    }

    public static j8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j8.t(view, dataBindingComponent);
    }

    public static j8 t(View view, Object object) {
        return (j8)ViewDataBinding.bind(object, view, 2131558592);
    }

    public static j8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j8.z(layoutInflater, dataBindingComponent);
    }

    public static j8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return j8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static j8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (j8)ViewDataBinding.inflateInternal(layoutInflater, 2131558592, viewGroup, bl2, object);
    }

    public static j8 z(LayoutInflater layoutInflater, Object object) {
        return (j8)ViewDataBinding.inflateInternal(layoutInflater, 2131558592, null, false, object);
    }

    public abstract void A(EditorTextMainFragment$a var1);

    public abstract void B(b var1);

    public EditorTextMainFragment$a u() {
        return this.e;
    }

    public b v() {
        return this.d;
    }
}

