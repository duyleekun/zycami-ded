/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.transition.EditorTransitionFragment$a;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.v1.o;
import d.v.c.w0.j4;

public abstract class n8
extends ViewDataBinding {
    public final j4 a;
    public final ConstraintLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final BaseResourceListView g;
    public final StatusView h;
    public o i;
    public EditorTransitionFragment$a j;

    public n8(Object object, View view, int n10, j4 j42, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, BaseResourceListView baseResourceListView, StatusView statusView) {
        super(object, view, n10);
        this.a = j42;
        this.b = constraintLayout;
        this.c = frameLayout;
        this.d = frameLayout2;
        this.e = frameLayout3;
        this.f = frameLayout4;
        this.g = baseResourceListView;
        this.h = statusView;
    }

    public static n8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n8.t(view, dataBindingComponent);
    }

    public static n8 t(View view, Object object) {
        return (n8)ViewDataBinding.bind(object, view, 2131558594);
    }

    public static n8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n8.z(layoutInflater, dataBindingComponent);
    }

    public static n8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return n8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static n8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (n8)ViewDataBinding.inflateInternal(layoutInflater, 2131558594, viewGroup, bl2, object);
    }

    public static n8 z(LayoutInflater layoutInflater, Object object) {
        return (n8)ViewDataBinding.inflateInternal(layoutInflater, 2131558594, null, false, object);
    }

    public abstract void A(EditorTransitionFragment$a var1);

    public abstract void B(o var1);

    public EditorTransitionFragment$a u() {
        return this.j;
    }

    public o v() {
        return this.i;
    }
}

