/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class gb
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final TextView d;

    public gb(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = constraintLayout;
        this.d = textView;
    }

    public static gb s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gb.t(view, dataBindingComponent);
    }

    public static gb t(View view, Object object) {
        return (gb)ViewDataBinding.bind(object, view, 2131558634);
    }

    public static gb u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gb.x(layoutInflater, dataBindingComponent);
    }

    public static gb v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gb.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static gb w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gb)ViewDataBinding.inflateInternal(layoutInflater, 2131558634, viewGroup, bl2, object);
    }

    public static gb x(LayoutInflater layoutInflater, Object object) {
        return (gb)ViewDataBinding.inflateInternal(layoutInflater, 2131558634, null, false, object);
    }
}

