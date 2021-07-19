/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class oa
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ImageButton b;
    public final TextView c;

    public oa(Object object, View view, int n10, ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = imageButton;
        this.c = textView;
    }

    public static oa s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oa.t(view, dataBindingComponent);
    }

    public static oa t(View view, Object object) {
        return (oa)ViewDataBinding.bind(object, view, 2131558625);
    }

    public static oa u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oa.x(layoutInflater, dataBindingComponent);
    }

    public static oa v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return oa.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static oa w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (oa)ViewDataBinding.inflateInternal(layoutInflater, 2131558625, viewGroup, bl2, object);
    }

    public static oa x(LayoutInflater layoutInflater, Object object) {
        return (oa)ViewDataBinding.inflateInternal(layoutInflater, 2131558625, null, false, object);
    }
}

