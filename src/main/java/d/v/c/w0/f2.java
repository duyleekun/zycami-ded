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
import com.zhiyun.cama.camera.widget.CheckedGroup;

public abstract class f2
extends ViewDataBinding {
    public final CheckedGroup a;

    public f2(Object object, View view, int n10, CheckedGroup checkedGroup) {
        super(object, view, n10);
        this.a = checkedGroup;
    }

    public static f2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f2.t(view, dataBindingComponent);
    }

    public static f2 t(View view, Object object) {
        return (f2)ViewDataBinding.bind(object, view, 2131558482);
    }

    public static f2 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f2.x(layoutInflater, dataBindingComponent);
    }

    public static f2 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return f2.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static f2 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (f2)ViewDataBinding.inflateInternal(layoutInflater, 2131558482, viewGroup, bl2, object);
    }

    public static f2 x(LayoutInflater layoutInflater, Object object) {
        return (f2)ViewDataBinding.inflateInternal(layoutInflater, 2131558482, null, false, object);
    }
}

