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
import com.zhiyun.cama.sort.EditorSortFragment$b;
import d.v.c.w0.j4;

public abstract class r7
extends ViewDataBinding {
    public final j4 a;
    public final RecyclerView b;
    public EditorSortFragment$b c;

    public r7(Object object, View view, int n10, j4 j42, RecyclerView recyclerView) {
        super(object, view, n10);
        this.a = j42;
        this.b = recyclerView;
    }

    public static r7 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r7.t(view, dataBindingComponent);
    }

    public static r7 t(View view, Object object) {
        return (r7)ViewDataBinding.bind(object, view, 2131558583);
    }

    public static r7 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r7.y(layoutInflater, dataBindingComponent);
    }

    public static r7 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r7.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r7 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r7)ViewDataBinding.inflateInternal(layoutInflater, 2131558583, viewGroup, bl2, object);
    }

    public static r7 y(LayoutInflater layoutInflater, Object object) {
        return (r7)ViewDataBinding.inflateInternal(layoutInflater, 2131558583, null, false, object);
    }

    public EditorSortFragment$b u() {
        return this.c;
    }

    public abstract void z(EditorSortFragment$b var1);
}

