/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RadioGroup
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class gh
extends ViewDataBinding {
    public final RadioGroup a;

    public gh(Object object, View view, int n10, RadioGroup radioGroup) {
        super(object, view, n10);
        this.a = radioGroup;
    }

    public static gh s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gh.t(view, dataBindingComponent);
    }

    public static gh t(View view, Object object) {
        return (gh)ViewDataBinding.bind(object, view, 2131558781);
    }

    public static gh u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gh.x(layoutInflater, dataBindingComponent);
    }

    public static gh v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return gh.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static gh w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (gh)ViewDataBinding.inflateInternal(layoutInflater, 2131558781, viewGroup, bl2, object);
    }

    public static gh x(LayoutInflater layoutInflater, Object object) {
        return (gh)ViewDataBinding.inflateInternal(layoutInflater, 2131558781, null, false, object);
    }
}

