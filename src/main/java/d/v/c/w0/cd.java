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
import com.zhiyun.cama.widget.ZYTextView;

public abstract class cd
extends ViewDataBinding {
    public final ZYTextView a;

    public cd(Object object, View view, int n10, ZYTextView zYTextView) {
        super(object, view, n10);
        this.a = zYTextView;
    }

    public static cd s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cd.t(view, dataBindingComponent);
    }

    public static cd t(View view, Object object) {
        return (cd)ViewDataBinding.bind(object, view, 2131558660);
    }

    public static cd u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cd.x(layoutInflater, dataBindingComponent);
    }

    public static cd v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return cd.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static cd w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (cd)ViewDataBinding.inflateInternal(layoutInflater, 2131558660, viewGroup, bl2, object);
    }

    public static cd x(LayoutInflater layoutInflater, Object object) {
        return (cd)ViewDataBinding.inflateInternal(layoutInflater, 2131558660, null, false, object);
    }
}

