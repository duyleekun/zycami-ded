/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class v2
extends ViewDataBinding {
    public final FrameLayout a;
    public final ImageButton b;
    public final Button c;
    public final TextView d;

    public v2(Object object, View view, int n10, FrameLayout frameLayout, ImageButton imageButton, Button button, TextView textView) {
        super(object, view, n10);
        this.a = frameLayout;
        this.b = imageButton;
        this.c = button;
        this.d = textView;
    }

    public static v2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v2.t(view, dataBindingComponent);
    }

    public static v2 t(View view, Object object) {
        return (v2)ViewDataBinding.bind(object, view, 2131558491);
    }

    public static v2 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v2.x(layoutInflater, dataBindingComponent);
    }

    public static v2 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v2.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static v2 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v2)ViewDataBinding.inflateInternal(layoutInflater, 2131558491, viewGroup, bl2, object);
    }

    public static v2 x(LayoutInflater layoutInflater, Object object) {
        return (v2)ViewDataBinding.inflateInternal(layoutInflater, 2131558491, null, false, object);
    }
}

