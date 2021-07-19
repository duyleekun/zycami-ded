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
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.e1.u;
import d.v.c.w0.j4;

public abstract class z8
extends ViewDataBinding {
    public final j4 a;
    public final BaseResourceListView b;
    public final NoOffsetSeekBar c;
    public final StatusView d;
    public final TextView e;
    public u f;
    public EditorTemplateFilterFragment$a g;

    public z8(Object object, View view, int n10, j4 j42, BaseResourceListView baseResourceListView, NoOffsetSeekBar noOffsetSeekBar, StatusView statusView, TextView textView) {
        super(object, view, n10);
        this.a = j42;
        this.b = baseResourceListView;
        this.c = noOffsetSeekBar;
        this.d = statusView;
        this.e = textView;
    }

    public static z8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z8.t(view, dataBindingComponent);
    }

    public static z8 t(View view, Object object) {
        return (z8)ViewDataBinding.bind(object, view, 2131558600);
    }

    public static z8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z8.z(layoutInflater, dataBindingComponent);
    }

    public static z8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return z8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static z8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (z8)ViewDataBinding.inflateInternal(layoutInflater, 2131558600, viewGroup, bl2, object);
    }

    public static z8 z(LayoutInflater layoutInflater, Object object) {
        return (z8)ViewDataBinding.inflateInternal(layoutInflater, 2131558600, null, false, object);
    }

    public abstract void A(EditorTemplateFilterFragment$a var1);

    public abstract void B(u var1);

    public EditorTemplateFilterFragment$a u() {
        return this.g;
    }

    public u v() {
        return this.f;
    }
}

