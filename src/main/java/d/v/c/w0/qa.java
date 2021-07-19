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
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class qa
extends ViewDataBinding {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;

    public qa(Object object, View view, int n10, ImageView imageView, ImageView imageView2, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageView2;
        this.c = textView;
    }

    public static qa s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qa.t(view, dataBindingComponent);
    }

    public static qa t(View view, Object object) {
        return (qa)ViewDataBinding.bind(object, view, 2131558626);
    }

    public static qa u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qa.x(layoutInflater, dataBindingComponent);
    }

    public static qa v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qa.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qa w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qa)ViewDataBinding.inflateInternal(layoutInflater, 2131558626, viewGroup, bl2, object);
    }

    public static qa x(LayoutInflater layoutInflater, Object object) {
        return (qa)ViewDataBinding.inflateInternal(layoutInflater, 2131558626, null, false, object);
    }
}

