/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import d.v.c.s0.h7.o0.v0$b;
import d.v.c.s0.h7.o0.w0;

public abstract class ch
extends ViewDataBinding {
    public final ImageView a;
    public final ImageButton b;
    public final Group c;
    public final RecyclerView d;
    public final ImageButton e;
    public final TextView f;
    public final TextView g;
    public ObservableBoolean h;
    public w0 i;
    public v0.b j;

    public ch(Object object, View view, int n10, ImageView imageView, ImageButton imageButton, Group group, RecyclerView recyclerView, ImageButton imageButton2, TextView textView, TextView textView2) {
        super(object, view, n10);
        this.a = imageView;
        this.b = imageButton;
        this.c = group;
        this.d = recyclerView;
        this.e = imageButton2;
        this.f = textView;
        this.g = textView2;
    }

    public static ch A(LayoutInflater layoutInflater, Object object) {
        return (ch)ViewDataBinding.inflateInternal(layoutInflater, 2131558779, null, false, object);
    }

    public static ch s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ch.t(view, dataBindingComponent);
    }

    public static ch t(View view, Object object) {
        return (ch)ViewDataBinding.bind(object, view, 2131558779);
    }

    public static ch x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ch.A(layoutInflater, dataBindingComponent);
    }

    public static ch y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return ch.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static ch z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (ch)ViewDataBinding.inflateInternal(layoutInflater, 2131558779, viewGroup, bl2, object);
    }

    public abstract void B(v0.b var1);

    public abstract void C(ObservableBoolean var1);

    public abstract void D(w0 var1);

    public v0.b u() {
        return this.j;
    }

    public ObservableBoolean v() {
        return this.h;
    }

    public w0 w() {
        return this.i;
    }
}

