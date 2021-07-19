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
import com.zhiyun.cama.camera.widget.StringScrollView;

public abstract class t3
extends ViewDataBinding {
    public final StringScrollView a;

    public t3(Object object, View view, int n10, StringScrollView stringScrollView) {
        super(object, view, n10);
        this.a = stringScrollView;
    }

    public static t3 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t3.t(view, dataBindingComponent);
    }

    public static t3 t(View view, Object object) {
        return (t3)ViewDataBinding.bind(object, view, 2131558521);
    }

    public static t3 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t3.x(layoutInflater, dataBindingComponent);
    }

    public static t3 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t3.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t3 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t3)ViewDataBinding.inflateInternal(layoutInflater, 2131558521, viewGroup, bl2, object);
    }

    public static t3 x(LayoutInflater layoutInflater, Object object) {
        return (t3)ViewDataBinding.inflateInternal(layoutInflater, 2131558521, null, false, object);
    }
}

