/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment$b;
import d.v.c.s0.u6;
import d.v.c.s0.v6;

public abstract class v1
extends ViewDataBinding {
    public final CheckBox a;
    public final CheckBox b;
    public final CheckedTextView c;
    public final ImageView d;
    public final ImageView e;
    public final RadioButton f;
    public final RadioButton g;
    public final RadioButton h;
    public final RadioButton i;
    public final RadioButton j;
    public final RadioGroup k;
    public final RadioGroup l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public SetGeneralFragment$b s;
    public BleViewModel t;
    public u6 u;
    public v6 v;

    public v1(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, CheckedTextView checkedTextView, ImageView imageView, ImageView imageView2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioGroup radioGroup, RadioGroup radioGroup2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = checkedTextView;
        this.d = imageView;
        this.e = imageView2;
        this.f = radioButton;
        this.g = radioButton2;
        this.h = radioButton3;
        this.i = radioButton4;
        this.j = radioButton5;
        this.k = radioGroup;
        this.l = radioGroup2;
        this.m = textView;
        this.n = textView2;
        this.o = textView3;
        this.p = textView4;
        this.q = textView5;
        this.r = textView6;
    }

    public static v1 A(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (v1)ViewDataBinding.inflateInternal(layoutInflater, 2131558477, viewGroup, bl2, object);
    }

    public static v1 B(LayoutInflater layoutInflater, Object object) {
        return (v1)ViewDataBinding.inflateInternal(layoutInflater, 2131558477, null, false, object);
    }

    public static v1 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v1.t(view, dataBindingComponent);
    }

    public static v1 t(View view, Object object) {
        return (v1)ViewDataBinding.bind(object, view, 2131558477);
    }

    public static v1 y(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v1.B(layoutInflater, dataBindingComponent);
    }

    public static v1 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return v1.A(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public abstract void C(BleViewModel var1);

    public abstract void D(u6 var1);

    public abstract void E(SetGeneralFragment$b var1);

    public abstract void F(v6 var1);

    public BleViewModel u() {
        return this.t;
    }

    public u6 v() {
        return this.u;
    }

    public SetGeneralFragment$b w() {
        return this.s;
    }

    public v6 x() {
        return this.v;
    }
}

