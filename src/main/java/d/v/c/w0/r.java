/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.l1.x$b;

public abstract class r
extends ViewDataBinding {
    public final Button a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final Button f;
    public final Button g;
    public x$b h;

    public r(Object object, View view, int n10, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7) {
        super(object, view, n10);
        this.a = button;
        this.b = button2;
        this.c = button3;
        this.d = button4;
        this.e = button5;
        this.f = button6;
        this.g = button7;
    }

    public static r s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r.t(view, dataBindingComponent);
    }

    public static r t(View view, Object object) {
        return (r)ViewDataBinding.bind(object, view, 2131558444);
    }

    public static r v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r.y(layoutInflater, dataBindingComponent);
    }

    public static r w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r)ViewDataBinding.inflateInternal(layoutInflater, 2131558444, viewGroup, bl2, object);
    }

    public static r y(LayoutInflater layoutInflater, Object object) {
        return (r)ViewDataBinding.inflateInternal(layoutInflater, 2131558444, null, false, object);
    }

    public x$b u() {
        return this.h;
    }

    public abstract void z(x$b var1);
}

