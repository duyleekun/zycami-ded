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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import d.v.c.x0.c.c.d$a;
import d.v.c.x0.c.c.f;

public abstract class d8
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final NoOffsetSeekBar c;
    public final TextView d;
    public final TextView e;
    public d.a f;
    public f g;

    public d8(Object object, View view, int n10, ConstraintLayout constraintLayout, RecyclerView recyclerView, NoOffsetSeekBar noOffsetSeekBar, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = noOffsetSeekBar;
        this.d = textView;
        this.e = textView2;
    }

    public static d8 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d8.t(view, dataBindingComponent);
    }

    public static d8 t(View view, Object object) {
        return (d8)ViewDataBinding.bind(object, view, 2131558589);
    }

    public static d8 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d8.z(layoutInflater, dataBindingComponent);
    }

    public static d8 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return d8.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static d8 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (d8)ViewDataBinding.inflateInternal(layoutInflater, 2131558589, viewGroup, bl2, object);
    }

    public static d8 z(LayoutInflater layoutInflater, Object object) {
        return (d8)ViewDataBinding.inflateInternal(layoutInflater, 2131558589, null, false, object);
    }

    public abstract void A(d.a var1);

    public abstract void B(f var1);

    public d.a u() {
        return this.f;
    }

    public f v() {
        return this.g;
    }
}

