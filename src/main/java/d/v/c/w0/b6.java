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
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.device.connect.help.ConnectHelpFragment$a;

public abstract class b6
extends ViewDataBinding {
    public final ImageView a;
    public final ConstraintLayout b;
    public final RecyclerView c;
    public final TextView d;
    public ConnectHelpFragment$a e;

    public b6(Object object, View view, int n10, ImageView imageView, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = constraintLayout;
        this.c = recyclerView;
        this.d = textView;
    }

    public static b6 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b6.t(view, dataBindingComponent);
    }

    public static b6 t(View view, Object object) {
        return (b6)ViewDataBinding.bind(object, view, 2131558562);
    }

    public static b6 v(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b6.y(layoutInflater, dataBindingComponent);
    }

    public static b6 w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b6.x(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b6 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b6)ViewDataBinding.inflateInternal(layoutInflater, 2131558562, viewGroup, bl2, object);
    }

    public static b6 y(LayoutInflater layoutInflater, Object object) {
        return (b6)ViewDataBinding.inflateInternal(layoutInflater, 2131558562, null, false, object);
    }

    public ConnectHelpFragment$a u() {
        return this.e;
    }

    public abstract void z(ConnectHelpFragment$a var1);
}

