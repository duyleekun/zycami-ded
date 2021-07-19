/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import d.v.c.i1.s2.r$c;
import d.v.c.i1.s2.s;
import d.v.c.w0.r9;
import d.v.g.g.c1;

public abstract class t9
extends ViewDataBinding {
    public final Button a;
    public final ConstraintLayout b;
    public final CardView c;
    public final FrameLayout d;
    public final FragmentContainerView e;
    public final ImageButton f;
    public final ImageButton g;
    public final TextView h;
    public final r9 i;
    public r$c j;
    public s k;
    public c1 l;

    public t9(Object object, View view, int n10, Button button, ConstraintLayout constraintLayout, CardView cardView, FrameLayout frameLayout, FragmentContainerView fragmentContainerView, ImageButton imageButton, ImageButton imageButton2, TextView textView, r9 r92) {
        super(object, view, n10);
        this.a = button;
        this.b = constraintLayout;
        this.c = cardView;
        this.d = frameLayout;
        this.e = fragmentContainerView;
        this.f = imageButton;
        this.g = imageButton2;
        this.h = textView;
        this.i = r92;
    }

    public static t9 A(LayoutInflater layoutInflater, Object object) {
        return (t9)ViewDataBinding.inflateInternal(layoutInflater, 2131558615, null, false, object);
    }

    public static t9 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t9.t(view, dataBindingComponent);
    }

    public static t9 t(View view, Object object) {
        return (t9)ViewDataBinding.bind(object, view, 2131558615);
    }

    public static t9 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t9.A(layoutInflater, dataBindingComponent);
    }

    public static t9 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return t9.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static t9 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (t9)ViewDataBinding.inflateInternal(layoutInflater, 2131558615, viewGroup, bl2, object);
    }

    public abstract void B(r$c var1);

    public abstract void C(c1 var1);

    public abstract void D(s var1);

    public r$c u() {
        return this.j;
    }

    public c1 v() {
        return this.l;
    }

    public s w() {
        return this.k;
    }
}

