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
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.filter.EditorFilterFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.e1.u;
import d.v.c.w0.b5;
import d.v.c.w0.j4;

public abstract class p6
extends ViewDataBinding {
    public final j4 a;
    public final b5 b;
    public final BaseResourceListView c;
    public final NoOffsetSeekBar d;
    public final StatusView e;
    public final TextView f;
    public u g;
    public EditorFilterFragment$a h;

    public p6(Object object, View view, int n10, j4 j42, b5 b52, BaseResourceListView baseResourceListView, NoOffsetSeekBar noOffsetSeekBar, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = j42;
        this.b = b52;
        this.c = baseResourceListView;
        this.d = noOffsetSeekBar;
        this.e = statusView;
        this.f = textView;
    }

    public static p6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p6.t(view, dataBindingComponent);
    }

    public static p6 t(View view, Object object) {
        return (p6)ViewDataBinding.bind(object, view, 2131558569);
    }

    public static p6 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p6.z(layoutInflater, dataBindingComponent);
    }

    public static p6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return p6.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static p6 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (p6)ViewDataBinding.inflateInternal(layoutInflater, 2131558569, viewGroup, bl2, object);
    }

    public static p6 z(LayoutInflater layoutInflater, Object object) {
        return (p6)ViewDataBinding.inflateInternal(layoutInflater, 2131558569, null, false, object);
    }

    public abstract void A(EditorFilterFragment$a var1);

    public abstract void B(u var1);

    public EditorFilterFragment$a u() {
        return this.h;
    }

    public u v() {
        return this.g;
    }
}

