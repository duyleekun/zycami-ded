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
import androidx.fragment.app.FragmentContainerView;
import com.zhiyun.cama.help.EditorHelpActivity$a;
import d.v.c.w0.ui;

public abstract class i
extends ViewDataBinding {
    public final FragmentContainerView a;
    public final ui b;
    public EditorHelpActivity$a c;

    public i(Object object, View view, int n10, FragmentContainerView fragmentContainerView, ui ui2) {
        super(object, view, n10);
        this.a = fragmentContainerView;
        this.b = ui2;
    }

    public static i s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return i.t(view, dataBindingComponent);
    }

    public static i t(View view, Object object) {
        return (i)ViewDataBinding.bind(object, view, 2131558434);
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
        return (i)ViewDataBinding.inflateInternal(layoutInflater, 2131558434, viewGroup, bl2, object);
    }

    public static i y(LayoutInflater layoutInflater, Object object) {
        return (i)ViewDataBinding.inflateInternal(layoutInflater, 2131558434, null, false, object);
    }

    public EditorHelpActivity$a u() {
        return this.c;
    }

    public abstract void z(EditorHelpActivity$a var1);
}

