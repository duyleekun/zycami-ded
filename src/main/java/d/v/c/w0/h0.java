/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.ui.ShadowSeekBar;

public abstract class h0
extends ViewDataBinding {
    public final LinearLayout a;
    public final RecyclerView b;
    public final ShadowSeekBar c;

    public h0(Object object, View view, int n10, LinearLayout linearLayout, RecyclerView recyclerView, ShadowSeekBar shadowSeekBar) {
        super(object, view, n10);
        this.a = linearLayout;
        this.b = recyclerView;
        this.c = shadowSeekBar;
    }

    public static h0 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h0.t(view, dataBindingComponent);
    }

    public static h0 t(View view, Object object) {
        return (h0)ViewDataBinding.bind(object, view, 2131558457);
    }

    public static h0 u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h0.x(layoutInflater, dataBindingComponent);
    }

    public static h0 v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return h0.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static h0 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (h0)ViewDataBinding.inflateInternal(layoutInflater, 2131558457, viewGroup, bl2, object);
    }

    public static h0 x(LayoutInflater layoutInflater, Object object) {
        return (h0)ViewDataBinding.inflateInternal(layoutInflater, 2131558457, null, false, object);
    }
}

