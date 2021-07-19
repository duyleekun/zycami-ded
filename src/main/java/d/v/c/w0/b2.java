/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.CheckBox
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment$a;
import d.v.c.s0.f7.d;
import d.v.c.s0.u6;

public abstract class b2
extends ViewDataBinding {
    public final RadioGroup A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public SetVideoFragment$a E;
    public u6 F;
    public d G;
    public final CheckBox a;
    public final CheckBox b;
    public final CheckBox c;
    public final CheckBox d;
    public final CheckBox e;
    public final CheckBox f;
    public final CheckBox g;
    public final ImageButton h;
    public final LinearLayout i;
    public final RadioButton j;
    public final RadioButton k;
    public final RadioButton l;
    public final RadioButton m;
    public final RadioButton n;
    public final RadioButton o;
    public final RadioButton p;
    public final RadioButton q;
    public final RadioButton r;
    public final RadioButton s;
    public final RadioButton t;
    public final RadioButton u;
    public final RadioButton v;
    public final RadioButton w;
    public final RadioGroup x;
    public final RadioGroup y;
    public final RadioGroup z;

    public b2(Object object, View view, int n10, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, ImageButton imageButton, LinearLayout linearLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, RadioButton radioButton11, RadioButton radioButton12, RadioButton radioButton13, RadioButton radioButton14, RadioGroup radioGroup, RadioGroup radioGroup2, RadioGroup radioGroup3, RadioGroup radioGroup4, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, n10);
        this.a = checkBox;
        this.b = checkBox2;
        this.c = checkBox3;
        this.d = checkBox4;
        this.e = checkBox5;
        this.f = checkBox6;
        this.g = checkBox7;
        this.h = imageButton;
        this.i = linearLayout;
        this.j = radioButton;
        this.k = radioButton2;
        this.l = radioButton3;
        this.m = radioButton4;
        this.n = radioButton5;
        this.o = radioButton6;
        this.p = radioButton7;
        this.q = radioButton8;
        this.r = radioButton9;
        this.s = radioButton10;
        this.t = radioButton11;
        this.u = radioButton12;
        this.v = radioButton13;
        this.w = radioButton14;
        this.x = radioGroup;
        this.y = radioGroup2;
        this.z = radioGroup3;
        this.A = radioGroup4;
        this.B = textView;
        this.C = textView2;
        this.D = textView3;
    }

    public static b2 A(LayoutInflater layoutInflater, Object object) {
        return (b2)ViewDataBinding.inflateInternal(layoutInflater, 2131558480, null, false, object);
    }

    public static b2 s(View view) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b2.t(view, dataBindingComponent);
    }

    public static b2 t(View view, Object object) {
        return (b2)ViewDataBinding.bind(object, view, 2131558480);
    }

    public static b2 x(LayoutInflater layoutInflater) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b2.A(layoutInflater, dataBindingComponent);
    }

    public static b2 y(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = DataBindingUtil.getDefaultComponent();
        return b2.z(layoutInflater, viewGroup, bl2, dataBindingComponent);
    }

    public static b2 z(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean bl2, Object object) {
        return (b2)ViewDataBinding.inflateInternal(layoutInflater, 2131558480, viewGroup, bl2, object);
    }

    public abstract void B(SetVideoFragment$a var1);

    public abstract void C(d var1);

    public abstract void D(u6 var1);

    public SetVideoFragment$a u() {
        return this.E;
    }

    public d v() {
        return this.G;
    }

    public u6 w() {
        return this.F;
    }
}

