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
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment$b;
import d.v.c.d1.h;
import d.v.c.w0.j4;

public abstract class x8
extends ViewDataBinding {
    public final j4 a;
    public final RecyclerView b;
    public final StatusView c;
    public h d;
    public EditorTemplateEndingFragment$b e;

    public x8(Object object, View view, int n10, j4 j42, RecyclerView recyclerView, StatusView statusView) {
        super(object, view, n10);
        this.a = j42;
        this.b = recyclerView;
        this.c = statusView;
    }

    public static x8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x8.t(view, dataBindingComponent);
    }

    public static x8 t(View view, Object object) {
        return (x8)ViewDataBinding.bind(object, view, 2131558599);
    }

    public static x8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x8.z(layoutInflater, dataBindingComponent);
    }

    public static x8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return x8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static x8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (x8)ViewDataBinding.inflateInternal(layoutInflater, 2131558599, viewGroup, bl2, object);
    }

    public static x8 z(LayoutInflater layoutInflater, Object object) {
        return (x8)ViewDataBinding.inflateInternal(layoutInflater, 2131558599, null, false, object);
    }

    public abstract void A(EditorTemplateEndingFragment$b var1);

    public abstract void B(h var1);

    public EditorTemplateEndingFragment$b u() {
        return this.e;
    }

    public h v() {
        return this.d;
    }
}

