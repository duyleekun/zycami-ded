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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity$e;

public abstract class ii
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public EditorTemplateEditActivity$e d;

    public ii(Object object, View view, int n10, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static ii s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ii.t(view, dataBindingComponent);
    }

    public static ii t(View view, Object object) {
        return (ii)ViewDataBinding.bind(object, view, 2131558795);
    }

    public static ii v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ii.y(layoutInflater, dataBindingComponent);
    }

    public static ii w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ii.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ii x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ii)ViewDataBinding.inflateInternal(layoutInflater, 2131558795, viewGroup, bl2, object);
    }

    public static ii y(LayoutInflater layoutInflater, Object object) {
        return (ii)ViewDataBinding.inflateInternal(layoutInflater, 2131558795, null, false, object);
    }

    public EditorTemplateEditActivity$e u() {
        return this.d;
    }

    public abstract void z(EditorTemplateEditActivity$e var1);
}

