/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.d1.e;
import d.v.c.d1.h;

public abstract class ya
extends ViewDataBinding {
    public final RoundImageView a;
    public final TextView b;
    public final View c;
    public final RingProgressBar d;
    public e e;
    public Integer f;
    public ObservableList g;
    public h h;

    public ya(Object object, View view, int n10, RoundImageView roundImageView, TextView textView, View view2, RingProgressBar ringProgressBar) {
        super(object, view, n10);
        this.a = roundImageView;
        this.b = textView;
        this.c = view2;
        this.d = ringProgressBar;
    }

    public static ya A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ya)ViewDataBinding.inflateInternal(layoutInflater, 2131558630, viewGroup, bl2, object);
    }

    public static ya B(LayoutInflater layoutInflater, Object object) {
        return (ya)ViewDataBinding.inflateInternal(layoutInflater, 2131558630, null, false, object);
    }

    public static ya s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ya.t(view, dataBindingComponent);
    }

    public static ya t(View view, Object object) {
        return (ya)ViewDataBinding.bind(object, view, 2131558630);
    }

    public static ya y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ya.B(layoutInflater, dataBindingComponent);
    }

    public static ya z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ya.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(e var1);

    public abstract void D(h var1);

    public abstract void E(ObservableList var1);

    public abstract void F(Integer var1);

    public e u() {
        return this.e;
    }

    public h v() {
        return this.h;
    }

    public ObservableList w() {
        return this.g;
    }

    public Integer x() {
        return this.f;
    }
}

