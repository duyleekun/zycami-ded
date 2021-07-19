/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.speed.EditorSpeedFragment$b;
import com.zhiyun.cama.widget.CurveView;
import d.v.c.s1.u;
import d.v.c.w0.b5;
import d.v.c.w0.j4;

public abstract class t7
extends ViewDataBinding {
    public final j4 a;
    public final CurveView b;
    public final b5 c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public EditorSpeedFragment$b i;
    public u j;

    public t7(Object object, View view, int n10, j4 j42, CurveView curveView, b5 b52, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, n10);
        this.a = j42;
        this.b = curveView;
        this.c = b52;
        this.d = recyclerView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static t7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t7.t(view, dataBindingComponent);
    }

    public static t7 t(View view, Object object) {
        return (t7)ViewDataBinding.bind(object, view, 2131558584);
    }

    public static t7 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t7.z(layoutInflater, dataBindingComponent);
    }

    public static t7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t7.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t7 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t7)ViewDataBinding.inflateInternal(layoutInflater, 2131558584, viewGroup, bl2, object);
    }

    public static t7 z(LayoutInflater layoutInflater, Object object) {
        return (t7)ViewDataBinding.inflateInternal(layoutInflater, 2131558584, null, false, object);
    }

    public abstract void A(EditorSpeedFragment$b var1);

    public abstract void B(u var1);

    public EditorSpeedFragment$b u() {
        return this.i;
    }

    public u v() {
        return this.j;
    }
}

