/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel;
import d.v.c.m1.d.p$a;

public abstract class eg
extends ViewDataBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final ProgressBar e;
    public final TextView f;
    public final AppCompatTextView g;
    public final TextView h;
    public final AppCompatTextView i;
    public final TextView j;
    public final View k;
    public final View l;
    public p$a m;
    public PrimeGetDialogViewModel n;

    public eg(Object object, View view, int n10, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ProgressBar progressBar, TextView textView, AppCompatTextView appCompatTextView, TextView textView2, AppCompatTextView appCompatTextView2, TextView textView3, View view2, View view3) {
        super(object, view, n10);
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = imageView;
        this.e = progressBar;
        this.f = textView;
        this.g = appCompatTextView;
        this.h = textView2;
        this.i = appCompatTextView2;
        this.j = textView3;
        this.k = view2;
        this.l = view3;
    }

    public static eg s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eg.t(view, dataBindingComponent);
    }

    public static eg t(View view, Object object) {
        return (eg)ViewDataBinding.bind(object, view, 2131558745);
    }

    public static eg w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eg.z(layoutInflater, dataBindingComponent);
    }

    public static eg x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return eg.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static eg y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (eg)ViewDataBinding.inflateInternal(layoutInflater, 2131558745, viewGroup, bl2, object);
    }

    public static eg z(LayoutInflater layoutInflater, Object object) {
        return (eg)ViewDataBinding.inflateInternal(layoutInflater, 2131558745, null, false, object);
    }

    public abstract void A(p$a var1);

    public abstract void B(PrimeGetDialogViewModel var1);

    public p$a u() {
        return this.m;
    }

    public PrimeGetDialogViewModel v() {
        return this.n;
    }
}

