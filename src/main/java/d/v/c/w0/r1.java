/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.c.s0.a7.k1$a;

public abstract class r1
extends ViewDataBinding {
    public final ImageView a;
    public final LinearLayout b;
    public final RadioButton c;
    public final RadioButton d;
    public final RadioButton e;
    public final RadioButton f;
    public final RadioButton g;
    public final RadioButton h;
    public final RadioButton i;
    public final RadioButton j;
    public final RadioButton k;
    public final RadioButton l;
    public final RadioGroup m;
    public final RadioGroup n;
    public final RadioGroup o;
    public final TextView p;
    public k1.a q;
    public CameraSet$Mode r;

    public r1(Object object, View view, int n10, ImageView imageView, LinearLayout linearLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, TextView textView) {
        super(object, view, n10);
        this.a = imageView;
        this.b = linearLayout;
        this.c = radioButton;
        this.d = radioButton2;
        this.e = radioButton3;
        this.f = radioButton4;
        this.g = radioButton5;
        this.h = radioButton6;
        this.i = radioButton7;
        this.j = radioButton8;
        this.k = radioButton9;
        this.l = radioButton10;
        this.m = radioGroup;
        this.n = radioGroup2;
        this.o = radioGroup3;
        this.p = textView;
    }

    public static r1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r1.t(view, dataBindingComponent);
    }

    public static r1 t(View view, Object object) {
        return (r1)ViewDataBinding.bind(object, view, 2131558475);
    }

    public static r1 w(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r1.z(layoutInflater, dataBindingComponent);
    }

    public static r1 x(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return r1.y(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static r1 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (r1)ViewDataBinding.inflateInternal(layoutInflater, 2131558475, viewGroup, bl2, object);
    }

    public static r1 z(LayoutInflater layoutInflater, Object object) {
        return (r1)ViewDataBinding.inflateInternal(layoutInflater, 2131558475, null, false, object);
    }

    public abstract void A(k1.a var1);

    public abstract void B(CameraSet$Mode var1);

    public k1.a u() {
        return this.q;
    }

    public CameraSet$Mode v() {
        return this.r;
    }
}

