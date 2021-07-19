/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.cama.widget.ZYTextView;

public abstract class qc
extends ViewDataBinding {
    public final ImageButton a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final FrameLayout d;
    public final LinearLayout e;
    public final PlayLayout f;
    public final ImageView g;
    public final ZYTextView h;
    public final ZYTextView i;
    public final ZYTextView j;
    public final LinearLayout k;
    public final RingProgressBar l;
    public final TextView m;
    public final ZYTextView n;
    public final TextView o;
    public final View p;
    public final TextView q;
    public final TextView r;
    public final View s;

    public qc(Object object, View view, int n10, ImageButton imageButton, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, LinearLayout linearLayout, PlayLayout playLayout, ImageView imageView, ZYTextView zYTextView, ZYTextView zYTextView2, ZYTextView zYTextView3, LinearLayout linearLayout2, RingProgressBar ringProgressBar, TextView textView, ZYTextView zYTextView4, TextView textView2, View view2, TextView textView3, TextView textView4, View view3) {
        super(object, view, n10);
        this.a = imageButton;
        this.b = constraintLayout;
        this.c = constraintLayout2;
        this.d = frameLayout;
        this.e = linearLayout;
        this.f = playLayout;
        this.g = imageView;
        this.h = zYTextView;
        this.i = zYTextView2;
        this.j = zYTextView3;
        this.k = linearLayout2;
        this.l = ringProgressBar;
        this.m = textView;
        this.n = zYTextView4;
        this.o = textView2;
        this.p = view2;
        this.q = textView3;
        this.r = textView4;
        this.s = view3;
    }

    public static qc s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qc.t(view, dataBindingComponent);
    }

    public static qc t(View view, Object object) {
        return (qc)ViewDataBinding.bind(object, view, 2131558653);
    }

    public static qc u(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qc.x(layoutInflater, dataBindingComponent);
    }

    public static qc v(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return qc.w(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static qc w(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (qc)ViewDataBinding.inflateInternal(layoutInflater, 2131558653, viewGroup, bl2, object);
    }

    public static qc x(LayoutInflater layoutInflater, Object object) {
        return (qc)ViewDataBinding.inflateInternal(layoutInflater, 2131558653, null, false, object);
    }
}

