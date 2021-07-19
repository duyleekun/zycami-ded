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

public abstract class gi
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public EditorTemplateEditActivity$e e;

    public gi(Object object, View view, int n10, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    public static gi s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gi.t(view, dataBindingComponent);
    }

    public static gi t(View view, Object object) {
        return (gi)ViewDataBinding.bind(object, view, 2131558794);
    }

    public static gi v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gi.y(layoutInflater, dataBindingComponent);
    }

    public static gi w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gi.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static gi x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gi)ViewDataBinding.inflateInternal(layoutInflater, 2131558794, viewGroup, bl2, object);
    }

    public static gi y(LayoutInflater layoutInflater, Object object) {
        return (gi)ViewDataBinding.inflateInternal(layoutInflater, 2131558794, null, false, object);
    }

    public EditorTemplateEditActivity$e u() {
        return this.e;
    }

    public abstract void z(EditorTemplateEditActivity$e var1);
}

