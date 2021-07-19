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

public abstract class ib
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final TextView d;

    public ib(Object object, View view, int n10, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = constraintLayout;
        this.d = textView;
    }

    public static ib s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ib.t(view, dataBindingComponent);
    }

    public static ib t(View view, Object object) {
        return (ib)ViewDataBinding.bind(object, view, 2131558635);
    }

    public static ib u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ib.x(layoutInflater, dataBindingComponent);
    }

    public static ib v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ib.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ib w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ib)ViewDataBinding.inflateInternal(layoutInflater, 2131558635, viewGroup, bl2, object);
    }

    public static ib x(LayoutInflater layoutInflater, Object object) {
        return (ib)ViewDataBinding.inflateInternal(layoutInflater, 2131558635, null, false, object);
    }
}

