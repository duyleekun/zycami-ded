/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.g0.t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.common.widget.RotateTextView;
import com.zhiyun.ui.R$layout;

public abstract class i
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final RotateTextView b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public Integer g;

    public i(Object object, View view, int n10, ConstraintLayout constraintLayout, RotateTextView rotateTextView, View view2, View view3, View view4, View view5) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = rotateTextView;
        this.c = view2;
        this.d = view3;
        this.e = view4;
        this.f = view5;
    }

    public static i s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i.t(view, dataBindingComponent);
    }

    public static i t(View view, Object object) {
        int n10 = R$layout.zyui_pop_guide_layout;
        return (i)ViewDataBinding.bind(object, view, n10);
    }

    public static i v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i.y(layoutInflater, dataBindingComponent);
    }

    public static i w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static i x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        int n10 = R$layout.zyui_pop_guide_layout;
        return (i)ViewDataBinding.inflateInternal(layoutInflater, n10, viewGroup, bl2, object);
    }

    public static i y(LayoutInflater layoutInflater, Object object) {
        int n10 = R$layout.zyui_pop_guide_layout;
        return (i)ViewDataBinding.inflateInternal(layoutInflater, n10, null, false, object);
    }

    public Integer u() {
        return this.g;
    }

    public abstract void z(Integer var1);
}

